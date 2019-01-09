
public class Factorial extends Thread
{
	int n, resultado; 
	
    public Factorial(int valor)
    {
		n=valor;
		resultado=1;
	}
	
	public void run()
	{
		
		for(int i=1; i<=n; i=i+1)
		{
	     resultado=resultado*i;					
		}
		
		System.out.println(n + " factorial es " + resultado);
				
	}

}
