package victor.proyectofinal;

/**
 * Created by Victor on 03/02/2016.
 */
public class Pedido {
    int id;
    String nombreusuario;
    String bebida;
    String vaso;
    String extra;
    int imagen;
    Double total;

    public Pedido(int id, String nombreusuario, String bebida, String vaso, String extra, int imagen, Double total) {
        this.id = id;
        this.nombreusuario = nombreusuario;
        this.bebida = bebida;
        this.vaso = vaso;
        this.extra = extra;
        this.imagen = imagen;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getVaso() {
        return vaso;
    }

    public void setVaso(String vaso) {
        this.vaso = vaso;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
