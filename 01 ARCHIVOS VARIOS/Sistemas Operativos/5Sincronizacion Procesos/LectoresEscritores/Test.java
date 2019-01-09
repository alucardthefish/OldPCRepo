
public class Test{

   public static void main(String a[]){
    
     Database baseDeDatos=new Database();   
     Writer e1=new Writer(baseDeDatos);  
              
     Reader r1=new Reader(baseDeDatos,1);
     Reader r2=new Reader(baseDeDatos,2);
     Reader r3=new Reader(baseDeDatos,3);
          
     e1.start();
     r1.start();
     r2.start();
     r3.start();
   }      
}