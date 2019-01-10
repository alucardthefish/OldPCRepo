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
; Propósito:
;   Esta funcion retorna la cantidad de impresoras que puede usar el
;   Computador "mipc"
(define (longitud lista)
  (cond 
    [(empty? lista) 0]
    [else (+ 1 (longitud (rest lista)))]))

(define (numero-impresoras mipc)
  (longitud (Computador-impresoras mipc)))

; Pruebas
(numero-impresoras pcdaniel) ; Debe devolver 3
(numero-impresoras pccarlos) ; Debe devolver 1

; Contrato:
;   computador-mas-veloz : Computador Computador -> Computador
; Propósito:
;   Esta funcion recibe 2 computadores y retorna el computador
;   mas veloz
(define (computador-mas-veloz pc1 pc2)
 (cond
   [(= (Computador-velocidad pc1) (Computador-velocidad pc2)) "son iguales"]
   [(> (Computador-velocidad pc1) (Computador-velocidad pc2)) pc1]
   [else pc2]))
; Pruebas
; Debe retornar pcdaniel:
; (make-Computador 2.2 512 (list "Dell 810" "Lexmark Zseries"
;                                "Canon Inkjet 2120"))
(computador-mas-veloz pcdaniel pccarlos)
