# ifndef RECTANGULO_H
# define RECTANGULO_H

#include <iostream>
#include <string>
#include <sstream>

#include "Figura2D.h"

class Rectangulo:  public  Figura2D
{
	private:
	double longitudLadoMenor;
	double longitudLadoMayor;
	
	public:
	Rectangulo (std::string nombreCuadrado, double ladoMenor, 
			double LadoMayor);
	Rectangulo (double ladoMenor, double LadoMayor);
	virtual ~Rectangulo();
	
	virtual double calcularArea();
	virtual double calcularPerimetro();
    virtual std::string   toString( );
	
};

#endif
