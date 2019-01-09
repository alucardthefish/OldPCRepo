//Preprocesador

#include <iostream>

#define PI 3.1415
#define pausar system("pause>nul");

#define hola 5
#define adios 7

#if hola <= adios
#define patata 50
#endif

#ifndef patata
#define patata 60
#else
#error ya esta definido
#endif

using namespace std;

int main()
{
    
    //cout << hola << " Saluda a PI = " << PI;
    cout << patata;
    pausar;
    //system("pause>nul");
    return 0;
}
