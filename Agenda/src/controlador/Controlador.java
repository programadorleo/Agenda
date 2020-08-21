package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConectaBaseDatos;
import vista.Vista;

public class Controlador implements ActionListener {

	private Vista vista;
	private DefaultTableModel modelo;
	private Connection con;
	private ConectaBaseDatos conexion = new ConectaBaseDatos();
	private PreparedStatement sentencia;	

	private int miid=0;
	private String miapellido;
	private String minombre;
	private String mitelefono;

	public Controlador(Vista vista) {

		this.vista = vista;

		mostrarDatos();

		vista.seleccionar.addActionListener(this);
		vista.agregar.addActionListener(this);
		vista.modificar.addActionListener(this);
		vista.eliminar.addActionListener(this);
		vista.nuevo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.seleccionar) {
			seleccionar();
		}

		if (e.getSource() == vista.agregar) {
			agregarDatos();
		}

		if (e.getSource() == vista.modificar) {
			modificar();
		}

		if (e.getSource() == vista.eliminar) {
			eliminar();
		}

		if (e.getSource() == vista.nuevo) {
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

	public void capturarDatosVista() {

		
		try {
			miid = Integer.parseInt(vista.id.getText());
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un numero en campo id");
			}
		
		
		miapellido = vista.apellido.getText();
		minombre = vista.nombre.getText();
		mitelefono = vista.telefono.getText();

	}
	
	public boolean cajasVacias() {
		
		boolean respuesta=true;
		
		if (miid == 0 || miapellido.equals("") || minombre.equals("") || mitelefono.equals("")) {

			respuesta= true;

		} else {
			respuesta= false;
		}
		
		return respuesta;
		
	}

	public void agregarDatos() {

		capturarDatosVista();

		if (cajasVacias()) {

			JOptionPane.showMessageDialog(null, "No puede haber cajas vacias","Error",JOptionPane.ERROR_MESSAGE);

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

				JOptionPane.showMessageDialog(null, "Error no se puede ingresar numero de id duplicado","Error",JOptionPane.ERROR_MESSAGE);

			}

		}
		mostrarDatos();
		limpiar();
	}

	public void modificar() {
		
		
		int row = vista.tabla.getSelectedRow();

		if (row != -1) {
		

		capturarDatosVista();

		if (cajasVacias()) {

			JOptionPane.showMessageDialog(null, "No puede haber cajas vacias","Error",JOptionPane.ERROR_MESSAGE);

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

				JOptionPane.showMessageDialog(null, "Error no se modificaron los datos","Error",JOptionPane.ERROR_MESSAGE);

			}

		}

		mostrarDatos();
		limpiar();
		
		}else{
			
			JOptionPane.showMessageDialog(null,"Debe seleccionar un contacto","Error", JOptionPane.ERROR_MESSAGE );
		}

	}

	public void eliminar() {
		
		int row = vista.tabla.getSelectedRow();

		if (row != -1) {
		

		capturarDatosVista();

		String sql = "DELETE FROM contactos where id=" + miid;

		try {

			con = conexion.getConexion();

			sentencia = con.prepareStatement(sql);

			sentencia.executeUpdate();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error no se pudo borrar datos","Error",JOptionPane.ERROR_MESSAGE);

		}

		mostrarDatos();
		limpiar();
		
		}else {
			
			JOptionPane.showMessageDialog(null,"Debe seleccionar un contacto","Error", JOptionPane.ERROR_MESSAGE );
		}

	}

	public void limpiar() {

		vista.id.setText(null);
		vista.apellido.setText(null);
		vista.nombre.setText(null);
		vista.telefono.setText(null);
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

			JOptionPane.showMessageDialog(null, "Error mostrar datos" ,"Error",JOptionPane.ERROR_MESSAGE);
		}

	}

}
