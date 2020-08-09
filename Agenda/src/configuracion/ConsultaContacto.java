package configuracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaContacto extends Conexion {

	public boolean registrar(Contacto contacto) {

		PreparedStatement ps = null;

		Connection con = getConexion();

		String sql = "INSERT INTO contactos(id, APELLIDO, NOMBRE,TELEFONO) VALUES(?,?,?,?)";

		try {

			ps = con.prepareStatement(sql);
			ps.setInt(1, contacto.getId());
			ps.setString(2, contacto.getApellido());
			ps.setString(3, contacto.getNombre());
			ps.setString(4, contacto.getTelefono());
			ps.execute();
			return true;

		} catch (SQLException e) {

			System.err.println(e);

			return false;
		} finally {

			try {
				con.close();

			} catch (SQLException e) {

				System.err.println(e);
			}
		}
	}

	public boolean modificar(Contacto contacto) {

		PreparedStatement ps = null;

		Connection con = getConexion();

		String sql = "UPDATE contactos SET id?, APELLIDO=?, NOMBRE=?, TELEFONO=? WHERE id=?";

		try {

			ps = con.prepareStatement(sql);
			ps.setInt(1, contacto.getId());
			ps.setString(2, contacto.getApellido());
			ps.setString(3, contacto.getNombre());
			ps.setString(4, contacto.getTelefono());
			ps.setInt(5, contacto.getId());
			ps.execute();
			return true;

		} catch (SQLException e) {

			System.err.println(e);

			return false;
		} finally {

			try {
				con.close();

			} catch (SQLException e) {

				System.err.println(e);
			}
		}
	}

	public boolean eliminar(Contacto contacto) {

		PreparedStatement ps = null;

		Connection con = getConexion();

		String sql = "DELETE FROM contactos WHERE id=?";

		try {

			ps.setInt(1, contacto.getId());
			ps.execute();
			return true;

		} catch (SQLException e) {

			System.err.println(e);

			return false;
		} finally {

			try {
				con.close();

			} catch (SQLException e) {

				System.err.println(e);
			}
		}
	}

	public boolean buscar(Contacto contacto) {

		PreparedStatement ps = null;

		ResultSet rs = null;

		Connection con = getConexion();

		String sql = "SELECT * FROM contactos WHERE id=?";

		try {

			ps.setInt(1, contacto.getId());
			rs = ps.executeQuery();

			if (rs.next()) {

				contacto.setId(Integer.parseInt(rs.getString("id")));
				contacto.setApellido(rs.getString("APELLIDO"));
				contacto.setNombre(rs.getString("NOMBRE"));
				contacto.setTelefono(rs.getString("TELEFONO"));
				return true;

			}

			return false;

		} catch (SQLException e) {

			System.err.println(e);

			return false;
		} finally {

			try {
				con.close();

			} catch (SQLException e) {

				System.err.println(e);
			}
		}
	}

}
