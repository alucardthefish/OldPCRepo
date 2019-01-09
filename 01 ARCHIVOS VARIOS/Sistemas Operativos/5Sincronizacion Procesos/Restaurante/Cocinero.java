
public class Cocinero extends Thread{
	
	Mesa mesa;
	
	public Cocinero(Mesa m){
		mesa=m;
	}
	
	public void run(){
		
		while(true){
	
			int tiempoCocinando=(int)(Math.random()*10);
			System.out.println("Cocinero preparando comida por " + tiempoCocinando + " segundos");
			
			try{
				sleep(tiempoCocinando*1000);
			}catch(InterruptedException e){}
			
			System.out.println("Cocinero trae un nuevo pedido a la mesa");			
			mesa.colocarPedido();			
		}
	}
}