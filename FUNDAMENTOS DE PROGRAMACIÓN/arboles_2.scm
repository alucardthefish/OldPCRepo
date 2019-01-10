
; Estructura que representa un arbol binario ordenado (ABO)
(define-struct abo (valor ramaizq ramader))

; Esta funcion busca un elemento 'num' en un arbol binario 'arbol'
; retornando true si encuentra 'num' en 'arbol', y false en caso contrario
; buscar-en-abo : abo numero -> bool
(define (buscar-en-abo arbol num)
  (cond
    ((empty? arbol) false)
    ((= (abo-valor arbol) num) true)
    ((> num (abo-valor arbol)) (buscar-en-abo (abo-ramader arbol) num))
    (else (buscar-en-abo (abo-ramaizq arbol) num))
    ))

(define abo1
   (make-abo 10 (make-abo 5 (make-abo 2 null null) (make-abo 6 null null))
             (make-abo 11 (make-abo 10.5 null null) (make-abo 100 null null)))
  )

(buscar-en-abo abo1 1)
( 1 2 3 4 )

; Esta funcion

