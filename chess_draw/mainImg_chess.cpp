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

int main (int argc, char *argv[])
{
    unsigned int alto=256,ancho=256;
    Img imagenP2(Img::P2,alto,ancho); 

    for (unsigned int idx=0; idx<ancho; idx+=64) //filas
    {	
    	for (unsigned int idx2=0; idx2<alto; idx2+=64) //inicio de columnas  de color blanco
	{
		for (unsigned int idx3=idx2; idx3<(idx2+32); idx3++)	//dibujar de blanco la columna

			for (unsigned int idx4=idx; idx4<(idx+32); idx4++)
		{
	 {
 			imagenP2.setPixel(idx4,idx3,255); 
			imagenP2.setPixel(idx4+32,idx3+32,255); 
 			
 	}
	}	
	}
    }
    
    imagenP2.save("syntetic.pgm");

return 0;

 
}
