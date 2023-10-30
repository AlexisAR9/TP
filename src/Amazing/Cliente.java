package Amazing;

public class Cliente {
	private String nombre;
	private String direccion;
	private int dni;
	
	
	Cliente(String nombre, String direccion, int dni){
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
	}
	
	public String mostrarDireccion() {
		return this.direccion;
	}
	public String mostrarNombre() {
		return this.nombre;
	}
	public int mostrarDni() {
		return this.dni;
	}
	
	
}
