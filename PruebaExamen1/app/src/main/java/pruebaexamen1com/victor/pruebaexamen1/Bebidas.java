package pruebaexamen1com.victor.pruebaexamen1;

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
}
