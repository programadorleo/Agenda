package modelo;


public class Contacto{
	
	private int id;
	private String apellido;
	private String nombre;
	private String telefono;
	
	
	
	
	public Contacto(int id, String apellido, String nombre, String telefono) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
	
	public Contacto() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	


}
