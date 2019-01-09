
public class PruebaHilos2
{	
	public static void main (String a[]) {

	 ThreadEjemplo2 hilo1= new ThreadEjemplo2("Tarea1");
	 ThreadEjemplo2 hilo2 = new ThreadEjemplo2("Tarea2");
		
	 hilo1.start();
	 hilo2.start();
			
	}

}

    
