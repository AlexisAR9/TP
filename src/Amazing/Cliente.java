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
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Datos del cliente: ");
		cadena.append('\n');
		cadena.append("Nombre = "); cadena.append(this.nombre);
		cadena.append('\n');
		cadena.append("Direccion = "); cadena.append( this.mostrarDireccion());
		cadena.append('\n');
		cadena.append("DNI = "); cadena.append( this.dni);
		return cadena.toString();
	}
}
