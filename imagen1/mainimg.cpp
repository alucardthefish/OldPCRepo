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
    for (unsigned int idx=0; idx<alto; idx++)
    {
       imagenP2.setPixel(idx,128,255); 
    }
    imagenP2.save("syntetic.pgm");
}
