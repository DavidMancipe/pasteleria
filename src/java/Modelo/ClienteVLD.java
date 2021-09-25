
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ClienteVLD {
      Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
      public Cliente Validar(String email, String pass) {
        String sql="select * from cliente where Nombre=? and Password=?";
        Cliente c=new Cliente();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdc(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setIden(rs.getString(3));
                c.setTel(rs.getString(4));
                c.setDir(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setPass(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return c;        
    } 
}
