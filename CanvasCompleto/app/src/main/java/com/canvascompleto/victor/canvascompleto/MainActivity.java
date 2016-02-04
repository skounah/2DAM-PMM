package com.canvascompleto.victor.canvascompleto;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    //AQUI PUEDEN IR LAS SUBLACES(BITMAP,SHAPE,LAYER,STATELIST,GRADIENT... PARA BIBUJAR


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(new EjemploView(this));//PONE LA CLASE EJEMPLOVIEW COMO "PANTALLA"
        setContentView(R.layout.main_activity);

    }//DEL ONCRATE

    public static class EjemploView extends View { // CLASE QUE EXTIENDE DE VIEW

        private ShapeDrawable miDrawable; // SUBCLASE PARA DIBUJAR GRAFICOS (OVALO)
        private BitmapDrawable miImagen; // SUBCLASE PARA DIBUJAR MAPAS DE BITS (ICONO)
        //private GradientDrawable miGradiente; SUBCLASE PARAPNER EL FONDO CON GRADIENTE

        public EjemploView(Context context, AttributeSet attrs) {
            super(context, attrs);
            Resources res = context.getResources();
            setBackgroundResource(R.drawable.degradado);// FONDO CON ARCHIVO XML

            //LOGO RIOT GAMES
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.logoriot);
            miImagen.setBounds(new Rect(30,90,200,260)); //CORDENADAS (X1,Y1,X2,Y2)

            //OVALO
            miDrawable = new ShapeDrawable(new OvalShape()); //DIBUJA GRAFICO DE TIPO OVALO
            miDrawable.getPaint().setColor(Color.rgb(255, 146, 1));
            miDrawable.setBounds(30, 430, 330, 580);  //CORDENADAS (X1,Y1,AMPLIACION X, AMPLIACION Y)

        }//CONSTRUCTOR


        public EjemploView(Context contexto) {
            super(contexto);
            Resources res = contexto.getResources();
            setBackgroundResource(R.drawable.degradado);// FONDO CON ARCHIVO XML

            //LOGO RIOT GAMES
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.logoriot);
            miImagen.setBounds(new Rect(30,90,200,260)); //CORDENADAS (X1,Y1,X2,Y2)

            //OVALO
            miDrawable = new ShapeDrawable(new OvalShape()); //DIBUJA GRAFICO DE TIPO OVALO
            miDrawable.getPaint().setColor(Color.rgb(255, 146, 1));
            miDrawable.setBounds(30, 430, 330, 580);  //CORDENADAS (X1,Y1,AMPLIACION X, AMPLIACION Y)

            /* FONDO DE VIEW SIN XML NECESITA API 16 O MAS PARA EL SET COLORS
            int[] c1 = {Color.BLACK,Color.WHITE};
            miGradiente.setColors(c1);*/

        }//DEL CONTRUCTOR


        @Override
        //METODO PARA DIBUJAR (DE LA  CLASE EJEMPLO VIEW)Dentro de este método utilizamos los distintos métodos para dibujar
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

            //ICONO
            canvas.drawText("DRAWABLE  ICONO - BITMAP",30,70,pinceltres);
            miImagen.draw(canvas);
            //OVALO
            canvas.drawText("OVALO - SHAPE",30,370,pinceldos);
            miDrawable.draw(canvas);
            //JJOO
            canvas.drawText("JJOO - CANVAS",300,670,pinceltres);
            for (int i=0;i<450;i+=150) { //1FILA JJOO
                if(i==150)pinceluno.setColor(Color.BLACK);
                if(i==300)pinceluno.setColor(Color.RED);
                canvas.drawCircle(350 + i, 800, 100, pinceluno);}//COORDENADAS CENTRO (X,Y, RADIO,PINCEL)
            for (int j=0;j<400;j+=200){ //2FILA JJOO
                if(j==0)pinceluno.setColor(Color.rgb(245,225,0));
                if(j==200)pinceluno.setColor(Color.rgb(35,196,13));
                canvas.drawCircle(400 + j, 880, 100, pinceluno);}//COORDENADAS CENTRO (X,Y, RADIO,PINCEL
            canvas.drawText("JUEGOS OLIMPICOS 1982", 150, 1100, pinceldos); //TITULO JJOO

            //miGradiente.draw(canvas); //DIBUJA EL CANVAS EN CASO DE NO ESTAR EN XML

        }//DEL METODO ONDRAW

    } //DE LA CLASE EJEMPLOVIEW

} //DE LA CLASE MAIN
