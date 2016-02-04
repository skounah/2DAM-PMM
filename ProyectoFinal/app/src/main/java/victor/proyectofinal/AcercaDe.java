package victor.proyectofinal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.app.Activity;


public class AcercaDe  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade);
    }//ONCREATE

    public static class EjemploView extends View {
        private BitmapDrawable iconoRest;

        public EjemploView(Context context, AttributeSet attrs) {
            super(context, attrs);
            Resources res = context.getResources();

            //ICONO RESTAURANTE
            iconoRest = (BitmapDrawable) res.getDrawable(R.drawable.iconocasaskoner);
            iconoRest.setBounds(new Rect(70,10,1000,300));
        }//CONTRUCTOR

        @Override
        protected void onDraw(Canvas canvas) {
            //DATOS DEL PINCEL1
            Paint pinceluno = new Paint();
            pinceluno.setColor(Color.BLACK);
            pinceluno.setStrokeWidth(10);
            pinceluno.setStyle(Paint.Style.STROKE);
            pinceluno.setTextSize(60);
            //DATOS DEL PINCEL2
            Paint pinceldos = new Paint();
            pinceldos.setColor(Color.BLUE);
            //pinceldos.setColor(Color.rgb(146, 12, 142));
            pinceldos.setStrokeWidth(10);
            pinceldos.setStyle(Paint.Style.STROKE);
            pinceldos.setTextSize(75);
            //DATOS DEL PINCEL3
            Paint pinceltres = new Paint();
            pinceltres.setColor(Color.rgb(255,165,27));
            pinceltres.setStyle(Paint.Style.FILL_AND_STROKE);
            pinceltres.setStrokeWidth(10);

            iconoRest.draw(canvas);
            //canvas.drawText("RESTAURANTE CASA SKONER.", 30, 100, pinceldos);

            //CORONA

            Path path = new Path();
            path.moveTo(350, 400);//DE1
            path.lineTo(400, 500);//A2
            path.moveTo(400, 500);//DE2
            path.lineTo(600, 500);//A3
            path.moveTo(600, 500);//DE3
            path.lineTo(650, 400);//A4
            path.moveTo(650, 400);//DE4
            path.lineTo(550, 450);//A5
            path.moveTo(550, 450);//DE5
            path.lineTo(500, 300);//A6
            path.moveTo(500, 300);//DE6
            path.lineTo(450, 450);//A7
            path.moveTo(450, 450);//DE7
            path.lineTo(350, 400);//A1
            path.close();
            pinceltres.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawPath(path, pinceltres);

            //CARA
            canvas.drawCircle(500, 570, 113, pinceluno);//CABEZA
            canvas.drawCircle(460, 550, 10, pinceldos);//OJO1
            canvas.drawCircle(540, 550, 10, pinceldos);//OJO2

            //CUERPO
            canvas.drawRect(400, 690, 600, 990, pinceluno);
            //BRAZODERECHO
            Path brazo = new Path();
            brazo.moveTo(600,690);
            brazo.lineTo(700, 790);
            brazo.moveTo(700, 790);
            brazo.lineTo(770, 600);
            brazo.moveTo(770, 600);
            brazo.lineTo(755, 555);
            brazo.moveTo(770,600);
            brazo.lineTo(785, 555);
            //brazo.close();
            canvas.drawPath(brazo, pinceluno);
            //BRAZOIZQUIERDO
            Path brazo2 = new Path();
            brazo2.moveTo(400,690);
            brazo2.lineTo(250,730);
            brazo2.lineTo(400,920);
            canvas.drawPath(brazo2,pinceluno);

            canvas.drawText("GRACIAS POR SU VISITA.", 220, 1100, pinceluno);
        }//ONDRAW
    }//CLASE EJEMPLOVIEW
}//CLASE ACERCA DE
