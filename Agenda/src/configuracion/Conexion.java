package configuracion;

import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import vista.*;

public class Conexion {

	private final String base = "proyecto_java";
	private final String user = "root";
	private final String password = "";
	private final String url = "jdbc:mysql://localhost:3306/" + base;
	private Connection conexion;

	static Statement statement;
	static ResultSet resultset;

	public Connection getConexion() {

		try {

			conexion = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

			statement = (Statement) conexion.createStatement();

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}

		return conexion;

	}

	public void mostrar() {

		try {

			String consultaSql = "select * from contactos";

			resultset = statement.executeQuery(consultaSql);

			while (resultset.next()) {

				System.out.println(resultset.getInt("id") + " " + resultset.getString("APELLIDO") + " "
						+ resultset.getString("APELLIDO") + " " + resultset.getString("NOMBRE") + " "
						+ resultset.getString("TELEFONO"));
			}

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}

	}

}
