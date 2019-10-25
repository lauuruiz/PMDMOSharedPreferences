package com.example.pmdmosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class TerceraActivity extends AppCompatActivity {
    private TextView tvTotal;
    private String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        initComponents();

        SharedPreferences pref =  getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        total = "Nombre: "+pref.getString("nombre", "Laura");
        total = total + "\n\nDireccion: " + pref.getString("direccion", "C/Paris");
        total = total + "\n\nEmail: " + pref.getString("email", "laura@gmail.com");
        total = total + "\n\nTelefono: " + pref.getString("telefono", "958473984");

        tvTotal.setText(total);
    }

    private void initComponents() {
        tvTotal = findViewById(R.id.tvResultado);
    }

}
