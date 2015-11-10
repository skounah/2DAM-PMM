package radiobuttoncolorescom.victor.raddiobuttoncolores;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView colorfondo = (TextView) findViewById(R.id.colorfondo);
        final RadioGroup radiogroup = (RadioGroup) findViewById(R.id.grupoboton);
        final Button botonok = (Button) findViewById(R.id.buttonAceptar);
        final Button botonborrar = (Button)findViewById(R.id.buttonBorrar);
        radiogroup.clearCheck();

        botonok.setOnClickListener(new View.OnClickListener() {     // Me daba un error que deica unsuported lambda expresion
            @Override
            public void onClick(View v) {
                if (radiogroup.getCheckedRadioButtonId() == R.id.botonRojo) {
                    Toast toastrojo = Toast.makeText(getApplicationContext(), "ROJO", Toast.LENGTH_SHORT);
                    toastrojo.show();
                    colorfondo.setBackgroundColor(Color.RED);
                }
                if (radiogroup.getCheckedRadioButtonId() == R.id.botonAzul) {
                    Toast toastazul = Toast.makeText(getApplicationContext(), "AZUL", Toast.LENGTH_SHORT);
                    toastazul.show();
                    colorfondo.setBackgroundColor(Color.BLUE);
                }
                if (radiogroup.getCheckedRadioButtonId() == R.id.botonVerde) {
                    Toast toastverde = Toast.makeText(getApplicationContext(), "VERDE", Toast.LENGTH_SHORT);
                    toastverde.show();
                    colorfondo.setBackgroundColor(Color.GREEN);
                }
            }
        });

        botonborrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast toastborrar = Toast.makeText(getApplicationContext(), "BORRANDO...", Toast.LENGTH_SHORT);
                toastborrar.show();
                colorfondo.setBackgroundColor(Color.WHITE);
                radiogroup.clearCheck();
            }
        });


    } //del onCreate
}// de la clase
