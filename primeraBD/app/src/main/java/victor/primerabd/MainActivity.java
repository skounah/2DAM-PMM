package victor.primerabd;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Clientes [] clientes;
    public Spinner miSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CREAMOS LA BD EN MODO ESCRITURA
        Bd1SQLiteHelper nuevaBD = new Bd1SQLiteHelper(this, "BASEDATOS1", null, 1);
        //SE OBTIENE LA REFERENCIA PARA PODER MODIFICARLA
        SQLiteDatabase bd = nuevaBD.getWritableDatabase();

        //bd.execSQL("DELETE FROM Clientes"); // LO PONGO PARA QUE NO CREE TODAS LAS VECES LOS MISMOS REGISTROS CUANDO INICIO LA APP
        if (bd!=null) { //SI EXISTE LA BD
            //Introducimos 5 clientes de ejemplo
            for (int cont = 4; cont <= 9; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }
        }


            /*Ejemplo Select
            String[] args3 = new String[]{"cli1"};
            Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);
            */

            //Ejemplo Select2
            String[] campos = new String[] {"codigo", "nombre", "telefono"};
            Cursor c2 = bd.query("Clientes", campos, null, null, null, null, null);
            clientes=new Clientes[c2.getCount()];
            int i=0;
            //Nos aseguramos de que exista al menos un registro
            if (c2.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    int id = c2.getInt(0);
                    String nombre = c2.getString(1);
                    String tlf = c2.getString(2);
                    String datosCli= nombre+ "-" +tlf;

                    Toast.makeText(this,datosCli, Toast.LENGTH_LONG).show();
                    clientes[i]=new Clientes(id,nombre,tlf);// CREO LOS CLIENTES CON LO QUE LEO DE LA BD
                    i++;
                } while (c2.moveToNext());
            }


            final Spinner miSpinner= (Spinner)findViewById(R.id.mispinner);
            AdaptadorCliente miAdaptador= new AdaptadorCliente(this);
            miSpinner.setAdapter(miAdaptador);

            //c2.close();
            bd.close();

    }//ONCREATE

    class AdaptadorCliente extends ArrayAdapter<Clientes>{
        public Activity context;

        public AdaptadorCliente(Activity context){
            super(context, R.layout.spinner_clientes, clientes);
            this.context=context;
        }

        public View getDropDownView(int posicion, View convertView, ViewGroup parent){
            return getView(posicion,convertView,parent);
        }
        public View getView(int posicion, View convertView,ViewGroup parent){
            LayoutInflater inflater=context.getLayoutInflater();
            View item=inflater.inflate(R.layout.spinner_clientes, null);

            TextView lblId =(TextView)item.findViewById(R.id.textView);
            TextView lblNombre=(TextView)item.findViewById(R.id.textView2);
            TextView lblTlf=(TextView)item.findViewById(R.id.textView3);

            lblId.setText(String.valueOf(clientes[posicion].getCodigo()));
            lblNombre.setText(clientes[posicion].getNombre());
            lblTlf.setText(clientes[posicion].getNumero());
            return item;
        }//DEL GETVIEW

    }//DE LA CLASE ARRAYDAPTER

    class ViewHolder{
        TextView id, nombre, telefono;
    }//CLASE HOLDER

}//DEL MAIN
