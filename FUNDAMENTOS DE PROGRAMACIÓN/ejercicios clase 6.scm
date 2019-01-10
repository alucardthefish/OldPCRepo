(define(semana dia)
  (cond
    ((= dia 1) 'domingo)
    ((= dia 2) 'lunes)
    ((= dia 3) 'martes)
    ((= dia 4) 'miercoles)
    ((= dia 5) 'jueves)
    ((= dia 6) 'viernes)
    ((= dia 7) 'sabado)
    (else 'DiaInvalido)
    ))
(list 12 25 67)
(list 25 67)
(list 67)
(list)
(define(mayor lis)
  (cond
    ((empty? lis)0)
    ((> (first lis)(mayor(rest lis)))(first lis))
    (else(mayor(rest lis)))
    ))
(mayor (list 1 4 2 5 7 4))

(define(mayor-que ls x)
  (cond
    ((empty? ls)false)
    ((>(first ls)x)(first ls))
    (else(mayor-que(rest ls)x))
    ))
(mayor-que (list 1 4 2 5 7 4) 4)
(define(list-get lsn n)
  (cond
    ((empty? lsn)false)
    ((= n 1)(first lsn))
    (else(list-get(rest lsn)(- n 1)))
    ))
(list-get (list 1 4 2 5 7 4) 5)

(define(ultimo ldn)
  (cond
    ((empty? ldn)empty)
    ((empty?(rest ldn))(first ldn))
    (else(ultimo(rest ldn)))
    ))
(ultimo (list 1 4 3 2 5 7 4))






































