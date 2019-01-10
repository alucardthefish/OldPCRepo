#include "Img.h"
#include <iostream>
using namespace std;


FiltrosColor::FiltrosColor ( )
{
Img * ptrImgFiltrada=0;
ptrImgFiltrada= new Img(Img::P3);

Img * ptrImgOriginal=0;
ptrImgOriginal= new Img(Img::P3);

Img * ptrHistoColor=0;
ptrHistoColor= new Img(Img::P2);

Img * ptrImgT0=0;
ptrImgT0= new Img(Img::P3);

Img * ptrImgT1=0;
ptrImgT1= new Img(Img::p3);
 
}

//******************************************************************************

FiltrosColor::~FiltrosColor() 
{
 if (ptrImgFiltrada!=0)
     {
          delete ptrImgFiltrada;
          ptrImgFiltrada=0;
     }
 
 if (ptrImgOriginal!=0)
     {
          delete ptrImgOriginal;
          ptrImgOriginal=0;
     }
  
 if (ptrHistoColor!=0)
     {
          delete ptrHistoColor;
          ptrHistoColor=0;
     }
     
 if (ptrImgT0!=0)
     {
          delete ptrImgT0;
          ptrImgT0=0;
     }
     
     
 if (ptrImgT1!=0)
     {
          delete ptrImgT1;
          ptrImgT1=0;
     }

 }


/*

int blanconegro (int a, int b, int c)

{

if (a=b=c=0)
{
return 0
}
else return 255
}


bool  histogramaAColor ( Img * ptrImgOriginal, Img * ptrHistoColor)

{
unsigned int fila=0,col=0,red=0,green=0,blue=0,reda[256],greena[256],bluea[256];


     
int ancho=buscador->getWidth();
int alto=buscador->getHeight();

    for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
	    
		    {
			    relaciona->getPixel(fila,col,red,green,blue);
			    imagenP2->setPixel(fila,col,(blanconegro(red,green,blue)));
			   
		    }
			}	
			    
 imagenP2->save("histograma.pgm");
}
*/
//**********************************************************************************************************************//

unsigned int histoColor (int a, int b, int c)
{
valor=0;
if (a=b=c=0){
valor=0;
return valor;}
else return 255;
}


bool  histogramaAColor ()
{

unsigned int fila=0,col=0,red=0,green=0,blue=0;

Img * ptrImgOriginal = new Img(Img::P3);
ptrImgOriginal->load("TEDDY_IZQ.ppm");
int niveles=0;
niveles=ptrImgOriginal->getLevels;
int ancho=0;
ancho=ptrImgOriginal->getWidth;
int alto=0;
alto=ptrImgOriginal->getHeight;

Img * ptrHistoColor = new Img(Img::P2, alto, ancho);

for (unsigned int nivel=0; nivel<niveles; nivel++)

for (unsigned int fils=0; fils<ancho; fils++)
 


}
}
}


//**********************************************************************************************************************//

unsigned int dev (unsigned int a)
{
int valor = 0;
if ((a==0)||(a%2==1)){
	valor = a;
	return valor;
} else return (a-1);

}




 bool  truncarAPisoImpar()

{

unsigned int fila=0,col=0,red=0,green=0,blue=0;


Img * ptrImgOriginal= new Img(Img::P3);
ptrImgOriginal->load("TEDDY_IZQ.ppm");
int ancho= 0;
ancho =ptrImgOriginal->getWidth();
int alto=0;
alto=ptrImgOriginal->getHeight();

Img * ptrImgFiltrada= new Img(Img::P3, alto, ancho);

 for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
		{


	ptrImgOriginal->getPixel(fila,col,red, green, blue);
	ptrImgFiltrada->setPixel(fila,col,(dev(red)), (dev(green)), (dev(blue)));
	

}	}

ptrImgFiltrada->save("truncarapisoimpar.ppm");
}


//*************************************************************************************************************************************


unsigned int t127 (int a)
{

int valor=0;
if (a==0){
valor= 0;
}else if (a%2==0){
valor=a/2;
return valor;}
else return (a-1)/2;

return valor;
}



bool  truncarA127 ( )

{
unsigned int fila=0,col=0,red=0,green=0,blue=0;


Img * ptrImgOriginal= new Img(Img::P3);
ptrImgOriginal->load("TEDDY_IZQ.ppm");
int ancho= 0;
ancho =ptrImgOriginal->getWidth();
int alto=0;
alto=ptrImgOriginal->getHeight();
Img * ptrImgFiltrada= new Img(Img::P3, alto, ancho);

 for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
		{


	ptrImgOriginal->getPixel(fila,col,red, green, blue);
	ptrImgFiltrada->setPixel(fila,col,(t127(red)), (t127(green)), (t127(blue)));
	
		}
}
ptrImgFiltrada->save("truncara127.ppm");

}


//***************************************************************************************************//





bool quantizarA16 ()
{
unsigned int fila=0,col=0,red=0,green=0,blue=0;


Img * ptrImgOriginal= new Img(Img::P3);
ptrImgOriginal->load("pintorUno.ppm");
int ancho= 0;
 ancho =ptrImgOriginal->getWidth();
 int alto=0;
 alto=ptrImgOriginal->getHeight();

Img * ptrImgFiltrada= new Img(Img::P3,alto,ancho);
ptrImgFiltrada->setLevels(16);

for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
		{


	ptrImgOriginal->getPixel(fila,col,red,green,blue);
	
	ptrImgFiltrada->setPixel(fila,col,red/16, green/16, blue/16);
	
		}


}

	

ptrImgFiltrada->save("quantizarA16.ppm");

}


//**********************************************************************************************************************//

unsigned int dAbs (int a, int b)
{

int valor = 0;
valor=fabs(a-b);
return valor;

}


bool  diferenciaAbsoluta ()

{
unsigned int fila=0,col=0,red=0,green=0,blue=0;
unsigned int fila1=0,col1=0,red1=0,green1=0,blue1=0;


Img * ptrImgT0= new Img(Img::P3);
ptrImgT0->load("pintorUno.ppm");
Img * ptrImgT1= new Img(Img::P3);
ptrImgT1->load("pintorDos.ppm");
int ancho= 0;
ancho =ptrImgT0->getWidth();
int alto=0;
alto=ptrImgT0->getHeight();
Img * ptrImgFiltrada= new Img(Img::P3, alto, ancho);

 for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
		{


	ptrImgT0->getPixel(fila,col,red,green,blue);
	ptrImgT1->getPixel(fila1,col1,red1,green1,blue1);
	ptrImgFiltrada->setPixel(fila,col,(dAbs(red,red1)), (dAbs(green,green1)), (dAbs(blue,blue1)));
	
		}
}
ptrImgFiltrada->save("diferenciaAbsoluta.ppm");

}



//********************************************************************************************************************//

unsigned int dPos (int a, int b)
{
int valor=0;
if (a>b){
valor=fabs(a-b);
} else return 0;
return valor;
}




bool diferenciaPositiva ()

{
unsigned int fila=0,col=0,red=0,green=0,blue=0;
unsigned int fila1=0,col1=0,red1=0,green1=0,blue1=0;


Img * ptrImgT0= new Img(Img::P3);
ptrImgT0->load("pintorUno.ppm");
Img * ptrImgT1= new Img(Img::P3);
ptrImgT1->load("pintorDos.ppm");
int ancho= 0;
ancho =ptrImgT0->getWidth();
int alto=0;
alto=ptrImgT0->getHeight();
Img * ptrImgFiltrada= new Img(Img::P3, alto, ancho);

 for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
		{


	ptrImgT0->getPixel(fila,col,red,green,blue);
	ptrImgT1->getPixel(fila1,col1,red1,green1,blue1);
	ptrImgFiltrada->setPixel(fila,col,(dPos(red,red1)), (dPos(green,green1)), (dPos(blue,blue1)));
	
		}
}
ptrImgFiltrada->save("diferenciaPositiva.ppm");

}


//*********************************************************************************************************************************

unsigned int dNeg (int a, int b)
{
int valor=0;
if (a<b){
valor=fabs(a-b);
} else return 0;
return valor;
}


bool diferenciaNegativa ()
{

unsigned int fila=0,col=0,red=0,green=0,blue=0;
unsigned int fila1=0,col1=0,red1=0,green1=0,blue1=0;


Img * ptrImgT0= new Img(Img::P3);
ptrImgT0->load("pintorUno.ppm");
Img * ptrImgT1= new Img(Img::P3);
ptrImgT1->load("pintorDos.ppm");
int ancho= 0;
ancho =ptrImgT0->getWidth();
int alto=0;
alto=ptrImgT0->getHeight();
Img * ptrImgFiltrada= new Img(Img::P3, alto, ancho);

 for (unsigned int fila=0; fila<alto; fila++) 
    {
	    for (unsigned int col=0; col<ancho; col++)
		{


	ptrImgT0->getPixel(fila,col,red,green,blue);
	ptrImgT1->getPixel(fila1,col1,red1,green1,blue1);
	ptrImgFiltrada->setPixel(fila,col,(dNeg(red,red1)), (dNeg(green,green1)), (dNeg(blue,blue1)));
	
		}
}
ptrImgFiltrada->save("diferenciaNegativa.ppm");

}


//***************************************************************************************************************************//

//unsigned int contador ()

//unsigned int getContador () const


//***************************************************************************************************************************//

int main ()

{


truncarAPisoImpar();
truncarA127();
quantizarA16();
diferenciaAbsoluta();
diferenciaPositiva();
diferenciaNegativa();

return 0;


}



