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
