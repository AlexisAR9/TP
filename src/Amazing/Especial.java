package Amazing;

public class Especial extends Paquete {
	private int porcentaje;
	private int costoAdicional;
	
	Especial(int codPedido, int volumen, int precio, int porcentaje, int adicional){
		super(codPedido, volumen, precio);
		this.porcentaje = porcentaje;
		this.costoAdicional = adicional;
	}
	
	@Override
	public double sumarCosto() {
		int volumen = super.mostrarVolumen() ;
		int precio = super.mostrarPrecio();
		 
		if(volumen >= 3000 ) {
			return  precio + ((precio * this.porcentaje) / 100) + this.costoAdicional;
			
		}
		if(volumen > 5000) {
			return precio + ((precio * this.porcentaje) / 100) +  this.costoAdicional * 2;
		}
		return precio + ((precio * this.porcentaje) / 100);
		
	}
	
	@Override
	public boolean mismosAtributos(Object t) {
		if(t instanceof Especial) {
			Especial otro = (Especial) t;
				if(this.porcentaje == otro.porcentaje && this.costoAdicional == otro.costoAdicional) {
					return true;
				}
		}
		return false;
		
	}
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Pocentaje sumado = "); cadena.append(this.porcentaje);
		cadena.append('\n');
		if(super.mostrarVolumen() >= 3000) {
			cadena.append("Costo adicional = "); cadena.append(this.costoAdicional);
		}
		if(super.mostrarVolumen() > 5000) {
			cadena.append("Costo adicional = "); cadena.append(this.costoAdicional*2);
		}
		cadena.append("Precio final = "); cadena.append(sumarCosto());
		return cadena.toString();
	}
	
	
	
	
	
}
