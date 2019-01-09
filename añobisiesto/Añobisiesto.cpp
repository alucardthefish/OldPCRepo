//******************************************************************************
// Programa del a�o bisiesto
// Este programa ingresa un a�o e imprime el a�o
// es bisiesto o no
//******************************************************************************

#include <iostream>

using namespace std;

bool IsLeapYear (int);

int main ()
{
    int year;
    cout << "Introduzca un a�o por ejemplo, 1997." << endl;
    cin >> year;
    
    if (IsLeapYear(year))
        cout << year << "es un a�o bisiesto." << endl;
    else
        cout << year << "no es un a�o bisiesto." << endl;
           
    return 0;
}

//******************************************************************************

bool IsLeapYear (int year)

// IsLeapYear regresa verdadero si year es un a�o bisiesto y
// falso en cualquier otro caso.

{
         if (year % 4 != 0)
           return false;
         else if (year % 100 != 0)
           return true;
         else if (year % 400 != 0)
           return false;
         else
           return true;
}
           
