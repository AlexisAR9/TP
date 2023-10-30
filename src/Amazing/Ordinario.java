package Amazing;

public class Ordinario extends Paquete {
	private int costoEnvio;
	
	Ordinario(int codPedido, int volumen, int precio, int costoEnvio) {
		super(codPedido, volumen, precio);
		this.costoEnvio = costoEnvio;
	}
	
	@Override
	public double sumarCosto() {
		//double precio = super.mostrarPrecio();
		return  super.mostrarPrecio() + this.costoEnvio;
	}

	@Override
	public boolean mismosAtributos(Object t) {
	
		if(t instanceof Ordinario) {
			Ordinario otro = (Ordinario) t;
			if(this.costoEnvio == otro.costoEnvio) {
				return true;
			}
		}
		
		return false;
	}

	

}
