
(define (calcular-promedio A B C)
  (/ (+ A B C) 3))
;(calcular-promedio 5 5 0)

(define (gano? nota)
  (cond
    ((< nota 3) false)
    (else true)
    ))

;(define (gano? nota)
;    (>= nota 3))

;(gano? 4)
;(gano? 3)
;(gano? 2)

(define (gano-desde-notas? A B C)
  (gano? (calcular-promedio A B C)))

(gano-desde-notas? 1 2 5)
(gano-desde-notas? 2 2 5)

