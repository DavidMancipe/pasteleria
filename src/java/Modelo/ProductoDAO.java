
package Modelo;

import Config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class ProductoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
         public void agregar(Producto p){
       
         
        String sql="insert into producto(Codigo, Nombre, Descripcion , Stock, PrecioVenta, Foto)values(?,?,?,?,?,?)";
        try{
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             ps.setString(1, p.getCodigo());
             ps.setString(2, p.getNombres());
             ps.setString(3, p.getDescripcion());
             ps.setInt(4, p.getStock());
             ps.setDouble(5, p.getPrecio());
             ps.setBlob(6, p.getFoto());
             ps.executeUpdate();
        }catch(Exception e){

}
    }
         public int actualizar(Producto p){
          String sql="UPDATE  producto set Codigo=?, Nombre=?, Descripcion=? , Stock=?, PrecioVenta=?  where idProducto=?";
        try{
             con=cn.Conexion();
             ps=con.prepareStatement(sql);
             ps.setString(1, p.getCodigo());
             ps.setString(2, p.getNombres());
             ps.setString(3, p.getDescripcion());
             ps.setInt(4, p.getStock());
             ps.setDouble(5, p.getPrecio());
        
             ps.setInt(6, p.getId());
             ps.executeUpdate();
        }
        catch(Exception e){
            
        }
        return r;
    }
    
    public void delete(int id){
          String sql="delete from producto where idProducto="+id;
try{
    con=cn.Conexion();
    ps=con.prepareStatement(sql);
    ps.executeUpdate();
}catch(Exception e){
    
}  
        
    }
    
    
    public List listar(){
        List<Producto>productos=new ArrayList<>();
        String sql="select * from producto";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setCodigo(rs.getString(2));
                p.setNombres(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setStock(rs.getInt(5));
                p.setPrecio(rs.getDouble(6));
                p.setFoto(rs.getBinaryStream(7)); 
                productos.add(p);
                
            }
        }catch(Exception e){
            
            
        }
            return productos;
    } 
    
      public void listarImg(int id, HttpServletResponse response){
        String sql="select * from producto where idProducto="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream    bufferedInputStream = null;
        BufferedOutputStream    bufferedOutputStream = null; 
        try{
         outputStream=response.getOutputStream();
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          if(rs.next()){
             inputStream=rs.getBinaryStream("Foto");
          }
            bufferedInputStream= new  BufferedInputStream(inputStream);
             bufferedOutputStream = new  BufferedOutputStream(outputStream);
             int i=0;
             while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
             }
          
        }catch(Exception e){
            
        }
        
    }
      
      public Producto listarId(int id){
        Producto p = new Producto();
        String sql="select * from producto where idProducto="+id;
        try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(); 
        while(rs.next()){
         p.setCodigo(rs.getString(2));    
        p.setId(rs.getInt(1));
       
        p.setNombres(rs.getString(3));
        p.setDescripcion(rs.getString(4));
        p.setStock(rs.getInt(5));
         p.setPrecio(rs.getDouble(6));
        p.setFoto(rs.getBinaryStream(7));
        
        }
        }catch(Exception e){
              
                    }
return p;    
}
       
       public Producto buscar(String cg){
           String sql="select IdProducto, Codigo, Nombre, Stock ,PrecioVenta  from producto where Codigo="+cg;
            Producto pt = new Producto();
            try{
                con=cn.Conexion();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
             while(rs.next()){
                 pt.setId(rs.getInt(1));
                 pt.setCodigo(rs.getString(2));
                 pt.setNombres(rs.getString(3));
                 pt.setStock(rs.getInt(4));
                 pt.setPrecio(rs.getDouble(5));
                
             }   
            }catch(Exception e){
                
            }
            return pt;
       }
       
       public int actualizarstock(String cg, int stock){
           String sql="update producto set Stock=? where Codigo=?";
           try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);  
            ps.setInt(1, stock);
            ps.setString(2, cg);
            ps.executeUpdate();
           }catch(Exception e){
               
           }
                return r;
       }
    public int actualizarstockCompra(int cg, int stock){
           String sql="update producto set Stock=? where idProducto=?";
           try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);  
            ps.setInt(1, stock);
            ps.setInt(2, cg);
            ps.executeUpdate();
           }catch(Exception e){
               
           }
                return r;
       }
    
    public Producto buscarAct(int cg){
           String sql="select IdProducto, Codigo, Nombre, Stock ,PrecioVenta  from producto where idProducto="+cg;
            Producto pt = new Producto();
            try{
                con=cn.Conexion();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
             while(rs.next()){
                 pt.setId(rs.getInt(1));
                 pt.setCodigo(rs.getString(2));
                 pt.setNombres(rs.getString(3));
                 pt.setStock(rs.getInt(4));
                 pt.setPrecio(rs.getDouble(5));
                
             }   
            }catch(Exception e){
                
            }
            return pt;
       }
}


