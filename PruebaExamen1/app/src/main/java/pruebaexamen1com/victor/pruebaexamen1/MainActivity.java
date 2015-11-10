package pruebaexamen1com.victor.pruebaexamen1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    //CREAMOS VARIABLES JAVA
    public Spinner miSpinner;
    String bebida, vaso , extras;
    Double total,preciobebida,preciovaso,precioextras;
    Integer imagen;
    RadioGroup rgroup;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;

    //CREAMOS LOS OBJETOS CLASE Bebidas
    private Bebidas[] bebidas = new Bebidas []{
            new Bebidas("Agua", 1.50, R.drawable.agua),
            new Bebidas("Refresco", 2.00, R.drawable.refrescos),
            new Bebidas("Cerveza", 2.50, R.drawable.beer),
            new Bebidas("Vino", 3.00, R.drawable.vino),
    };

    //ONCREATE (SELECCION DE SPINNER, CLICK DEL BOTON, SELECCION RADIOBUTTON)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preciobebida=0.0;
        preciovaso=0.0;
        precioextras=0.0;
        total=0.0;

        // MUESTRA Y SELECCION DE DEBIDA (SPINNER)
        miSpinner = (Spinner)findViewById(R.id.miSpinner);
        AdaptadorBebidas miAdaptador = new AdaptadorBebidas(this);
        miSpinner.setAdapter(miAdaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                bebida = bebidas[position].getNombre();
                preciobebida = bebidas[position].getPrecio();
                imagen = bebidas[position].getImagen();
                String mensaje = "Ha seleccionado: " + bebidas[position].getNombre();
                showToast(mensaje);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bebida = "NO HA SELECCIONADO NINGUNA BEBIDA";
            }
        });//FINAL MUESTRA Y ESELECCION SPINNER

        //VARIBBLES JAVA ASIGNADAS AL XML (RARIOGROYP + RADIOBUTTONS)
        rgroup= (RadioGroup) findViewById(R.id.radiovaso);
        r1= (RadioButton) findViewById(R.id.radio1);
        r2= (RadioButton) findViewById(R.id.radio2);
        r3= (RadioButton) findViewById(R.id.radio3);
        r4= (RadioButton) findViewById(R.id.radio4);

        //ESTADO POR DEFECTO DEL RADIOGROUP
        rgroup.clearCheck();
        r1.setChecked(true);
        vaso=String.valueOf(r1.getText());

        //SELECCION DEL VASO (RADIOGROUP)
        rgroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (r1.isChecked() == true) {
                            vaso=String.valueOf(r1.getText());
                            preciovaso=0.0;

                        }  if (r2.isChecked() == true) {
                            vaso=String.valueOf(r2.getText());
                            preciovaso=0.5;

                        } if (r3.isChecked() == true) {
                            vaso=String.valueOf(r3.getText());
                            preciovaso=1.0;

                        } if (r4.isChecked() == true) {
                            vaso=String.valueOf(r4.getText());
                            preciovaso=1.5;
                        }

                        showToast("Vaso seleccionado:" +vaso+ ",PVP :" +preciovaso);
                    }
                });//FIN SELECCION RADIOGROUP


        //ASIGNACION DE LA VARIABLE JAVA A EL XML (CKECKBOX)
        check1 = (CheckBox) findViewById(R.id.box1);
        check2 = (CheckBox) findViewById(R.id.box2);
        check3 = (CheckBox) findViewById(R.id.box3);

        //BOTON PARA CAMBIAR DE ACTIVIDAD Y PASAR LOS DATOS (BOTON)
        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                extras=getExtraClick(v);
                total=preciobebida+preciovaso+precioextras;

                Intent miIntent = new Intent(MainActivity.this, PantallaDetalles.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("BEBIDA",bebida);
                miBundle.putDouble("PRECIOBEBIDA", preciobebida);
                miBundle.putString("VASO", vaso);
                miBundle.putDouble("PRECIOVASO", preciovaso);
                miBundle.putString("EXTRAS", extras);
                miBundle.putDouble("PRECIOEXTRAS", precioextras);
                miBundle.putInt("IMAGEN", imagen);
                miBundle.putDouble("TOTAL", total);

                miIntent.putExtras(miBundle);
                startActivity(miIntent);

                showToast("Total:" +total);
            }//ONCLICK
        });//ONCLICKLISTENER
    }//ONCREATE

    //SELECCION DE EXTRAS (CHECKBOX)
    public String getExtraClick(View v){
        String extraselect = "";
        precioextras=0.0;

        if(check1.isChecked()){
            extraselect+=check1.getText()+" ";
            precioextras +=0.5;
        }
        if(check2.isChecked()){
            extraselect+=check2.getText()+" ";
            precioextras +=1.0;
        }
        if(check3.isChecked()){
            extraselect+=check3.getText()+" ";
            precioextras +=0.2;
        }
        if(extraselect.length()==0){
            extraselect+="Sin Aperitivos";
        }
        return extraselect;
    }

    //ADAPTADOR PARA LA CLASE BEBIDAS
    class AdaptadorBebidas extends ArrayAdapter<Bebidas> {
        public Activity AdaptadorBebidas;

        public AdaptadorBebidas(Activity Adaptadorbebidas) {
            super(Adaptadorbebidas, R.layout.spinitem_bebidas, bebidas);
            this.AdaptadorBebidas = Adaptadorbebidas;
        }
        public View getDropDownView (int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }
        //ADAPTACION PARA EL SPINNER
        public  View getView (int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = AdaptadorBebidas.getLayoutInflater();
            View item=inflater.inflate(R.layout.spinitem_bebidas, null);

            //VARIABLES JAVA ASIGNADAS AL XML (SIPNNER)
            TextView lblNombre = (TextView) item.findViewById(R.id.LbLNombre);
            TextView lblPrecio = (TextView) item.findViewById(R.id.LbLPrecio);
            ImageView lblImagen = (ImageView) item.findViewById(R.id.LbLImagen);

            lblNombre.setText(bebidas[position].getNombre());
            lblPrecio.setText(String.valueOf(bebidas[position].getPrecio()));
            lblImagen.setBackground(getDrawable(bebidas[position].getImagen())); //EL ERROR ES POR QUE ANTES DE UNA VERSION DE LOLIPORP SE HACICA DE OTRA FORMA PE

            return item;
        }
    }

    //METODO PARA TOSTADAS
    protected void showToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show(); }

}