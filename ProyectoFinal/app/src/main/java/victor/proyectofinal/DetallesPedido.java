package victor.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Victor on 13/02/2016.
 */
public class DetallesPedido extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verpedido);
        Bundle bundlerecoje = getIntent().getExtras();
        final String pasausuario4 = bundlerecoje.getString("IDUSUARIO");

        //ASIGNACION DE VARIABLES JAVA A XML + RECOJIDA DEL BUNDLE.(NO MUESTRA EL USUARIO AQUI)
        final TextView bebida = (TextView) findViewById(R.id.bebidaselect);
        bebida.setText(bundlerecoje.getString("BEBIDA"));
        final TextView preciobebida = (TextView) findViewById(R.id.preciobebibdaselect);
        preciobebida.setText(String.valueOf(bundlerecoje.getDouble("PRECIOBEBIDA")));

        final TextView envio = (TextView) findViewById(R.id.vasoselect);
        envio.setText(bundlerecoje.getString("VASO"));
        final TextView precioenvio = (TextView) findViewById(R.id.preciovasoselect);
        precioenvio.setText(String.valueOf(bundlerecoje.getDouble("PRECIOVASO")));

        final TextView extras = (TextView) findViewById(R.id.extraselect);
        extras.setText(bundlerecoje.getString("EXTRAS"));
        final TextView precioextras = (TextView) findViewById(R.id.precioextraselect);
        precioextras.setText(String.valueOf(bundlerecoje.getDouble("PRECIOEXTRAS")));

        final TextView imagen = (TextView) findViewById(R.id.imagenbebida);
        imagen.setBackground(getDrawable(bundlerecoje.getInt("IMAGEN"))); // ERROR POR VERSION LOLYPOP FUNCIONA IGUALMENTE.

        final TextView total = (TextView) findViewById(R.id.totalpedido);
        total.setText(String.valueOf(bundlerecoje.getDouble("TOTAL")));


        ImageButton botonvovler=(ImageButton) findViewById(R.id.botonvolver);
        botonvovler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVolver = new Intent(DetallesPedido.this,MainActivity.class);
                Bundle bundleVolver = new Bundle();
                bundleVolver.putString("IDUSUARIO",pasausuario4);
                intentVolver.putExtras(bundleVolver);
                setResult(RESULT_OK, intentVolver);
                startActivity(intentVolver);
            }
        });

    }
}
