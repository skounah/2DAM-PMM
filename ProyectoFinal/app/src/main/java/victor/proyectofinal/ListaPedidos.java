package victor.proyectofinal;

import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class ListaPedidos extends Activity{

    Pedido[] pedidos;
    int numeroPedido;
    String idusuario;
    ListView misPedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listapedidos);

        Bundle bundlerecojeusuario3 = getIntent().getExtras();
        final String pasaususario3=(bundlerecojeusuario3.getString("IDUSUARIO3"));

        //CREAMOS LA BD EN MODO ESCRITURA
        BDSQLiteHelper BDFinal = new BDSQLiteHelper(this, "BASEDATOS1", null, 1);
        //SE OBTIENE LA REFERENCIA PARA PODER MODIFICARLA
        SQLiteDatabase bd = BDFinal.getWritableDatabase();

        //String[] campos = new String[] {"numeroPedido", "idUsuario", "bebida", "vaso", "aperativo", "total", "imagen"};
        Cursor c2 = bd.rawQuery("SELECT * FROM pedidos WHERE idUsuario='" + pasaususario3 + "'", null);
        //Cursor c2 = bd.query("pedidos", campos, "pedidos.idUsuario =" +pasaususario3, null, null, null, null);
        pedidos = new Pedido[c2.getCount()];
        int cont=0;


        if (c2.moveToFirst()) {
            do {
                numeroPedido=c2.getInt(0);
                idusuario=c2.getString(1);
                String bebida=c2.getString(2);
                String vaso=c2.getString(3);
                String extra=c2.getString(4);
                Double total=c2.getDouble(5);
                int imagen=c2.getInt(6);
                pedidos[cont]= new Pedido(numeroPedido,idusuario,bebida,vaso,extra,imagen,total);
                cont ++;
            }while(c2.moveToNext());
        }
        misPedidos = (ListView) findViewById(R.id.listView);
        registerForContextMenu(misPedidos);
        miAdaptador adptapedidos = new miAdaptador(this);
        misPedidos.setAdapter(adptapedidos);

        /*misPedidos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int i, long id) {
                numeroPedido = pedidos[i].getId();


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                numeroPedido = 0 ;
            }
        });*/

        Button botonvolver = (Button) findViewById(R.id.volveralmenu);
        botonvolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent1 = new Intent(ListaPedidos.this, MainActivity.class);
                Bundle miBundleusuario = new Bundle();
                miBundleusuario.putString("IDUSUARIO", pasaususario3);
                miIntent1.putExtras(miBundleusuario);
                startActivity(miIntent1);
            }//ONCLICK
        });//ONCLICKLISTENER


    }// ONCREATE


    //ADAPTOR LISTA CLASE PEDIDO
    class miAdaptador extends ArrayAdapter<Object> {
        Activity context;

        miAdaptador(Activity context) {

            super(context, R.layout.listitem_pedidos, pedidos);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_pedidos, null);
            TextView pedido = (TextView) item.findViewById(R.id.LbLId);
            TextView usuario = (TextView) item.findViewById(R.id.LbLUsuario);
            TextView producto = (TextView) item.findViewById(R.id.LblProducto);
            TextView vaso = (TextView) item.findViewById(R.id.lblVaso);
            TextView extra = (TextView) item.findViewById(R.id.lblExtra);
            TextView precio = (TextView) item.findViewById(R.id.lblTotal);
            ImageView imagen = (ImageView) item.findViewById(R.id.LbLImagen);


            pedido.setText(String.valueOf("   Numero Pedido: " + pedidos[position].getId()));
            usuario.setText("   Usuario: " + pedidos[position].getNombreusuario());
            producto.setText("   Producto: " + String.valueOf(pedidos[position].getBebida()));
            vaso.setText("   Vaso: " + String.valueOf(pedidos[position].getVaso()));
            extra.setText("   Extra: " + pedidos[position].getExtra());
            precio.setText(String.valueOf("   Total: " + pedidos[position].getTotal()) + " euros");
            imagen.setImageResource(pedidos[position].getImagen());

            return item;
        }
    }

    //CREACION DEL MENU CONTEXTUAL
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_borrar, menu);
    }

    //METODO SELECCION MENU CONTEXTUAL
    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)itemMnuContex.getMenuInfo(); //COJE EL CONTEXTO DEL OBJETO (ID)
        switch (itemMnuContex.getItemId()) {
            case R.id.borrar:
                BDSQLiteHelper BDFinal = new BDSQLiteHelper(this, "BASEDATOS1", null, 1);
                SQLiteDatabase bd = BDFinal.getWritableDatabase();

                bd.execSQL("DELETE FROM pedidos WHERE numeroPedido = " +pedidos[info.position].getId()); //BORRA BUSCANDO POR LA ID
                // pedidos[numeroPedido].getId()
                //INTENT PARA RECARGAR LISTVIEW
                Intent intentrecarga = new Intent(this,ListaPedidos.class);
                Bundle bundlerecarga = new Bundle();
                bundlerecarga.putString("IDUSUARIO3",idusuario);
                intentrecarga.putExtras(bundlerecarga);
                startActivity(intentrecarga);
                //onRestart(); NO HACE NADA
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}
