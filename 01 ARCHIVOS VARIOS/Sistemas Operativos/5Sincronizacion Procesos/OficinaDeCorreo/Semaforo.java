
public class Semaforo{

	private int valor;

	public Semaforo(int valor){ 
		this.valor = valor;
	}
	
	public synchronized void P(){ 
		this.valor--;      
		
		if(valor < 0){  
			try {		
				this.wait();
			} catch (InterruptedException e) {}
		}
	}
	

	public synchronized void V(){ 
		this.valor++; 			
		this.notify();
	}
	
}