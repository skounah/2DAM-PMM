package com.preferencias.victor.preferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Victor on 17/12/2015.
 */
public class EjemploPreferencias extends ActionBarActivity {
    private Button btnPreferencias;
    private Button btnObtenerPreferencias;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main.layout);

        btnPreferencias = (Button)findViewById(R.id.BtnPreferencias);
        btnObtenerPreferencias = (Button)findViewById(R.id.BtnObtenerPreferencias);
        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EjemploPreferencias.this,   PantallaOpciones.class));
            }
        });
        btnObtenerPreferencias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(EjemploPreferencias.this);
                Log.i("", "Opción 1: " + pref.getBoolean("opcion1", false));
                Log.i("", "Opción 2: " + pref.getString("opcion2", ""));
                Log.i("", "Opción 3: " + pref.getString("opcion3", ""));
            });
        }
    }

}

