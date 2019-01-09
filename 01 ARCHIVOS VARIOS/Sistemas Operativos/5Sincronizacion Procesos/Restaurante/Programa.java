
public class Programa{

 public static void main(String a[]){
 	
 	Mesa mesa=new Mesa();
 	
 	Cocinero c1=new Cocinero(mesa);
 	Mensajero m1=new Mensajero(mesa,1);
 	Mensajero m2=new Mensajero(mesa,2);
 	Mensajero m3=new Mensajero(mesa,3);
 	
 	c1.start(); 	
 	m1.start();
 	m2.start();
 	m3.start();
 	
 }

}