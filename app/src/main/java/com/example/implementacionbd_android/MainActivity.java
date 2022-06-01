package com.example.implementacionbd_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private List<modeloSitios> lsSitios;
    private RecyclerView recyclerView;
    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv=findViewById(R.id.textview);//mostrar error
        lsSitios = new ArrayList<modeloSitios>();
        lsSitios.clear();
        recyclerView = findViewById(R.id.rcvLugares);


        cargarSitios();
    }

    private void cargarSitios(){
        String URL = "http://192.168.0.23/webServices/cargardatos.php";

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Response", response);
                        try {
                            Log.i("Error Response", response);
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("items");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jObject = jsonArray.getJSONObject(i);
                                modeloSitios mSitios = new modeloSitios();
                                mSitios.setIcono(jObject.getString("icono"));
                                mSitios.setTitulo(jObject.getString("titulo"));
                                mSitios.setIntroduccion(jObject.getString("introduccion"));
                                mSitios.setPortada(jObject.getString("imagenportada"));
                                mSitios.setDescripcion(jObject.getString("descripcion"));
                                lsSitios.add(mSitios);
                            }//Fin FOR
                            setDataRecyclerAdapter(lsSitios);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.i("Error Catch", e.toString());
                        }
                    }//FIn OnResponse
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Error",error.toString());txv.setText("data "+error.toString());
                    }
                });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void setDataRecyclerAdapter(List<modeloSitios> lsSitios){
        adapterSitios myadapter = new adapterSitios(this,lsSitios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}