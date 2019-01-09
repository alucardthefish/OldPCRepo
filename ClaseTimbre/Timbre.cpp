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

