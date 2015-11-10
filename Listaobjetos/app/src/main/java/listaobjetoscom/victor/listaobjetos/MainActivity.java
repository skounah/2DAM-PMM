package listaobjetoscom.victor.listaobjetos;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private Titular[] datos = new Titular[]{
            new Titular("El Senyor de los anillos 1", "La comunidad del anillo", 10,R.drawable.imagen1),
            new Titular("El Senyor de los anillos 2", "Las dos torres", 20,R.drawable.imagen2),
            new Titular("El Senyor de los anillos 3", "El retorno del rey", 30,R.drawable.imagen3)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lstOpciones= (ListView) findViewById(R.id.LstOpciones);
        AdaptadorTitulares adaptador= new AdaptadorTitulares(this);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = datos[position].toString();
                //String mensaje2 = String.valueOf(datos[position].getPrecio());
                showToast(mensaje);
                ImageView imageselect = (ImageView) findViewById(R.id.imagenfinal);
                imageselect.setBackground(getDrawable(datos[position].getImagen())); // ERROR POR VERSION SE ARREGLA OCN UNA MOVIDILLA PERO ASI FUNCIONA A PARTIR DE LOLIPOP
            }
        });

    }


        class AdaptadorTitulares extends ArrayAdapter {
            Activity context;

            AdaptadorTitulares(Activity context) {
                super(context, R.layout.listitem_titular, datos);
                this.context = context;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = context.getLayoutInflater();
                View item = inflater.inflate(R.layout.listitem_titular, null);

                TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
                lblTitulo.setText(datos[position].getTitulo());

                TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
                lblSubtitulo.setText(datos[position].getSubtitulo());

                TextView lblPrecio = (TextView) item.findViewById(R.id.LbLPrecio);
                lblPrecio.setText(String.valueOf(datos[position].getPrecio()));

                ImageView lblIagen = (ImageView) item.findViewById(R.id.LblImagen);
                lblIagen.setBackground(getDrawable(datos[position].getImagen()));      // ERROR POR VERSION SE ARREGLA OCN UNA MOVIDILLA PERO ASI FUNCIONA A PARTIR DE LOLIPOP



                return (item);
            }
        }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

