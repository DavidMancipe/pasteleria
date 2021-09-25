package Modelo;
public class Cliente {
    
    int idc;
    String nombre;
    String iden;
    String tel;
    String dir;
    String correo;
    String pass;

    public Cliente() {
    }

    public Cliente(int idc, String nombre, String iden, String tel, String dir, String correo, String pass) {
        this.idc = idc;
        this.nombre = nombre;
        this.iden = iden;
        this.tel = tel;
        this.dir = dir;
        this.correo = correo;
        this.pass = pass;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
