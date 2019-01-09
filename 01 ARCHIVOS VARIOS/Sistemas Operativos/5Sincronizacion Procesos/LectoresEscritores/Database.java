
public class Database{
	
	int readerCount;
	Semaforo mutex=new Semaforo(1);	
	Semaforo db=new Semaforo(1);
		
	public Database(){
		readerCount=0;		
	}
		
	public void startRead(){
		mutex.P();				
		readerCount=readerCount+1;	
		
	    if (readerCount==1) //si es el lector 1, pedir BD
		  db.P(); 
					  
		mutex.V(); 	
	}
	
	public void endRead(){
		mutex.P(); 
		readerCount=readerCount-1;
		
		if (readerCount==0) //si ya no hay lectores se regresa el control a BD
		  db.V();  
				
		mutex.V(); 
	}
	
	public void startWrite(){
		db.P(); 
	}	
		
    public void endWrite(){
		db.V(); 
	}	
}