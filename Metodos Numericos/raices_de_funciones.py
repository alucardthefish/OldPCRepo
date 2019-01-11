# Clase Funcion
# Representa una funcion escrita como una cadena de operaciones en sintaxis python. Permite hallar raices mediante diferentes algoritmos
# de metodos numericos.
# Author: Sergio Ortiz P.
# Date: Feb-25-2017

import sys
from math import *

class Funcion:
    
    def __init__(self, exp_func, exp_func_prima = ""):
        '''Contructor de la clase Funcion'''
        '''param exp_func (string): cadena que representa una funcion en terminos de x en sintaxis de python (ej. x*x - 4 --> x^2 - 4)'''
        '''param exp_func_prima (string) cadena que representa la derivada de la cadena exp_func'''
        self.exp_func = exp_func
        self.exp_func_prima = exp_func_prima
    
    def eval_fx(self, valor, exp):
        '''Metodo que evalua la funcion ingresada en un valor concreto'''
        '''param valor (double): asignacion de valor de la variable "x" de la funcion'''
        '''param exp (string): cadena que representa una funcion en terminos de "x"'''
        '''Retorna el valor de evaluar la funcion con dicho valor'''
        x = valor
        return eval(exp)
        
    def __str__(self):
        '''Metodo que muestra como cadena de caracteres los atributos de la clase Funcion'''
        if self.exp_func_prima != "":
            return "[f(x)=%s] ---------> [f'(x)=%s]"%(self.exp_func, self.exp_func_prima)
        else:
            return "[f(x)=%s]"%self.exp_func
    
    # MÉTODOS SET Y GET DE LA CLASE
    def setExpFunc(self, exp):
        self.exp_func = exp
    
    def getExpFunc(self):
        return self.exp_func
    
    def setExpFuncPrima(self, exp):
        self.exp_func_prima = exp
    
    def getExpFuncPrima(self):
        return self.exp_func_prima

    # FIN METODOS SET Y GET DE LA CLASE


    def signo(self, numero):
        '''Método que devuelve el signo de un numero, -1 para negativos, 1 para  positivos'''
        if numero < 0:
            return -1
        elif numero > 0:
            return 1
        return 0
    
    def biseccion(self, a, b, m, delta, epsilon):
        '''Metodo que ejecuta el algoritmo de biseccion'''
        '''params a,b (double): representan el intervalo donde se cree existe una raiz a la funcion'''
        '''param m (int): numero de iteraciones del algoritmo'''
        '''params delta, epsilon (double): criterios de parada'''
        u = self.eval_fx(a, self.getExpFunc())
        v = self.eval_fx(b, self.getExpFunc())
        mitad = b-a + 0.0
        c = 0.0
        w = 0.0
        print ("[a] = %s, [b] = %s, [u] = %s, [v] = %s"%(a,b,u,v))
        
        #chequear si los signos de las imagenes de la funcion son diferentes
        if self.signo(u) != self.signo(v):
            # iteracion para hallar la raiz
            for k in range(1, m+1):
                mitad = mitad/2
                c = a+mitad
                w = self.eval_fx(c, self.getExpFunc())
                print ("[k] = %s, [c] = %s, [w] = %s, [e] = %s"%(k,c,w,mitad))
                
                if abs(mitad) < delta or abs(w) < epsilon:
                    print ("[RESULTADO][BISECCION] funcion f(x)= %s es: -----> [x = %s] aproximadamente"%(self.getExpFunc(),c))
                    break
                elif self.signo(w) != self.signo(u):
                    b = c
                    v = w
                else:
                    a = c
                    u = w
        else:
            print ("[RESULTADO][BISECCION] funcion f(x)= %s es: -----> NO se pudo encontrar"%(self.getExpFunc()))
    
    def newton_raphson(self, x0, m, delta, epsilon):
        '''Metodo que ejecuta el algoritmo de Newton-Ramphson'''
        '''params x0 (double): representa un numero cercano a la raiz a encontrar'''
        '''param m (int): numero de iteraciones del algoritmo'''
        '''params delta, epsilon (double): criterios de parada'''
        
        v = self.eval_fx(x0, self.getExpFunc())
        
        print ("[k] = 0, [x0] = %s, [v] = %s"%(x0, v))
        
        if abs(v) < epsilon:
             print ("[RESULTADO][NEWTON-RAPSHON] funcion f(x)= %s: No se pudo encontrar la raiz"%(self.getExpFunc()))
        else:
            for k in range(1, m+1):
                x1 = x0 - v/self.eval_fx(x0,self.getExpFuncPrima())
                v = self.eval_fx(x1, self.getExpFunc())
                print ("[k] = %s, [x1] = %s, [v] = %s"%(k, x1, v))
                
                if abs(x1-x0) < delta or abs(v) < epsilon:
                    print ("[RESULTADO][NEWTON-RAPSHON] funcion f(x)= %s es: -----> [x = %s] aproximadamente"%(self.getExpFunc(),x1))
                    break
                else:
                    x0 = x1
    
    
    def secante(self, a, b, m, delta, epsilon):
        '''Metodo que ejecuta el algoritmo de biseccion'''
        '''params a,b (double): representan el intervalo donde se cree existe una raiz a la funcion'''
        '''param m (int): numero de iteraciones del algoritmo'''
        '''params delta, epsilon (double): criterios de parada'''
        fa, fb = 0.0, 0.0
        fa = self.eval_fx(a, self.getExpFunc())
        fb = self.eval_fx(b, self.getExpFunc())
        print ("[k] = 0, [a] = %s, [fa] = %s"%(a,fa))
        print ("[k] = 1, [b] = %s, [fb] = %s"%(a,fb))
        
        for k in range(2, m+1):
            if abs(fa) > abs(fb):
                temp = a
                a = b
                b = temp
                temp = fa
                fa = fb
                fb = temp
            
            s = (b-a)/(fb-fa)
            b = a
            fb = fa
            a = a - fa*s
            fa = self.eval_fx(a, self.getExpFunc())
            
            print ("[k] = %s, [a] = %s, [fa] = %s"%(k,a,fa))
            
            if abs(fa) < epsilon or abs(b-a) < delta:
                print ("[RESULTADO][SECANTE] funcion f(x)= %s es: -----> [x = %s] aproximadamente"%(self.getExpFunc(),a))
                break
            
        


if __name__ == "__main__":
    #funcion prueba para Bisección
    f1 = "pow(e, x) - sin(x)"
    funcion1 = Funcion(f1)
    print ("------------------------Biseccion--------------------------\n")
    funcion1.biseccion(-4, -3, 40, 0.00001, 0.00001)
    
    print ("-----------------------------------------------------------\n")
    print ("---------------------Newton-Ramphson-----------------------\n")
    
    #funcion prueba Newton-Ramphson
    f2 = "pow(e, x) - 1.5 - atan(x)"
    #funcion derivada de la prueba Newton-Ramphson
    f3 = "pow(e, x) - pow(1 + pow(x, 2), -1)"
    funcion2 = Funcion(f2, f3)
    funcion2.newton_raphson(-7.0, 8, 0.00001, 0.00001)
    
    print ("-----------------------------------------------------------\n")
    print ("--------------------------Secante--------------------------\n")
    #funcion de prueba algoritmo de la secante
    f4 = "pow(x,3) - sinh(x) + 4*pow(x,2) + 6*x + 9"
    funcion3 = Funcion(f4)
    funcion3.secante(7, 8, 100, 0.00001, 0.00001)
    print ("-----------------------------------------------------------\n")
    
    
    
    
    







