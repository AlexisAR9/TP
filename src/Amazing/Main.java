/*package Amazing;

public class Main {

	public static void main(String[] args) {

	   EmpresaAmazing empresa = new EmpresaAmazing("30-456789-2");
	   
		   empresa.registrarAutomovil("AB444ZZ", 10000, 3500, 5);
		   empresa.registrarUtilitario("AA222FF", 18000, 10000, 10000);
		   empresa.registrarAutomovil("AA666XX", 8000, 2500, 4);
		   empresa.registrarCamion("AE555YY", 40000, 200000, 50);
		   empresa.registrarUtilitario("AG111ZZ", 21000, 6000, 9000);
		   empresa.registrarCamion("AA111BB", 55000, 300000, 35);

		  
		   int p1 = empresa.registrarPedido("Angel Gutierrez",  "San Martin 321", 28324132); //fue cerrado y totalmente enviado
		   int p2 = empresa.registrarPedido("Marta Benitez",  "Pasco 1020", 19456398);
		   int p3 = empresa.registrarPedido("Daniel Constanzo",  "J.Verdi 876", 35678901);	//fue cerrado y totalmente enviado
		   int p4 = empresa.registrarPedido("Beatriz Espinoza",  "L.Alberdi 549", 20345678);
		   int p5 = empresa.registrarPedido("Angel Gutierrez",  "Madariaga 321", 28324132);
		   int p6 = empresa.registrarPedido("Beatriz Espinoza", "L.Alberdi 549", 20345678); //fue cerrado
		   
		   int paq1= empresa.agregarPaquete(p1, 1235, 2890, 1000); // carga uti  ***** sumado 1                                               ordinario
		 //  int paq2= empresa.agregarPaquete(p4, 1290, 5500, 1100);
		   int paq3= empresa.agregarPaquete(p1, 5400, 13400, 3, 400);//especial carga uti **** sumado 2                                       especial
		   int paq4= empresa.agregarPaquete(p6, 800, 2890, 1000); // no lo carga nadie  sumado 7                                              ordinario
		   int paq5= empresa.agregarPaquete(p3, 1800, 3500, 1000); //carga uti   sumado 4                                                     ordinario
		   int paq6= empresa.agregarPaquete(p1, 3800, 13400, 3, 400);//especial carga uti **** sumado 3                                       especial
		   int paq7= empresa.agregarPaquete(p6, 17000, 28900, 1000); // no lo carga nadie (se pasa del volumen del camion) sumado 6           ordinario
		   int paq8= empresa.agregarPaquete(p1, 35000, 134000, 3, 400);//lo carga camion ()paquete especial  sumado 5                         especial
		   //int paq9= empresa.agregarPaquete(p4, 120000, 56000, 2, 1100);
		   //int paq10= empresa.agregarPaquete(p2, 1500, 3890, 1000);
		  // 4 ordinarios 3 especiales
		   double suma = 0;
		   double suma1 = 0;
		   double suma3 = 0;
		   suma1 += (13400 + (13400*(3/100))+ 400);
		   suma3 += (134000 + (134000*(3/100)) + 400*2);
		   suma+= ((2890+1000)  + suma1 + (13400+(13400*(3/100))+ 400*2) + (3500 + 1000) + suma3 +  (28900 + 1000) + (2890 + 1000));
		  
		   empresa.cerrarPedido(p1); 
		   empresa.cerrarPedido(p3);
		   
		   System.out.println("Listados con la carga de transportes: ");
		   
		   System.out.println("Utilitario con patente AA222FF cargado con: "); //carga bien
		   System.out.println(empresa.cargarTransporte("AA222FF"));//uti
		   
		   System.out.println("Auto con patente AA666XX cargado con: "); //carga bien
		   System.out.println(empresa.cargarTransporte("AA666XX"));//auto
		   System.out.println();
		   
		   empresa.cerrarPedido(p6);
		  // empresa.quitarPaquete(paq10);
		   
		   System.out.println("Camion con patente AA666XX cargado con: "); //carga bien
		   System.out.println(empresa.cargarTransporte("AE555YY")); //camion
		   System.out.println();
		   
		   System.out.println("Costo del transporte: " + 
                   empresa.costoEntrega("AE555YY")); //calcula bien
		   System.out.println();
		   
		   System.out.println("Facturacion total de pedidos: " + 
		           empresa.facturacionTotalPedidosCerrados()); //puede ser
		   		System.out.println(suma);
		   System.out.println();
		   
		   System.out.println("Listados con paquetes sin entregar: ");
		   System.out.println(empresa.pedidosNoEntregados()); //funcional bien
		   System.out.println();
		   
		   System.out.println("Hay transportes iguales: " + empresa.hayTransportesIdenticos()); //funciona mal
		   
		   System.out.println(empresa.toString());   
	}
}*/
package Amazing;

public class Main {

	public static void main(String[] args) {

	   EmpresaAmazing empresa = new EmpresaAmazing("30-456789-2");
	   
		   //empresa.registrarAutomovil("AB444ZZ", 10000, 3500, 5);
		   empresa.registrarUtilitario("AA222FF", 18000, 10000, 10000);
		   empresa.registrarAutomovil("AA666XX", 8000, 2500, 4);
		   empresa.registrarCamion("AE555YY", 40000, 200000, 50);
		   //empresa.registrarUtilitario("AG111ZZ", 21000, 6000, 9000);
		   //empresa.registrarCamion("AA111BB", 55000, 300000, 35);
		   empresa.registrarUtilitario("AA222FP", 18000, 10000, 10000);
		  
		   int p1 = empresa.registrarPedido("Angel Gutierrez",  "San Martin 321", 28324132);
		   int p2 = empresa.registrarPedido("Marta Benitez",  "Pasco 1020", 19456398);
		   int p3 = empresa.registrarPedido("Daniel Constanzo",  "J.Verdi 876", 35678901);
		   int p4 = empresa.registrarPedido("Beatriz Espinoza",  "L.Alberdi 549", 20345678);
		   int p5 = empresa.registrarPedido("Angel Gutierrez",  "Madariaga 321", 28324132);
		   int p6 = empresa.registrarPedido("Beatriz Espinoza", "L.Alberdi 549", 20345678);
		   
		   int paq1= empresa.agregarPaquete(p1, 1235, 2890, 1000); // 2890+1000  //carga uti
		  // int paq2= empresa.agregarPaquete(p4, 1290, 5500, 1100); 
		   int paq3= empresa.agregarPaquete(p1, 5400, 13400, 3, 400); // 13400 + (13400 * (3/100)) + 400 * 2  //carga uti
		   //int paq4= empresa.agregarPaquete(p6, 800, 2890, 1000);     // 2890+1000
		   int paq5= empresa.agregarPaquete(p3, 1800, 3500, 1000);    // 3500 + 1000							//carga uti
		   int paq6= empresa.agregarPaquete(p1, 3800, 13400, 3, 400); // 13400 + (13400 * (3/100)) + 400  //carga uti
		   int paq7= empresa.agregarPaquete(p6, 17000, 28900, 1000);  // 28900 + 1000
		   int paq8= empresa.agregarPaquete(p1, 35000, 134000, 3, 400); // 13400+(13400*(3/100))+ 400*2 
		  // int paq9= empresa.agregarPaquete(p4, 120000, 56000, 2, 1100);
		 //  int paq10= empresa.agregarPaquete(p6, 1500, 3890, 1000);
		   int paq12= empresa.agregarPaquete(p6, 1235, 2890, 1000);
		   int paq9= empresa.agregarPaquete(p6, 5400, 13400, 3, 400);
		   int paq10= empresa.agregarPaquete(p6, 1800, 3500, 1000);
		   int paq11= empresa.agregarPaquete(p6, 3800, 13400, 3, 400);
		   
		   double suma = 0;
		   double suma1 = 0;
		   double suma3 = 0;
		   suma1 += (13400 + (13400*(3/100))+ 400);
		   suma3 += (134000 + (134000*(3/100)) + 400*2);
		   suma+= ((2890+1000)  + suma1 + (13400+(13400*(3/100))+ 400*2) + (3500 + 1000) + suma3 +  (28900 + 1000) + (2890 + 1000));
		   
		   
		   empresa.cerrarPedido(p1);
		   empresa.cerrarPedido(p3);
		   
		   System.out.println("Listados con la carga de transportes: ");
		  
		   System.out.println(empresa.cargarTransporte("AA222FF"));
           
		   System.out.println(empresa.cargarTransporte("AA666XX"));
		   System.out.println();
		   
		   empresa.cerrarPedido(p6);
		  // empresa.quitarPaquete(paq10);
		   
		   //System.out.println(empresa.cargarTransporte("AE555YY"));
		   System.out.println();
		   System.out.println("mi auto");
		   System.out.println(empresa.cargarTransporte("AA222FP"));
		   System.out.println();
		   
		   /*System.out.println("Costo del transporte: " + 
                   empresa.costoEntrega("AE555YY"));
		   System.out.println();*/
		   
		   System.out.println("Facturacion total de pedidos: " + 
		           empresa.facturacionTotalPedidosCerrados());
		      System.out.println("Valor real :" + suma);
		   System.out.println();
		   
		   System.out.println("Listados con paquetes sin entregar: ");
		   System.out.println(empresa.pedidosNoEntregados());
		
		   System.out.println();
		   
		   System.out.println("Hay transportes iguales: " + empresa.hayTransportesIdenticos());
		   
		   System.out.println(empresa.toString());   
	}
}