#ifndef OPERACIONES_H
#define OPERACIONES_H





class Operaciones

{

private:

 	double primero; 
	double segundo;


	public:
	
	Operaciones();
	~Operaciones();
	
	void setPrimero(double uno);
	
	double getPrimero();

	void setsegundo(double dos);
	
	double getsegundo();

	double sumar(double primero,double segundo);
	
	double restar(double primero,double segundo);
	
	double multiplicar(double primero,double segundo);
	
	double dividir(double primero,double segundo);

	
};



	

#endif



