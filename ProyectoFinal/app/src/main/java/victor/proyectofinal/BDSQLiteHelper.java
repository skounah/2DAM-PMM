package victor.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDSQLiteHelper extends SQLiteOpenHelper {
    String tablaUsuarios = "CREATE TABLE IF NOT EXISTS 'usuarios' (" +
            "  'usuario' TEXT NOT NULL PRIMARY KEY," +
            "  'pass' TEXT NOT NULL," +
            "  'nombre' TEXT NOT NULL," +
            "  'apellidos' TEXT NOT NULL," +
            "  'email' TEXT NOT NULL UNIQUE" +
            "  );";

    String tablaPedidos = "CREATE TABLE IF NOT EXISTS 'pedidos' (" +
            "  'numeroPedido' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "  'idUsuario' TEXT NOT NULL," +
            "  'bebida' TEXT NOT NULL," +
            "  'vaso' TEXT NOT NULL," +
            "  'extras' TEXT NOT NULL," +
            //"  'unidades' INTEGER NOT NULL," +
            "  'total' DECIMAL NOT NULL," +
            "  'imagen' INTEGER NOT NULL," +
            "   FOREIGN KEY('idUsuario') REFERENCES usuarios('usuario') ON DELETE CASCADE" +
            "  );";

    public BDSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version) {
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.delete("usuarios",null,null);
        db.delete("pedidos",null,null);*/
        db.execSQL(tablaPedidos);
        db.execSQL(tablaUsuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAtnerior, int versionNueva) {
        /*db.execSQL("DELETE TABLE IF EXISTS usuarios");
        db.delete("usuarios",null,null);
        db.delete("pedidos",null,null);*/
        db.execSQL(tablaPedidos);
        db.execSQL(tablaUsuarios);
    }
}
