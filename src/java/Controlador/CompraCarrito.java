  
package Controlador;


import Config.Fecha;
import Modelo.Carrito;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.ClienteVLD;
import Modelo.Compra;
import Modelo.ComprasDAO;
import Modelo.DetalleCompra;
import Modelo.DetalleDomicilio;
import Modelo.Domicilios;
import Modelo.DomiciliosDAO;
import Modelo.Pago;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
public class CompraCarrito extends HttpServlet {
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    List<Producto>productos=new ArrayList<>();
   
    List<Carrito>listaCarrito=new ArrayList<>();
     int item;
     double totalPagar=0.0;
     int cantidad=1;
     int idp;
     Carrito car;
   
     Cliente c= new Cliente();
     ClienteDAO cdao= new ClienteDAO();
     
     String logueo = "Iniciar Sesion";
    String correo = "Iniciar Sesion";
    ClienteVLD cldao = new ClienteVLD();
    
    /* generar comprA*/
    Compra co = new Compra();
    ComprasDAO cpdao = new ComprasDAO();
    Pago pago = new Pago();
    int idcompra;
    int idpago;
    double montopagar;
    int idProducto = 0;
    
    Fecha fechaSistem = new Fecha();
    
    /* generar domicilio*/
    DetalleDomicilio dtd= new DetalleDomicilio();
    Domicilios dml = new Domicilios();
    int d;
     List<Domicilios>domic = new ArrayList<>();
    DomiciliosDAO dldao = new DomiciliosDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");
              
        HttpSession session = request.getSession();
        session.setAttribute("logueo", logueo);
        session.setAttribute("correo", correo);
        
        String accion=request.getParameter("accion");
        productos=pdao.listar();
        switch (accion){
            
            case "Comprar":
                totalPagar = 0.0;
                idp=Integer.parseInt(request.getParameter("id"));
                 p=pdao.listarId(idp);
                 item = item + 1;
                  car= new Carrito();
                 car.setItem(item);
                 car.setIdproducto(p.getId());
                 car.setNombres(p.getNombres());
                 car.setDescripcion(p.getDescripcion());
                 car.setPrecioCompra(p.getPrecio());
                 car.setCantidad(cantidad);
                 car.setSubTotal(cantidad*p.getPrecio());
                 listaCarrito.add(car);
                     for (int i = 0; i < listaCarrito.size(); i++) {
                 totalPagar= totalPagar+listaCarrito.get(i).getSubTotal();
             }
                 request.setAttribute("carrito", listaCarrito);
                 request.setAttribute("contador", listaCarrito.size()); 
                 request.setAttribute("totalPagar", totalPagar);
                 request.getRequestDispatcher("Vistas/Carrito.jsp").forward(request, response);
                 break;  
                 
             case "AgregarCarrito":
                 int pos = 0;
                 cantidad = 1;
                 idp = Integer.parseInt(request.getParameter("id"));
                 p=pdao.listarId(idp);
                 if (listaCarrito.size() > 0) {
                     for (int i = 0; i < listaCarrito.size(); i++){
                      if(idp==listaCarrito.get(i).getIdproducto()){
                          pos=i;
                      } 
                      
                     }
                     if(idp==listaCarrito.get(pos).getIdproducto()){
                         cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                         double subtotal=listaCarrito.get(pos).getPrecioCompra()*cantidad;
                         listaCarrito.get(pos).setCantidad(cantidad);
                         listaCarrito.get(pos).setSubTotal(subtotal);
                     }else{
                 item = item + 1;
                 car= new Carrito();
                 car.setItem(item);
                 car.setIdproducto(p.getId());
                 car.setNombres(p.getNombres());
                 car.setDescripcion(p.getDescripcion());
                 car.setPrecioCompra(p.getPrecio());
                 car.setCantidad(cantidad);
                 car.setSubTotal(cantidad*p.getPrecio());
                 listaCarrito.add(car);           
                     }
                     
                 } else {
                 item = item + 1;
                 car= new Carrito();
                 car.setItem(item);
                 car.setIdproducto(p.getId());
                 car.setNombres(p.getNombres());
                 car.setDescripcion(p.getDescripcion());
                 car.setPrecioCompra(p.getPrecio());
                 car.setCantidad(cantidad);
                 car.setSubTotal(cantidad*p.getPrecio());
                 listaCarrito.add(car);   
                 }
                 request.setAttribute("contador", listaCarrito.size());
                 request.getRequestDispatcher("CompraCarrito?accion=home").forward(request, response);
                break;
             case "Delete":
                 int idproducto=Integer.parseInt(request.getParameter("idp"));
                 for(int i = 0; i < listaCarrito.size(); i++){
                     if(listaCarrito.get(i).getIdproducto()==idproducto){
                         listaCarrito.remove(i);
                     }
                 }
                 break;    
             case "ActualizarCantidad":
                 int idpro=Integer.parseInt(request.getParameter("idp"));
                 int cant= Integer.parseInt(request.getParameter("cantidad"));
                 for (int i = 0; i < listaCarrito.size(); i++){
                     if(listaCarrito.get(i).getIdproducto()==idpro){
                         listaCarrito.get(i).setCantidad(cant);
                         double st=listaCarrito.get(i).getPrecioCompra()*cant;
                         listaCarrito.get(i).setSubTotal(st);
                     }
                 }
                 break; 
                 
             case "Carrito":
                 totalPagar=0.0;
                 request.setAttribute("carrito", listaCarrito);
                 for (int i = 0; i < listaCarrito.size(); i++) {
                 totalPagar= totalPagar+listaCarrito.get(i).getSubTotal();
                }
                 request.setAttribute("totalPagar", totalPagar);
                 request.getRequestDispatcher("Vistas/Carrito.jsp").forward(request, response);
                 break;
                 
             case"RealizarPago":
                 montopagar = totalPagar;
                 if(c.getIdc()!= 0 && montopagar > 0){
                     cpdao.Pagar(montopagar);
                     request.getRequestDispatcher("CompraCarrito?accion=Carrito").forward(request, response);
                 }else{
                     montopagar = 0;
                     request.getRequestDispatcher("CompraCarrito?accion=Carrito").forward(request, response);
                 }
                         
                 break;
             case "GenerarCompra":
                 
                 // Actualizar stock cuando se hace compra por carrito
                    for(int i = 0; i<listaCarrito.size(); i++){
                        
                        Producto p = new Producto();  
                        int cantidad=listaCarrito.get(i).getCantidad();
                        int codigo=listaCarrito.get(i).getIdproducto();
                        ProductoDAO pdao= new ProductoDAO();
                        p= pdao.buscarAct(codigo);
                        int sac=p.getStock()-cantidad;
                        pdao.actualizarstockCompra(codigo, sac);
                        
                    }
                 
                 //guardar compra
                 idpago = cpdao.IdPago();
                 if(c.getIdc() != 0 && listaCarrito.size() !=0 && montopagar > 0){
                     if (totalPagar > 0.0){
                     
                         co.setIdCliente(c.getIdc());
                         co.setFecha(fechaSistem.FechaBD());
                         co.setMonto(totalPagar);
                         co.setIdPago(idpago);
                         co.setEstado("Comprado");
                         cpdao.guardarCompra(co);
                         montopagar = 0;
                         
                         //guardar detalle compra
                         
                         idcompra = cpdao.IdCompra();
                         for(int i = 0; i< listaCarrito.size(); i++){
                         DetalleCompra dc = new DetalleCompra(); 
                         dc.setIdcompra(idcompra);
                         dc.setIdproducto(listaCarrito.get(i).getIdproducto());
                         dc.setCantidad(listaCarrito.get(i).getCantidad());
                         dc.setPrecioCompra(listaCarrito.get(i).getPrecioCompra());
                         cpdao.guardarDetalleCompra(dc);
                         }
                         listaCarrito= new ArrayList<>();
                         List compra = cpdao.misCompras(c.getIdc());
                         request.setAttribute("myCompras", compra);
                         request.getRequestDispatcher("Vistas/Compras.jsp").forward(request, response);
                        }else{
                         request.getRequestDispatcher("CompraCarrito?accion=home").forward(request, response);
                     }
                 }
                     else{
                  request.getRequestDispatcher("CompraCarrito?accion=home").forward(request, response);
        
                    } 
                 break;
                 
             case "MisCompras":
                 if(c.getIdc() != 0){
                     List compra = cpdao.misCompras(c.getIdc());
                     request.setAttribute("myCompras", compra);
                     request.getRequestDispatcher("Vistas/Compras.jsp").forward(request, response);                   
                 }else if(listaCarrito.size() > 0){
                     request.getRequestDispatcher("CompraCarrito?accion=Carrito").forward(request, response);
                 }else{
                     request.getRequestDispatcher("CompraCarrito?accion=home").forward(request, response);
                 }
                 break;
                 
             case "verDetalle":
               totalPagar = 0.0;
               int idcompras = Integer.parseInt(request.getParameter("idcompra"));
               List<DetalleCompra>detalle = cpdao.Detalle(idcompras);
               request.setAttribute("myDetalle", detalle);
               for(int i= 0; i < detalle.size(); i++){
                   totalPagar = totalPagar + (detalle.get(i).getPrecioCompra()* detalle.get(i).getCantidad());  
               }
               request.setAttribute("montoPagar", totalPagar);
               request.getRequestDispatcher("Vistas/DetalleCompra.jsp").forward(request, response);
                 break;
                 
                  case "Agregar":
                    String nom= request.getParameter("txtnom");
                    String ident= request.getParameter("txtIden");
                    String telf= request.getParameter("txtTel");
                    String dir= request.getParameter("txtDir");
                    String email2= request.getParameter("txtemail");
                    String passw= request.getParameter("txtpass");
                    c.setNombre(nom);
                    c.setIden(ident);
                    c.setTel(telf);
                    c.setDir(dir);
                    c.setCorreo(email2);
                    c.setPass(passw);
                    cdao.agregar(c);
                      request.getRequestDispatcher("CompraCarrito?accion=Carrito").forward(request, response);
                    break;
                 
                  case "Validar":
                String email = request.getParameter("txtuser");
                String pass = request.getParameter("txtpass");
                c = cldao.Validar(email, pass);
                if (c.getIdc() != 0) {
                    logueo = c.getNombre();
                    correo = c.getCorreo();
                }
                request.getRequestDispatcher("CompraCarrito?accion=home").forward(request, response);
                break;
        
        
                 case "Salir":
                listaCarrito = new ArrayList();
                c = new Cliente();
                session.invalidate();
                logueo = "Iniciar Sesion";
                correo = "Iniciar Sesion";
                request.getRequestDispatcher("CompraCarrito?accion=Salirr").forward(request, response);
                break;
                
                 case "AgregarDomicilio":
                    
                     dml.setIdcliente(c.getIdc());
                     dml.setFecha(fechaSistem.FechaBD());
                     dml.setHora(fechaSistem.getHoraActual());
                     dml.setEstado("Activo");
                     String tel = request.getParameter("txtTel"); 
                     String ciu = request.getParameter("txtCiu");
                     String dirr = request.getParameter("txtDir");
                     String ema = request.getParameter("txtEmail");
                    
                     dml.setTelefono(tel);
                     dml.setCiudad(ciu);
                     dml.setDir(dirr);
                     dml.setCorreo(ema);
                     
                     dldao.guardarDomicilio(dml);
                     request.setAttribute("mydomicilio", domic);
                      request.getRequestDispatcher("CompraCarrito?accion=MisDomicilios").forward(request, response);
                     request.getRequestDispatcher("Vistas/Domicilios.jsp").forward(request, response);                   
                   
                     break;
                     
                      case "MisDomicilios":
                 if(c.getIdc() != 0){
                     List domic = dldao.misDomicilios(c.getIdc());
                     request.setAttribute("mydomicilio", domic);
                     request.getRequestDispatcher("Vistas/Domicilios.jsp").forward(request, response);                   
                }else{
                     request.getRequestDispatcher("CompraCarrito?accion=Carrito").forward(request, response);
                 }
                 break;
                    
                    
                 
            default:
             request.setAttribute("productos" , productos);
             request.getRequestDispatcher("Vistas/Menu.jsp").forward(request, response);
             
           
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
