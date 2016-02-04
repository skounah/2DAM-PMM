package com.misfigurasaleatorias.victor.animacionytransicion;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    AnimationDrawable mi_animacion;
    TransitionDrawable mi_transicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TRANSUCION
        ImageView viewtransition = (ImageView) findViewById(R.id.transicion); //ASIGNACION DE JAVA A XML
        mi_transicion = (TransitionDrawable) getResources().getDrawable(R.drawable.transicion); //ASIGNACION DE FICHERO XML A VARIABLE JAVA
        viewtransition.setImageDrawable(mi_transicion);//PONE LA IMAGEN
        mi_transicion.startTransition(4000);

        //ANIMACION
        ImageView viewanimation = (ImageView) findViewById(R.id.animacion);
        mi_animacion = (AnimationDrawable) getResources().getDrawable(R.drawable.animacion);
        viewanimation.setImageDrawable(mi_animacion);

    }
        public boolean onTouchEvent(MotionEvent evento) {
            //Al realizar una pulsación en pantalla
            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                //Ponemos en marcha la animación
                mi_animacion.start();
                return true;
            }
            return super.onTouchEvent(evento);
        }






}
