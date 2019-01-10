/*
Autor: Mauricio Cabezas
Fecha: Septiembre 18 de 2007
PropOsito: Ilustrar el uso de la clase Img en la
construcciOn de una imagen sintEtica      
Comentarios:
            Para compilar en Linux:
                 g++ -c *.cpp
                 g++ -o imgEjem *.o
                 
            Para ejecutar en Linux:
                 ./imgEjem

*/

#include "Img.h"
#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <cassert>
#include <cmath>
#include <cstdlib>

using namespace std;

int color(int a,int b,int c)
{
int resultado=0;
	if (a>=b&&a>=c)
	{
	 resultado=a;
	}
	else {if (b>=c&&b>=a)
        {
	resultado=b;
	}
	else resultado=c;
}
return resultado;
}

int segundo(int a,int b,int c)
{
	int resultado=0;
	if (a>b&&a>c)
	{
		resultado=85;
	}
	else {if (b>c&&b>a)
		{
			resultado=170;
		}
		else { if  (c>a&&c>b)
			{
				resultado=255;
			}
			
			else resultado=0;	
		}
		
		
		
	return resultado;
	
}
}

void intensidad()



{


Img *buscador=0;
buscador= new Img(Img::P3);
buscador->load("TEDDY_DER.ppm");
int ancho=buscador->getWidth();
int alto=buscador->getHeight();


unsigned int fila=0,col=0,red=0,green=0,blue=0;




//Img imagenP2();
     
Img *imagenP2=0;
imagenP2=new Img(Img::P2,alto,ancho); 

Img *as=0;
as= new Img(Img::P2,alto,ancho); 


    for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
	    
		    {
			    buscador->getPixel(fila,col,red,green,blue);
			    imagenP2->setPixel(fila,col,(color(red,green,blue)));
			    as->setPixel(fila,col,(segundo(red,green,blue)));
		    
			    
		    }
		   
	    
	    
    }
    imagenP2->save("intensidad.pgm");
    as->save("colores.pgm");
}
// void intensidad()
// 
// {
// 
// 
// 
// }




int main (int argc, char *argv[])
{

intensidad();


return 0;

}
