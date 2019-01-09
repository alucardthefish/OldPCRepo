
public class Estante{
	
	int cantidadCartas;
	Semaforo cartasDisponibles=new Semaforo(0);
	Semaforo espaciosDisponibles=new Semaforo(50);
	Semaforo mutex=new Semaforo(0);

	public Estante(){
 	     cantidadCartas=0;       
	}

	public void colocar(){ 
	   espaciosDisponibles.P();
	   espaciosDisponibles.P();
	   espaciosDisponibles.P();
	   espaciosDisponibles.P();
	   
	   mutex.P();
	   cantidadCartas=cantidadCartas+4;
	   mutex.V();
	   
	   cartasDisponibles.V();
	   cartasDisponibles.V();
	   cartasDisponibles.V();
	   cartasDisponibles.V();
	}	
	
	public void tomar(){		
	   cartasDisponibles.P();
	   cartasDisponibles.P();
	   
	   mutex.P();
	   cantidadCartas=cantidadCartas-2;
	   mutex.V();
	   
	   espaciosDisponibles.V();
	   espaciosDisponibles.V();
	
    }
}