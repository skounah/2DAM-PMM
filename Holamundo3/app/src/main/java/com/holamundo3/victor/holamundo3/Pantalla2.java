package com.holamundo3.victor.holamundo3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo=(TextView)findViewById(R.id.miMensaje);
        final Button miBoton2=(Button)findViewById(R.id.botonatras);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarSaludo=miBundleRecoger.getString("TEXTO");


        miBoton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent miIntent2 = new Intent();
                    Bundle miBundle2 = new Bundle();

                    String mensajedevuelta = "Devuelto a pantalla princcipal: " + completarSaludo;
                    miBundle2.putString("clave", mensajedevuelta); //????????
                    miIntent2.putExtras(miBundle2);
                    setResult(RESULT_OK, miIntent2);
                    startActivity(miIntent2);
                    //finish();
            }
        });

        showAlert();
        //showToast();
    }


    protected void showAlert() {
        CharSequence text = getResources().getString(R.string.noNameMsg2);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);    alert.setPositiveButton(android.R.string.ok, null);
        alert.show(); }

}

