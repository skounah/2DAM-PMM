package listaobjetoscom.victor.listaobjetos;

public class Titular
{
    private String titulo;
    private String subtitulo;
    private int precio;
    private int imagen;

    public Titular(String tit, String sub, int prec, int img){
        titulo = tit;
        subtitulo = sub;
        precio = prec;
        imagen = img;
    }
    public String getTitulo(){ return titulo; }
    public String getSubtitulo(){ return subtitulo; }
    public int getPrecio() {return precio; }
    public int getImagen() {return imagen; }

    public String toString (){
       String todo= titulo + ":" +subtitulo + "-->" +precio;
        return  todo;
    }
}