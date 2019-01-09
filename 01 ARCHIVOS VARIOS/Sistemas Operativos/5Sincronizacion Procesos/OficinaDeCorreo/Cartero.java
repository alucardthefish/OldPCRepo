
public class Cartero extends Thread{
	
	Estante estante;
	int numeroCartero;
	
	public Cartero(Estante e, int n){
		estante=e;
		numeroCartero=n;
	}
	
	public void run(){
			
		while(true){
	
			int tiempoEnLaCalle=(int)(Math.random()*15);
			System.out.println("Cartero " + numeroCartero + " estar� en la calle por " + tiempoEnLaCalle + " segundos");
			
			try{
				sleep(tiempoEnLaCalle*1000);
			}catch(InterruptedException e){}
		
			System.out.println("Llega el cartero " + numeroCartero);			
			estante.colocar();						
		}
	}
}