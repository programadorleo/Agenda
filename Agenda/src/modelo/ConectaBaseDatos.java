package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBaseDatos {

	public static Connection conexion;

	public Connection getConexion() {

		String url = "jdbc:mysql://localhost:3306/proyecto_java";
		String user = "root";
		String password = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}

		return conexion;

	}

	public static void cerrar() {

		try {

			if (conexion != null)
				conexion.close();

		} catch (Exception e) {
			System.out.println("Error: No se logro cerrar conexion:" + e.getMessage());
		}
	}

}
