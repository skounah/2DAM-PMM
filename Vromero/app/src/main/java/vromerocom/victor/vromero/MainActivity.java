package vromerocom.victor.vromero;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    //CREAMOS VARIABLES JAVA
    public Spinner miSpinner;
    String pizza, envio , extras;
    Double total,preciopizza,precioextras,precioenvio;
    int imagen, unidades;
    RadioGroup rgroup;
    RadioButton r1;
    RadioButton r2;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    EditText numero1;

    //CREAMOS LOS OBJETOS CLASE Bebidas
    private Pizza[] pizzas = new Pizza []{
            new Pizza("Margarita","Jamon y queso", 15.00, R.drawable.pizza1),
            new Pizza("Tres Quesos","Queso 1, Queso2, Queso3", 15.00, R.drawable.pizza2),
            new Pizza("Peperoni","Queso y Peperoni", 15.00, R.drawable.pizza3),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unidades=1;
        preciopizza=0.0;
        precioenvio=1.0;
        precioextras=0.0;
        total=0.0;

        //ADAPTACION Y SELECCION SPINNER
        miSpinner = (Spinner)findViewById(R.id.miSpinner);
        AdaptadorPizzas miAdaptador = new AdaptadorPizzas(this);
        miSpinner.setAdapter(miAdaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                pizza = pizzas[position].getNombre();
                preciopizza = pizzas[position].getPrecio();
                imagen = pizzas[position].getImagen();
                String mensaje = "Ha seleccionado: " + pizzas[position].getNombre();
                showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                pizza = "NO HA SELECCIONADO NINGUNA PIZZA";
            }
        });//FINAL MUESTRA Y ESELECCION SPINNER

        //VARIBBLES JAVA ASIGNADAS AL XML (RARIOGROUP + RADIOBUTTONS)
        rgroup= (RadioGroup) findViewById(R.id.radiodetallesgroup);
        r1= (RadioButton) findViewById(R.id.radio1);
        r2= (RadioButton) findViewById(R.id.radio2);

        //ESTADO POR DEFECTO DEL RADIOGROUP
        rgroup.clearCheck();
        r1.setChecked(true);
        envio=String.valueOf(r1.getText()); // NO ENTIENDO POR QUE NO COJE POR DEFECTO EL VALOR

        //SELECCION DEL ENVIO (RADIOGROUP)
        rgroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (r1.isChecked() == true) {
                            envio=String.valueOf(r1.getText());
                            precioenvio= 1.00;
                        }
                        if (r2.isChecked() == true) {
                            envio = String.valueOf(r2.getText());
                            precioenvio= 1.10;
                        }

                        showToast("Envio:" + envio + ",PVP :x" + precioenvio);
                    }
                });//FIN SELECCION ENVIO (RADIOGROUP)

        //ASIGNACION DE LA VARIABLE JAVA A EL XML (CKECKBOX)
        check1 = (CheckBox) findViewById(R.id.box1);
        check2 = (CheckBox) findViewById(R.id.box2);
        check3 = (CheckBox) findViewById(R.id.box3);

        //CLICK DEL BOTON
        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                numero1= (EditText)findViewById(R.id.number1);
                unidades = Integer.parseInt(numero1.getText().toString());

                extras = getExtraClick(v);
                total = ((preciopizza + precioextras)*unidades)*precioenvio;

                Intent miIntent = new Intent(MainActivity.this, PantallaDetalles.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("PIZZA", pizza);
                miBundle.putDouble("PRECIOPIZZA", preciopizza);
                miBundle.putString("ENVIO", envio);
                miBundle.putDouble("PRECIOENVIO", precioenvio);
                miBundle.putString("EXTRAS", extras);
                miBundle.putDouble("PRECIOEXTRAS", precioextras);
                miBundle.putInt("IMAGEN", imagen);
                miBundle.putInt("UNIDADES", unidades);
                miBundle.putDouble("TOTAL", total);

                miIntent.putExtras(miBundle);
                startActivity(miIntent);

                showToast("Total:" + total);
            }//ONCLICK
        });//ONCLICKLISTENER
    }//ONCREATE

    //SELECCION DE EXTRAS (CHECKBOX)
    public String getExtraClick(View v){
        String extraselect = "";
        precioextras=0.0;

        if(check1.isChecked()){
            extraselect+=check1.getText()+" ";
            precioextras +=3.0;
        }
        if(check2.isChecked()){
            extraselect+=check2.getText()+" ";
            precioextras +=1.0;
        }
        if(check3.isChecked()){
            extraselect+=check3.getText()+" ";
            precioextras +=2.0;
        }
        if(extraselect.length()==0){
            extraselect+="Sin Aperitivos";
        }
        return extraselect;
    }

    //ADAPTADOR PARA LA CLASE BEBIDAS
    class AdaptadorPizzas extends ArrayAdapter<Pizza> {
        public Activity AdaptadorBebidas;

        public AdaptadorPizzas(Activity Adaptadorbebidas) {
            super(Adaptadorbebidas, R.layout.spin_item_pizza, pizzas);
            this.AdaptadorBebidas = Adaptadorbebidas;
        }
        public View getDropDownView (int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }
        //ADAPTACION PARA EL SPINNER
        public  View getView (int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = AdaptadorBebidas.getLayoutInflater();
            View item=inflater.inflate(R.layout.spin_item_pizza, null);

            //VARIABLES JAVA ASIGNADAS AL XML (SIPNNER)
            TextView lblNombre = (TextView) item.findViewById(R.id.LbLNombre);
            TextView lblIngredientes = (TextView) item.findViewById(R.id.LbLIngredientes);
            TextView lblPrecio = (TextView) item.findViewById(R.id.LbLPrecio);
            ImageView lblImagen = (ImageView) item.findViewById(R.id.LbLImagen);

            lblNombre.setText(pizzas[position].getNombre());
            lblIngredientes.setText(pizzas[position].getIngrediente());
            lblPrecio.setText(String.valueOf(pizzas[position].getPrecio()));
            lblImagen.setBackground(getDrawable(pizzas[position].getImagen())); //EL ERROR ES POR QUE ANTES DE UNA VERSION DE LOLIPORP SE HACICA DE OTRA FORMA PE

            return item;
        }
    }

    //METODO PARA TOSTADAS
    protected void showToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show(); }




}
