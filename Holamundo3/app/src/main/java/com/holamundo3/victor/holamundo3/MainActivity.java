package com.holamundo3.victor.holamundo3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public static int COD_RESPUESTA=0;
    TextView elSaludo;
    TextView elsaludo2;
     MediaPlayer miMusica;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miMusica= MediaPlayer.create(getApplicationContext(),R.raw.cancion); // musica
        final EditText miTexto = (EditText) findViewById(R.id.miTxt);  // pantalla de texto
        final Button miBoton = (Button) findViewById(R.id.miBtn);      // boton

        elSaludo = (TextView) findViewById(R.id.miLabel); // texto=hola caracola  ?????????

        if (savedInstanceState!=null){     // si vengo de otra pantalla
            String mensajePasado=savedInstanceState.getString("TEXTO");
            elSaludo.setText(mensajePasado);
        }


        // borra el texto inicial del edit text al clickear
        miTexto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 miTexto.setText("");
            }
        });


        miBoton.setOnClickListener(new View.OnClickListener() {  //Espera que le hagan click
            public void onClick(View v) { // Lo que hace con el click
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class); // sirve para cambiar de pantalla
                Bundle miBundle = new Bundle(); //Crea un contenedor;

                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
                //startActivityForResult(miIntent, COD_RESPUESTA); //copiado
                miMusica.pause();// para musica cuando clicas.

            }
        });

        miMusica.start();
        showToast();
        //showAlert();
    };

    protected void onRestart(){
        final MediaPlayer miMusica= MediaPlayer.create(getApplicationContext(),R.raw.cancion);
        miMusica.start();
        Bundle otroBundle = getIntent().getExtras();
        elsaludo2.setText(otroBundle.getString("clave"));
    }

    protected void showToast() {
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.noNameMsg);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show(); }


   /* public void onActivityResult(int cod_resp, int cod_result,Intent intent) {
        if (cod_result== RESULT_OK) {
            Bundle otroBundle = getIntent().getExtras();
            elSaludo.setText(otroBundle.getString("clave"));     //elSaludo???????? y DEVUELTO???????
        }
    }*/

}