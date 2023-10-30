package Amazing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Automovil extends Transporte {
	private int limiteDPaquetes;
	
	Automovil(String patente, int volumen, int valorViaje, int limiteDPaquetes){
		super(patente, volumen, valorViaje);
		this.limiteDPaquetes = limiteDPaquetes;
	}
	@Override
	public double sumarCostoEntrega() {
		if(this.limiteDPaquetes >= super.cantPaquetesEnCarga() && super.cantPaquetesEnCarga() > 0) {
			return super.mostrarValorViaje() ;
		}
		throw new RuntimeException ("Transporte sin cargar")	;
	}
	@Override
	public String cargarPaquete(int codPedido, LinkedList<Paquete> noEntregados, String direccion) {
		StringBuilder string = new StringBuilder();
		
		for(Paquete p: noEntregados) {
			if(p instanceof Ordinario && p.mostrarVolumen() < 2000 && super.mostrarVolumen() >= super.volumenCargardo() + p.mostrarVolumen()){
				
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
	
	
}
