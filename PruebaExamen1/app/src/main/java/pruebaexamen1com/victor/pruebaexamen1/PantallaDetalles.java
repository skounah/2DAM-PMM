package pruebaexamen1com.victor.pruebaexamen1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PantallaDetalles extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);
        Bundle bundlerecoje = getIntent().getExtras();

        //ASIGNACION DE VARIABLES JAVA A XML + RECOJIDA DEL BUNDLE.
        final TextView bebida = (TextView) findViewById(R.id.bebidaselect);
        bebida.setText(bundlerecoje.getString("BEBIDA"));
        final TextView preciobebida = (TextView) findViewById(R.id.preciobebibdaselect);
        preciobebida.setText(String.valueOf(bundlerecoje.getDouble("PRECIOBEBIDA")));

        final TextView envio = (TextView) findViewById(R.id.vasoselect);
        envio.setText(bundlerecoje.getString("ENVIO"));
        final TextView precioenvio = (TextView) findViewById(R.id.preciovasoselect);
        precioenvio.setText(String.valueOf(bundlerecoje.getDouble("PRECIOENVIO")));

        final TextView extras = (TextView) findViewById(R.id.extraselect);
        extras.setText(bundlerecoje.getString("EXTRAS"));
        final TextView precioextras = (TextView) findViewById(R.id.precioextraselect);
        precioextras.setText(String.valueOf(bundlerecoje.getDouble("PRECIOEXTRAS")));

        final TextView imagen = (TextView) findViewById(R.id.imagenbebida);
        imagen.setBackground(getDrawable(bundlerecoje.getInt("IMAGEN"))); // ERROR POR VERSION LOLYPOP FUNCIONA IGUALMENTE.

        final TextView total = (TextView)findViewById(R.id.totalpedido);
        total.setText(String.valueOf(bundlerecoje.getDouble("TOTAL")));

        //VOLVER ATRAS (IMAGEBUTTON)
        ImageButton botonvovler=(ImageButton) findViewById(R.id.botonvolver);
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
}
