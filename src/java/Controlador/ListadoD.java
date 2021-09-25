
package Controlador;

import Config.Fecha;
import Modelo.DetalleDomicilio;
import Modelo.Domicilios;
import Modelo.DomiciliosDAO;
import Modelo.ListasCVDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListadoD extends HttpServlet {
   DetalleDomicilio dtd= new DetalleDomicilio();
  Domicilios dmcs = new Domicilios();
  ListasCVDAO lcvdao = new ListasCVDAO();
  Fecha fechaSistem = new Fecha();
  DomiciliosDAO dldao = new DomiciliosDAO();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "ListarDomicilios":
                List lista = lcvdao.listaDomicilios();
                request.setAttribute("domicilios", lista);
                break;
            
             case "Enviar":
                
                dtd.setIddomicilio(dmcs.getId());
                dtd.setHoraentrega(fechaSistem.getHoraActual());
                double valord =Double.parseDouble(request.getParameter("txtValor"));
                String estadodm = request.getParameter("txtEstado"); 
                String fechae = request.getParameter("txtFecha");
                
                dtd.setValordomiiclio(valord);
                dtd.setEstado(estadodm);
                dtd.setFechaentrega(fechae);
                
                dldao.guardardetalleDomicilio(dtd);
                request.getRequestDispatcher("ListadoD?accion=ListarDomicilios").forward(request, response);  
                request.getRequestDispatcher("Vistas/ListarDomicilios.jsp").forward(request, response);  
                break;
            
            default:
        }
       request.getRequestDispatcher("Vistas/ListarDomicilios.jsp").forward(request, response);

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
