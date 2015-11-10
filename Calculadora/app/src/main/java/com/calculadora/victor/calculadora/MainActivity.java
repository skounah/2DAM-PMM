package com.calculadora.victor.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    boolean suma=false;
    boolean resta=false;
    boolean mult=false;
    boolean div=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button n0 = (Button)findViewById(R.id.boton0);
        n0.setOnClickListener(this);
        Button n1 = (Button)findViewById(R.id.boton1);
        n1.setOnClickListener(this);
        Button n2 = (Button)findViewById(R.id.boton2);
        n2.setOnClickListener(this);
        Button n3 = (Button)findViewById(R.id.boton3);
        n3.setOnClickListener(this);
        Button n4 = (Button)findViewById(R.id.boton4);
        n4.setOnClickListener(this);
        Button n5 = (Button)findViewById(R.id.boton5);
        n5.setOnClickListener(this);
        Button n6 = (Button)findViewById(R.id.boton6);
        n6.setOnClickListener(this);
        Button n7 = (Button)findViewById(R.id.boton7);
        n7.setOnClickListener(this);
        Button n8 = (Button)findViewById(R.id.boton8);
        n8.setOnClickListener(this);
        Button n9 = (Button)findViewById(R.id.boton9);
        n9.setOnClickListener(this);
        Button nmas = (Button)findViewById(R.id.botonmas);
        nmas.setOnClickListener(this);
        Button nmenos = (Button)findViewById(R.id.botonmenos);
        nmenos.setOnClickListener(this);
        Button npor = (Button)findViewById(R.id.botonpor);
        npor.setOnClickListener(this);
        Button nentre = (Button)findViewById(R.id.botonentre);
        nentre.setOnClickListener(this);
        Button nc = (Button)findViewById(R.id.botonc);
        nc.setOnClickListener(this);
        Button nigual = (Button)findViewById(R.id.botonigual);
        nigual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView texto = (TextView)findViewById(R.id.pantalla);
        int seleccion=v.getId();
        String acu=texto.getText().toString();
        double[] numero=new double[2];
        double resultado;

        switch (seleccion){
            case R.id.boton0:
                texto.setText(acu+"0");
                break;
            case R.id.boton1:
                texto.setText(acu+"1");
                break;
            case R.id.boton2:
                texto.setText(acu+"2");
                break;
            case R.id.boton3:
                texto.setText(acu+"3");
                break;
            case R.id.boton4:
                texto.setText(acu+"4");
                break;
            case R.id.boton5:
                texto.setText(acu+"5");
                break;
            case R.id.boton6:
                texto.setText(acu+"6");
                break;
            case R.id.boton7:
                texto.setText(acu+"7");
                break;
            case R.id.boton8:
                texto.setText(acu+"8");
                break;
            case R.id.boton9:
                texto.setText(acu+"9");
                break;
            case R.id.botonmas:
                suma=true;
                numero[1]= Double.parseDouble(acu);
                texto.setText("");
                break;
            case R.id.botonmenos:
                resta=true;
                numero[1]= Double.parseDouble(acu);
                texto.setText("");
                break;
            case R.id.botonpor:
                resta=true;
                numero[1]= Double.parseDouble(acu);
                texto.setText("");
                break;
            case R.id.botonentre:
                div=true;
                numero[1]= Double.parseDouble(acu);
                texto.setText("");
                break;
            case R.id.botonc:
                texto.setText("");

                break;
            case R.id.botonigual:

                numero[2]= Double.parseDouble(acu);
                if (suma==true){
                    resultado= numero[1] + numero[2];
                    texto.setText(String.valueOf(resultado));
                }
                else if(resta==true){
                    resultado= numero[1] - numero[2];
                    texto.setText(String.valueOf(resultado));
                }else if (mult==true){
                    resultado= numero[1] * numero[2];
                    texto.setText(String.valueOf(resultado));
                }else if (div==true){
                    resultado= numero[1] / numero[2];
                    texto.setText(String.valueOf(resultado));
                }
                suma=false;
                resta=false;
                mult=false;
                div=false;
                break;
        }
    }
}