(define(sumatoria N)
  (if(= N 0)
     0
     (+ N(sumatoria(- N 1)))))
(define(par-impar N)
  (if(=(remainder N 2)0)
     "par"
     "impar"
     ))