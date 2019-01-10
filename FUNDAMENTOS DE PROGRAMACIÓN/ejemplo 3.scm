
(define (etapas-vida edad)
  (cond
    ((< edad 0) "edad invalida")
    ((<= edad 15) "niño")
    ((<= edad 40) "joven")
    ((<= edad 80) "mayor")
    (else "anciano")
    ))

(etapas-vida  -1)
(etapas-vida  0)
(etapas-vida  16)
(etapas-vida  48)
(etapas-vida  428)