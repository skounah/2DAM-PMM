package victor.proyectofinal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);

        BDSQLiteHelper BDFinal = new BDSQLiteHelper(this, "BASEDATOS1", null, 1);
        final SQLiteDatabase bd = BDFinal.getWritableDatabase();

        //BDFinal.onUpgrade(BDFinal.getWritableDatabase(),1,2);

        final EditText nombre = (EditText)findViewById(R.id.entrynombre);
        final EditText apellido = (EditText)findViewById(R.id.entryapellidos);
        final EditText usuario = (EditText)findViewById(R.id.entryusuario);
        final EditText pass = (EditText)findViewById(R.id.entrypass);
        final EditText email = (EditText)findViewById(R.id.entrymail);

        Button botonregistrar = (Button) findViewById(R.id.registrar);
        botonregistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nuevousuario = ""+usuario.getText();
                String nuevomail= ""+email.getText();
                String nuevonombre = ""+nombre.getText();
                String nuevoapellido =""+apellido.getText();
                String nuevopass =""+pass.getText();
                String datos= ""+nuevousuario+"-"+nuevopass;

                //HAY QUE ARREGLAR LA TABLA QUE NO TIENE ESTOS DATOS POR UQE AL CREARLA LO CREE CON OTROS CAMPOS
                /*ContentValues contentValues = new ContentValues();
                contentValues.put("usuario" , nuevousuario);
                contentValues.put("clave"   , nuevopass);
                bd.insert("usuarios", null, contentValues);*/

                bd.execSQL("INSERT INTO usuarios (usuario, pass, nombre, apellidos, email) " +
                        "VALUES ('" + nuevousuario + "', '" + nuevopass + "', '" + nuevonombre + "', '" + nuevoapellido + "', '" + nuevomail + "')");

                showToast(datos);

                Intent miIntentregistro = new Intent(Registro.this, Logeo.class);
                startActivity(miIntentregistro);
            }//ONCLICK
        });//ONCLICKLISTENER

    }
    protected void showToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show(); }

}
