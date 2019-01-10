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
    unsigned int alto=255,ancho=360;
    Img imagenP3(Img::P3,alto,ancho); 
     
    for (unsigned int idx=0; idx<85; idx++) //filas

    //{	
      
          for (unsigned int idx1=0; idx1<360; idx1++)
       {
     //      for (unsigned int idx2=0; idx2<360; idx2++)
       
imagenP3.setPixel(idx,idx1,255,255,0);
imagenP3.setPixel(idx+85,idx1,0,0,255); 
imagenP3.setPixel(idx+170,idx1,255,0,0); 


}

   

	
	//imagenP3.setPixel(idx,idx,1); 


    //}

    

    imagenP3.save("syntetic.pgm");



return 0;



 

}
