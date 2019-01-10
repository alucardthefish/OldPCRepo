(define (sumar-lista lon)
(cond
((empty? lon) 0)
(else (+(first lon)
(sumar-lista (rest lon))))
))
(define (list-length lista)
  (cond 
    ((empty? lista) 0)
    (else (+ 1 (list-length (rest lista))))
    ))
(define(promedio lis)
  (cond
    ((empty? lis)0)
    ((empty?(rest lis))(first lis))
    (else(/(sumar-lista lis)(list-length lis)))
    ))
(promedio(list 3 4 5))