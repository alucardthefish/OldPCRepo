#include "UsaOperaciones.h"




int main ()

{
UsaOperaciones *llamado=0;
llamado= new UsaOperaciones();
llamado->auxiliar();
delete llamado;
llamado=0;
}


/*
using std::cin;
using std::cout;
using std::endl;
*/

/*
using namespace std;


int aux()
{
   char   c_opcion=' ';
    double d_alfa=0.0;
    double d_beta=0.0;

    while (true)
    {

        cin >>  c_opcion ;
        if  (c_opcion == 's' || c_opcion == 'S' )
        {
            cout <<"EXIT"<<endl;
            exit(0);
        }
        cin >> d_alfa >>    d_beta;
        switch (c_opcion)
        {
               case '+':
                    
                    break;
               case '-':
                    
                    break;
		case '*':
                   
                    break;
               case '/':
                    
                    break;
               default:
                   cout<<"OpciOn no vAlida :("<<endl;

        };

    }
}




int main(int argc, char *argv[])
{
 
aux();

	return 0;
}

*/



