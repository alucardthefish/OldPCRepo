/*
  Archivo: Img.cpp
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


#include "Img.h"

using namespace std;

/*****************************************************/
	  Img::Img (const Img::ImgFormat & format)
	  {
	  	 imgFormat=format; 
	  	 height=width=fileWidth=0;
	  	 levels=255;
	  	 data=0;
	  }	  
	  
/*****************************************************/	  
	  bool  Img::newData( )
	  {
	  	
	  	 data = new unsigned int *[height];
	  	 if (data==0) return false;
	  	  
	  	 for (unsigned int idFilas=0; idFilas<height; idFilas++ )
		   {
                data [idFilas]= new unsigned int [fileWidth];
                 if (data[idFilas]==0) return false;

           		for (unsigned int idCols=0; idCols<fileWidth ; idCols++ )
				      {
                     data[idFilas][idCols]=0;
				      }
		   }   
		   return true;
	  }//
	  
	  
/*****************************************************/	  
		Img::Img(const Img::ImgFormat & format,const unsigned int & filas_IN, const unsigned int & cols_IN)
		{
			  imgFormat=format;
			  height=filas_IN;
			  width=cols_IN;
			  levels=255;
			  if (imgFormat==Img::P3)  fileWidth=width*3;
			  else fileWidth=width;
			  
			  if (!newData()) 
			  { 
			  	cerr<<" Img::Img:: Unable to alloc memory "<<height<<" * "<< width<<endl;
          assert(false);	      
			  }		  
			  
		}//Img

/*****************************************************/	  		
		void Img::deleteData( )		
    {
           if (data!=0)
           {
                for (unsigned int idxFilas=0; idxFilas<height; idxFilas++)
	            {
		               delete []data[idxFilas];
	            }
                delete  []data;
                data=0;
           }
    }//deleteData
		
/*****************************************************/	  		
		Img::~Img( )
		{
			 if (data!=0)deleteData();
		}

	 unsigned int Img::getHeight( ) const 
	 {
	 	   return height;
	 	}
	 
/*****************************************************/	  	 
   unsigned int Img::getWidth( )  const 
   {
   	   return width;
   }

/*****************************************************/	     
   unsigned int Img::getLevels( ) const 
   {
      	 return levels;
   }
   
/*****************************************************/	     
   bool Img::setLevels(const unsigned int &levelsIN ) 
   {
   	     levels=levelsIN; 
      	 return true;
   }
    
/*****************************************************/	  
   Img::ImgFormat Img::getFormat () const
   { 
   	   return imgFormat;
   }

/*****************************************************/	     
	 unsigned int Img::getPixel(const  unsigned int & fila, const unsigned int&  col) const
	 {
           if ( ((fila < 0) || (fila > height)) || (((col < 0) || (col>width))) )
         {
           cerr<<" Img::getPixel:: IndexOutOfBounds ["<<fila<<"] ["<< col<<"] in ["<<height<<"] ["<<width<<"]"<<endl;
           assert(false);
	       return false;
         }

	         return data[fila][col];	
	 }

/***************************************************************************/	  	 	 
	 void Img::getPixel(const  unsigned int & fila, const unsigned int&  col, 
	            unsigned int &red, unsigned int &green, unsigned int &blue)
	 {
         if ( ((fila < 0) || (fila > height)) || (((col < 0) || (col>width))) )
         {
           cerr<<" Img::getPixel:: IndexOutOfBounds ["<<fila<<"] ["<< col<<"] in ["<<height<<"] ["<<width<<"]"<<endl;
           assert(false);	      
         }

	 	    unsigned int widthPos=0;
	 	    if (imgFormat==Img::P3)  widthPos=col*3;
			  else widthPos=col;
			  
			  red=data[fila][widthPos];
			  green=data[fila][widthPos+1];
			  blue=data[fila][widthPos+2];
	 }//

/***************************************************************************/	  	 	 	 
	 bool Img::setPixel(const unsigned int & fila, const unsigned int &  col, const unsigned  int & greyValue)
	 {

         if ( ((fila < 0) || (fila > height)) || (((col < 0) || (col>width))) )
         {
           cerr<<" Img::setPixel:: IndexOutOfBounds ["<<fila<<"] ["<< col<<"] in ["<<height<<"] ["<<width<<"]"<<endl;
           assert(false);
	       return false;
         }

	 	 if (imgFormat==Img::P3)  return false;
	 	  data[fila][col]=greyValue;
	 	 return true; 
	 }//

/***************************************************************************/	  	 	 	 	 
	 bool Img::setPixel(const unsigned int & fila,
                       const unsigned int &  col,
                       const unsigned  int & red,
                       const unsigned  int & green,
                       const unsigned  int & blue )
	 {

          if ( ((fila < 0) || (fila > height)) || (((col < 0) || (col>width))) )
         {
           cerr<<" Img::setPixel:: IndexOutOfBounds ["<<fila<<"] ["<< col<<"] in ["<<height<<"] ["<<width<<"]"<<endl;
           assert(false);
	       return false;
         }

	  	 if (imgFormat==Img::P2)  return false;
  	     unsigned int widthPos=col*3;
	   
	    data[fila][widthPos]=red;
		data[fila][widthPos+1]=green;
		data[fila][widthPos+2]=blue; 	 
		
	 	 return true;
	 }//


/***************************************************************************/	  	 	 
     bool Img::load (const char * fileNameIn)
     {
        unsigned int grey=0;
        unsigned int red,green,blue;
        unsigned int heightIN,widthIn,levelsIN;
        grey=red=green=blue=0;

        std::ifstream fileIn;
        fileIn.open(fileNameIn,ios::in);

        if (fileIn==0)
        {
           cerr<<" Img::load:: UnableToOpenFile "<<fileNameIn<<endl;
           assert(false);
	       return false;
         }

        string cadena;
        fileIn>>cadena;
        fileIn>>widthIn;
        fileIn>>heightIN;
        fileIn>>levelsIN;

        if ( (data==0) || ( (data!=0) && (widthIn!=width || height!= heightIN ) ) )
        {
            deleteData();

            width=widthIn;
            height=heightIN;

            if (imgFormat==Img::P3)  fileWidth=width*3;
            else fileWidth=width;

            newData();
        }

     for (unsigned int filas=0; filas<height; filas++)
     {
         for (unsigned int cols=0; cols<width; cols++)
         {
              if (imgFormat==Img::P3)
              {
                   fileIn>>red;
                   fileIn>>green;
                   fileIn>>blue;
                   setPixel(filas,cols,red,green,blue);
              }
              else
              {
                   fileIn>>grey;
                   setPixel(filas,cols,grey);
              }
         }//cols
     }//filas

     fileIn.close();
	 return true;
  }//

    
/***************************************************************************/	  	 	 
   bool Img::save (const char * fileNameOut)
   {
        if (data==0) return false;

        unsigned int red,green,blue;
        red=green=blue=0;

        std::ofstream fileOut;
        fileOut.open(fileNameOut,ios::out);

        if (fileOut==0)
        {
           cerr<<" Img::save:: UnableToCreateFile "<<fileNameOut<<endl;
           assert(false);
	       return false;
         }

        if (imgFormat==Img::P3) fileOut<<"P3"<<endl;
        else  fileOut<<"P2"<<endl;

        fileOut<<width<<" ";
        fileOut<<height<<endl;
        fileOut<<levels<<endl;

     for (unsigned int filas=0; filas<height; filas++)
     {
         for (unsigned int cols=0; cols<width; cols++)
         {
              if (imgFormat==Img::P3)
              {
                   getPixel(filas,cols,red,green,blue);

                   fileOut<<setw(4)<<red<<" ";
                   fileOut<<setw(4)<<green<<" ";
                   fileOut<<setw(4)<<blue<<" ";
              }
              else
              {
                   fileOut<<setw(4)<<getPixel(filas,cols)<<" ";
              }
         }//cols
          fileOut<<endl;
     }//filas

     fileOut.close();
	 return true;

   }//
   

