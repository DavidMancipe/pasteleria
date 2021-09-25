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
public class ClienteDAO {
     Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
 
    
    public List listar(){
        String sql="select * from cliente";
        List<Cliente>lista = new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdc(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setIden(rs.getString(3));
                c.setTel(rs.getString(4));
                c.setDir(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setPass(rs.getString(7));
                lista.add(c);
            }
        }catch(Exception e){
            
        }
            return lista;
    }
      
    public int agregar(Cliente c) {
        String sql="insert into cliente(Nombre , Identificacion, Telefono, Direccion, Correo, Password)values(?,?,?,?,?,?)";        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getIden());
            ps.setString(3, c.getTel());
            ps.setString(4, c.getDir());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getPass());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;        
    }
    
    public Cliente listarId(int id){
        Cliente cln = new Cliente();
        String sql=" select * from cliente where IdCliente="+id;
        try{
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();            
        while(rs.next()){
            cln.setNombre(rs.getString(2));
            cln.setIden(rs.getString(3));
            cln.setTel(rs.getString(4));
            cln.setDir(rs.getString(5));
            cln.setCorreo(rs.getString(6));
            cln.setPass(rs.getString(7));
        }    
        }catch(Exception e){
            
        
    }
    return cln;
}
    
    public int actualizar(Cliente c){
 String sql="update  cliente set Nombre=? , Identificacion=? , Telefono=?, Direccion=?, Correo=?, Password=? where IdCliente=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getIden());
            ps.setString(3, c.getTel());
            ps.setString(4, c.getDir());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getPass());
            ps.setInt(7, c.getIdc());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;        

}

    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
try{
    con=cn.Conexion();
    ps=con.prepareStatement(sql);
    ps.executeUpdate();
}catch(Exception e){
}
    }
    

    public Cliente buscar(String dni){
        String sql="select * from cliente where Identificacion="+dni;
        Cliente ce = new Cliente();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                ce.setIdc(rs.getInt(1));
                ce.setIden(rs.getString(3));
                ce.setNombre(rs.getString(2));
                ce.setTel(rs.getString(4));
                ce.setDir(rs.getString(5));
                ce.setCorreo(rs.getString(6));
                ce.setCorreo(rs.getString(7));
            }
        }catch(Exception e){
            
        }
        return ce;
    }   
    }
    


