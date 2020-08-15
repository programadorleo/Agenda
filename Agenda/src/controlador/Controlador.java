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
import modelo.Contacto;
import vista.Vista;



public class Controlador implements ActionListener {

	Vista vista = new Vista();
	DefaultTableModel modelo;
	Connection con;
	Conexion conexion = new Conexion();
	PreparedStatement sentencia;
	JScrollPane scrollPane = new JScrollPane();

	public Controlador(Vista vista) {
		
		vista = new Vista();
		System.out.println("controlador");
		
		
		mostrarDatos();
		
						
	/*	super();
		
		vista = new Vista();
		this.vista=vista;

		

		
		
		vista.agregar.addActionListener(this);
	
		miapellido = c.getApellido();

		System.out.println(miapellido);*/

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Vista vista=new Vista();

		if (e.getSource()==vista.agregar) {

			System.out.println("paso performed");
					
			agregarDatos();
			mostrarDatos();

		}*/

	}

	public void agregarDatos() {
		
	/*	vista = new Vista();
		
		System.out.println("metodo agrego datos");
		
		int miid = 7;		
		String miapellido = vista.apellido.getText();
		String minombre =  vista.nombre.getText();
		String mitelefono =  vista.telefono.getText();
	
		
		

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
				
				System.out.println("llego aca");

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Error mostrar ingresar datos" + e.getMessage());

			}

		}*/
	}

	public void mostrarDatos() {
		
		Vista vista=new Vista();

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
