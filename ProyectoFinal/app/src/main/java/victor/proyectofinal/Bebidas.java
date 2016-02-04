package victor.proyectofinal;

public class Bebidas {
    private String bebida;
    private double precio;
    private int imagen;

    public Bebidas(String nombre, double prec, int img){
        bebida = nombre;
        precio = prec;
        imagen = img;
    }
    public String getNombre(){ return bebida; }
    public double getPrecio() {return precio; }
    public int getImagen() {return imagen; }

    public String toString (){
        String todo= bebida+ "-->" +precio;
        return  todo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
