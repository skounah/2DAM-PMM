package victor.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Logeo extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logeo);
        //CREAMOS LA BD EN MODO ESCRITURA
        BDSQLiteHelper BDFinal = new BDSQLiteHelper(this, "BASEDATOS1", null, 1);
        //SE OBTIENE LA REFERENCIA PARA PODER MODIFICARLA
        SQLiteDatabase bd = BDFinal.getWritableDatabase();
        //
        BDFinal.onUpgrade(bd,1,2);


        Button botonlog = (Button) findViewById(R.id.botonentrar);
        botonlog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent1 = new Intent(Logeo.this, MainActivity.class);
                startActivity(miIntent1);
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
