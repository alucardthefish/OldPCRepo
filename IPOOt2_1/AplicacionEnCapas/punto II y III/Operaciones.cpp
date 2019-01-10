/*
  Archivo: Operaciones.cpp
  Autores: Gustavo Gonzalez - Sergio Ortiz
  Fecha creacion: Noviembre 2007
  Fecha ultima modificacion: Septiembre 2007
  Version: 1.0
*/


#include "Operaciones.h"


using namespace std;

void Operaciones::setPrimero (double uno)
{

primero=uno;

}

double Operaciones::getPrimero ()

{

return primero;

}


void Operaciones::setsegundo (double dos)
{

segundo=dos;

}

double Operaciones::getsegundo ()

{

return segundo;

}


Operaciones::Operaciones ( )

{
primero=0;
segundo=0;
}

Operaciones::~Operaciones ( )

{

}

double Operaciones::sumar (double primero,double segundo)
{

double sumar=0;
sumar=primero+segundo;
return sumar;

}

double Operaciones::restar (double primero,double segundo)
{

double restar=0;
restar=primero-segundo;
return restar;

}

double Operaciones::multiplicar (double primero,double segundo)
{

double multiplicar=0;
multiplicar=primero*segundo;
return multiplicar;

}

double Operaciones::dividir (double primero,double segundo)
{

double dividir=0;
dividir=primero/segundo;
return dividir;

}


