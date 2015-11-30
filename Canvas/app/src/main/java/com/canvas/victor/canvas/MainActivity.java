package com.canvas.victor.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {


    private BitmapDrawable miImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        private ShapeDrawable miDrawable; // OVALO
        public EjemploView(Context contexto) {
            super(contexto);
            Resources res = contexto.getResources();
            //LOGO RIOT GAMES
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.logoriot);
            miImagen.setBounds(new Rect(30,90,200,260));

            //OVALO
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(Color.rgb(255,146,1));
            miDrawable.setBounds(30,430,330,580);
        }
        @Override
        protected void onDraw(Canvas canvas) {

            //DATOS DEL PINCEL1
            Paint pinceluno= new Paint();
            pinceluno.setColor(Color.BLUE);
            pinceluno.setStrokeWidth(10);
            pinceluno.setStyle(Paint.Style.STROKE);
            pinceluno.setTextSize(60);
            //DATOS DEL PINCEL2
            Paint pinceldos= new Paint();
            pinceldos.setColor(Color.rgb(146,12,142));
            pinceldos.setStrokeWidth(10);
            pinceldos.setStyle(Paint.Style.STROKE);
            pinceldos.setTextSize(60);

            //DATOS DEL PINCEL3
            Paint pinceltres=new Paint();
            pinceltres.setColor(Color.RED);
            pinceltres.setStrokeWidth(10);
            pinceltres.setStyle(Paint.Style.STROKE);
            pinceltres.setTextSize(60);

            //Dentro de este método utilizamos los métodos para dibujar BitmapDrawable
            canvas.drawText("DRAWABLE  ICONO - BITMAP",30,70,pinceltres);
            miImagen.draw(canvas);
            canvas.drawText("OVALO - SHAPE",30,370,pinceldos);
            miDrawable.draw(canvas);
            canvas.drawText("JJOO - CANVAS",300,670,pinceltres);
            //DIBUJO DE LOS JUEGOS OLIMPICOS
            for (int i=0;i<450;i+=150) { //1FILA JO
                if(i==150)pinceluno.setColor(Color.BLACK);
                if(i==300)pinceluno.setColor(Color.RED);
                canvas.drawCircle(350 + i, 800, 100, pinceluno);//COORDENADAS CENTRO Y RADIO
            }
            for (int j=0;j<400;j+=200){ //2FILA JO
                if(j==0)pinceluno.setColor(Color.rgb(245,225,0));
                if(j==200)pinceluno.setColor(Color.rgb(35,196,13));
                canvas.drawCircle(400 + j, 880, 100, pinceluno);
            }

            canvas.drawText("JUEGOS OLIMPICOS 1982",150,1100,pinceldos); //TITULO
        }
    }

}
