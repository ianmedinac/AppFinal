package com.medina.ian.appfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dias extends AppCompatActivity {
    Button Tres;
    Button Cinco;
    TextView Dias;
    String prueba;
    public static String gdias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias);
        Tres = (Button) findViewById(R.id.button6);
        Cinco = (Button) findViewById(R.id.button7);
        Dias = (TextView) findViewById(R.id.textView2);

        Tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),Rutina.class);
                gdias="3";
                startActivity(c);
            }
        });

        Cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),Rutina.class);
                gdias="5";
                startActivity(c);
            }
        });
    }


}
