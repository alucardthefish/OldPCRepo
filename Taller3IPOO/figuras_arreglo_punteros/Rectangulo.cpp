#include "Rectangulo.h"

using namespace std;

Rectangulo::Rectangulo(std::string nombreRectangulo, 
			double ladoMenor, double ladoMayor)
{
       nombre="Rectangulo_"+nombreRectangulo;
       longitudLadoMenor=ladoMenor;
       longitudLadoMayor=ladoMayor;
       
       calcularArea();
       calcularPerimetro();
}

Rectangulo::~Rectangulo( )
{
  cout<<"# "<<nombre<<" dice chao. "<<endl;
}

Rectangulo::Rectangulo(double ladoMenor, double ladoMayor)
{
       nombre="Rectangulo_NN";
       longitudLadoMenor=ladoMenor;
       longitudLadoMayor=ladoMayor;
       
       calcularArea();
       calcularPerimetro();
}

double Rectangulo::calcularPerimetro()
{
	perimetroCentimetros=longitudLadoMenor*2 + longitudLadoMayor*2;
	return perimetroCentimetros;
}

double Rectangulo::calcularArea()
{
	areaCentimetros=longitudLadoMenor*longitudLadoMayor;
	return areaCentimetros;
}

std::string   Rectangulo::toString( )   
{
    std::string cad("Soy el Rectangulo ");           
	cad.append(nombre);
    cad.append(descripcion());    
    return  cad;	
}
