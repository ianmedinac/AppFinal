package com.medina.ian.appfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Nivel extends AppCompatActivity {
    Button Principiante;
    Button Intermedio;
    Button Avanzado;
    TextView Nivel;
    public static String gnivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        Principiante = (Button) findViewById(R.id.button2);
        Intermedio = (Button) findViewById(R.id.button3);
        Avanzado = (Button) findViewById(R.id.button4);
        Nivel = (TextView) findViewById(R.id.textView);

        Principiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),Dias.class);
                gnivel="1";
                startActivity(b);
            }
        });

        Intermedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),Dias.class);
                gnivel="2";
                startActivity(b);
            }
        });

        Avanzado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),Dias.class);
                gnivel="3";
                startActivity(b);
            }
        });
    }
}
