package com.medina.ian.appfinal;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;

public class Rutina extends AppCompatActivity {
    ScrollView rutinas;
    String ejer;

    String ejercicios[][] = {{"5","upper","peso","moderado","moderado","alto"},
            {"5","upper","press banca","3x12","4x12","5x5"},
            {"5","upper","press militar","3x12","4x12","4x8"},
            {"5","upper","press banca cerrado","3x12","4x12","4x8"},
            {"5","upper","dominadas","3x4","4x6","4x10"},
            {"5","upper","curl","3x12","4x12","4x8"},
            {"5","upper","fondos","3x6","4x8","4x10"},
            {"5","lower","peso","moderado","moderado","alto"},
            {"5","lower","sentadilla","3x10","3x12","5x5"},
            {"5","lower","peso muerto","3x10","3x12","3x8"},
            {"5","lower","extension de pierna","3x12","4x12","4x12"},
            {"5","lower","curl pierna","3x10","4x10","4x10"},
            {"5","lower","levantamiento pantorrilla","3x12","4x12","4x12"},
            {"3,5","Push","peso","moderado","moderado","moderado"},
            {"3,5","Push","press banca inclinado","3x10","3x10","3x10"},
            {"3,5","Push","press banca","3x10","3x10","3x10"},
            {"3,5","Push","press militar","3x10","3x10","3x10"},
            {"3,5","Push","press mancuernas","3x10","3x10","3x10"},
            {"3,5","Push","extensiones tricep","3x12","3x12","3x12"},
            {"3,5","Push","skul crusher","3x12","3x12","3x12"},
            {"3,5","pull","peso","moderado","moderado","moderado"},
            {"3,5","pull","peso muerto","3x10","3x10","3x10"},
            {"3,5","pull","body row","3x12","3x12","3x12"},
            {"3,5","pull","dominadas","3x4","4x6","4x10"},
            {"3,5","pull","curl","4x12","4x12","4x12"},
            {"3,5","pull","curl martillo","4x12","4x12","4x12"},
            {"3,5","legs","peso","moderado","moderado","moderado"},
            {"3,5","legs","sentadilla","3x10","3x10","3x10"},
            {"3,5","legs","extension de pierna","3x12","3x12","3x12"},
            {"3,5","legs","curl pierna","4x10","4x10","4x10"},
            {"3,5","legs","levantamiento pantorrilla","4x12","4x12","4x12"},
            {"3,5","legs","levantamiento sentado","4x12","4x12","4x12"}};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StringBuilder cadena = new StringBuilder();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina);
        int x_nivel;

        final LinearLayout botonera = (LinearLayout) findViewById(R.id.botonera);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT );
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        //lista de cadenas para sacar de la martirz los grupos de ejercicios para hacer los botones de arriba
        final ArrayList<String> grupos = new  ArrayList<String>();
        // recorrer la lista de ejercicios, y discrimina los ejercicios de manera que si el ejercicio no esta y aparte con cuerda con el numero de dias se agrega a la lista
        //los discrimina para poder crear los botones de los grupos de ejercicios
        for (int i=0; i < ejercicios.length; i++) {
            if(!grupos.contains(ejercicios[i][1]) && ejercicios[i][0].contains(Dias.gdias)){
                grupos.add(ejercicios[i][1]);
            }
        }

        if( grupos.size()<4) { //cuando son menos de 4 botones solo mete un renglon de botones
            LinearLayout renglon = new LinearLayout(this);
            renglon.setOrientation(LinearLayout.HORIZONTAL);
            renglon.setLayoutParams(lp2);

            //entra en un ciclo para crear un boton y asignarle el nombre de los valores de los grupos para mostrar los ejercicios
            for (int i = 0; i < grupos.size(); i++) {
                final Button ejerc = new Button(this);
                ejerc.setText(grupos.get(i));
                ejerc.setLayoutParams(lp);
                ejerc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //de manera dinamica al momento de hacer click al boton muestra los ejercicios que tienen el valor del boton
                        CharSequence text = ejerc.getText();
                        listar_ejercicios( botonera, 1 , text);
                    }
                });
                renglon.addView(ejerc);
            }
            botonera.addView(renglon);
        } else { //si son 4 botones agrega dos renglones para botones
                LinearLayout renglon = new LinearLayout(this);
                renglon.setLayoutParams(lp2);
                renglon.setOrientation(LinearLayout.HORIZONTAL);
//en el renglon uno añade 3 botones
                for (int i = 0; i < 3; i++) {
                    final Button ejerc = new Button(this);
                    ejerc.setText(grupos.get(i));
                    ejerc.setLayoutParams(lp);
                    ejerc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CharSequence text = ejerc.getText();
                            listar_ejercicios( botonera, 2 , text);
                        }
                    });
                    renglon.addView(ejerc);
                }
                botonera.addView(renglon);

                LinearLayout renglon2 = new LinearLayout(this);
                renglon2.setLayoutParams(lp2);
                renglon2.setOrientation(LinearLayout.HORIZONTAL);
//en el renglon 2 añade 2 botones
                for (int i = 3; i < grupos.size(); i++) {
                    final Button ejerc = new Button(this);
                    ejerc.setText(grupos.get(i));
                    ejerc.setLayoutParams(lp);
                    ejerc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CharSequence text = ejerc.getText();
                            listar_ejercicios( botonera, 2 , text);
                        }
                    });
                    renglon2.addView(ejerc);
                }
                botonera.addView(renglon2);
            }

        cadena.append(Nivel.gnivel);
        cadena.append("\n");
        cadena.append(Dias.gdias+": "+ejercicios.length+"\n\n");
        for (int i=0; i < ejercicios.length; i++) {
            if( ejercicios[i][0].contains(Dias.gdias)) {
                x_nivel=2+Integer.parseInt(Nivel.gnivel);
                cadena.append(ejercicios[i][2] +": "+ ejercicios[i][x_nivel]+ "\n");
            }
        }
        //rutina.setText(cadena);

    }

    void image_select(ImageView img, String ejerc){
        if( ejerc == "press banca"){
            img.setImageResource(R.drawable.pressdebanca);
        }
        if( ejerc == "press militar"){
            img.setImageResource(R.drawable.pressmilitar);
        }
        if( ejerc == "press banca inclinado"){
            img.setImageResource(R.drawable.inclinedpress);
        }
        if( ejerc == "dominadas"){
            img.setImageResource(R.drawable.dominada1);
        }
        if( ejerc == "curl"){
            img.setImageResource(R.drawable.curl);
        }
        if( ejerc == "fondos"){
            img.setImageResource(R.drawable.fondo);
        }
        if( ejerc == "sentadilla"){
            img.setImageResource(R.drawable.sentadillas);
        }
        if( ejerc == "peso muerto"){
            img.setImageResource(R.drawable.pesomuerto);
        }
        if( ejerc == "extension de pierna"){
            img.setImageResource(R.drawable.extensiondepierna);
        }
        if( ejerc == "curl pierna"){
            img.setImageResource(R.drawable.curldepierna);
        }
        if( ejerc == "levantamiento pantorrilla"){
            img.setImageResource(R.drawable.levantamientopantorrilla);
        }
        if( ejerc == "press mancuernas"){
            img.setImageResource(R.drawable.pressmancuernas);
        }
        if( ejerc == "extensiones tricep"){
            img.setImageResource(R.drawable.extenciondetricep);
        }
        if( ejerc == "skul crusher"){
            img.setImageResource(R.drawable.skullcrusher);
        }
        if( ejerc == "curl martillo"){
            img.setImageResource(R.drawable.curlmartillo);
        }
        if( ejerc == "levantamiento sentado"){
            img.setImageResource(R.drawable.pantorillassentado);
        }
        if( ejerc == "body row"){
            img.setImageResource(R.drawable.bodyrow);
        }
        if( ejerc == "press banca cerrado"){
            img.setImageResource(R.drawable.closegrippress);
        }

    }

 //cuando hay 3 botones al momento de mostrar los ejercicios y querer borrarlo, depende de los renglones de botones empieza a eliminar la informacion o en el renglon 1 o en el 2
    void listar_ejercicios( LinearLayout b, int i, CharSequence contenido ){
        int eliminar=b.getChildCount();
        b.removeViews(i,eliminar-i);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT );
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(80,80);

        for( int x=0; x < ejercicios.length; x++){
            if(ejercicios[x][1] == contenido ) {
                LinearLayout renglon = new LinearLayout(this);
                renglon.setLayoutParams(lp2);
                renglon.setOrientation(LinearLayout.HORIZONTAL);

                //TextView imagen = new TextView(this);
                //imagen.setText("Imagen ");
                //imagen.setLayoutParams(lp);

                ImageView imagen = new ImageView(this);
                image_select(imagen,ejercicios [x][2]);
                //imagen.setImageResource(R.drawable.pressdebanca);
                imagen.setLayoutParams(lp3);
                renglon.addView(imagen);


                TextView ejercicio= new TextView(this);
                ejercicio.setText(ejercicios[x][2]);
                ejercicio.setLayoutParams(lp);
                renglon.addView(ejercicio);

                TextView repeticiones = new TextView(this);
                repeticiones.setText(ejercicios[x][2+Integer.parseInt(Nivel.gnivel)]);
                repeticiones.setLayoutParams(lp);
                renglon.addView(repeticiones);

                b.addView(renglon);
            }
        }
    }

}
