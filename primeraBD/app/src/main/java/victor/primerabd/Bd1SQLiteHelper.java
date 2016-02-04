package victor.primerabd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Bd1SQLiteHelper extends SQLiteOpenHelper{
    //SENTENCIA PARA CREAR TABLAS
    String createtable = "CREATE TABLE Clientes (codigo INTEGER, nombre TEXT, telefono TEXT)";

    public Bd1SQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version) {
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXIST Clientes");
        //db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAtnerior, int versionNueva) {
        //BORRA LA TABLA
        db.execSQL("DROP TABLE IF EXIST Clientes");
        //VUELVE A REAR LA TABLA
        db.execSQL(createtable);
    }
}
