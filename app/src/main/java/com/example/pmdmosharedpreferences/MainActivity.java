package com.example.pmdmosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etDireccion, etEmail;
    private Button btGuardar, btMostrar, btSiguiente;
    private String nombre, direccion, email;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        initEvent();

        pref =  getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = pref.edit();

    }

    private void initComponents() {
        btGuardar = findViewById(R.id.btGuardar);
        btMostrar = findViewById(R.id.btMostrar);
        btSiguiente = findViewById(R.id.btSiguiente);
        etNombre = findViewById(R.id.etNombre);
        etDireccion = findViewById(R.id.etDireccion);
        etEmail = findViewById(R.id.etEmail);
    }

    private void initEvent() {
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("nombre", etNombre.getText().toString());
                editor.putString("direccion", etDireccion.getText().toString());
                editor.putString("email", etEmail.getText().toString());
                editor.commit();
            }
        });

        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = pref.getString("nombre", "Laura");
                direccion = pref.getString("direccion", "C/Paris");
                email = pref.getString("email", "laura@gmail.com");
                Log.i("xyz", "Nombre: "+nombre+" Direccion: "+direccion+" Email: "+email);
                Toast.makeText(MainActivity.this, "Email: "+email, Toast.LENGTH_SHORT);
            }
        });

        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(i);
            }
        });
    }

}
