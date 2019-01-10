# ifndef CUADRADO_H
# define CUADRADO_H
#include <iostream>
#include <string>
#include <sstream>

#include "Figura2D.h"

class Cuadrado:  public  Figura2D
{
      private:
      ///todo cuadrado tiene cuatro lados iguales
      static int const numeroLados=4;
      double longitudLadoCentimetros;

      public:
      Cuadrado (std::string nombreCuadrado, double ladoCentimetros);
      Cuadrado (double ladoCentimetros);
      ~Cuadrado();
      virtual double calcularArea();
      virtual double calcularPerimetro();
      virtual std::string   toString( );
};

# endif
