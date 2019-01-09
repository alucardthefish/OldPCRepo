

public class Reader extends Thread{
	
	Database database;
	int numeroLector;
		
	public Reader(Database db,int r){
		database=db;
		numeroLector=r;		
	}
	
	public void run(){
	
		while(true){			
	
	 	    int tiempoDormir=(int)(Math.random()*10);
			System.out.println("Lector " + numeroLector + " durmiendo por " + tiempoDormir + " segundos");			
			
			try{
				sleep(tiempoDormir*1000);
			}
			catch(InterruptedException e){}
		    
		    System.out.println("Lector " + numeroLector + " quiere leer");			    
		    
		    database.startRead();		    		    
		    System.out.println("Lector " + numeroLector + " esta leyendo");
		   	
		   	int tiempoLeer=(int)(Math.random()*5);
		   	
		   	try{
				sleep(tiempoLeer*1000);
			}
			catch(InterruptedException e){}		   		   
		   
		    database.endRead();			
			System.out.println("Lector " + numeroLector + " termino de leer");	
		}
	}
}