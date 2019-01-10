;Punto 1
;Investigue para qué sirve cada una de estas funciones y de un ejemplo:
 ;car
 ;cdr
 ;cadr
 ;cddr
 ;cadddr

;Las funciones car y cdr en Scheme vienen de LISP, puesto que Scheme es un dialecto de LISP.

;car: car devuelve el primer elemento de una lista, y por eso, cuando utilices CAR siempre debes hacerlo mandandole como parámetro una lista, no un átomo, puras listas. Si es así, entonces CAR te devolverá la primer expresión S(átomo o lista) de la lista, una lista puede tener como miembros otras listas o átomos. Si mandas llamar CAR son una lista vacía marca error. 

;cdr: cdr devuelve el resto de la lista, excluyendo a la primer expresión S de una lista, es como degollar la lista por decirlo así. CDR al igual que CAR recibe una lista como parámetro, pero CDR regresa una lista también, es decir nunca regresa átomos como resultado, y si le llegas a mandar una lista vacía a CDR, te regresa una lista vacía también.

;cadr: cadr devuelve el segundo elemento de la lista y se debe mandar siempre como parametro de una lista. El CADR es como la abreviación del (car(cdr(list))) o sea llama al primer elemento del resto de la lista, o sea el segundo elemento.

;cddr: cddr devuelve el resto de la lista, excluyendo a la primer y segunda expresion S de una lista. Es el (cdr(cdr(list))) o sea llama al resto del resto de una lista.

;cadddr: cadddr devuelve el cuarto elemento de una lista, el cadddr es lo mismo que (car(cdr(cdr(cdr(list))))), o sea que primero llama al resto de la lista, luego al resto del resto de la lista, luego al resto del resto del resto de la lista y el primer elemento de la lista resultante. o sea el 4 elemento de una lista.

;Las repeticiones de las funciones no pueden ser mas de 4 puesto que no reconoce esa instruccion y devolveria error.

;Ejemplos:
;car:
(car(list 1 2 3 4 5 6)) ; debe retornar 1
;cdr:
(cdr(list 1 2 3 4 5 6)) ; debe retornar (cons 2 (cons 3 (cons 4 (cons 5 (cons 6 empty)))))
;cadr:
(cadr(list 1 2 3 4 5 6)) ; debe retornar 2
;cddr:
(cddr(list 1 2 3 4 5 6)) ; debe retornar (cons 3 (cons 4 (cons 5 (cons 6 empty))))
;cadddr:
(cadddr(list 1 2 3 4 5 6)) ; debe retornar 4

;Punto 2
;Qué otras funciones de la familia car y cdr existen ?
;otras funciones son:

;caddr: caddr devuelve el tercer elemento de la lista, es el (car(cdr(cdr(list)))), es el primer elemento del resto del resto de la lista.

;cdddr: cdddr devuelve el resto de la lista excluyendo el primero, segundo y tercer expresion s de la lista.

;Punto 3

; Esta estructura representa a un humano con las siguientes
; caracteristicas:
; nombre -> un string que representa los nombres y apellidos
; del Humano
; sexo -> un symbol que representa el tipo de sexo del Humano.
; Puede ser 'F o 'M
; tiposangre -> un symbol que representa el tipo de sangre del
; Humano. Puede ser 'A 'B o 'AB
(define-struct Humano (nombre sexo tiposangre))
; Contrato:
; tiposangre-hijo : Humano Humano -> symbol
; Prop?sito:
; Esta funcion toma 2 estructuras de tipo "Humano", A y B, y retorna
; el tipo de sangre que tendria un hijo de A y B.
(define (tiposangre-hijo humano1 humano2)
  (cond
    [(symbol=? (Humano-tiposangre humano1) (Humano-tiposangre humano2)) (Humano-tiposangre humano1)]
    [(symbol=? (Humano-tiposangre humano1) 'O) (Humano-tiposangre humano2)]
    [(symbol=? (Humano-tiposangre humano2) 'O) (Humano-tiposangre humano1)]
    [(symbol=? (Humano-tiposangre humano1) 'AB) (Humano-tiposangre humano1)]
    [(symbol=? (Humano-tiposangre humano2) 'AB) (Humano-tiposangre humano2)]
    [(and (symbol=? (Humano-tiposangre humano1) 'A) (symbol=? (Humano-tiposangre humano2) 'B)) 'AB]
    [(and (symbol=? (Humano-tiposangre humano1) 'B) (symbol=? (Humano-tiposangre humano2) 'A)) 'AB])
)
; Definicion de personas que quieren saber de que tipo seria la sangre
; de sus hijos
(define Andrea (make-Humano "Andrea Gomez" 'F 'O))
(define Camilo (make-Humano "Camilo Diaz" 'M 'O))
(define Genny (make-Humano "Genny Lopez" 'F 'A))
(define Diana (make-Humano "Diana Maria Santacruz" 'F 'AB))
(define Jairo (make-Humano "Jairo Perez" 'M 'B))
; Pruebas:
(tiposangre-hijo Andrea Camilo) ; Debe devolver 'O
(tiposangre-hijo Andrea Jairo) ; Debe devolver 'B
(tiposangre-hijo Diana Camilo) ; Debe devolver 'AB
(tiposangre-hijo Jairo Genny) ; Debe devolver 'AB

;Punto 4

; Esta estructura representa a un computador con estas
; caracteristicas:
;   velocidad      -> un numero positivo que representa la velocidad
;                     del PC en GHz
;   catidadram     -> un entero positivo que representa la cantidad de
;                     RAM en MBs
;   impresoras     -> una lista que contiene los nombres (strings) de
;                     las impresoras que puede usar ese computador
(define-struct Computador (velocidad cantidadram impresoras))
; Variables de tipo Computador
(define pcdaniel (make-Computador 2.2  512 '("Dell 810" "Lexmark Zseries" "Canon Inkjet  2120")))
(define pccarlos (make-Computador 1.5  1024 '("HP All in One 212")))
(define pcjimena (make-Computador 3.5  256 '("Epson 223" "Canon 45EF")))

; Contrato:
;   numero-impresoras : Computador -> entero
; Prop?sito:
;   Esta funcion retorna la cantidad de impresoras que puede usar el
;   Computador "mipc"

(define(contar l)
  (cond
    ((empty? (rest l)) 1)
    (else (+ 1 (contar(rest l))))
    ))

(define (numero-impresoras mipc)
  (contar (Computador-impresoras mipc)))

; Pruebas
(numero-impresoras pcdaniel) ; Debe devolver 3
(numero-impresoras pccarlos) ; Debe devolver 1

; Contrato:
;   computador-mas-veloz : Computador Computador -> Computador
; Prop?sito:
;   Esta funcion recibe 2 computadores y retorna el computador
;   mas veloz

(define (computador-mas-veloz pc1 pc2)
 (cond
   ((= (Computador-velocidad pc1) (Computador-velocidad pc2)) "son iguales")
   ((> (Computador-velocidad pc1) (Computador-velocidad pc2)) pc1)
   (else pc2)))

; Pruebas
; Debe retornar pcdaniel:
; (make-Computador 2.2 512 (list "Dell 810" "Lexmark Zseries"
;                                "Canon Inkjet 2120"))
(computador-mas-veloz pcdaniel pccarlos)

;Punto 5

;Contrato:
;cant-ram-mayor: lista -> entero
;Proposito:
;Esta función recibe una lista de computadores y retorna
;el computador con la cantidad ram mayor.

(define (cant-ram-mayor ldc)
  (cond
     ((empty? ldc) 0)
     ((empty? (rest ldc)) (Computador-cantidadram (first ldc)))
     ((> (Computador-cantidadram (car ldc)) (Computador-cantidadram (cadr ldc)))
      (cant-ram-mayor (cons (car ldc) (cddr ldc))))
     (else (cant-ram-mayor (cons (cadr ldc) (cddr ldc))))
  ))

; Pruebas:
(cant-ram-mayor (list pcdaniel pcjimena pccarlos)) ; Debe devolver 1024















