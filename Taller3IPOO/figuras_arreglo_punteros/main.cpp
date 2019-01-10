#include "Figura2D.h"
#include "Cuadrado.h"
#include "Rectangulo.h"

#include <iostream>
using namespace std;

void esperarEnter()
{
	char tecla=' ';
	cout<<"# Presione una tecla y enter para continuar."<<endl;	
	cin>>tecla;
}
 
void preguntarCuadrado(double* lado)
{
	cout<<"#Cuadrado\n#Dame el valor del lado "<<endl;
 	cin>> (*lado);
}

void preguntarRectangulo(double &base, double &altura)
{
	cout<<"#Rectangulo\n#Dame el valor de la base"<<endl;
 	cin>> base;
	
	cout<<"#Dame el valor de la altura"<<endl;
 	cin>> altura;
}

void crearCuadrado(Figura2D *ptrFigura2D)
{
	double longitudLado1=0.0;
	preguntarCuadrado(&longitudLado1);
	ptrFigura2D = new Cuadrado(longitudLado1);
	cout<<ptrFigura2D->toString()<<endl;
	if (ptrFigura2D!=0) 
	{
		delete ptrFigura2D;
		ptrFigura2D=0;
	}	
}

void crearRectangulo(Figura2D *ptrFigura2D)
{
	double longitudLado1,longitudLado2;
	longitudLado1=longitudLado2=0.0;
	
	preguntarRectangulo(longitudLado1,longitudLado2);
	ptrFigura2D = new Rectangulo(longitudLado1,longitudLado2);
	cout<<ptrFigura2D->toString()<<endl;
	if (ptrFigura2D!=0) 
	{
		delete ptrFigura2D;
		ptrFigura2D=0;
	}
	
}


int main(int argc, char *argv[])
{
	///varible puntero de la superclase	
	
	Figura2D *ptrFigura2D;
	ptrFigura2D=0;
	
	if (ptrFigura2D==0)
	{
		cout<<"#La variable ptrFigura2D la inicializamos en null"<<endl;
	}
	cout<<"#Un mismo puntero base para apuntar a subclases diferentes"<<endl;
	///creamos un cuadrado	
	crearCuadrado(ptrFigura2D);
	
	esperarEnter();
	
	///creamos un rectangulo
	crearRectangulo(ptrFigura2D);
	
	if (ptrFigura2D==0)
	{
		cout<<"#Despues de llamar los mEtodos, la variable ptrFigura2D";
		cout<<" apunta a null"<<endl;
	}
	
	esperarEnter();
	
	cout<<"#Un arreglo estAtico de punteros "<<endl;
	cout<<"Figura2D *arrayPtrFigura2D[2];"<<endl; 
	Figura2D *arrayPtrFigura2D[2];
	
	arrayPtrFigura2D[0]=0;
	arrayPtrFigura2D[1]=0;
	
	///creemos un cuadrado	
	cout<<"#Creemos un cuadrado"<<endl;
	crearCuadrado(arrayPtrFigura2D[0]);
	
	esperarEnter();
	
	///creemos un rectangulo
	cout<<"#Creemos un rectangulo"<<endl;
	crearRectangulo(arrayPtrFigura2D[1]);
	
	esperarEnter();
	
	cout<<"#Un arreglo dinAmico de punteros "<<endl;
	cout<<"Figura2D **arrayDinPtrFigura2D;"<<endl;
	Figura2D **arrayDinPtrFigura2D;
	
	int valorUsuario=2;
	arrayDinPtrFigura2D = new Figura2D* [valorUsuario];
	arrayDinPtrFigura2D[0]=0;
	arrayDinPtrFigura2D[1]=0;
	
	///creemos un cuadrado	
	cout<<"#Creemos un cuadrado"<<endl;
	crearCuadrado(arrayDinPtrFigura2D[0]);
	
	///creemos un rectangulo
	cout<<"#Creemos un rectangulo"<<endl;
	crearRectangulo(arrayDinPtrFigura2D[1]);
	
	system ("PAUSE");
	return 0;
}
