package com.example.conexionbluetooth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDispositivo extends RecyclerView.Adapter<AdaptadorDispositivo.ViewHolderDispositivo> {

    ArrayList<Dispositivo> listaDispositivos;

    public AdaptadorDispositivo(ArrayList<Dispositivo> listaDispositivos) {
        this.listaDispositivos = listaDispositivos;
    }

    @NonNull
    @Override
    public ViewHolderDispositivo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Se infla una variable de ese XML
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null,false);

        //Y se retorna un objeto View holder, es decir, el que modificará los datos del objeto infado
        return new ViewHolderDispositivo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDispositivo holder, int position) {

        holder.asignarDatos(listaDispositivos.get(position));

    }

    @Override
    public int getItemCount() {
        return listaDispositivos.size();
    }

    public class ViewHolderDispositivo extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtMac;
        RadioButton rb_item;

        public ViewHolderDispositivo(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txt_Name);
            txtMac = itemView.findViewById(R.id.txt_mac);
            rb_item = itemView.findViewById(R.id.rb_item);

        }

        public void asignarDatos(Dispositivo dispositivo) {

            txtMac.setText(dispositivo.getNombre());
            txtNombre.setText(dispositivo.getMac());
            rb_item.setChecked(dispositivo.isCheck);

        }

    }


}
