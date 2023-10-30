package Amazing;

import java.util.HashMap;
import java.util.HashSet;
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
	
	public int agregarPaqueteOrdinario(int numPaquete, int volumen, int precio, int costoEnvio) {
		if(this.estado == false) {
			carrito.put(numPaquete,new Ordinario(numPaquete, volumen, precio, costoEnvio));
			return numPaquete;
		}	
		throw new RuntimeException ("Pedido cerrado");
	}
	public int agregarPaqueteEspecial(int numPaquete, int volumen, int precio, int porcentaje, int adicional) {
		if(this.estado == false) {
			carrito.put(numPaquete, new Especial(numPaquete, volumen, precio, porcentaje, adicional));
			return numPaquete;
		}
		throw new RuntimeException ("Pedido cerrado");
	}
	
	public boolean eliminarPaquete(int codPaquete) {
		if(verificarCodPaquete(codPaquete)) {
			return carrito.remove(codPaquete, darPaquete(codPaquete));
		}
		throw new RuntimeException("Paquete no registrado");
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
				valor += paq.sumarCosto();
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

	private boolean verificarCodPaquete(int codPaquete) {
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
	
	
	
	
	
	
}
