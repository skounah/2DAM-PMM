package com.mispreferencias.victor.mispreferencias;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;

/**
 * Created by Victor on 17/12/2015.
 */
public class MainActivity extends ActionBarActivity {
    private Button btnPreferencias;
    private Button btnObtenerPreferencias;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreferencias = (Button)findViewById(R.id.Preferencias);
        btnObtenerPreferencias = (Button)findViewById(R.id.Obtener);
    }
}
