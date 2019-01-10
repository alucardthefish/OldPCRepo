(define-struct Computador (velocidad cantidadram impresoras))
; Variables de tipo Computador
(define pcdaniel (make-Computador 2.2  512 '("Dell 810" "Lexmark Zseries" "Canon Inkjet  2120")))
(define pccarlos (make-Computador 1.5  1024 '("HP All in One 212")))
(define pcjimena (make-Computador 3.5  256 '("Epson 223" "Canon 45EF")))
; Contrato:
; mayor-ram: lista -> entero
; Propósito:
; Esta funcion recibe una lista de computadores y retorna el computador con la memoria ram mas grande
(define (mayor-ram lista)
  (cond
     [(empty? lista) 0]
     [(empty? (rest lista)) (Computador-cantidadram (first lista))]
     [(> (Computador-cantidadram (car lista)) (Computador-cantidadram (cadr lista)))  (mayor-ram (cons (car lista) (cddr lista)))]
     [else (mayor-ram (cons (cadr lista) (cddr lista)))]
  ))
; Pruebas:
(mayor-ram (list pcdaniel pcjimena pccarlos)) ; Debe devolver 1024
