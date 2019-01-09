#include "UsaOperaciones.h"


using namespace std;





UsaOperaciones::UsaOperaciones ()
{
Operaciones *interactuar=0;
interactuar= new Operaciones();


}


UsaOperaciones::~UsaOperaciones ()
{
if (interactuar!=0)
    {
         delete interactuar;
         interactuar=0;
    }
}




void  UsaOperaciones::auxiliar()

{


       
       
double primero=0;
double segundo=0;


while (true)
    { 
char c_opcion=' ';
cin>> c_opcion;
 if  (c_opcion == 's' || c_opcion == 'S' )
        {
            cout <<"EXIT"<<endl;
            exit(0);
	}
cin>>primero>>segundo;





 switch (c_opcion)
        {
           
	       case '+':
                   cout <<"La Suma de "<<primero<<" y "<<segundo<< " es "<< interactuar->sumar(primero,segundo)<<endl;
                    break;
               case '-':
                    cout <<"La Resta de "<<primero<<" y "<< segundo<< " es "<< interactuar->restar(primero,segundo)<<endl;
		    break;
		case '*':
                    cout <<"La Multiplicacion de "<<primero<<" y "<< segundo<< " es "<< interactuar->multiplicar(primero,segundo)<<endl;
		    break;
               case '/':
                    cout <<"La Division de "<<primero<<" y "<< segundo<< " es "<<interactuar->dividir(primero,segundo)<<endl;
                    break;
               default:
                   cout<<"OpciOn no vAlida :("<<endl;exit(0);}
		
		

        }


}




