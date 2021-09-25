
package Controlador;

import Config.Fecha;
import Modelo.Cliente;
import Modelo.ClienteDAO;

;

import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class Controlador extends HttpServlet {

   Usuario u = new Usuario();
   int idu;
   UsuarioDAO udao = new UsuarioDAO();
   
   ClienteDAO cdao = new ClienteDAO();
   int idc;
   Cliente c = new Cliente();
   
   ProductoDAO pdao = new ProductoDAO();
   int idp;
   Producto p = new Producto();
   
   // comienzo cliente pqrs
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String menu = request.getParameter("menu");
        String accion= request.getParameter("accion");
        
        if(menu.equals("Crud")){
        request.getRequestDispatcher("Vistas/Crud.jsp").forward(request, response);
            
        }
       
         if(menu.equals("Usuario")){
        switch(accion){
            
                case "Listar":
        List lista=udao.listar();
        request.setAttribute("usuarios", lista); 
                break; 
                
                case "Agregar":
        String nom= request.getParameter("txtNom");
        String tel= request.getParameter("txtTel");
        String em= request.getParameter("txtEmail");
        String user= request.getParameter("txtUser");
        String pass= request.getParameter("txtPass");
        String est= request.getParameter("txtEst");
        u.setNombre(nom);
        u.setTel(tel);
        u.setEmail(em);
        u.setUser(user);
        u.setPass(pass);
        u.setEstado(est);
        udao.agregar(u);
        request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);                 
                break;
                case "Editar":
        idu=Integer.parseInt(request.getParameter("id"));
        Usuario o = udao.listarId(idu);
        request.setAttribute("usuario", o);
        request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                break; 
                case "Actualizar":
                 String nom1= request.getParameter("txtNom");
        String tel1= request.getParameter("txtTel");
        String em1= request.getParameter("txtEmail");
        String user1= request.getParameter("txtUser");
        String pass1= request.getParameter("txtPass");
        String est1= request.getParameter("txtEst");
        u.setNombre(nom1);
        u.setTel(tel1);
        u.setEmail(em1);
        u.setUser(user1);
        u.setPass(pass1);
        u.setEstado(est1);
        u.setId(idu);
       udao.actualizar(u);
        request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                break;
                case "Delete":
        idu=Integer.parseInt(request.getParameter("id"));
        udao.delete(idu);
        request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);        
                break; 
            default:
        }
       request.getRequestDispatcher("Vistas/Usuario.jsp").forward(request, response);
      
    }
        if(menu.equals("Cliente")){
            switch(accion){
                case "Listar":
                   List lista=cdao.listar(); 
                   request.setAttribute("cliente", lista);
                break;
                case "Agregar":
                    String nom= request.getParameter("txtNom");
                    String ident= request.getParameter("txtIde");
                    String telf= request.getParameter("txtTel");
                    String dir= request.getParameter("txtDir");
                    String email= request.getParameter("txtEmail");
                    String passw= request.getParameter("txtPass");
                    c.setNombre(nom);
                    c.setIden(ident);
                    c.setTel(telf);
                    c.setDir(dir);
                    c.setCorreo(email);
                    c.setPass(passw);
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    idc=Integer.parseInt(request.getParameter("id"));
                    Cliente clien = cdao.listarId(idc);
                    request.setAttribute("clientes", clien);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);   
                break;
                case "Actualizar":
                  String nom1= request.getParameter("txtNom");
                  String ident1= request.getParameter("txtIde");
                  String telf1= request.getParameter("txtTel");
                  String dir1= request.getParameter("txtDir");
                  String email1= request.getParameter("txtEmail");
                  String passw1= request.getParameter("txtPass");
                    
                  c.setNombre(nom1);
                  c.setIden(ident1);
                  c.setTel(telf1);
                  c.setDir(dir1);
                  c.setCorreo(email1);
                  c.setPass(passw1);
                  c.setIdc(idc);
                  cdao.actualizar(c); 
                  request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                break;
                case "Delete":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                   request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response); 
                break;
                default:       
            }
                 request.getRequestDispatcher("Vistas/Cliente.jsp").forward(request, response);

        }
        
        if(menu.equals("Producto")){
            switch(accion){
                case "Listar":
                    List lista=pdao.listar();
                    request.setAttribute("producto", lista);
                break;
                case "Agregar":
                    String cod=request.getParameter("txtCod");
                    String nom= request.getParameter("txtNom");
                    String des= request.getParameter("txtDes"); 
                    int  cant=Integer.parseInt(request.getParameter("txtCant"));
                    double precio=Double.parseDouble(request.getParameter("txtPre"));
                    Part part=request.getPart("txtFot");
                    InputStream inputStream = part.getInputStream();
                   p.setCodigo(cod);
                   p.setNombres(nom);
                   p.setDescripcion(des);
                   p.setStock(cant);
                   p.setPrecio(precio);
                   p.setFoto(inputStream);
                   pdao.agregar(p);
                   request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);    
                break;
                case "Editar":
                    idp=Integer.parseInt(request.getParameter("id"));
                    Producto pto= pdao.listarId(idp);
                    request.setAttribute("pr", pto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                   String cod1=request.getParameter("txtCod"); 
                   String nom1= request.getParameter("txtNom");  
                   String des1= request.getParameter("txtDes"); 
                   int  cant1=Integer.parseInt(request.getParameter("txtCant"));
                   double precio1=Double.parseDouble(request.getParameter("txtPre"));
                   p.setCodigo(cod1);
                   p.setNombres(nom1);
                   p.setDescripcion(des1);
                   p.setStock(cant1);
                   p.setPrecio(precio1);
                   p.setId(idp);
                   pdao.actualizar(p);
                   request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                   break;    
            
                case "Delete":
                    idp=Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                default:
            }
              request.getRequestDispatcher("Vistas/Productos.jsp").forward(request, response);       
        }
        
          
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


