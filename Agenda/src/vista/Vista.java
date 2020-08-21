package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import controlador.Controlador;

public class Vista extends JFrame {

	public static void main(String[] args) {

		Vista v = new Vista();
		Controlador c = new Controlador(v);
		v.setVisible(true);

	}

	public JPanel contentPane;
	public JTable tabla;
	public Button seleccionar;
	public Button agregar;
	public Button modificar;
	public Button eliminar;
	public Button nuevo;
	public TextField id;
	public TextField apellido;
	public TextField nombre;
	public TextField telefono;	

	public Vista() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Font fuenteBoton = new Font("Tahoma", Font.BOLD, 15);

		JLabel lblNewLabel = new JLabel("CONTACTOS");
		lblNewLabel.setBounds(172, 13, 165, 33);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(40, 48, 440, 170);
		panel.setBackground(Color.GRAY);
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

		seleccionar = new Button("SELECCIONAR");
		seleccionar.setBounds(280, 67, 145, 24);
		seleccionar.setFont(fuenteBoton);
		panel.add(seleccionar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_1.setBounds(40, 245, 440, 72);
		panel_1.setBackground(Color.gray);
		contentPane.add(panel_1);
		panel_1.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 5, 5));

		agregar = new Button("AGREGAR");
		agregar.setFont(fuenteBoton);

		panel_1.add(agregar);

		modificar = new Button("MODIFICAR");
		modificar.setFont(fuenteBoton);
		panel_1.add(modificar);

		eliminar = new Button("ELIMINAR");
		eliminar.setFont(fuenteBoton);
		panel_1.add(eliminar);

		nuevo = new Button("NUEVO");
		nuevo.setFont(fuenteBoton);
		panel_1.add(nuevo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_2.setBounds(40, 351, 440, 225);
		panel_2.setBackground(Color.gray);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 29, 397, 183);

		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		panel_2.add(scrollPane);

	}
}
