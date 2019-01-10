(define(sumatoria n)
  (if(= n 0)
     0
     (+ n(sumatoria(- n 1)))
     ))
(define(fibonacci n)
  (cond
    ((= n 0)0)
    ((= n 1)1)
    (else(+(fibonacci(- n 1))(fibonacci(- n 2))))
    ))
(define(mcd n m)
  (cond
    ((= m n)n)
    ((< m n)(- n m))
    (else(- m n))
 










