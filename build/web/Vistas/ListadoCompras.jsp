


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
        <h1>Listado Compras Carrito</h1>
         <div class="col-sm-12">
                <div class="card">
                <div class="card-body">
                      <div class="col-sm-12">
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
                            <th>Codigo Compra</th>
                            <th>Fecha compra</th>
                            <th>Total pagado</th>          
                            <th>Estado</th>
                           
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="lista" items="${listacompra}">
                            <tr>
                                <td>${lista.cliente.nombre}</td>
                                <td>${lista.getIdPago()}</td>
                                <td>${lista.getFecha()}</td>
                                <td>${lista.getMonto()}</td>
                                <td>${lista.getEstado()}</td>
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
