



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
        <h1>Listado Ventas</h1>
         <div class="col-sm-121">
                <div class="card">
                <div class="card-body">
                      <div class="col-sm-12 ">
                       <br>
                <div class="container">
                    <div>
                        
                             <button type="submit" name="accion" onclick="print();" class="btn btn-danger"><i class="matetial-icons left"></i>Reporte pdf</button>
                            <button type="submit" name="accion"  class="btn btn-success"><i class="matetial-icons left"></i>Reporte Excel</button>
                    
                    </div>                 
                </div>
                <br>    
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Nombre Cliente</th>
                            <th>Nª Serie</th>
                            <th>Fecha Venta</th>
                            <th>Total Venta</th>
                            <th>Estado</th>     
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="vn" items="${listaventa}">
                                <tr>
                                    <td>${vn.cliente.nombre}</td>
                                    <td>${vn.getNumserie()}</td>
                                    <td>${vn.getFecha()}</td>
                                    <td>${vn.getMonto()}</td>
                                    <td>${vn.getEstado()}</td>
                                </tr>
                        </c:forEach>
                            
                        </tbody>
                          
                    </table>
                </div> 
                
                </div>
            </div>
         </div>
    </body>
</html>
