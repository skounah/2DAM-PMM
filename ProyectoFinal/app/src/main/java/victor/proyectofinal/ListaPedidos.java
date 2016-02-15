package victor.proyectofinal;

import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ListaPedidos extends Activity{

     Pedido[] pedidos;
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

        String[] campos = new String[] {"numeroPedido", "idUsuario", "bebida", "vaso", "aperativo", "total", "imagen"};
        Cursor c2 = bd.rawQuery("SELECT * FROM pedidos WHERE idUsuario='" + pasaususario3 + "'", null);
        //Cursor c2 = bd.query("pedidos", campos, "pedidos.idUsuario =" +pasaususario3, null, null, null, null);
        pedidos = new Pedido[c2.getCount()];
        int cont=0;


        if (c2.moveToFirst()) {
            do {
                int numeroPedido=c2.getInt(0);
                String idusuario=c2.getString(1);
                String bebida=c2.getString(2);
                String vaso=c2.getString(3);
                String aperitivo=c2.getString(4);
                Double total=c2.getDouble(5);
                int imagen=c2.getInt(6);
                pedidos[cont]= new Pedido(numeroPedido,idusuario,bebida,vaso,aperitivo,imagen,total);
                cont ++;
            }while(c2.moveToNext());
        }
        final ListView misPedidos = (ListView) findViewById(R.id.listView);
        miAdaptador adptapedidos = new miAdaptador(this);
         misPedidos.setAdapter(adptapedidos);

        Button botonvolver = (Button) findViewById(R.id.volveralmenu);
        botonvolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent1 = new Intent(ListaPedidos.this,MainActivity.class);
                Bundle miBundleusuario = new Bundle();
                miBundleusuario.putString("IDUSUARIO", pasaususario3);
                miIntent1.putExtras(miBundleusuario);
                startActivity(miIntent1);
            }//ONCLICK
        });//ONCLICKLISTENER
    }// ONCREATE



    class miAdaptador extends ArrayAdapter<Object> {
        Activity context;

        miAdaptador(Activity context) {

            super(context, R.layout.listitem_pedidos, pedidos);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_pedidos, null);
            //LinearLayout linear = (LinearLayout) item.findViewById(R.id.campoLinear);
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
            precio.setText(String.valueOf("   Total: " + pedidos[position].getTotal()) + " €");
            imagen.setImageResource(pedidos[position].getImagen());

            return item;
        }
    }
}
