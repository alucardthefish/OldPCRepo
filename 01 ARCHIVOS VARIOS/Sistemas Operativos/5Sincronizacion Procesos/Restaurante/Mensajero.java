
public class Mensajero extends Thread{
	
	Mesa mesa;
	int numeroMensajero;
	
	public Mensajero(Mesa m, int n){
		mesa=m;
		numeroMensajero=n;
	}
	
	public void run(){
			
		while(true){
	
			int tiempoEnLaCalle=(int)(Math.random()*15);
			System.out.println("Mensajero " + numeroMensajero + " estará en la calle por " + tiempoEnLaCalle + " segundos");
			
			try{
				sleep(tiempoEnLaCalle*1000);
			}catch(InterruptedException e){}
		
			System.out.println("Llega el mensajero " + numeroMensajero);			
			mesa.atenderPedido();						
		}
	}
}