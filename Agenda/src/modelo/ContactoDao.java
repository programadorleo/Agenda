package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ContactoDao {
	
	Conexion conectar = new Conexion();
	
	Connection con;
	
	PreparedStatement ps;
	
	ResultSet rs;
	
	
	public List listar() {
		
		List<Contacto>datos = new ArrayList<>();
		
		String sql="selct * from contacto";
				
		try {
					
			con= conectar.getConexion();
			
			ps = con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Contacto c=new Contacto();
				
				c.setId(rs.getInt("id"));
				c.setApellido(rs.getString("APELLIDO"));
				c.setNombre(rs.getString("NOMBRE"));
				c.setTelefono(rs.getString("TELEFONO"));
				
				datos.add(c);
			}
			
		}catch(Exception e) {
			
		}
		
		return datos;
	}
	
	

}
