package Modelo;

public class Usuario {
    
    int id;
    String nombre;
    String tel;
    String email;
    String user;
    String pass;
    String estado;

    public Usuario() {
    }

    public Usuario(int id, String nombre,  String tel, String email, String user, String pass, String estado) {
        this.id = id;
        this.nombre = nombre;
       
        this.tel = tel;
        this.email = email;
        this.user = user;
        this.pass = pass;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
