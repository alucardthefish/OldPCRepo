/// Timbre.cpp

#include "Timbre.h"



Timbre:: Timbre ( )
{
     vecesTimbradas=0;
     cout << "elTimbre says: \"Hello world.";
     cout << "\" " << endl;
}

Timbre:: ~Timbre ( )
{
    cout << "elTimbre says: \"Ohh I must be destroyed.";
    cout << "Bye world. \" " << endl;
}

 void Timbre::timbrar( )
 {
      cout << "Ding***   Dong!!!" << endl;
      cout << static_cast <char>(7);
      vecesTimbradas++;
      cout << "#Esta es la ocasion nUmero: " << vecesTimbradas;
      cout << " que alguien timbra." << endl;
 }



/******************************************************************************************************************/
/******************************************************************************************************************/
/********************************************main******************************************************************/


#include <iostream>
#include "Timbre.h"

using namespace std;

int main(int argc, char *argv[])
{

  ///++ implementar clase UsaTimbre  
  /*
  UsaTimbre obj;
  obj.interactuar();
  */

  Timbre elTimbre;
  unsigned int  opcion=0;
  while (opcion!=2)
  {
     cout <<"1) Timbrar.  2) Salir ";
     cin >> opcion;
     if (opcion==1)
     {
         elTimbre.timbrar();
     }
  }

  return 0;
}


