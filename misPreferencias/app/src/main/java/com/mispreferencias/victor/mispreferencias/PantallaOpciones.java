package com.mispreferencias.victor.mispreferencias;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Victor on 17/12/2015.
 */
public class PantallaOpciones extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
    }
}
