#include <cstdlib>
#include <iostream>

using namespace std;

int main(int argc, char *argv[])

{
    double x = 2.0;
    printf("lf", x); // se imprime 2.0
    {
                 printf("lf", x); // se imprime 2.0
                 double x = 3.0;
                 printf("lf", x); // se imprime 3.0
                 }
                 printf("lf", x); // se imprime 2.0
}


