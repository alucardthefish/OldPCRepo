
 public class Hilo3 extends Thread{
     
		public void run(){
				
			System.out.println("El hilo va a dormir 5 segundos");
		
		    try{		    
				sleep(5000);
			}catch (InterruptedException e){}
			
			System.out.println("El hilo despertó");
			
		}

	}