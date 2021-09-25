package Controlador;


import Config.Fecha;
import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GenerarVenta extends HttpServlet {

  ClienteDAO cdao= new ClienteDAO();
  Cliente c = new Cliente();
  
  ProductoDAO pdao=new  ProductoDAO();
  Producto p = new Producto();
  
  Venta v= new Venta();
  int item = 0;
  int cod;
  String codigo;
  String descripcion;
  double precio;
  int cant;
  double subtotal;
  List<Venta>lista = new ArrayList<>();
  double totalPagar;
  String numeroserie;
  VentasDAO vdao = new VentasDAO();
   Fecha fechaSistem = new Fecha();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");
        String accion= request.getParameter("accion");
        
          if(menu.equals("NuevaVenta")){
            switch (accion){
                
               
                case "BuscarCliente":
                String dni=request.getParameter("codigocliente");
                c.setIden(dni);
                c=cdao.buscar(dni);
                request.setAttribute("cr", c);
                request.setAttribute("nserie", numeroserie);

                break;
                
                case "BuscarProducto":
                    String cg= request.getParameter("codigoproducto");
                    p.setCodigo(cg);
                    p=pdao.buscar(cg);
                    request.setAttribute("pr", p);  
                    request.setAttribute("cr", c);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);

                    break;
                case "Agregar":
                    
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    codigo=request.getParameter("codigoproducto");
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio*cant;
                    
                    v= new Venta();
                    v.setItem(item);
                    v.setIdproducto(p.getId());
                    v.setCodigo(codigo);
                    v.setDescripcion(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    
                    for(int i=0; i< lista.size(); i++){
                        totalPagar=totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("cr", c);
                    request.setAttribute("nserie", numeroserie);
                    break;
                    
             
                    
                case "GenerarVenta":
                    
                    //actualizarstock
                    
                    for(int i = 0; i<lista.size(); i++){
                        
                        Producto prod = new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        String codigo=lista.get(i).getCodigo();
                        ProductoDAO aO= new ProductoDAO();
                        prod= aO.buscar(codigo);
                        int sac=prod.getStock()-cantidad;
                        aO.actualizarstock(codigo, sac);
                        
                    }
                    
                    // guardar venta
                    v.setIdcliente(c.getIdc());
                    v.setIdusuario(1);
                    v.setNumserie(numeroserie);
                    v.setFecha(fechaSistem.FechaBD());
                    v.setMonto(totalPagar);
                    v.setEstado("Cancelado");
                    vdao.guardarVenta(v);
                    
                    //guardar detalle venta
                    
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for(int i =0; i < lista.size();i++){
                        v=new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCodigo(lista.get(i).getCodigo());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    break;
                default:
                  numeroserie =vdao.GenerarSerie();
                  if(numeroserie==null){
                      numeroserie="00000001";
                      request.setAttribute("nserie", numeroserie);
                  }
                  else{
                      int incrementar=Integer.parseInt(numeroserie);
                      GenerarSerie gs = new GenerarSerie();
                      numeroserie=gs.NumeroSerie(incrementar);
                      request.setAttribute("nserie", numeroserie);
                  }
       request.getRequestDispatcher("Vistas/RegistrarVenta.jsp").forward(request ,response);
            }
       request.getRequestDispatcher("Vistas/RegistrarVenta.jsp").forward(request ,response);
         }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
