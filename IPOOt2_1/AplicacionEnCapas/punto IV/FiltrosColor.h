/* Archivo: FiltrosColor.h
   Autores: Gustavo A. Gonzalez() - Sergio Ortiz Paz(0731354)
   Version: 1.1
   E-mail:  
*/

/*
   Integrantes: Gustavo Adolfo Gonzalez, Cod: 0732286
                Sergio Ortiz Paz, Cod: 0731354
*/

/*
   Clase: FiltrosColor, representa los distintos tipos de filtros para una imagen
   Relaciones con otras clases y objetos: se relaciona con otra clase.
   Para que sirve: Permite aplicarle filtros a una imagen.
*/

#ifndef FILTROSCOLOR_H
#define FILTROSCOLOR_H

#include "Img.h"
#include <iostream>

/*

Documentacion  de la clase FiltrosColor.h


* @short: Esta clase tiene metodos especialmente para la filtracion
  y utilizacion imagenes.


* @autores: Gustavo A. Gonzalez - Sergio Ortiz Paz 

* @version  : 1.1 creador de imagenes filtradas
*/


class FiltrosColor
{
      private:
        unsigned int contador;
	Img * ptrImgOriginal;
	Img * ptrImgFiltrada;
      public:
	int dev (int a);
        
        FiltrosColor ();
        /*
        * mi metodo   FiltrosColor ();

          este es un contructor utilizado para inicializar la clase
        * @return este metodo no nos esta retornando algun valor, esta inicializando la clase 
        */
        
        
        ~FiltrosColor();
        
        /*
         * mi metodo  ~FiltrosColor();

          este metodo es un destrucor que es necesario por requisito del mencionado anteriomente
          * @return este metodo no nos esta retornando algun valor, esta inicializando la clase 
          */
        
        unsigned int getContador( ) const; /* este metodo es un contador y devuelve un numero */
        
        
        bool  histogramaAColor ( Img * ptrImgOriginal, Img * ptrHistoColor);
        bool  truncarAPisoImpar( Img * ptrImgOriginal, Img * ptrImgFiltrada);
        bool  truncarA127 ( Img * ptrImgOriginal, Img * ptrImgFiltrada);
        bool  quantizarA16 ( Img * ptrImgOriginal, Img * ptrImgFiltrada);
        bool  diferenciaAbsoluta ( Img * ptrImgT0, Img * ptrImgT1, Img * ptrImgFiltrada);
        bool  diferenciaPositiva ( Img * ptrImgT0, Img * ptrImgT1, Img * ptrImgFiltrada);
        bool  diferenciaNegativa ( Img * ptrImgT0, Img * ptrImgT1, Img * ptrImgFiltrada);
        
        /*
        Estos son todos los metodos de los filtros.
        */
};
#endif



