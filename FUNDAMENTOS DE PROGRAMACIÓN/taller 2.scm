;1. Detecte y corrija los errores que tienen las siguientes 5
;expresiones Scheme. El resultado esperado después de la
;corrección es el que aparece después del ;.
;Debe indicar a que se debía el error corregido.
;i. round(54 * 3/PI)     ; #i52
;ii. (/ (* 100 5 4)      ; 125
;iii. remainder 100 6    ; 4
;iv. abs –100 / 10       ; 10
;v. (define (fun 1) (* 2 3)) ;

;R/.i. round(54 * 3/PI)     ; #i52
;(round(* 54(/ 3 pi))) le faltaba un parentesis que uniera a round con el resto y organizar las operaciones en forma prefija que es la forma como lo entiende scheme

;ii. (/ (* 100 5 4)      ; 125
;(/(* 100 5 4)16) le faltaba encontrar el numero que faltaba para que el resultado fuera el mismo (en este caso el 16) y encerrarlo a la operacion en un parentesis

;iii. remainder 100 6    ; 4
; (remainder 100 6) lo unico que faltaba era encerrarlo en parentesis lo demas estaba bien

;iv. abs –100 / 10       ; 10
;(abs(/ -100 10)) le faltaba encerrarlo en los parentesis correspondientes y ordenar las operaciones en forma prefija

;v. (define (fun 1) (* 2 3)) ;



;2. Detecte y corrija los errores que tiene la siguiente función
;Scheme, si el resultado esperado de aplicar la función es el que
;aparece en la sección de ejemplos.
;Debe indicar a que se debía el error corregido.
;(define (operar valor1 valor2)
;(cond
;(= valor1 valor2) (* valor1 valor2)
;[(> valor1 valor2) (+ valor1 valor2)]
;(= valor1 (* 2 valor2)) valor2); este condicional esta anulado por que para que este se cumpla tiene que ser siempre el valor1 mayor que el valor2 entonces se va por el anterior condicional asi que es lo mismo que no colocarlo
;[else (abs (- valor1 valor2)))
;))
; Ejemplos:
;(operar 1 1) ; 1
;(operar 1 2) ; 1
;(operar 2 1) ; 3
;(operar 4 2) ; 6

;R/.
(define(operar valor1 valor2)
  (cond
    ((= valor1 valor2)(* valor1 valor2)); a este condicional solo le faltaba encerrarlo con otro par de parentesis
    [(> valor1 valor2)(+ valor1 valor2)]; este condicional esta correcto
    [else(abs(- valor1 valor2))]; le faltaba cambiar su ultimo parentesis por un corchete puesto que asi empezo.
    ))

;3. Diseñe las funciones par? e impar? (con contrato, ejemplos y
;descripción) que permita resolver el siguiente problema recursivo
;mediante la función par-o-impar definida así:

(define (par-o-impar numero)
 (cond
  ((par? numero) "par")
  ((impar? numero) "impar")
))

;R/.funcion par?

;contrato:
;par?: numero-palabra
;proposito:calcula si un numero es par o no
;(resta el numero con 1 y si es igual a cero es par sino no, usando recursividad)
(define(par? N)
  (if(= N 0)
     true
     (not(par?(- N 1)))
     ))
;ejemplo y pruebas:
(par? 4); se espera true
(par? 26); se espera true
(par? 5); se espera false

;- funcion impar?

;contrato:
;impar?: numero-palabra 
;proposito: muestra si un numero es impar o no
;(resta el numero con 1 y si es igual a 1 es impar sino no, usando recursividad)
(define(impar? n)
  (if(= n 1)
     true
     (not(impar?(- n 1)))
     ))
;ejemplo y pruebas:
(impar? 4); se espera false
(impar? 26); se espera false
(impar? 5); se espera true


;4. Las funciones par? e impar? tienen un problema con los números negativos, debido a que si son aplicadas a uno de ellos entrarían en recursión infinita. Corrija las funciones para que den el valor correcto cuando sean aplicadas a números negativos.

;R/.la correccion seria

(define(par? N)
   (if(=  N 0)
      true
   (not(par?(-(abs N) 1)))
   ))

5. La función par-o-impar también tiene un problema si es llamada con el número 0, ya que respondería “par” y el 0 no es
considerado un número par Corrija la función para que responda “cero” cuando sea aplicada al número 0. Así:
(par-o-impar 0) ; Valor esperado: “cero”

;R/. 










