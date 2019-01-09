
public class Factorial{
	
	int n, resultado; 
	
    public Factorial(int valor){
		n=valor;
		resultado=1;
	}
	
	public void calcularFactorial(){
		
		for(int i=1; i<=n; i=i+1){
	     resultado=resultado*i;					
		}
		
		System.out.println(n + " factorial es " + resultado);
				
	}
}