package com.misfigurasaleatorias.victor.misfigurasaleatorias;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Victor on 03/12/2015.
 */
public class Pantalla3 extends ActionBarActivity {
    public Spinner miSpinner;

    private Figuras[] figuras = new Figuras[]{
            new Figuras("Ciruclo", "Radio","",R.drawable.circulo ),
            new Figuras("Rectangulo", "Base","Altura", R.drawable.rectangulo1),
            new Figuras("Rectangulo", "Lado","", R.drawable.cuadrado),
            new Figuras("Triangulo", "Base","Altura", R.drawable.triangulo1),
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        //MUESTRA Y SELECCION DEL SPINNER
        miSpinner = (Spinner)findViewById(R.id.miSpinner);
        AdaptadorFiguras miAdaptador = new AdaptadorFiguras(this);
        miSpinner.setAdapter(miAdaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                /*bebida = bebidas[position].getNombre();
                preciobebida = bebidas[position].getPrecio();
                imagen = bebidas[position].getImagen();
                String mensaje = "Ha seleccionado: " + bebidas[position].getNombre();
                showToast(mensaje);*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //bebida = "NO HA SELECCIONADO NINGUNA BEBIDA";
            }
        });//FINAL MUESTRA Y ESELECCION SPINNER

    }

    //ADAPTADOR PARA LA CLASE BEBIDAS
    class AdaptadorFiguras extends ArrayAdapter<Figuras> {
        public Activity AdaptadorBebidas;

        public AdaptadorFiguras(Activity Adaptadorbebidas) {
            super(Adaptadorbebidas, R.layout.spinitem_figuras, figuras);
            this.AdaptadorBebidas = Adaptadorbebidas;
        }
        public View getDropDownView (int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }
        //ADAPTACION PARA EL SPINNER
        public  View getView (int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = AdaptadorBebidas.getLayoutInflater();
            View item=inflater.inflate(R.layout.spinitem_figuras, null);

            //VARIABLES JAVA ASIGNADAS AL XML (SIPNNER)
            TextView lblNombre = (TextView) item.findViewById(R.id.LbLNombre);
            TextView lblDato1 = (TextView) item.findViewById(R.id.LbLDato1);
            TextView lblDato2= (TextView) item.findViewById(R.id.LbLDato2);
            ImageView lblImagen = (ImageView) item.findViewById(R.id.LbLImagen);

            lblNombre.setText(figuras[position].getNombre());
            lblDato1.setText(String.valueOf(figuras[position].getDato1()));
            lblDato2.setText(String.valueOf(figuras[position].getDato2()));
            lblImagen.setBackground(getDrawable(figuras[position].getImagen())); //EL ERROR ES POR QUE ANTES DE UNA VERSION DE LOLIPOP SE HACICA DE OTRA FORMA //setImageResource
            return item;
        }
    }
}