package victor.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Logeo extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logeo);


        //CREAMOS LA BD EN MODO ESCRITURA
        BDSQLiteHelper BDFinal = new BDSQLiteHelper(this, "BASEDATOS1", null, 1);
        //SE OBTIENE LA REFERENCIA PARA PODER MODIFICARLA
        SQLiteDatabase bd = BDFinal.getWritableDatabase();
        //BDFinal.onUpgrade(bd,1,2);

        final EditText nombreusulogeo = (EditText)findViewById(R.id.usuariolog);
        final EditText passusulogeo = (EditText)findViewById(R.id.passlog);
        final TextView errorLogeo = (TextView)findViewById(R.id.TextoError);

        //CREAMOS TODOS LOS USUARIOS QUE LEEMOS DE LA BD
        String[] campos = new String[] {"usuario", "pass"};
        Cursor c2 = bd.query("usuarios", campos, null, null, null, null, null);
        final Usuario[] allusers=new Usuario[c2.getCount()];
        int i=0;

        if (c2.moveToFirst()) {
            do {
                String nombreusuario = c2.getString(0);
                String pass = c2.getString(1);

                String datosUsu= "SELECT:" +nombreusuario+ "-" +pass;

                Toast.makeText(this, datosUsu, Toast.LENGTH_LONG).show();
                allusers[i]=new Usuario(nombreusuario,pass);// CREO LOS CLIENTES CON LO QUE LEO DE LA BD
                i++;
            } while (c2.moveToNext());
            //Toast.makeText(this, "NO HAY COUNCIDENCIA", Toast.LENGTH_LONG).show();
        }

        Button botonlog = (Button) findViewById(R.id.botonentrar);
        botonlog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //VARIABLES JAVA PARA RECOJER DATOS DE LOGEO
                String nuevousuariolog = nombreusulogeo.getText().toString();
                String nuevopasslog = passusulogeo.getText().toString();
                boolean pasa = false;
                //COMPROVACION PARA VER SI EXISTE LA DUPLA USU/PASS
                for(int i=0;i<allusers.length;i++) {
                    if ((allusers[i].getUsuario().equals(nuevousuariolog)) && (allusers[i].getPass().equals(nuevopasslog))) {
                        pasa = true;
                        errorLogeo.setText("");
                    }
                }
                //LO HAGO EN METODOS SEPARADOS PARA EVITAR QUE MUESTRE EL MENSAJE DE ERROR AUNQUE SEA CORRECTO EL USUARIO CONTRASEÑA
                if (pasa){

                    //BUNDLE DE NUEVOUSUARIOLOG
                    Bundle miBundleusuario = new Bundle();
                    miBundleusuario.putString("IDUSUARIO", nuevousuariolog);
                    Intent miIntent1 = new Intent(Logeo.this, MainActivity.class);
                    miIntent1.putExtras(miBundleusuario);

                    startActivity(miIntent1);
                }else {
                    errorLogeo.setText("USUARIO O PASS INCORRECTOS");
                }

            }//ONCLICK
        });//ONCLICKLISTENER

        Button botonregistro = (Button) findViewById(R.id.botonregistro);
        botonregistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent2 = new Intent(Logeo.this, Registro.class);
                startActivity(miIntent2);
            }//ONCLICK
        });//ONCLICKLISTENER
    }
}
