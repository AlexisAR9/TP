package Amazing;


import java.util.LinkedList;

public class Utilitario extends Transporte {
	private int valorExtra;
	
	Utilitario(String patente, int volumen, int valorViaje, int valorExtra){
		super(patente, volumen, valorViaje);
		this.valorExtra = valorExtra;
	}
	
	@Override
	public double sumarCostoEntrega() {
		if(super.cantPaquetesEnCarga() > 0) {
			if(super.cantPaquetesEnCarga() > 3) {
				return super.mostrarValorViaje() + this.valorExtra;
			}
			return super.mostrarValorViaje();
		}
		throw new RuntimeException ("Transporte sin cargar");
	}
	
	@Override
	public String cargarPaquete(int codPedido, LinkedList<Paquete> noEntregados, String direccion) {
		StringBuilder string = new StringBuilder();
		LinkedList<Paquete> ordinarioNoEntregados = new LinkedList<>();
		for(Paquete p: noEntregados) {
			if(p instanceof Especial && super.mostrarVolumen() > super.volumenCargardo() + p.mostrarVolumen()) {
				
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
			else {
				ordinarioNoEntregados.add(p);
			}
		}
		for(Paquete op: ordinarioNoEntregados) {
			if(super.mostrarVolumen() > super.volumenCargardo() + op.mostrarVolumen()) {
				
				string.append(" + ");	
				string.append("[ ");
				string.append(codPedido);
				string.append(" - ");
				string.append(op.mostrarCodigo());
				string.append(" ] ");
				string.append(direccion);
				string.append('\n');
				super.cargar(op.mostrarCodigo(), op);
			}

		}
		return string.toString();
	}	
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Valor extra = "); cadena.append(this.valorExtra);
		cadena.append('\n');
		cadena.append("Precio de entrega = "); cadena.append(sumarCostoEntrega());
		
		return cadena.toString();
	}
	
}
