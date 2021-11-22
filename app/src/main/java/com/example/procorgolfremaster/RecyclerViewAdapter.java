package com.example.procorgolfremaster;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.procorgolfremaster.clases.Datos;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<Datos> mData;
    private Context mContext;

    public RecyclerViewAdapter(List<Datos> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.torneo.setText(mData.get(position).getTorneo());
        holder.ciudad.setText(mData.get(position).getCampo());
        String persona = mData.get(position).getNombre() + " " + mData.get(position).getApellidos();
        holder.nombre.setText(persona);
        holder.cargo.setText(mData.get(position).getCargo());
        holder.dni.setText(mData.get(position).getDni());
        holder.resultado.setText(mData.get(position).getResultado());
        holder.resultado.setEnabled(false);
        holder.nprueba.setText(String.valueOf(mData.get(position).getNumero_prueba()));
        holder.generarbtn.setVisibility(View.GONE);
        String resultado = holder.resultado.getText().toString();
        if (resultado.equalsIgnoreCase("positivo")) {
            holder.cardviewverde.setBackgroundColor(Color.parseColor("#F1554E"));
            holder.generarbtn.setVisibility(View.GONE);
            holder.analizarbtn.setVisibility(View.GONE);
            holder.resultado.setEnabled(false);
            holder.nprueba.setEnabled(false);
            holder.tvnprueba.setTextColor(Color.parseColor("#ffffff"));
            holder.tvresultado.setTextColor(Color.parseColor("#ffffff"));
            holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
            holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
            holder.tvdni.setTextColor(Color.parseColor("#ffffff"));
            holder.tvnombre.setTextColor(Color.parseColor("#ffffff"));
            holder.ciudad.setTextColor(Color.parseColor("#ffffff"));
            holder.torneo.setTextColor(Color.parseColor("#ffffff"));
            holder.nombre.setTextColor(Color.parseColor("#ffffff"));
            holder.cargo.setTextColor(Color.parseColor("#ffffff"));
            holder.dni.setTextColor(Color.parseColor("#ffffff"));
            holder.nprueba.setTextColor(Color.parseColor("#ffffff"));
            holder.resultado.setTextColor(Color.parseColor("#ffffff"));
            holder.linea.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            if (resultado.equalsIgnoreCase("negativo")) {
                holder.cardviewverde.setBackgroundColor(Color.parseColor("#A0D8D0"));
                holder.generarbtn.setVisibility(View.GONE);
                holder.analizarbtn.setVisibility(View.GONE);
                holder.resultado.setEnabled(false);
                holder.nprueba.setEnabled(false);
                holder.tvnprueba.setTextColor(Color.parseColor("#ffffff"));
                holder.tvresultado.setTextColor(Color.parseColor("#ffffff"));
                holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
                holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
                holder.tvdni.setTextColor(Color.parseColor("#ffffff"));
                holder.tvnombre.setTextColor(Color.parseColor("#ffffff"));
                holder.ciudad.setTextColor(Color.parseColor("#ffffff"));
                holder.torneo.setTextColor(Color.parseColor("#ffffff"));
                holder.nombre.setTextColor(Color.parseColor("#ffffff"));
                holder.cargo.setTextColor(Color.parseColor("#ffffff"));
                holder.dni.setTextColor(Color.parseColor("#ffffff"));
                holder.nprueba.setTextColor(Color.parseColor("#ffffff"));
                holder.resultado.setTextColor(Color.parseColor("#ffffff"));
                holder.linea.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }

        holder.analizarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardviewverde.setBackgroundColor(Color.parseColor("#D8D8D8"));
                holder.analizarbtn.setVisibility(View.GONE);
                holder.resultado.setEnabled(true);
                holder.nprueba.setEnabled(false);
                holder.generarbtn.setVisibility(View.VISIBLE);
            }
        });

        holder.generarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = holder.resultado.getText().toString();
                if (resultado.equalsIgnoreCase("positivo")) {
                    holder.cardviewverde.setBackgroundColor(Color.parseColor("#FB2F03"));
                    holder.generarbtn.setVisibility(View.GONE);
                    holder.resultado.setEnabled(false);
                    holder.nprueba.setEnabled(false);
                    holder.tvnprueba.setTextColor(Color.parseColor("#ffffff"));
                    holder.tvresultado.setTextColor(Color.parseColor("#ffffff"));
                    holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
                    holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
                    holder.tvdni.setTextColor(Color.parseColor("#ffffff"));
                    holder.tvnombre.setTextColor(Color.parseColor("#ffffff"));
                    holder.ciudad.setTextColor(Color.parseColor("#ffffff"));
                    holder.torneo.setTextColor(Color.parseColor("#ffffff"));
                    holder.nombre.setTextColor(Color.parseColor("#ffffff"));
                    holder.cargo.setTextColor(Color.parseColor("#ffffff"));
                    holder.dni.setTextColor(Color.parseColor("#ffffff"));
                    holder.nprueba.setTextColor(Color.parseColor("#ffffff"));
                    holder.resultado.setTextColor(Color.parseColor("#ffffff"));
                    holder.linea.setBackgroundColor(Color.parseColor("#ffffff"));
                } else {
                    if (resultado.equalsIgnoreCase("negativo")) {
                        holder.cardviewverde.setBackgroundColor(Color.parseColor("#037BFB"));
                        holder.generarbtn.setVisibility(View.GONE);
                        holder.resultado.setEnabled(false);
                        holder.nprueba.setEnabled(false);
                        holder.tvnprueba.setTextColor(Color.parseColor("#ffffff"));
                        holder.tvresultado.setTextColor(Color.parseColor("#ffffff"));
                        holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
                        holder.tvcargo.setTextColor(Color.parseColor("#ffffff"));
                        holder.tvdni.setTextColor(Color.parseColor("#ffffff"));
                        holder.tvnombre.setTextColor(Color.parseColor("#ffffff"));
                        holder.ciudad.setTextColor(Color.parseColor("#ffffff"));
                        holder.torneo.setTextColor(Color.parseColor("#ffffff"));
                        holder.nombre.setTextColor(Color.parseColor("#ffffff"));
                        holder.cargo.setTextColor(Color.parseColor("#ffffff"));
                        holder.dni.setTextColor(Color.parseColor("#ffffff"));
                        holder.nprueba.setTextColor(Color.parseColor("#ffffff"));
                        holder.resultado.setTextColor(Color.parseColor("#ffffff"));
                        holder.linea.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnombre;
        TextView tvdni;
        TextView tvresultado;
        TextView tvnprueba;
        TextView tvcargo;
        TextView torneo;
        TextView ciudad;
        TextView nombre;
        TextView cargo;
        TextView dni;
        EditText nprueba;
        TextView resultado;
        View linea;
        Button analizarbtn;
        Button generarbtn;
        LinearLayout cardviewverde;

        MyViewHolder(View itemView) {
            super(itemView);
            torneo = itemView.findViewById(R.id.torneo);
            ciudad = itemView.findViewById(R.id.ciudad);
            tvnombre = itemView.findViewById(R.id.tvNombre);
            nombre = itemView.findViewById(R.id.nombre);
            tvcargo = itemView.findViewById(R.id.tvCargo);
            cargo = itemView.findViewById(R.id.cargo);
            tvdni = itemView.findViewById(R.id.tvDni);
            dni = itemView.findViewById(R.id.dni);
            tvnprueba = itemView.findViewById(R.id.tvNprueba);
            nprueba = itemView.findViewById(R.id.ndepruba);
            analizarbtn = itemView.findViewById(R.id.btn_analizar);
            generarbtn = itemView.findViewById(R.id.btn_informe);
            cardviewverde = itemView.findViewById(R.id.cardviewprincipal);
            tvresultado = itemView.findViewById(R.id.tvResultado);
            resultado = itemView.findViewById(R.id.resultado);
            linea = itemView.findViewById(R.id.linea);
        }
    }
}

