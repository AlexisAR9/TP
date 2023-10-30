package Amazing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class Transporte {
	private String patente;
	private HashMap <Integer, Paquete> paquetesEnCarga;
	private int volumen;
	private int valorViaje;
	
	Transporte(String patente, int volumen, int valorViaje){
		this.patente = patente;
		this.volumen = volumen;
		this.valorViaje = valorViaje;
		paquetesEnCarga = new HashMap<>();	
	}
	
	public int mostrarVolumen() {
		return this.volumen;
	}
	public String mostrarPatente() {
		return this.patente;
	}
	
	public int mostrarValorViaje() {
		return this.valorViaje;
	}
	
	public int cantPaquetesEnCarga() {
		return paquetesEnCarga.values().size();
	}
	
	public void cargar(int codPaquete, Paquete paquete) {
		if(!verificarPaquete(codPaquete)) {
			paquetesEnCarga.put(codPaquete, paquete);
			darPaquete(codPaquete).darPorEntregado();
			return ;
		}
		throw new RuntimeException ("Paquete anteriormente cargado");
	}
	public LinkedList <Paquete> listadoDeCarga(){
		LinkedList<Paquete> listado = new LinkedList<>();
		for(Paquete p: paquetesEnCarga.values()) {
			listado.add(p);
		}
		return listado;
	}
	public double volumenCargardo() {
		double volumen = 0;
		for(Paquete p: paquetesEnCarga.values()) {
			volumen += p.mostrarVolumen();
		}
		return volumen;
	}
	
	public abstract String cargarPaquete(int codPedido, LinkedList<Paquete> noEntregados, String direccion);
	public abstract double sumarCostoEntrega();
	
	//--------------------------------Metodos de verificacion------------------------------------
	private boolean verificarPaquete(int codPaquete) {
		return paquetesEnCarga.containsKey(codPaquete);
	}
	
	private Paquete darPaquete(int codPaquete) {
		return paquetesEnCarga.get(codPaquete);
	}
	
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Patente = "); cadena.append(this.patente);
		cadena.append('\n');
		cadena.append("Volumen = "); cadena.append(this.volumen);
		cadena.append('\n');
		cadena.append("Valor del viaje = "); cadena.append(this.valorViaje);
		return cadena.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
