package calculadoraentryscom.victor.calculadoraentrys;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText numero1 = (EditText)findViewById(R.id.numero1);
        final EditText numero2 = (EditText)findViewById(R.id.numero2);
        final TextView result = (TextView)findViewById(R.id.resultado);
        final RadioGroup operaciones = (RadioGroup)findViewById(R.id.operaciones);
        //final RadioButton suma = (RadioButton)findViewById(R.id.suma);
        //final RadioButton resta = (RadioButton)findViewById(R.id.resta);
        //final RadioButton mult = (RadioButton)findViewById(R.id.mult);
        //final RadioButton div = (RadioButton)findViewById(R.id.div);
        final Button boton = (Button)findViewById(R.id.boton);

        operaciones.clearCheck();
        //rg.check(R.id.radio1);
        //int idSeleccionado = rg.getCheckedRadioButtonId();

        //METODO PARA HACER OPERACION SIN CLICK EN BOTON
        /*operaciones.setOnCheckedChangeListener(
            new RadioGroup.OnCheckedChangeListener() {
                double resultado = 0.0;

               public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (suma.isChecked() == true) {
                        resultado = Double.parseDouble(numero1.getText().toString()) + Double.parseDouble(numero2.getText().toString());
                        result.setText(String.valueOf(resultado));

                    } else if (resta.isChecked() == true) {
                        resultado = Double.parseDouble(numero1.getText().toString()) - Double.parseDouble(numero2.getText().toString());
                        result.setText(String.valueOf(resultado));

                    } else if (mult.isChecked() == true) {
                        resultado = Double.parseDouble(numero1.getText().toString()) / Double.parseDouble(numero2.getText().toString());
                        result.setText(String.valueOf(resultado));

                    } else if (div.isChecked() == true) {
                        resultado = Double.parseDouble(numero1.getText().toString()) * Double.parseDouble(numero2.getText().toString());
                        result.setText(String.valueOf(resultado));
                    }
               }
            });*/

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(numero1.getText().toString());
                double num2 = Double.parseDouble(numero2.getText().toString());
                double total = 0.0;

                if(operaciones.getCheckedRadioButtonId()==R.id.suma){
                    total=num1+num2;
                }
                if(operaciones.getCheckedRadioButtonId()==R.id.resta){
                    total=num1-num2;
                }
                if(operaciones.getCheckedRadioButtonId()==R.id.mult){
                    total=num1*num2;
                }
                if(operaciones.getCheckedRadioButtonId()==R.id.div) {
                    total = num1 / num2;
                }
                result.setText(""+total);

                //LOS DEJA A NULL CUANDO CLICKAS EN EL BOTON
                numero1.setText("");
                numero2.setText("");
                operaciones.clearCheck();
            }
        });
    }
}
