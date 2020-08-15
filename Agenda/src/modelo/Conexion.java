package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {

	public Connection conexion;
	public Statement statement;
	public ResultSet resultset;
	
	public Connection getConexion() {

		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/proyecto_java";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection(url, user, password);
			statement = (Statement) conexion.createStatement();

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}

		return conexion;

	}

}
