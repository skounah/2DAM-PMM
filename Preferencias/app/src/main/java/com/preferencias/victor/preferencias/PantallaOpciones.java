package com.preferencias.victor.preferencias;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PantallaOpciones extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
        //addPreferencesFromResource(R.xml.opciones);
    }
}
