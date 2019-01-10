#include  "Figura2D.h"
using namespace std;
double Figura2D::consultarArea( )
{
       return areaCentimetros;
}

double Figura2D::consultarPerimetro( )
{
       return perimetroCentimetros;
}

std::string Figura2D::descripcion( )
{
    std::string cadena("");
    cadena.append("\nMi area es de "+ doubleToStr(areaCentimetros)+" cm y ");
    cadena.append(" mi perimetro es de "+ doubleToStr(perimetroCentimetros)+" cm.");       
    return cadena;     
}

string Figura2D::doubleToStr(double valor)
{
       std::ostringstream strStream;
       strStream << valor;
       return strStream.str();
       
}
