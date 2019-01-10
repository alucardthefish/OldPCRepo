(define(list-length lista)
  (cond
    ((empty? lista)0)
    (else(+ 1 (list-length (rest lista))))
    ))
(define (sumar-lista lon)
(cond
((empty? lon) 0)
(else (+ (first lon)
(sumar-lista (rest lon))))
))
(define(promedio lost)
  (cond
    ((empty? lost)0)
    ((empty?(rest lost))(first lost))
    (else(/(sumar-lista lost)(list-length lost)))
    ))