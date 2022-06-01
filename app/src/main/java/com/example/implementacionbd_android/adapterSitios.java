package com.example.implementacionbd_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class adapterSitios extends RecyclerView.Adapter<adapterSitios.MyViewHolder>{
    private Context context;
    private List<modeloSitios> mData;

    public adapterSitios(Context context, List<modeloSitios> mData){
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public adapterSitios.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.lugares,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterSitios.MyViewHolder myViewHolder, final int j) {
        final int i=j;
        final String icono = mData.get(i).getIcono();
        final String titulo = mData.get(i).getTitulo();
        final String introduccion = mData.get(i).getIntroduccion();
        final String portada = mData.get(i).getPortada();
        final String descripcion = mData.get(i).getDescripcion();

        Picasso.get()
                .load("http://192.168.0.23/webservices/imagenes/iconos/"+icono)
                .into(myViewHolder.icono);
        myViewHolder.titulo.setText(titulo);
        myViewHolder.introduccion.setText(introduccion);
        myViewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                switch (i){
                    case 0:
                        intent = new Intent(context,activity_sitio.class);
                        break;
                    default:
                        intent = new Intent(context,activity_sitio.class);
                        break;
                }//FIn de switch
                //Ejecutar la actividad a mostrar segun el case
                intent.putExtra("titulo",titulo);
                intent.putExtra("descripcion",descripcion);
                intent.putExtra("portada",portada);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder{
        ImageView icono;
        TextView titulo, introduccion;
        LinearLayout container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            icono = itemView.findViewById(R.id.iconoId);
            titulo = itemView.findViewById(R.id.idTitulo);
            introduccion = itemView.findViewById(R.id.idDescripcion);
            container = itemView.findViewById(R.id.idContainer);
        }//FIn del constructor
    }//Fin del MyViewHolder
}
