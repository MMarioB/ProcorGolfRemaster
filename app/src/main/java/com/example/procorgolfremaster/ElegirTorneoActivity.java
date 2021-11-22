package com.example.procorgolfremaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ElegirTorneoActivity extends AppCompatActivity {
    String pasarInfo = "";
    Button btn_ir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_torneo);
        String[] arraySpinner = new String[]{
                "Madrid", "Sevilla", "Valencia", "Tenerife", "Caceres", "Leon", "Segovia"
        };
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_spinner, R.id.text1, arraySpinner);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = spinner.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_LONG).show();
                pasarInfo = selectedItem;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_ir = findViewById(R.id.btn_Ir);
        btn_ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segunda_pantalla(v);
            }
        });


    }

    public void segunda_pantalla(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("datos", pasarInfo);
        startActivity(i);
    }
}
