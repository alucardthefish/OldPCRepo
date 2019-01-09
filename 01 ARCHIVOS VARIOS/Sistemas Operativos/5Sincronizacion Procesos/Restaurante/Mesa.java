
public class Mesa{
	
	int cantidadPedidos;
	Semaforo cajasDisponibles=new Semaforo(0);
	Semaforo mutex=new Semaforo(1);
		
	public Mesa(){
		cantidadPedidos=0;	    		
	}
	
	public void colocarPedido(){		
	    mutex.P();
		cantidadPedidos=cantidadPedidos+1;	
		mutex.V();
		cajasDisponibles.V();		   
	}
	
	public void atenderPedido(){		
		cajasDisponibles.P();		   
	    cajasDisponibles.P();		   
		mutex.P();   
		cantidadPedidos=cantidadPedidos-2;
        mutex.V();
	}
}