package pruebaexamen1com.victor.pruebaexamen1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        //MENU CONETEXTUAL
        Button botonmenu = (Button) findViewById(R.id.botonmenu);
        registerForContextMenu(botonmenu);

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
            lblImagen.setBackground(getDrawable(bebidas[position].getImagen())); //EL ERROR ES POR QUE ANTES DE UNA VERSION DE LOLIPOP SE HACICA DE OTRA FORMA //setImageResource
            return item;
        }
    }


    //METODO PARA TOSTADAS
    protected void showToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show(); }


    //METODO CREACION MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //METODO SELECCION DEL MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       /* PROGRAMACIÓN DE BAJO NIVEL
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            showToast("PULSADO SETTINGS");
            return true;}
        if (id == R.id.action_acercade) {
            showToast("PULSADO ACERCA DE");
            return true;}
        if (id == R.id.action_submenu) {
            showToast("PULSADO SUBMENU");

            return true;}
        if (id == R.id.action_close) {
            showToast("PULSADO CLOSE");
            this.finish();
            return true;}
        return super.onOptionsItemSelected(item);
        */

          switch (item.getItemId()){        //NO TIENE USO
            case R.id.action_settings:
                showToast("PULSADO SETTINGS");

                return true;

            case R.id.action_submenu:       //NO TIENE USO
                showToast("PULSADO SUBMENU");
                return true;

                case R.id.SubMnuOpc1:
                    showToast("PULSADO SUBMENU OPCION 1");
                    return true;
                case R.id.SubMnuOpc2:
                    showToast("PULSADO SUBMENU OPCION 2");
                    return true;
                case R.id.SubMnuOpc3:
                    showToast("PULSADO SUBMENU OPCION 3");

            case R.id.action_close:     //CIERRA LA APLICACION
                showToast("CERRANDO APLICACION...");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // METODO DE CREACION DEL MENU CONTEXTUAL
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }


    //METODO SELECCION MENU CONTEXTUAL
    public boolean onContextItemSelected(MenuItem itemMnuContex) {  // HAY QUE MANTENER PULSADO PARA QUE DE DESLPEGUE NO VALE CON UN SOLO CLICK
        switch (itemMnuContex.getItemId()) {
            case R.id.Opc1:
                showToast(" Opcion 1 pulsada!");
                Intent miIntent2 = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(miIntent2);
                //closeContextMenu();
                return true;
            case R.id.Opc2:
                //QUIERO QUE REINICIE LAS SELECCIONES
                showToast(" Opcion 2 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}

