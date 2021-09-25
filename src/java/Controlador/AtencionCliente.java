/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Fecha;
import Modelo.ListasCVDAO;
import Modelo.Pqrs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
public class AtencionCliente extends HttpServlet {

    Fecha fechaSistem = new Fecha();
   Pqrs pqs = new Pqrs();
   int idpq;
   ListasCVDAO lcvdao = new ListasCVDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion= request.getParameter("accion");
              
        
        switch(accion){
            
                  case "EnviarMensaje":
                     String nom =request.getParameter("txtNom");
                     String tel =request.getParameter("txtTel");
                     String email =request.getParameter("txtEmail");
                     String tp =request.getParameter("txtTp");
                     String cal =request.getParameter("txtCal");
                     String descripcion =request.getParameter("txtMens");
                      
                     pqs.setNombre(nom);
                     pqs.setTelefono(tel);
                     pqs.setCorreo(email);
                     pqs.setTipopeticion(tp);
                     pqs.setCalificacion(cal);
                     pqs.setDescripcion(descripcion);
                     pqs.setFecha(fechaSistem.FechaBD());
                     pqs.setId(idpq);
                     lcvdao.agregarpqrs(pqs);
                      break;
                  default:
                  
              }
     request.getRequestDispatcher("AtencionCliente.jsp").forward(request, response);       

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
