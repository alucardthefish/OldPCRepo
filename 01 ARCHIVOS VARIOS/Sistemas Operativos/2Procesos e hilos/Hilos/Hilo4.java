
 public class Hilo4 extends Thread{

  public void run(){

      int tiempoDormir=(int)(Math.random()*20);
      System.out.println("El hilo va a dormir " + tiempoDormir + " segundos");
		
      try{
        sleep(tiempoDormir*1000);
      }catch (InterruptedException excepcion){ } 
			
       System.out.println("El hilo despertO");
    }	
}