
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
                @media print{
                    .btn, accion{
                        display:none;
                    }
                } 
            </style>
    </head>
    <body>
        <h1>Listado Pqrs</h1>
         <div class="col-sm-13">
                <div class="card">
                <div class="card-body">
                      <div class="col-sm-13 ">
                       <br>
                <div class="container">
                    <div>
                        
                            <button type="submit" name="accion" onclick="print();" class="btn btn-danger"><i class="matetial-icons left"></i>Reporte pdf</button>
                            <button type="submit" name="accion"  class="btn btn-success"><i class="matetial-icons left"></i>Reporte Excel</button>
                 
                    </div>                 
                </div>
                <br>    
                    <table id="tblReporte" class="table table-hover text-center">
                        <thead>
                        <tr>
                            <th>Nombre Cliente</th>
                            <th>Telefono</th>
                            <th>Correo</th>                           
                            <th>Reclamo/ sugerencia / queja</th>
                            <th>Calificacion</th>
                            <th>Descripcion</th>     
                            <th>Fecha</th>
                            <th>accion</th>
                        </tr>
                        </thead>
                        <tbody class="text-center"> 
                            <c:forEach var="lista" items="${listapqrs}">
                                <tr>
                            <td>${lista.getNombre()}</td>
                            <td>${lista.getCorreo()}</td>
                            <td>${lista.getTelefono()}</td>
                             <td>${lista.getTipopeticion()}</td>
                             <td>${lista.getCalificacion()}</td>
                            <td>${lista.getDescripcion()}</td>
                            <td>${lista.getFecha()}</td>
                            <td>
                                <a  href="#" data-toggle="modal" data-target="#myModal">Atender Solicitud</a>
                            </td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                          
                    </table>
                </div>       
                </div>
            </div>
         </div>     
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="container col-lg-9">                   
                    <div class="modal-content">                   
                        <div class="pr-2 pt-1">                         
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                            </button>                    
                        </div>
                        <div class="text-center">                         
                            <img src="img/user.png" width="100" height="100">                         
                        </div>
                        <div class="modal-header text-center">                      
                            <ul class="nav nav-pills">                           
                                <li class="nav-item">
                                    <a class="nav-link active text-center" data-toggle="pill" href="#pills-iniciar">Formulario de seguimiento de las Pqrs</a>
                                </li>                         
                            </ul>  
                        </div>
                        <div class="modal-body"> 
                            <div class="tab-content" id="pills-tabContent">
                                
                                
                                
                                <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                                    <form action="LisdatodPqrs?accion=EnvioCorreo" method="POST">
                                        <div class="form-group text-center">
                                            <label>Correo el cual se envia</label>
                                            <input type="email" class="form-group">
                                            <br>
                                            <label>contraseña usuario</label>
                                            <input type="password" class="form-group">
                                            <br>
                                            <label>Correo Destinatario</label>
                                            <input type="email" class="form-group">
                                            
                                            
                                        </div>                                 
                                        <button type="submit" name="accion" value="enviarCorreo" class="btn btn-outline-danger btn-block">Enviar</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
        <script src="../js/ventanam.js" type="text/javascript"></script>
         <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
