#include "Cuadrado.h"
using namespace std;

Cuadrado::Cuadrado( std::string nombreCuadrado,double ladoCentimetros)
{
       nombre="Cuadrado_"+nombreCuadrado;
       longitudLadoCentimetros=ladoCentimetros;
       calcularArea();
       calcularPerimetro();
};

Cuadrado::Cuadrado( double ladoCentimetros)
{
       nombre="Cuadrado_NN";
       longitudLadoCentimetros=ladoCentimetros;
       calcularArea();
       calcularPerimetro();
};


Cuadrado::~Cuadrado( )
{
  cout<<"# "<<nombre<<" dice chao. "<<endl;
};


double Cuadrado::calcularArea()
{
       areaCentimetros= longitudLadoCentimetros *  longitudLadoCentimetros;
       return   areaCentimetros;
};

double Cuadrado::calcularPerimetro( )
{
       perimetroCentimetros =   longitudLadoCentimetros * (double)numeroLados;
       return   perimetroCentimetros;
};
std::string   Cuadrado::toString( )   
{
    std::string cad("Soy el Cuadrado ");           
	cad.append(nombre);
    cad.append(descripcion());     
    return cad;
};
