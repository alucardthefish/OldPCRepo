/*
  Archivo: Img.h
  Autor: Mauricio Cabezas
  Fecha creacion: Agosto 2007
  Fecha ultima modificacion: Septiembre 2007
  Version: 1.0
  Email: mcabezas@univalle.edu.co
*/

/* 
integrantes:

Gustavo Adolfo Gonzalez Carrillo cod.0732286
Sergo Ortiz Paz  cod. 0731354
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
#include <cstdlib>


/*

 Documentacion  de la clase img.h


* @short: Esta clase tiene funciones escencialmente para la creacion
de imagenes, su manupulacion y algunas clases de cosas que necesitemos 
para crear unas imagenes ya se en colores o engrises.


* @autor :Mauricio Cabezas 

* @version  : 1.0 creator-of-img


*/
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
/*
* mi metodo   Img (const Img::ImgFormat & format);

este es un contructor utilizado para inicializar la clase

* @return este metodo no nos esta retornando algun valor, esta inicializando la clase 
* parámetro de párrafos A del @param estamos utilizando const Img::ImgFormat & format para el formato de la imagen

*/
   Img(const Img::ImgFormat & format,const unsigned int & filas_IN, const unsigned int & cols_IN);
   ~Img();
/*
* mi metodo    Img(const Img::ImgFormat & format,const unsigned int & filas_IN, const unsigned int & cols_IN);
   ~Img();

este metodo es un destrucor que es necesario por requisito del mencionado anteriomente
* @return este metodo no nos esta retornando algun valor, esta inicializando la clase 
* parámetro de párrafos A del @param estamos utilizando const Img::ImgFormat & format para el formato de la imagen

*/


	 unsigned int getHeight( ) const ;
   unsigned int getWidth( )  const ;
   unsigned int getLevels( ) const ; 
   Img::ImgFormat getFormat () const;

	 unsigned int getPixel(const  unsigned int & fila, const unsigned int&  col) const;
	 
	 void getPixel(const  unsigned int & fila, const unsigned int& col, unsigned int &red, unsigned int &green, unsigned int &blue);

	 bool setPixel(const unsigned int & fila, const unsigned int & col, const unsigned  int & greyValue);
	
/* mi metodo: bool setPixel(const unsigned int & fila, const unsigned int & col, const unsigned  int & greyValue);

este  metodo es el que usamos para la creacion de imagenes en grises

* @return este metodo nos esta retornando bool o una respuesta de la creacion
* parámetro de párrafos A del @param estamos utilizando const unsigned int & fila para ingresar las filas.de la imagen 
* parB del @param otro parametro que estamos utilizando es const unsigned int & col para ingresar la columnas de la imagen.
* parC del @param y el tercer parametro esta siendo utilizado para el color de la misma. 
*/
	 bool setPixel(const unsigned int & fila, const unsigned int & col,
                   const unsigned  int & red,
                   const unsigned  int & green,
                   const unsigned  int & blue );

/* mi metodo: bool setPixel(const unsigned int & fila, const unsigned int & col,
                   const unsigned  int & red,
                   const unsigned  int & green,
                   const unsigned  int & blue );

este  metodo es el que usamos para la creacion de imagenes en colores

* @return este metodo nos esta retornando bool o una respuesta de la creacion 
* parámetro de párrafos A del @param estamos utilizando const unsigned int & fila para ingresar las filas.de la imagen 
* parB del @param otro parametro que estamos utilizando es const unsigned int & col para ingresar la columnas de la imagen.
* parC del @param el tercer parametro esta siendo utilizado  const unsigned  int & red 
* parD del @param el tercer parametro esta siendo utilizado  const unsigned  int & green 
* parE del @param el tercer parametro esta siendo utilizado  const unsigned  int & blue
estos ultomos tres parametros son los utilizados para la aplicacion de los colores, utilizando escalas y combinaciones 
para lograr el color deseado 
*/	

   bool setLevels(const unsigned int &levelsIN ); 

   bool load (const char * fileNameIn);
   bool save (const char * fileNameOut);  
/*
* mi metodo  bool save (const char * fileNameOut); 

este metodo lo estamos utilizando cada vez que ejecutamos y queremos guardar la imagen

* @return este metodo nos esta retornando una respuesta para saber si guardo la imagen
* parámetro de párrafos A del @param estamos utilizando const Img::ImgFormat & format para el formato de la imagen

*/

};

#endif

