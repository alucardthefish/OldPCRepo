/*
  Archivo: Img.h
  Autor: Mauricio Cabezas
  Fecha creacion: Agosto 2007
  Fecha ultima modificacion: Septiembre 2007
  Version: 1.0
  Email: mcabezas@univalle.edu.co
*/


/*
  Clase: Img, representa imagenes sin compresiOn, en escala de grises P2, y en el espacio de colores RGB P3
  Atributos: relacionados con las propiedades de la imagen
  Interfase: permiten la especificaciOn de propiedades al crear la imagen y la manipulaciOn de pixeles
  Relaciones con otras clases y objetos: Ninguna en esta clase
  Para que sirve: permite la creaciOn de magenes sintEtica
*/

#ifndef IMG_H
#define IMG_H

#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <cassert>
#include <cmath>

class Img 
{

   public:
   enum ImgFormat {P2,P3};

	private:
   unsigned int height, width, fileWidth, levels;
   Img::ImgFormat  imgFormat;
   unsigned int **data;
   Img(const Img & objPorValor);
   Img();
   bool newData();
   void deleteData( );
  
	public:
	 Img (const Img::ImgFormat & format);

   Img(const Img::ImgFormat & format,const unsigned int & filas_IN, const unsigned int & cols_IN);
   ~Img();

	 unsigned int getHeight( ) const ;
   unsigned int getWidth( )  const ;
   unsigned int getLevels( ) const ; 
   Img::ImgFormat getFormat () const;

	 unsigned int getPixel(const  unsigned int & fila, const unsigned int&  col) const;
	 
	 void getPixel(const  unsigned int & fila, const unsigned int& col, unsigned int &red, unsigned int &green, unsigned int &blue);
	 
	 bool setPixel(const unsigned int & fila, const unsigned int & col, const unsigned  int & greyValue);
	 
	 bool setPixel(const unsigned int & fila, const unsigned int & col,
                   const unsigned  int & red,
                   const unsigned  int & green,
                   const unsigned  int & blue );

   bool setLevels(const unsigned int &levelsIN ); 

   bool load (const char * fileNameIn);
   bool save (const char * fileNameOut);  

};

#endif


