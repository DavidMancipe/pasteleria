package Modelo;
public class Compra {
    int id;
    int idCliente;
    String fecha;
    Double monto;
    int idPago;
    String estado;
    
    Cliente cliente;
    
    public Compra() {
    }

    public Compra(int id, int idCliente, String fecha, Double monto, int idPago, String estado, Cliente cliente) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.monto = monto;
        this.idPago = idPago;
        this.estado = estado;
        this.cliente = cliente;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}

/*
  public listaCompras(int id){
        
    List lista = new ArrayList();
    String sql="SELECT cl.Nombre, co.FechaCompras, co.Monto , co.Estado  from compras co INNER JOIN cliente cl on cl.IdCliente = co.idCliente";
    try{
 con = cn.Conexion();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
            Compra com = new Compra();
            com.setId(rs.getInt(1));
            com.setIdCliente(rs.getInt(2));
            com.setCliente(new Cliente());
            com.getCliente().setNombre(rs.getString(3));
            com.setIdPago(rs.getInt(4));
            com.setFecha(rs.getString(5));
            com.setMonto(rs.getDouble(6));
            com.setEstado(rs.getString(7));
            lista.add(com);
            
            }
            }catch(Exception e){

          }
   
         }
*/