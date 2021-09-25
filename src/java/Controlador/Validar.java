/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Validar extends HttpServlet {

  Usuario u = new Usuario();
   UsuarioDAO udao = new UsuarioDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion=request.getParameter("accion");
        
                if(accion.equalsIgnoreCase("Ingresar")){
                    String user =request.getParameter("txtuser");
                    String pass= request.getParameter("txtpass");
                    u=udao.validar(user, pass);
                    if(u.getUser()!=null){
                        
                        request.setAttribute("usuario", u);
                        request.getRequestDispatcher("Controlador?menu=Crud").forward(request, response);
                    }else{
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                    }
            
                }
                else{
                request.getRequestDispatcher("Login.jsp").forward(request, response);

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
