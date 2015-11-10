package vromerocom.victor.vromero;

/**
 * Created by Victor on 09/11/2015.
 */
public class Pizza {
    private String pizza;
    private String ingrediente;
    private double precio;
    private int imagen;

    public Pizza(String nombre,String ingre, double prec, int img){
        pizza = nombre;
        ingrediente = ingre;
        precio = prec;
        imagen = img;
    }
    public String getNombre(){ return pizza; }
    public String getIngrediente(){return ingrediente; }
    public double getPrecio() {return precio; }
    public int getImagen() {return imagen; }

    public String toString (){
        String todo= pizza+ "-->" +precio;
        return  todo;
    }
}
