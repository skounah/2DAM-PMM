package victor.proyectofinal;

/**
 * Created by Victor on 05/02/2016.
 */
public class Usuario {
    String usuario;
    String pass;
    String nombre;
    String apellidos;
    String email;


    public Usuario(String usuario, String pass, String nombre, String apellidos, String email) {
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Usuario(String usuario, String pass) {
        this.usuario=usuario;
        this.pass=pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
