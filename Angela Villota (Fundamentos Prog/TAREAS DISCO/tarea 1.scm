;; The first three lines of this file were inserted by DrScheme. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |tarea 1|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #8(#t constructor repeating-decimal #f #t none #f ())))
;punto 1

;contrato: triangulo: numero numero -> numero
;propósito: calcular el area de un triangulo

;ejemplos:
;(triangulo 2 4) debe retornar 4)
;(triangulo 4 9) debe retornar 18)
;(triangulo 6 18) debe retornar 54)

;programa:
(define (triangulo base altura)
  (/ (* base altura) 2)
  )

;pruebas:
(triangulo 2 4)
(triangulo 4 9)
(triangulo 6 18)

;punto 2.a

;contrato: f: numero -> numero
;proposito: evaluar el valor de la funcion para un valor de x dado

;ejemplos:
;(f 2) debe devolver 2.6666)
;(f 5) debe devolver 3.6666)
;(f 9) debe devolver 5)

;programa:
(define (f x)
  (+ (/ x 3) 2)
  )

;pruebas:
(f 2)
(f 5)
(f 9)

;punto 2.b

;contrato: uno: numero -> numero
;proposito: evaluar el valor de la funcion para un de n dado

;ejemplos:
;(uno 4) debe retornar 26)
;(uno 5) debe retornar 35)
;(uno 9) debe retornar 91)

;programa:
(define (uno n)
  (+ (* n n) 10)
  )

;pruebas:
(uno 4)
(uno 5)
(uno 9)

;contrato: dos: numero -> numero
;proposito: evaluar el de la funcion para el valor en m dado

;ejemplos:
;(dos 4) debe devolver 28)
;(dos 5) debe devolver 32.5)
;(dos 9) debe devolver 60.5)

;programa:
(define (dos m)
  (+ (/ (* m m) 2) 20)
  )

;pruebas:
(dos 4)
(dos 5)
(dos 9)

;punto 3

;contrato: camiones: numero -> numeros
;propósito: calcular el numero necesario de camiones para llevar una cantidad
;determinada de cajas. capacidad por camion de 30 cajas.

;ejemplos:
;(camiones 89) debe devolver 3)
;(camiones 60) debe devolver 2)
;(camiones 15) debe devolver 1)

;programa:
(define (camiones cajas)
  (ceiling (/ cajas 30))
  )
;pruebas:
(camiones 89)
(camiones 60)
(camiones 15)

;punto 4

;contrato: baldosas: numero numero numero numero -> numero
;proposito: calcular el numero de baldosas necesarias para cubrir un cuarto.

;ejemplos:
;(baldosas 4 3 2 1) debe retornar 6)
;(baldosas 8 6 3 2) debe retornar 8)
;(baldosas 25 12 4 3) debe retornar 25)

;programa:
(define (baldosas largo ancho largo1 ancho1)
  (* (/ largo largo1)(/ ancho ancho1))
  )

;pruebas:
(baldosas 4 3 2 1)
(baldosas 8 6 3 2)
(baldosas 25 12 4 3)
