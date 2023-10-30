package Amazing;

import java.util.HashMap;
import java.util.LinkedList;

public class Pedido {
	private int codPedido;
	private HashMap<Integer, Paquete> carrito;
	private Cliente cliente;
	private boolean estado;
	
	
	Pedido(int codPedido, String clientName, String clientDirec, int dni){
		this.codPedido = codPedido;
		carrito = new HashMap<>();
		cliente = new Cliente(clientName, clientDirec, dni);
		this.estado = false;
		
	}
	
	public int agregarPaquete(int numPaquete, int volumen, int precio, int costoEnvio) { //ordinario //sobrecarga
		if(this.estado == false) {
			carrito.put(numPaquete,new Ordinario(numPaquete, volumen, precio, costoEnvio));
			return numPaquete;
		}	
		throw new RuntimeException ("Pedido cerrado");
	}
	public int agregarPaquete(int numPaquete, int volumen, int precio, int porcentaje, int adicional) { //especial //sobrecarga
		if(this.estado == false) {
			carrito.put(numPaquete, new Especial(numPaquete, volumen, precio, porcentaje, adicional));
			return numPaquete;
		}
		throw new RuntimeException ("Pedido cerrado");
	}
	
	public boolean eliminarPaquete(int codPaquete) {
		return carrito.remove(codPaquete, darPaquete(codPaquete));
	}
	
	public int mostrarCodigo() {
		return this.codPedido;
	}
	public String mostrarNombreClient() {
		return cliente.mostrarNombre();
	}
	public String mostrarDireccionClient() {
		return cliente.mostrarDireccion();
	}
	
	public boolean mostrarEstado() {
		return this.estado;
	}
	
	public double darValorTotal() {
		double valor = 0;
		if(this.estado) {
			for(Paquete paq: carrito.values()) {
				valor += paq.sumarCosto(); //Polimorfismo en paq.sumarCosto()
			}
		}
		return valor;
	}
	
	public void cerrarPedido() {
		if(this.estado != true) {
			this.estado = true;
			return ;
		}
		throw new RuntimeException ("El pedido ha sido cerrado anteriormente ");
	}
	
	public LinkedList <Paquete> darPaquetesNoEntregados(){
		LinkedList<Paquete> noEntregados = new LinkedList<>();
		if(this.estado == true) {
			for (Paquete paq: carrito.values()) {
				if(!paq.mostrarEstado()) {
					noEntregados.add(paq);
				}
			}
		}
		return noEntregados;
	}
	//--------------------------------Metodos de verificacion------------------------------------

	boolean verificarCodPaquete(int codPaquete) {
		return carrito.containsKey(codPaquete);
	}
	private Paquete darPaquete(int codPaquete) {
		return carrito.get(codPaquete);
	}
	
	public boolean faltanEntregar() {
		boolean faltan = true;
		for(Paquete p: carrito.values()) {
			faltan &= p.mostrarEstado();
		}
		return faltan;
	}
	
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Codigo del pedido = "); cadena.append(this.codPedido);
		cadena.append('\n');
		cadena.append(cliente.toString());
		if(this.estado) {
			cadena.append('\n');
			cadena.append("El pedido cerrado");
		}
		cadena.append('\n');
		cadena.append("El pedido abierto");
		return cadena.toString();
	}
	
	
	
	
}
