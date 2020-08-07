package vista;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import configuracion.Conexion;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	Conexion conexion = new Conexion();
	Connection con;
	Statement statement;
	ResultSet resultset;
	DefaultTableModel modelo;
	int id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	
	public Principal() {

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

		TextField id = new TextField();
		id.setBounds(112, 26, 145, 24);
		panel.add(id);

		TextField apellido = new TextField();
		apellido.setBounds(112, 57, 145, 24);
		panel.add(apellido);

		TextField nombre = new TextField();
		nombre.setBounds(112, 87, 145, 24);
		panel.add(nombre);

		TextField telefono = new TextField();
		telefono.setBounds(112, 117, 145, 24);
		panel.add(telefono);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(38, 245, 429, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Button agregar = new Button("AGREGAR");
		panel_1.add(agregar);

		Button modificar = new Button("MODIFICAR");
		panel_1.add(modificar);

		Button eliminar = new Button("ELIMINAR");
		panel_1.add(eliminar);

		Button nuevo = new Button("NUEVO");
		panel_1.add(nuevo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(28, 351, 433, 225);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 29, 397, 183);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "APELLIDO", "NOMBRE", "TELEFONO" }));
		scrollPane.setViewportView(table);

		listar();
	}

	void listar() {
		String consultaSql = "select * from contactos";

		try {

			con = (Connection) conexion.getConnextion();
			statement = (Statement) con.createStatement();
			resultset = statement.executeQuery(consultaSql);

			Object[] contacto = new Object[4];
			modelo = (DefaultTableModel) table.getModel();
			while (resultset.next()) {

				contacto[0] = resultset.getInt("ID");
				contacto[1] = resultset.getString("APELLIDO");
				contacto[2] = resultset.getString("NOMBRE");
				contacto[3] = resultset.getString("TELEFONO");
				modelo.addRow(contacto);

			}

			table.setModel(modelo);
		} catch (Exception e) {

		}

	}
}
