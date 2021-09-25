
package Modelo;

public class Domicilios {
  
    int id;
    int idcliente;
    String telefono;
    String ciudad;
    String fecha;
    String hora;
    String estado;
    String dir;
    String correo;
    Cliente cliente;

    public Domicilios() {
    }

    public Domicilios(int id, int idcliente, String telefono, String ciudad, String fecha, String hora, String estado, String dir, String correo, Cliente cliente) {
        this.id = id;
        this.idcliente = idcliente;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.dir = dir;
        this.correo = correo;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}