package Amazing;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public  class EmpresaAmazing implements IEmpresa  {
	
	private	HashMap <Integer, Pedido> pedidos;
	private	HashMap <String, Transporte> transportes;
	private String cuit;
	private int numPedidos;
	private int numPaquete;
	
	//----------------------------------------- Metodos principales -----------------------------------------
	EmpresaAmazing(String cuit){
		if(cuit.length() != 0) {
			this.cuit = cuit;
			pedidos = new HashMap<>();
			transportes = new HashMap<>();
			return ;
		}
		throw new RuntimeException ("Cuit invalido");
	}
	
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) { 
		if(!verificarPatente(patente)) {
			transportes.put(patente, new Automovil(patente, volMax, valorViaje, maxPaq));
			return ; 
		}
		throw new RuntimeException ("Patente ya registrada");
	}
	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) { 
		if(!verificarPatente(patente)) {
			transportes.put(patente, new Utilitario(patente, volMax, valorViaje, valorExtra));
			return ; 
		}
		throw new RuntimeException ("Patente ya registrada");
	}
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) { 
		if(!verificarPatente(patente)) {
			transportes.put(patente, new Camion(patente, volMax, valorViaje, adicXPaq));
			return ; 
		}
		throw new RuntimeException ("Patente ya registrada");
	}
	
	public int registrarPedido(String cliente, String direccion, int dni) {
		pedidos.put(numPedidos, new Pedido(numPedidos, cliente, direccion, dni));  
		int aux = numPedidos;
		numPedidos++;
		return aux;
	}
	
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) { //Ordinario 
		Pedido pedido = darPedido(codPedido);
		if(verificarPedido(codPedido)){
			return pedido.agregarPaquete(numPaquete++, volumen, precio, costoEnvio);
		}
		throw new RuntimeException ("Pedido no registrado");
		
	}
	
	public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {//Especial
		Pedido pedido = darPedido(codPedido);
		if(verificarPedido(codPedido) ){
			return pedido.agregarPaquete(numPaquete++, volumen, precio, porcentaje, adicional);
		}
		throw new RuntimeException ("Pedido no registrado");
	}
	public boolean quitarPaquete(int codPaquete) { 

		for(Pedido p: pedidos.values()) {
			if(!p.mostrarEstado() && p.verificarCodPaquete(codPaquete)){
				return  p.eliminarPaquete(codPaquete);
			}
		}
		throw new RuntimeException ("Posibles errores =  Pedido cerrado / Paquete no registrado");
	}	
		
	public double cerrarPedido(int codPedido) {
		Pedido pedido = darPedido(codPedido);
		if(verificarPedido(codPedido) ) {
			pedido.cerrarPedido();
			return pedido.darValorTotal();
		}
		throw new RuntimeException ("Pedido no registrado");
	}
	public String cargarTransporte(String patente) {
		Transporte transpo = darTransporte(patente);
		StringBuilder string = new StringBuilder();
		if(verificarPatente(patente) && transpo != null) {
			for(Pedido p: pedidos.values()) {
				if(p.mostrarEstado()) { //verifica que se carga con pedidods cerrados
					LinkedList <Paquete> noEntregados = p.darPaquetesNoEntregados();
					string.append(transpo.cargarPaquete(p.mostrarCodigo(), noEntregados, p.mostrarDireccionClient())); //Polimorfismo en transpo.cargarPaquete(p.mostrarCodigo(), noEntregados, p.mostrarDireccionClient())
					}
				}
			return string.toString();
		}
		throw new RuntimeException ("Numero de patente no registrado: ");	
	}
	
	public double costoEntrega(String patente) {
		return darTransporte(patente).sumarCostoEntrega(); //Polimorfismo en darTransporte(patente).sumarCostoEntrega()
	}
	public Map<Integer,String> pedidosNoEntregados(){
		HashMap<Integer, String> faltantes = new HashMap<>(); 
		for(Pedido p: pedidos.values()) {
			if(p.mostrarEstado() == true && !p.faltanEntregar()) {
					faltantes.put(p.mostrarCodigo(), p.mostrarNombreClient());
			}
		}
		return faltantes;
	}
	public double facturacionTotalPedidosCerrados() {
		return sumarPedidosCerrados();
	}
	public boolean hayTransportesIdenticos() {
		boolean hayAlgunTransporteIgualAOtro = false;
		LinkedList <Transporte> transpoLis = lisValores();
		for(int i=0; i < transpoLis.size() - 1; i++) {
			Transporte t = transpoLis.get(i);
			if(t != null && t.cantPaquetesEnCarga() > 0) {
				for(int j=1; j < transpoLis.size(); j++) {
					Transporte t1 =	transpoLis.get(j);
					if(t1 != null && t1.cantPaquetesEnCarga() > 0)
					hayAlgunTransporteIgualAOtro |= sonIguales(t,t1);
				}
			}
		}
		return hayAlgunTransporteIgualAOtro;
	}
	
	//--------------------------------Metodos de verificacion------------------------------------
	
	private boolean sonIguales(Transporte t, Transporte t1) {
			if (transporteDelMismoTipo(t,t1) && !verificarPatentes(t, t1) && tienenMismosCarga(t,t1)) {
				return true;
			}
			return false;
	}
	
	private boolean verificarPatentes(Transporte t, Transporte t1) {
		String pat = t.mostrarPatente();
		String pat1 = t1.mostrarPatente();
				
		return pat.equals(pat1);
	}
	
	private boolean tienenMismosCarga(Transporte t, Transporte t1) {

		LinkedList <Paquete> lispaq = t.listadoDeCarga();
		LinkedList <Paquete> lispaq1 = t1.listadoDeCarga();
		
		return lispaq.size() == lispaq1.size() && tienePaquetesIguales(lispaq, lispaq1);
	}

	private boolean tienePaquetesIguales(LinkedList<Paquete> paq, LinkedList<Paquete> paq1) {
		boolean paqIgualitos = true;
		for(int i = 0; i < paq.size(); i++) {
			paqIgualitos &= perteneceAambos(paq.get(i),paq1);
		}
		return paqIgualitos;
	}

	private boolean perteneceAambos(Paquete p, LinkedList<Paquete> paq1) {
		boolean pertenece = false;
		for(int i = 0; i < paq1.size(); i++) {
			pertenece |= (p.equals(paq1.get(i)) && p.mismosAtributos(paq1.get(i)) ); //Polimorfismo en p.mismosAtributos(paq1.get(i)
		}
		return pertenece;
	}
	private boolean transporteDelMismoTipo(Transporte t, Transporte t1) { 
		return t.getClass() == t1.getClass();
	}

	private boolean verificarPedido(int codPedido) { 
		return pedidos.containsKey(codPedido);
		
	}
	private boolean verificarPatente(String patente) {
		return transportes.containsKey(patente) ;
	}
	private Pedido darPedido(int codPedido) {
		return pedidos.get(codPedido);
	}
	
	private Transporte darTransporte(String patente) {
		return transportes.get(patente);
	}
	 
	private double sumarPedidosCerrados() {
		double suma = 0.0;
		for(Pedido p: pedidos.values()) {
				suma += p.darValorTotal(); // .darValorTotal() verifica que si el pedido cerrado y, en caso de ser true, suma todos sus paquetes
		}
			return suma;
	}
	LinkedList<Transporte> lisValores(){
		LinkedList <Transporte> transpo = new LinkedList <>();
		for(Transporte t: transportes.values()){
			transpo.add(t);
		}
		return transpo;
	}

	
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Empresa = "); cadena.append(this.cuit);
		return cadena.toString();
	}
	
	
}
