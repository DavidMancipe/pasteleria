/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ListasCVDAO {
     Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listaCompras(){
        
    List<Compra>lista = new ArrayList<>();
    String sql="SELECT  c.FechaCompras, c.Monto, c.Estado , c.idPago, cl.Nombre  from compras c inner join cliente cl on cl.idCliente = c.idCliente";
    try{
           con = cn.Conexion();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                
            Compra com = new Compra();
            com.setCliente(new Cliente());
            com.getCliente().setNombre(rs.getString(5));
            com.setFecha(rs.getString(1));
            com.setMonto(rs.getDouble(2));
            com.setEstado(rs.getString(3));
            com.setIdPago(rs.getInt(4));
            lista.add(com); 
            }
            }catch(Exception e){
          }
           return lista;
    }
      
    public List listaVentas(){ 
    List<Venta>lista = new ArrayList<>();
    String sql="select  ve.NumeroSerie, ve.FechaVentas, ve.Monto,  ve.Estado, cl.Nombre from ventas ve INNER join cliente cl on cl.IdCliente = ve.IdCliente";
    try{
           con = cn.Conexion();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){   
            Venta vn = new Venta();
            vn.setCliente(new Cliente());
            vn.getCliente().setNombre(rs.getString(5));
            vn.setNumserie(rs.getString(1));
            vn.setFecha(rs.getString(2));
            vn.setMonto(rs.getDouble(3));
            vn.setEstado(rs.getString(4));
            lista.add(vn);
            }
            }catch(Exception e){
          }
           return lista;
    }
    
    public List listaDomicilios(){
        List<Domicilios> lista = new ArrayList<>();
        String sql="select dl.Telefono, dl.Ciudad, dl.FechaReserva, dl.HoraReserva, dl.Estado, dl.Dirrecion, dl.Email, cl.Nombre  from domicilios dl  inner join cliente cl on cl.IdCliente = dl.idCliente";
        try{
            con = cn.Conexion();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();  
            while(rs.next()){
                Domicilios dmlc = new Domicilios();
                dmlc.setCliente(new Cliente());
                dmlc.getCliente().setNombre(rs.getString(8));
                dmlc.setTelefono(rs.getString(1));
                dmlc.setCiudad(rs.getString(2));
                dmlc.setFecha(rs.getString(3));
                dmlc.setHora(rs.getString(4));
                dmlc.setEstado(rs.getString(5));
                dmlc.setDir(rs.getString(6));
                dmlc.setCorreo(rs.getString(7));
                lista.add(dmlc);
                
            }
        }catch(Exception e){
            
        }
        return lista;
    }
        
    
    public List listaPqrs(){ 
    List<Pqrs>lista = new ArrayList<>();
    String sql="SELECT * from pqrs"; 
    try{
           con = cn.Conexion();
            ps =  con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){   
            Pqrs pqr = new Pqrs();
            pqr.setNombre(rs.getString(2));
            pqr.setCorreo(rs.getString(3));
            pqr.setTelefono(rs.getString(4));
            pqr.setTipopeticion(rs.getString(5));
            pqr.setCalificacion(rs.getString(6));
            pqr.setDescripcion(rs.getString(7));
            pqr.setFecha(rs.getString(8));
           
            lista.add(pqr);
            }
            }catch(Exception e){
          }
           return lista;
    }
            
    public void agregarpqrs(Pqrs pr){
        
        String sql="insert into pqrs(Nombre, Telefono ,Correo, TipoPeticion, Calificacion, Descripcion , fecha)values(?,?,?,?,?,?,?)";
   try{
       con=cn.Conexion();
       ps= con.prepareStatement(sql);
       
       ps.setString(1, pr.getNombre());
       ps.setString(2, pr.getTelefono());
       ps.setString(3, pr.getCorreo());
       ps.setString(4, pr.getTipopeticion());
       ps.setString(5, pr.getCalificacion());
       ps.setString(6, pr.getDescripcion());
       ps.setString(7, pr.getFecha());
       ps.executeUpdate();
       
       
   }catch(Exception e){
       
   }
    }
}
