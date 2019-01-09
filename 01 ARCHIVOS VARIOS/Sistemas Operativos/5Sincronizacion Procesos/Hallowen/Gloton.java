
public class Gloton extends Thread{
	
	Mesa mesa;
		
	public Gloton(Mesa m){
		mesa=m;
	}
	
	public void run(){
			
		while(true){
	
			int tiempoComiendo=(int)(Math.random()*15);
			System.out.println("Gloton comiendo por " + tiempoComiendo + " segundos");
			
			try{
				sleep(tiempoComiendo*1000);
			}catch(InterruptedException e){}
		
			System.out.println("Llega el gloton a la mesa ");			
			mesa.tomarDulce();						
		}
	}
}