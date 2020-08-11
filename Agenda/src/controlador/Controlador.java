package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Conexion;
import modelo.Contacto;
import modelo.ContactoDao;
import vista.Vista;

public class Controlador implements ActionListener {

	ContactoDao dao = new ContactoDao();

	Contacto c = new Contacto();

	Vista vista = new Vista();

	DefaultTableModel modelo;

	Conexion conexion = new Conexion();
	
	JScrollPane scrollPane = new JScrollPane();

	public Controlador(Vista vista) {

		this.vista = vista;

		this.vista.agregar.addActionListener(this);
		
		mostrarDatos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.agregar) {
			listar(vista.tabla);
			mostrarDatos();

			
		}
		
		//mostrarDatos();

	}

	public void listar(JTable tabla) {

		modelo = (DefaultTableModel) tabla.getModel();

		List<Contacto> lista = dao.listar();

		Object[] object = new Object[4];

		for (int i = 0; i < lista.size(); i++) {

			object[0] = lista.get(i).getId();
			object[1] = lista.get(i).getApellido();
			object[2] = lista.get(i).getNombre();
			object[3] = lista.get(i).getTelefono();

			modelo.addRow(object);

		}

		vista.tabla.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportView(tabla);

	}

	public void mostrarDatos() {
		
		String []titulo= {"ID", "APELLIDO", "NOMBRE", "TELEFONO" };
		
		String[] registro = new String[4];
		
		modelo = new DefaultTableModel(null,titulo);
		
		String sql = "SELECT * FROM contactos";
	

        try {
        	
        	Statement st = conexion.getConexion().createStatement();
        	
        	ResultSet rs=st.executeQuery(sql);
        	
        
      
		while (rs.next()) {

			registro[0]= rs.getString("id");
			registro[1]= rs.getString("APELLIDO");
			registro[2]= rs.getString("NOMBRE");
			registro[3]= rs.getString("TELEFONO");

		    modelo.addRow(registro);
		    
		    
		}

		vista.tabla.setModel(modelo);
		

	  
        }catch(Exception e) {
        	
        	
        	JOptionPane.showMessageDialog(null,"Error mostrar datos"+ e.getMessage());
        }
        
	   }
	}