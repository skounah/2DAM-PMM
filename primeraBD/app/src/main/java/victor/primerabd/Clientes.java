package victor.primerabd;

/**
 * Created by Victor on 18/01/2016.
 */
public class Clientes {
    int codigo;
    String nombre;
    String numero;

    public Clientes(int codigo, String nombre, String numero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
