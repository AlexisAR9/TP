package Amazing;

public abstract class Paquete{
	private int codPaquete;
	private int precio;
	private int volumen;
	private boolean estado;
	
	
	Paquete(int codPaquete, int volumen, int precio){
		this.codPaquete = codPaquete;
		this.volumen = volumen;
		this.precio = precio;
		this.estado = false; // indica si el paquete fue entregado o no
	}
	
	
	public int mostrarVolumen(){
		return this.volumen;
	}
	
	public int mostrarCodigo() {
		return this.codPaquete;
	}
	
	public int mostrarPrecio(){
		return this.precio;
	}
	public boolean mostrarEstado() {
		return this.estado;
	}
	public void darPorEntregado(){
		// se considera entregado una vez fue carga en el transporte
		this.estado = true;
		return ;
	}
	public boolean equals(Paquete paq) {
		if((this.getClass() == paq.getClass()) && (this.precio == paq.precio) && (this.volumen == paq.volumen)) {
			return true;
		}
		return false;
	}
	public abstract boolean mismosAtributos(Object t);
	
	public abstract double sumarCosto();
	
	
	
	
	
	
	
	
	
	
	
	
}
