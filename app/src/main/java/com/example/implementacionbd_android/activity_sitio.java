package com.example.implementacionbd_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class activity_sitio extends AppCompatActivity {
    TextView txvTitulo, txvDescripcion;
    ImageView imvPortada1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitio);
        txvTitulo = findViewById(R.id.txvTituloSitio);
        txvDescripcion = findViewById(R.id.txvDescripcion);
        imvPortada1 = findViewById(R.id.imvSitio);

        Bundle bundle = getIntent().getExtras();
        //Recuperando texto
        String titulo = bundle.getString("titulo");
        txvTitulo.setText(titulo);

        String descripcion = bundle.getString("descripcion");
        txvDescripcion.setText(descripcion);

        String Portada = bundle.getString("portada");
        Picasso.get()
                .load("http://192.168.0.15/webservices/imagenes/sitios/"+Portada)
                .into(imvPortada1);
    }
}