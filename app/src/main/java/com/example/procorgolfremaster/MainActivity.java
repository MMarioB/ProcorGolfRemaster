package com.example.procorgolfremaster;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.procorgolfremaster.clases.Datos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<Datos> golfistas = new ArrayList<>();
    List<Datos> nuevoslist = new ArrayList<>();
    List<Datos> positivoslist = new ArrayList<>();
    List<Datos> negativoslist = new ArrayList<>();
    List<Datos> pruebaordenlist = new ArrayList<>();
    List<Datos> filtradoPersonalizado = new ArrayList<>();
    List<String> dnisParticipantes = new ArrayList<>();
    List<String> correosParticipantes = new ArrayList<>();

    String campo_busqueda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button positivos = findViewById(R.id.btn_positivos);
        Button negativos = findViewById(R.id.btn_negativos);
        Button nuevos = findViewById(R.id.btn_nuevos);
        Button pruebas = findViewById(R.id.btn_nprueba);
        Button filtrobtn = findViewById(R.id.btn_filtro);
        EditText filtro = findViewById(R.id.et_texto_filtro);
        Datos d = new Datos(1, "Madrid", "Casa de Campo", "Mario", "Bravo Ovejero",
                "Jugador", "dni1", "28941", "mario@gmail.com",
                "638177492", "no", "0", "no", "antigenos", "",
                0, 0);

        Datos d1 = new Datos(2, "Madrid", "Casa de Campo", "Mario", "Bravo Ovejero",
                "Jugador", "dni2", "28941", "mario2@gmail.com",
                "638177492", "no", "0", "no", "antigenos", "positivo",
                2, 1);
        Datos d2 = new Datos(3, "Madrid", "Casa de Campo", "Mario", "Bravo Ovejero",
                "Jugador", "dni3", "28941", "mario3@gmail.com",
                "638177492", "no", "0", "no", "antigenos", "",
                0, 0);

        Datos d3 = new Datos(4, "Madrid", "Casa de Campo", "Mario", "Bravo Ovejero",
                "Jugador", "dni4", "28941", "mario4@gmail.com",
                "638177492", "no", "0", "no", "antigenos", "",
                0, 0);

        Datos d4 = new Datos(5, "Madrid", "Casa de Campo", "Mario", "Bravo Ovejero",
                "Jugador", "dni5", "28941", "mario5@gmail.com",
                "638177492", "no", "0", "no", "antigenos", "negativo",
                3, 1);
        Datos d5 = new Datos(6, "Madrid", "Casa de Campo", "Mario", "Bravo Ovejero",
                "Jugador", "dni6", "28941", "mario6@gmail.com",
                "638177492", "no", "0", "no", "antigenos", "",
                0, 0);

        golfistas.add(d);
        golfistas.add(d1);
        golfistas.add(d2);
        golfistas.add(d3);
        golfistas.add(d4);
        golfistas.add(d5);

        RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
        RecyclerViewAdapter rva = new RecyclerViewAdapter(golfistas, MainActivity.this);
        rv.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(rva);


        // Nuevos
        for (int i = 0; i < golfistas.size(); i++) {
            if (golfistas.get(i).getAnalizada() == 0) {
                nuevoslist.add(golfistas.get(i));
            }
        }

        //  Positivos o negativos
        for (int i = 0; i < golfistas.size(); i++) {
            if (golfistas.get(i).getResultado() == null) {
                Log.d("Nada", "Nada");
            } else {
                if (golfistas.get(i).getResultado().equalsIgnoreCase("positivo")) {
                    positivoslist.add(golfistas.get(i));
                } else {
                    if (golfistas.get(i).getResultado().equalsIgnoreCase("negativo")) {
                        negativoslist.add(golfistas.get(i));
                    }
                }
            }
        }

        // Numero pruebas
        for (int i = 0; i < golfistas.size(); i++) {
            if (golfistas.get(i).getNumero_prueba() > 0 && golfistas.get(i).getAnalizada() == 1) {
                pruebaordenlist.add(golfistas.get(i));
            }
        }

        // Añadir a lista de dnis y correos todos los emails y dnis
        for (int i = 0; i < golfistas.size(); i++) {
            dnisParticipantes.add(golfistas.get(i).getDni());
            correosParticipantes.add(golfistas.get(i).getCorreo());
        }


        filtrobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tamanio = golfistas.size();
                Log.d("Tamaño", String.valueOf(tamanio));
                campo_busqueda = filtro.getText().toString();
                if (correosParticipantes.contains(campo_busqueda) || dnisParticipantes.contains(campo_busqueda)) {
                    for (int i = 0; i < golfistas.size(); i++) {
                        if (golfistas.get(i).getDni().equals(campo_busqueda) || golfistas.get(i).getCorreo().equals(campo_busqueda)) {
                            Log.d("ENTRA AQUI","HOLAAAA");
                            filtradoPersonalizado.add(golfistas.get(i));
                        }
                    }
                    Log.d("Filtritooo", filtradoPersonalizado.toString());
                    if (filtradoPersonalizado.size() > 0) {
                        if (filtradoPersonalizado.size()==2){
                            filtradoPersonalizado.remove(0);
                        }
                        RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                        RecyclerViewAdapter rva = new RecyclerViewAdapter(filtradoPersonalizado, MainActivity.this);
                        rv.setLayoutManager(
                                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                        rv.setAdapter(rva);
                    }
                } else {
                    showEmptyField();
                }

                filtro.setText("");
            }
        });

        positivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positivoslist.size() > 0) {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(positivoslist, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                } else {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(negativoslist, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                }
            }
        });
        Collections.reverse(positivoslist);
        negativos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (negativoslist.size() > 0) {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(negativoslist, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                } else {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(golfistas, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                }
            }
        });
        Collections.reverse(negativoslist);
        nuevos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nuevoslist.size() > 0) {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(nuevoslist, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                } else {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(golfistas, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                }
            }
        });
        Collections.reverse(nuevoslist);
        pruebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pruebaordenlist.size() > 0) {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(pruebaordenlist, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                } else {
                    RecyclerView rv = findViewById(R.id.recyclerviewParticipantes);
                    RecyclerViewAdapter rva = new RecyclerViewAdapter(golfistas, MainActivity.this);
                    rv.setLayoutManager(
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                    rv.setAdapter(rva);
                }
            }
        });

    }

    public void showEmptyField() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Error");
        alertDialog.setMessage("No se ha encontrado ningun participante con ese DNI o Correo");
        alertDialog.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                startActivity(getIntent());
            }
        });
        alertDialog.show();
    }
}