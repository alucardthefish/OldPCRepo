#include <iostream>
#include <cstdlib>

/*
using std::cin;
using std::cout;
using std::endl;
*/
using namespace std;

int main(int argc, char *argv[])
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
                    cout <<"La Suma de "<<d_alfa<<" y "<< d_beta<< " es "<< (d_alfa + d_beta)<<endl;
                    break;
               case '-':
                    cout <<"La Resta de "<<d_alfa<<" y "<< d_beta<< " es "<< (d_alfa - d_beta)<<endl;
                    break;
               default:
                   cout<<"OpciOn no vAlida :("<<endl;

        };

    }

	return 0;
}
