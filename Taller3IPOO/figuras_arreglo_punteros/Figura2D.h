# ifndef FIGURA2D_H
# define FIGURA2D_H

#include <iostream>
#include <string>
#include <sstream>

class Figura2D
{
      ///privado para el mundo exterior, pero visible para subclases
      protected:

      std::string nombre;
      double areaCentimetros;
      double perimetroCentimetros; 
      std::string doubleToStr(double valor);          
      virtual std::string   descripcion( );///virtual puro
      
      public:

      virtual ~Figura2D() {};
      virtual double calcularArea()=0;///virtual puro
      virtual double consultarArea();
      virtual double calcularPerimetro()=0;///virtual puro
      virtual double consultarPerimetro();
      virtual std::string   toString( )=0;///virtual puro
};

# endif
