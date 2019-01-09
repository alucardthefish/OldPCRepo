
public class Recolector extends Thread{
	
	Mesa mesa;
	int numeroRecolector;
	
	public Recolector(Mesa m, int n){
		mesa=m;
		numeroRecolector=n;
	}
	
	public void run(){
		
		while(true){
	
			int tiempoRecogiendoDulces=(int)(Math.random()*10);
			System.out.println("Recolector " + numeroRecolector + " sale a tomar dulces por " + tiempoRecogiendoDulces + " segundos");
			
			try{
				sleep(tiempoRecogiendoDulces*1000);
			}catch(InterruptedException e){}
			
			System.out.println("Recolecor llega a la mesa con dulces");			
			mesa.colocarDulce();			
		}
	}
}