package com.dubujos.victor.dibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
        //setContentView(R.layout.activity_main);
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
        }
        @Override

        //METODO DE DIBUJAR
        protected void onDraw(Canvas canvas) {
            //DATOS DEL PINCEL1
            Paint pinceluno= new Paint();
            pinceluno.setColor(Color.BLUE);
            pinceluno.setStrokeWidth(15);
            pinceluno.setStyle(Paint.Style.STROKE);
            pinceluno.setTextSize(60);
            //DATOS DEL PINCEL2
            Paint pinceldos= new Paint();
            pinceldos.setColor(Color.rgb(35,196,13));
            pinceldos.setStrokeWidth(5);
            pinceldos.setStyle(Paint.Style.FILL);
            pinceldos.setTextSize(60);


            //DIBUJO DE LOS JUEGOS OLIMPICOS
            for (int i=0;i<900;i+=300) { //1FILA JO
                if(i==300)pinceluno.setColor(Color.BLACK);
                if(i==600)pinceluno.setColor(Color.RED);
                canvas.drawCircle(250 + i, 500, 200, pinceluno);//COORDENADAS CENTRO Y RADIO
            }
            for (int j=0;j<800;j+=400){ //2FILA JO
                if(j==0)pinceluno.setColor(Color.rgb(245,225,0));
                if(j==400)pinceluno.setColor(Color.rgb(35,196,13));
                canvas.drawCircle(350 + j, 700, 200, pinceluno);
            }
            canvas.drawText("JUEGOS OLIMPICOS 1982",200,1000,pinceldos); //TITULO


            RectF cuadrado = new RectF(600,1200,700,1300); //CREACION DE CUADRADO PARA SIMBOLO ANDROID
            canvas.drawCircle(650,1200,50,pinceldos);      //CIRCULO
            canvas.drawRect(cuadrado,pinceldos);           //DIBUJO DEL CUADRADO DE ANDROID
        }
    }
}
