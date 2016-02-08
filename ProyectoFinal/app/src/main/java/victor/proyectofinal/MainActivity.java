package victor.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundlerecojeusuario1 = getIntent().getExtras();
        final String pasaususario=(bundlerecojeusuario1.getString("IDUSUARIO"));

        Button boton1 = (Button) findViewById(R.id.hacerpedido);
        boton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent1 = new Intent(MainActivity.this, HacerPedido.class);
                Bundle miBundleusuario2 = new Bundle();
                miBundleusuario2.putString("IDUSUARIO2", pasaususario);
                miIntent1.putExtras(miBundleusuario2);
                startActivity(miIntent1);
            }//ONCLICK
        });//ONCLICKLISTENER

        /*Button boton2 = (Button) findViewById(R.id.hacerpedido);
        boton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent2 = new Intent(MainActivity.this, HacerPedido.class);
                Bundle miBundleusuario = new Bundle();
                miBundleusuario.putString("IDUSUARIO2", pasaususario);
                startActivity(miIntent2);
            }//ONCLICK
        });//ONCLICKLISTENER*/

        //MENU CONETEXTUAL
        Button botonmenu = (Button) findViewById(R.id.acercade);
        registerForContextMenu(botonmenu);

    }//ONCREATE

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //CREACION DEL MENU CONTEXTUAL
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
                //showToast(" Opcion 1 pulsada!");
                Intent miIntent2 = new Intent(this, AcercaDe.class);
                startActivity(miIntent2);
                //closeContextMenu();
                return true;
            case R.id.Opc2:
                finish();
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}
