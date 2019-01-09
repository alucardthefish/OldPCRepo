

public class Writer extends Thread{
	
	Database database;	
		
	public Writer(Database db){		
		database=db;
	}
	
	public void run(){		
		
		while(true){					    
		   	int tiempoDormir=(int)(Math.random()*10);
			System.out.println("Escritor durmiendo por " + tiempoDormir + " segundos");			
			
			try{
				sleep(tiempoDormir*1000);
			}
			catch(InterruptedException e){}		
			
			System.out.println("Escritor quiere escribir");			    	
		    
		    database.startWrite();		 
		       		    		   
		    int tiempoEscribir=(int)(Math.random()*5);
		    
			System.out.println("Escritor esta escribiendo");			    			
			
			try{
				sleep(tiempoEscribir*1000);
			}
			catch(InterruptedException e){}		
		   	
		   	database.endWrite();			
			
			System.out.println("Escritor termina de escribir");	
		}
	}
}