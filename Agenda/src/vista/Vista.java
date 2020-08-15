package vista;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Conexion;

public class Vista extends JFrame {

	public static void main(String[] args) {
					
		Vista v = new Vista();
		Controlador c = new Controlador(v);
		v.setVisible(true);

	}

	public JPanel contentPane;
	public JTable tabla;
	public Button agregar;
	public Button modificar;
	public Button eliminar;
	public Button nuevo;
	public TextField id;
	public TextField apellido;
	public TextField nombre;
	public TextField telefono;	
    //public Contacto contacto;
	public TextField numero;
	
	public Vista() {
		
		numero= new TextField("10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("CONTACTOS");
		lblNewLabel.setBounds(172, 13, 165, 33);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 48, 433, 170);
		contentPane.add(panel);
		panel.setLayout(null);

		Label label = new Label("ID");
		label.setBounds(10, 26, 70, 24);
		panel.add(label);

		Label label_1 = new Label("APELLIDO");
		label_1.setBounds(10, 57, 70, 24);
		panel.add(label_1);

		Label label_2 = new Label("NOMBRE");
		label_2.setBounds(10, 87, 70, 24);
		panel.add(label_2);

		Label label_3 = new Label("TELEFONO");
		label_3.setBounds(10, 117, 70, 24);
		panel.add(label_3);

	    id = new TextField();
		id.setBounds(112, 26, 145, 24);
		panel.add(id);

		apellido = new TextField();
		apellido.setBounds(112, 57, 145, 24);
		panel.add(apellido);

	    nombre = new TextField();
		nombre.setBounds(112, 87, 145, 24);
		panel.add(nombre);

		telefono = new TextField();
		telefono.setBounds(112, 117, 145, 24);
		panel.add(telefono);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(38, 245, 429, 72);
		contentPane.add(panel_1);
		panel_1.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 5, 5));

		agregar = new Button("AGREGAR");
		panel_1.add(agregar);

		modificar = new Button("MODIFICAR");
		panel_1.add(modificar);

	    eliminar = new Button("ELIMINAR");
		panel_1.add(eliminar);

	    nuevo = new Button("NUEVO");
		panel_1.add(nuevo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(28, 351, 433, 225);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 29, 397, 183);
		

		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		panel_2.add(scrollPane);
		
		
			
	/*	int contactoID;
		if(id.getText()=="") {
			contactoID=0;}*/
	/*	else {
			
		
		    contactoID = Integer.parseInt(id.getText());		     		
        String contactoApellido = apellido.getText();
        String contactoNombre=nombre.getText();
        String contactoTelefono = telefono.getText();
        
        contacto = new  Contacto(contactoID,contactoApellido,contactoNombre,contactoTelefono);
	
		}*/
	}
}
