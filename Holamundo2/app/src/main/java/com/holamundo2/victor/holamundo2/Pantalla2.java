package com.holamundo2.victor.holamundo2;

        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.widget.TextView;

public class Pantalla2 extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

    }
}

