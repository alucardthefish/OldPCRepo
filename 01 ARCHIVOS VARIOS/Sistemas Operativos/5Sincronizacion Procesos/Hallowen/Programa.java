
public class Programa{

 public static void main(String a[]){
 	
 	Mesa mesa=new Mesa();
 		
 	Recolector r1=new Recolector(mesa,1);
 	Recolector r2=new Recolector(mesa,2);
 	Recolector r3=new Recolector(mesa,3);
 	
 	Gloton g1=new Gloton(mesa);
 	
 	r1.start(); 	
 	r2.start();
 	r3.start();
 	
 	g1.start();
 	
 }

}