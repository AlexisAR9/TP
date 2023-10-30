package Amazing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Camion extends Transporte{
	private int valorAdicional;
	
	Camion(String patente, int volumen, int valorViaje, int valorAdicional){
		super(patente, volumen, valorViaje);
		this.valorAdicional = valorAdicional;
	}
	@Override
	public double sumarCostoEntrega() {
		
		if(super.cantPaquetesEnCarga() > 0) {
			return (super.mostrarValorViaje() + (valorAdicional * super.cantPaquetesEnCarga()));
		}
		
		throw new RuntimeException("Transporte sin cargar");
	}
	@Override
	public String cargarPaquete(int codPedido, LinkedList<Paquete> noEntregados, String direccion) {
		StringBuilder string = new StringBuilder();
	
		for(Paquete p: noEntregados) {
			if( p instanceof Especial && p.mostrarVolumen() > 2000 && super.mostrarVolumen() > super.volumenCargardo() + p.mostrarVolumen()){
				string.append(" + ");	
				string.append("[ ");
				string.append(codPedido);
				string.append(" - ");
				string.append(p.mostrarCodigo());
				string.append(" ] ");
				string.append(direccion);
				string.append('\n');
				super.cargar(p.mostrarCodigo(), p);
			}
		}
		return string.toString();
	}
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Valor adicional = "); cadena.append(this.valorAdicional);
		cadena.append('\n');
		cadena.append("Precio de entrega = "); cadena.append(sumarCostoEntrega());
		
		return cadena.toString();
	}
	
	
	
	
}
