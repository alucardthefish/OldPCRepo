//******************************************************************************
// Archivo de especificacion (Name.h)
// Este archivo da la especificacion del tipo de datos
// abstractos Name. Hay dos constructores_ uno toma el primer nombre,
// segundo nombrey apellido como parametros, y el segundo fija el primer
// nombre, segundo nombre y apellido en espacion en blanco
//******************************************************************************

#include <iostream>
#include <string>

using namespace std;

enum RelationType{BEFORE, SAME, AFTER};

class Name
{
  Name();
  Name(string firstName, string middleName, string lastName);
  
  void SetName(string firstName, string middleName, string lastName);
  void ReadName();
  
  string FirstName() const;
  
  string LastName() const;
  
  string MiddleName() const;
  
  char MiddleInitial() const;
  
  RelationType CompareTo(Name otherName) const;
  
  private:
          
          string first;
          string last;
          string middle;
      
};

