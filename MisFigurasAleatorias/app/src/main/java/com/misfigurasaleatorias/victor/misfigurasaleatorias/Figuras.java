package com.misfigurasaleatorias.victor.misfigurasaleatorias;

/**
 * Created by Victor on 11/01/2016.
 */
public class Figuras {
    private String nombre;
    private String dato1;
    private String dato2;
    private int imagen;

    public Figuras(String nombre, String dato1,String dato2, int imagen){
        this.nombre=nombre;
        this.dato1=dato1;
        this.dato2=dato2;
        this.imagen=imagen;
    }

    public String getNombre(){return nombre;}
    public String getDato1(){return dato1;}
    public String getDato2(){return dato2;}
    public int getImagen(){return imagen;}
}


