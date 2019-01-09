//******************************************************************************
// Programa del año bisiesto
// Este programa ingresa un año e imprime el año
// es bisiesto o no
//******************************************************************************

#include <iostream>

using namespace std;

bool IsLeapYear (int);

int main ()
{
    int year;
    cout << "Introduzca un año por ejemplo, 1997." << endl;
    cin >> year;
    
    if (IsLeapYear(year))
        cout << year << "es un año bisiesto." << endl;
    else
        cout << year << "no es un año bisiesto." << endl;
           
    return 0;
}

//******************************************************************************

bool IsLeapYear (int year)

// IsLeapYear regresa verdadero si year es un año bisiesto y
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
           
