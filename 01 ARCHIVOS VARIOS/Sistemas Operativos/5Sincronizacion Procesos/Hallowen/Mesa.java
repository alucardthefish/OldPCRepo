
public class Mesa{
	
   int cantidadDulces;
   Semaforo mutex=new Semaforo(1);
   Semaforo dulcesDisponibles=new Semaforo(0);
   Semaforo espaciosDisponibles=new Semaforo(10);
  
   public Mesa(){
    cantidadDulces=0;    
   }
   
   public void colocarDulce(){
     espaciosDisponibles.P();
     mutex.P(); 
     cantidadDulces=cantidadDulces+1;
     mutex.V();
     dulcesDisponibles.V();
   }
   
   public void tomarDulce(){
      dulcesDisponibles.P();
      mutex.P(); 
      cantidadDulces=cantidadDulces-1;
      mutex.V(); 
      espaciosDisponibles.V();      
   }
}