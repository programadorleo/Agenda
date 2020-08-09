package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import configuracion.ConsultaContacto;
import configuracion.Contacto;
import vista.Principal;

public class ControlContacto implements ActionListener{
	
	
	private Contacto contacto;
	private ConsultaContacto conContacto;
	private Principal principal;
	

	public ControlContacto(Contacto contacto, ConsultaContacto conContacto,Principal principal) {
		
		this.contacto=contacto;
		this.conContacto=conContacto;
		this.principal=principal;
		
		this.principal.agregar.addActionListener(this);
		this.principal.modificar.addActionListener(this);
		this.principal.eliminar.addActionListener(this);
		this.principal.nuevo.addActionListener(this);
		//this.principal.buscar.addActionListener(this);
						
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== principal.modificar) {
			
		    contacto.setId(Integer.parseInt(principal.id.getText()));
		    contacto.setApellido(principal.apellido.getText());
		    contacto.setNombre(principal.nombre.getText());
		    contacto.setTelefono(principal.telefono.getText());
		    
		    if(conContacto.modificar(contacto))  {
		    	
		    	JOptionPane.showMessageDialog(null, "Registro Guardado");
		    			    	
		    }else {
		    	JOptionPane.showMessageDialog(null, "Error al guardar");
		    }
		    
		}
	}


	
	
	
}
