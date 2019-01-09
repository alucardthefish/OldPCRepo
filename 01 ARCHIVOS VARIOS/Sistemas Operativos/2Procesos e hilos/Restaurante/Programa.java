
public class Programa{

 public static void main(String a[]){
 	
 	Mesa mesa=new Mesa();
 	
 	Cocinero procesoCocinero=new Cocinero(mesa);
 	Mensajero procesoMensajero=new Mensajero(mesa);
 	
 	procesoCocinero.start(); 	
 	procesoMensajero.start();
 	
 }

}