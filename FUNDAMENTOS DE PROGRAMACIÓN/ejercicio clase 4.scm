(define(hipotenusa a b)(sqrt(+(sqr a)(sqr b))))
(define(maximo a b)(if (> a b) a b))
(define(maximotresnumeros A B C)
  (if(> A B)
     (if(> A C)A C)
     (if(> B C)B C)
     ))
(define(negativo-positivo a)
  (if(> a 0)"p" "n"))
(define(positivo-negativo-cero a)
  (cond
    ((= a 0)"c")
    ((> a 0)"p")
    (else "n")
    ))
(define(promedio a b c)(/(+ a b c)3))
(define(gana? promedio a b c)
  (cond
    ((>= promedio a b c 3)"gana")
    (else "pierde")
    ))
(define(precio-cliente a)
  (cond
    ((and(< a 10)(> a 0))(* a 700))
    ((and(>= a 10)(<= a 50))(* a 600))
    (else (* a 500))))

"CORRECCION DEL PROFESOR"
(define(precios-dvds cantidad)
  (cond
    ((or(not(integer? cantidad))(< cantidad 1))"cantidad invalidad")
    ((> cantidad 10)(* cantidad 700))
    ((<= cantidad 50)(* cantidad 600))
    (else(* cantidad 500))
    ))











