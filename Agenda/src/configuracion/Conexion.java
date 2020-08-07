package configuracion;

import java.sql.*;
import javax.sql.*;

public class Conexion {
	
	Connection miConexion;

	public Conexion (){

		try {

			
			   miConexion =
			  DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java",
			  "root", "");
			  
			/* * 
			 * Statement miStatement = miConexion.createStatement();
			 * 
			 * ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM CONTACTOS");
			 * 
			 * while (miResultSet.next()) {
			 * 
			 * System.out.println(miResultSet.getString("id") + " " +
			 * miResultSet.getString("APELLIDO") + " " + miResultSet.getString("NOMBRE") +
			 * " " + miResultSet.getString("TELEFONO")); }
			 */

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}
	}
	
	public Connection getConnextion() {
		
		return miConexion;
	}
	
}
