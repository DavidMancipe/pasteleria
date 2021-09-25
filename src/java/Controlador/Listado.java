/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compra;
import Modelo.ListasCVDAO;
import Modelo.Venta;
import Modelo.VentasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Listado extends HttpServlet {
  Compra cpdao = new Compra();
  ListasCVDAO lcvdao = new ListasCVDAO();

  
  Venta ven = new Venta();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
         String accion=request.getParameter("accion");
       /*
        switch (accion){
        
            case "ListarCompras":
                List lista = lcvdao.listaCompras();
                request.setAttribute("listacompra", lista);
                break;
            
            default:
        } 
       
       request.getRequestDispatcher("Vistas/ListadoCompras.jsp").forward(request, response);
         */        
      switch (accion){
          case "ListarVentas":
              
              List lista = lcvdao.listaVentas();
              request.setAttribute("listaventa" ,lista);
              break;
      }
             request.getRequestDispatcher("Vistas/ListarVentas.jsp").forward(request, response);

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
