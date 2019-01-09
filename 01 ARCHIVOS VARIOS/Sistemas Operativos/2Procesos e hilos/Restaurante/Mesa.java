
public class Mesa{
	
	int cantidadPedidos;
	
	public Mesa(){
	    cantidadPedidos=0;		
	}
	
	public void colocarPedido(){		
		cantidadPedidos=cantidadPedidos+1;	
	}
	
	public void atenderPedido(){
		
		while (cantidadPedidos<2)		   
		   ;				
		   
		cantidadPedidos = cantidadPedidos - 2;
       
	}
}