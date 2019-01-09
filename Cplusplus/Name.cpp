//******************************************************************************
// Archivo de Implementacion (Name.cpp)
// Este archivo ejecuta las funciones miembro Name
//******************************************************************************

#include "Name.h"
#include <iostream>

Name::Name()
{
            first = " ";
            middle = " ";
            last = " ";            
}

Name::Name(string firstName, string middleName, string lastName)
{
                  first = firstName;
                  middle = middleName;
                  last = lastName;
}

void Name::SetName(string firstName, string middleName, string lastName)
{
     first = firstName;
     middle = middleName;
     last = lastName;
}

void Name::ReadName()
{
     cout << "Enter first name: ";
     cin >> first;
     cout << "Enter middle name: ";
     cin >> middle;
     cout << "Enter last name: ";
     cin >> last;
 }
 
string Name::FirstName() const
{
       return first;
}

string Name::LastName() const
{
       return last;
}

string Name::MiddleName() const
{
       return middle;
}

char Name::MiddleInitial() const
{
     return middle[0];
 }
 
 RelationType Name::CompareTo( Name otherName ) const
 {
              if(last < otherName.last)
                      return BEFORE;
              else if(otherName.last < last)
                   return AFTER;
              else if(first < otherName.first)
                   return BEFORE;
              else if(otherName.first < first)
                   return AFTER;
              else if(middle < otherName.middle)
                   return BEFORE;
              else if(otherName.middle < middle)
                   return AFTER;
              else
                  return SAME;
 }
