package vromerocom.victor.vromero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Victor on 09/11/2015.
 */
    public class PantallaDetalles extends ActionBarActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detalles);
            Bundle bundlerecoje = getIntent().getExtras();

            //ASIGNACION DE VARIABLES JAVA A XML + RECOJIDA DEL BUNDLE.
            final TextView pizza = (TextView) findViewById(R.id.pizzaselect);
            pizza.setText(bundlerecoje.getString("PIZZA"));
            final TextView preciopizza = (TextView) findViewById(R.id.preciopizzaselect);
            preciopizza.setText(String.valueOf(bundlerecoje.getDouble("PRECIOPIZZA")));

            final TextView envio = (TextView) findViewById(R.id.envioselect);
            envio.setText(bundlerecoje.getString("ENVIO"));
            final TextView precioenvio = (TextView) findViewById(R.id.precioenvioselect);
            precioenvio.setText(String.valueOf(bundlerecoje.getDouble("PRECIOENVIO")));

            final TextView extras = (TextView) findViewById(R.id.extraselect);
            extras.setText(bundlerecoje.getString("EXTRAS"));
            final TextView precioextras = (TextView) findViewById(R.id.precioextraselect);
            precioextras.setText(String.valueOf(bundlerecoje.getDouble("PRECIOEXTRAS")));

            final TextView unidades = (TextView) findViewById(R.id.unidades);
            unidades.setText(String.valueOf(bundlerecoje.getInt("UNIDADES")));

            final TextView imagen = (TextView) findViewById(R.id.imagenpizza);
            imagen.setBackground(getDrawable(bundlerecoje.getInt("IMAGEN"))); // ERROR POR VERSION LOLYPOP FUNCIONA IGUALMENTE.

            final TextView total = (TextView) findViewById(R.id.totalpedido);
            total.setText(String.valueOf(bundlerecoje.getDouble("TOTAL")));

            //VOLVER ATRAS (IMAGEBUTTON)
            ImageButton botonvovler = (ImageButton) findViewById(R.id.botonvolver);
            botonvovler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentVolver = new Intent();
                    Bundle bundleVolver = new Bundle();
                    intentVolver.putExtras(bundleVolver);
                    setResult(RESULT_OK, intentVolver);
                    finish();
                }
            });
        }

    /*public String getExtraClick(View v){ // NO M HA DADO TIEMPO A IMPLENETARLO
       /String relojito="";
        return relojito;
        if(checkreloj.isChecked()){
            relojito=checkrelojito.setVisible=true;
            ;
    }*/





}
