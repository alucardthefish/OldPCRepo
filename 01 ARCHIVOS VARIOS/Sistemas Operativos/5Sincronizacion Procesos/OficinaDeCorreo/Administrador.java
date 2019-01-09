
public class Administrador extends Thread{
	
	Estante estante;
	
	public Administrador(Estante e){
		estante=e;
	}
	
	public void run(){
		
		while(true){
	
			int tiempoPreparandoCartas=(int)(Math.random()*10);
			System.out.println("Administrador trabajando por " + tiempoPreparandoCartas + " segundos");
			
			try{
				sleep(tiempoPreparandoCartas*1000);
			}catch(InterruptedException e){}
			
			System.out.println("Administrador trae cartas al estante");			
			estante.colocar();			
		}
	}
}