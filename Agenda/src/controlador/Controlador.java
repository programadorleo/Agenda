package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.Vista;

public class Controlador implements ActionListener {

	Vista vista;
	DefaultTableModel modelo;
	Connection con;
	Conexion conexion = new Conexion();
	PreparedStatement sentencia;
	JScrollPane scrollPane = new JScrollPane();

	public Controlador(Vista vista) {

		this.vista = vista;

		mostrarDatos();

		vista.agregar.addActionListener(this);

		vista.seleccionar.addActionListener(this);

		vista.modificar.addActionListener(this);

		vista.eliminar.addActionListener(this);

		vista.nuevo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.agregar) {

			agregarDatos();

			mostrarDatos();
		}
		if (e.getSource() == vista.seleccionar) {

			seleccionar();

		}

		if (e.getSource() == vista.nuevo) {

			limpiar();
		}

		if (e.getSource() == vista.modificar) {

			modificar();
			mostrarDatos();
			limpiar();
		}

		if (e.getSource() == vista.eliminar) {

			eliminar();
			mostrarDatos();
			limpiar();
		}

	}

	public void seleccionar() {

		int row = vista.tabla.getSelectedRow();

		if (row != -1) {

			vista.id.setText((String) vista.tabla.getValueAt(row, 0));
			vista.apellido.setText((String) vista.tabla.getValueAt(row, 1));
			vista.nombre.setText((String) vista.tabla.getValueAt(row, 2));
			vista.telefono.setText((String) vista.tabla.getValueAt(row, 3));

		}
	}

	public void limpiar() {

		vista.id.setText(null);
		vista.apellido.setText(null);
		vista.nombre.setText(null);
		vista.telefono.setText(null);
	}

	public void modificar() {

		int miid = Integer.parseInt(vista.id.getText());
		String miapellido = vista.apellido.getText();
		String minombre = vista.nombre.getText();
		String mitelefono = vista.telefono.getText();

		if (miid == 0 || miapellido.equals("") || minombre.equals("") || mitelefono.equals("")) {

			JOptionPane.showMessageDialog(null, "No puede haber cajas vacias");

		} else {

			String sql = "UPDATE contactos SET APELLIDO=?,NOMBRE=?,TELEFONO=?  where Id=?";

			try {

				con = conexion.getConexion();

				sentencia = con.prepareStatement(sql);

				sentencia.setString(1, miapellido);
				sentencia.setString(2, minombre);
				sentencia.setString(3, mitelefono);
				sentencia.setInt(4, miid);

				sentencia.executeUpdate();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Error no se modificaron los datos" + e.getMessage());

			}

		}

	}

	public void eliminar() {

		int miid = Integer.parseInt(vista.id.getText());

		String sql = "DELETE FROM contactos where id="+miid;

		try {

			con = conexion.getConexion();
			
			sentencia=con.prepareStatement(sql);
			
			sentencia.executeUpdate();
			

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error no se pudo borrar datos" + e.getMessage());

		}

	}

	public void agregarDatos() {

		int miid = Integer.parseInt(vista.id.getText());
		String miapellido = vista.apellido.getText();
		String minombre = vista.nombre.getText();
		String mitelefono = vista.telefono.getText();

		if (miid == 0 || miapellido.equals("") || minombre.equals("") || mitelefono.equals("")) {

			JOptionPane.showMessageDialog(null, "No puede haber cajas vacias");

		} else {

			String sql = "INSERT INTO contactos (id,APELLIDO,NOMBRE,TELEFONO) VALUES(?,?,?,?)";

			try {

				con = conexion.getConexion();

				sentencia = con.prepareStatement(sql);

				sentencia.setInt(1, miid);
				sentencia.setString(2, miapellido);
				sentencia.setString(3, minombre);
				sentencia.setString(4, mitelefono);

				sentencia.executeUpdate();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Error mostrar ingresar datos" + e.getMessage());

			}

		}
	}

	public void mostrarDatos() {

		String[] titulo = { "ID", "APELLIDO", "NOMBRE", "TELEFONO" };

		String[] registro = new String[4];

		modelo = new DefaultTableModel(null, titulo);

		String sql = "SELECT * FROM contactos";

		try {

			Statement st = conexion.getConexion().createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				registro[0] = rs.getString("id");
				registro[1] = rs.getString("APELLIDO");
				registro[2] = rs.getString("NOMBRE");
				registro[3] = rs.getString("TELEFONO");

				modelo.addRow(registro);

			}

			vista.tabla.setModel(modelo);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error mostrar datos" + e.getMessage());
		}

	}

}
