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

public class SegundaActivity extends AppCompatActivity {
    private EditText etTelefono;
    private Button btSiguiente;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        initComponents();
        initEvent();

        pref =  getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    private void initComponents() {
        etTelefono = findViewById(R.id.etTelefono);
        btSiguiente = findViewById(R.id.btSiguiente);
    }

    private void initEvent() {
        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    editor.putString("telefono", etTelefono.getText().toString());
                    editor.commit();
                    Log.i("xyz", etTelefono.getText().toString());
                    Intent i = new Intent(SegundaActivity.this, TerceraActivity.class);
                    startActivity(i);
            }
        });
    }
}
