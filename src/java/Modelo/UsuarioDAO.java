package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
  
    public Usuario validar(String user, String pass){
        
        Usuario u = new Usuario();
        String sql="select * from usuario where User=? and Password=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            while(rs.next()){
                u.setId(rs.getInt("idUsuario"));
                u.setUser(rs.getString("User"));
                u.setTel(rs.getString("Telefono"));
                u.setNombre(rs.getString("Nombre"));
                u.setEmail(rs.getString("Correo"));
                
            }
        }catch(Exception e){
            
        }
        return u;
    }
    //operaciones crud
    
    public List listar(){
        String sql="select * from usuario";
        List<Usuario>lista= new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario u=new Usuario();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setTel(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setUser(rs.getString(5));
                u.setPass(rs.getString(6));
                u.setEstado(rs.getString(7));
                lista.add(u);
                
            }
        }catch(Exception e){
            
        }
        return lista;
        
    } 
    
   
    public int agregar(Usuario u){
  String sql="insert into usuario(Nombre,Telefono,Correo,User,Password,Estado)values(?,?,?,?,?,?)";  
try{
    con=cn.Conexion();
    ps=con.prepareStatement(sql);
    ps.setString(1, u.getNombre());
    ps.setString(2, u.getTel());
    ps.setString(3, u.getEmail());
    ps.setString(4, u.getUser());
    ps.setString(5, u.getPass());
    ps.setString(6, u.getEstado());                 
    ps.executeUpdate();
}catch(Exception e){
    
}
return r;
}
    
      public Usuario listarId(int id){
        Usuario usu = new Usuario();
        String sql="select * from usuario where idUsuario="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                usu.setNombre(rs.getString(2));
                usu.setTel(rs.getString(3));
                usu.setEmail(rs.getString(4));
                usu.setUser(rs.getString(5));
                usu.setPass(rs.getString(6));
                usu.setEstado(rs.getString(7));
            }
        }catch(Exception e){
            
        }
        return usu;
    }
     
    public int actualizar(Usuario u){
      String sql="update  usuario  set Nombre=?, Telefono=?,Correo=?,User=?,Password=?,Estado=? where idUsuario=?";  
try{
    con=cn.Conexion();
    ps=con.prepareStatement(sql);
    ps.setString(1, u.getNombre());
    ps.setString(2, u.getTel());
    ps.setString(3, u.getEmail());
    ps.setString(4, u.getUser());
    ps.setString(5, u.getPass());
    ps.setString(6, u.getEstado());  
    ps.setInt(7, u.getId());
    ps.executeUpdate();
}catch(Exception e){
    
}
return r;
}
    public void delete(int id){
    String sql="delete from usuario where idUsuario="+id;
try{
    con=cn.Conexion();
    ps=con.prepareStatement(sql);
    ps.executeUpdate();
}catch(Exception e){
    
}

}
    }
    

