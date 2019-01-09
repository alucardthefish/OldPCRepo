
public class Pi extends Thread
{
	int termino;
	double resultado; 
	
    public Pi(int t){
		termino=t;
		resultado=0.0;
	}
	
	public void run(){
		
		int signo=1;
		
		for(int i=1; i<=termino; i=i+2){
	     resultado=resultado + (4.0*signo)/i;					
	     signo=signo*-1;
		}
		
		System.out.println("Pi aproximado es " + resultado);
				
	}

}
