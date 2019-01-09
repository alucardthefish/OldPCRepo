;; The first three lines of this file were inserted by DrScheme. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |tarea 2|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #8(#t constructor repeating-decimal #f #t none #f ())))
;punto 1

;contrato: ganancia: numero numero -> numero
;proposito: determinar el precio de entrada con el cual se obtenga mayor ganancia
;Comentario: Se debe evaluar tomando valores del precio de la boleta desde 5 pesos
;y disminuyendo este valor en 10 centavos hasta llegar al precio cero (Entrada 
;gratuita). La cantidad de espectadores se aumenta en 15 sucesivamente y luego se
;escoge el mayor valor de ganancia.

;ejemplos:
;(ganancia 120 5) debe retornar 415.2)
;(ganancia 135 4.9) debe retornar 476.1)
;(ganancia 150 4.8) debe retornar 534)

;programa: e = entradas , v = valor boleta
(define (ganancia e v)
  (- (* e v) (+ 180 (* e 0.04)))
  )

;pruebas:
(ganancia 120 5)
(ganancia 135 4.9)
(ganancia 150 4.8)



;punto 2

;contrato: porcentaje: numero numero -> numero
;propósito: calcula el porcentaje x de una cantidad dada z.

;ejemplos: 
;(porcentaje 50 200) debe retornar 100)
;(porcentaje 25 60) debe retornar 15)
;(porcentaje 5 80) debe retornar 4)

;programa:
(define (porcentaje x z)
  (/ (* x z) 100)
  )

;pruebas:
(porcentaje 50 200)
(porcentaje 25 60)
(porcentaje 5 80)

;punto 3

;contrato: nota_asignatura: numero numero numero -> numero
;propósito: calcula la nota final de una asignatura, que evalua talleres, primer parcial y final con sus respectivos porcentajes.
;comentario: La nota de la asignatura es la sumatoria de los porcentajes de talleres (30%), parcial (25%) y examen final (45%).

;ejemplos:
;(nota_asignatura 4 5 3) debe devolver 3.8)
;(nota_asignatura 2 4 3) debe devolver 2.95)
;(nota_asignatura 1.8 3.5 4) debe devolver 3.215)

;programa:
(define (nota_asignatura talleres ex-p ex-f)
  (+ (* talleres 0.3) (* ex-p 0.25) (* ex-f 0.45) )
  )

;pruebas
(nota_asignatura 4 5 3)
(nota_asignatura 2 4 3)
(nota_asignatura 1.8 3.5 4)














 
       







;punto 1

;contrato: ganancia: numero numero -> numero
;proposito: determinar el precio de entrada con el cual se obtenga mayor ganancia
;Comentario: Se debe evaluar tomando valores del precio de la boleta desde 5 pesos
;y disminuyendo este valor en 10 centavos hasta llegar al precio cero (Entrada 
;gratuita). La cantidad de espectadores se aumenta en 15 sucesivamente y luego se
;escoge el mayor valor de ganancia.

;ejemplos:
;(ganancia 120 5) debe retornar 415.2)
;(ganancia 135 4.9) debe retornar 476.1)
;(ganancia 150 4.8) debe retornar 534)

;programa: e = entradas , v = valor boleta
(define (ganancia e v)
  (- (* e v) (+ 180 (* e 0.04)))
  )

;pruebas:
(ganancia 120 5)
(ganancia 135 4.9)
(ganancia 150 4.8)



;punto 2

;contrato: porcentaje: numero numero -> numero
;propósito: calcula el porcentaje x de una cantidad dada z.

;ejemplos: 
;(porcentaje 50 200) debe retornar 100)
;(porcentaje 25 60) debe retornar 15)
;(porcentaje 5 80) debe retornar 4)

;programa:
(define (porcentaje x z)
  (/ (* x z) 100)
  )

;pruebas:
(porcentaje 50 200)
(porcentaje 25 60)
(porcentaje 5 80)

;punto 3

;contrato: nota_asignatura: numero numero numero -> numero
;propósito: calcula la nota final de una asignatura, que evalua talleres, primer parcial y final con sus respectivos porcentajes.
;comentario: La nota de la asignatura es la sumatoria de los porcentajes de talleres (30%), parcial (25%) y examen final (45%).

;ejemplos:
;(nota_asignatura 4 5 3) debe devolver 3.8)
;(nota_asignatura 2 4 3) debe devolver 2.95)
;(nota_asignatura 1.8 3.5 4) debe devolver 3.215)

;programa:
(define (nota_asignatura talleres ex-p ex-f)
  (+ (* talleres 0.3) (* ex-p 0.25) (* ex-f 0.45) )
  )

;pruebas
(nota_asignatura 4 5 3)
(nota_asignatura 2 4 3)
(nota_asignatura 1.8 3.5 4)














 
       







