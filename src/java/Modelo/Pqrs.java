
package Modelo;


public class Pqrs {
   
    int id;
    String nombre;
    String telefono;
    String correo;
    String tipopeticion;
    String calificacion;
    String descripcion;
    String fecha;

    public Pqrs() {
    }

    public Pqrs(int id, String nombre, String telefono, String correo, String tipopeticion, String calificacion, String descripcion, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.tipopeticion = tipopeticion;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.fecha = fecha;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipopeticion() {
        return tipopeticion;
    }

    public void setTipopeticion(String tipopeticion) {
        this.tipopeticion = tipopeticion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   
    
}
