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
public class VentasDAO {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
     String numeroserie="";
     String sql="select max(NumeroSerie) from ventas";
        try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            numeroserie=rs.getString(1);
        }
        }catch(Exception e){
            
        }
        return numeroserie;
    } 
    
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVenta) from ventas";
        try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            
            idventas=rs.getString(1);
        }
        }catch(Exception e){
            
        }
            return idventas;
    }
    
    public int guardarVenta(Venta ve){
        
            String sql="insert into ventas(IdCliente, IdUsuario, NumeroSerie, FechaVentas, Monto, Estado)values(?,?,?,?,?,?)";
            try{
               con=cn.Conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, ve.getIdcliente());
               ps.setInt(2, ve.getIdusuario());
               ps.setString(3, ve.getNumserie());
               ps.setString(4, ve.getFecha());
               ps.setDouble(5, ve.getMonto());
               ps.setString(6, ve.getEstado());
               ps.executeUpdate();
            }catch(Exception e){
                
            }
   return r;
}
    
    public int guardarDetalleventas( Venta venta){
    String sql="insert into detalleventa(IdVenta, Idproducto, Codigo, Cantidad,PrecioVenta)values(?,?,?,?,?)";
    try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        ps.setInt(1, venta.getId());
        ps.setInt(2, venta.getIdproducto());
        ps.setString(3, venta.getCodigo());
        ps.setInt(4, venta.getCantidad());
        ps.setDouble(5, venta.getPrecio());      
        ps.executeUpdate();
        
    }catch(Exception e){
        
    }
    return r;
}
    
   

   }