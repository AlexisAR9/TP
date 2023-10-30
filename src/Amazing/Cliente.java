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
	
	String mostrarDireccion() {
		return this.direccion;
	}
	String mostrarNombre() {
		return this.nombre;
	}
	int mostrarDni() {
		return this.dni;
	}
	
	
}
