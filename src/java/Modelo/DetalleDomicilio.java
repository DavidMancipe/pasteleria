
package Modelo;


public class DetalleDomicilio {

int id;
int iddomicilio;
String fechaentrega;
String horaentrega;
Double valordomiiclio;
String estado;

    public DetalleDomicilio() {
    }

    public DetalleDomicilio(int id, int iddomicilio, String fechaentrega, String horaentrega, Double valordomiiclio, String estado) {
        this.id = id;
        this.iddomicilio = iddomicilio;
        this.fechaentrega = fechaentrega;
        this.horaentrega = horaentrega;
        this.valordomiiclio = valordomiiclio;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIddomicilio() {
        return iddomicilio;
    }

    public void setIddomicilio(int iddomicilio) {
        this.iddomicilio = iddomicilio;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getHoraentrega() {
        return horaentrega;
    }

    public void setHoraentrega(String horaentrega) {
        this.horaentrega = horaentrega;
    }

    public Double getValordomiiclio() {
        return valordomiiclio;
    }

    public void setValordomiiclio(Double valordomiiclio) {
        this.valordomiiclio = valordomiiclio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
