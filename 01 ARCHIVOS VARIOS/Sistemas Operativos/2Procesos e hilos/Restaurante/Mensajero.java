
public class Mensajero extends Thread{
	
	private Mesa mesa;
	
	public Mensajero(Mesa m){
		mesa=m;
	}
	
	public void run(){
			
		while(true){
	
			int tiempoEnLaCalle=(int)(Math.random()*15);
			System.out.println("Mensajero estar� en la calle por " + tiempoEnLaCalle + " segundos");
			
			try{
				sleep(tiempoEnLaCalle*1000);
			}catch(InterruptedException e){}
		
			System.out.println("Llega el mensajero y espera pedidos");			
			mesa.atenderPedido();						
		}
	}
}