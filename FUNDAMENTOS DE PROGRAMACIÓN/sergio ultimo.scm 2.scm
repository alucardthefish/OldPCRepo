(define-struct humano (nombre sexo tiposangre))
(define Andrea (make-humano "Andrea Gomez" 'F 'O))
(define Camilo (make-humano "Camilo Diaz" 'M 'O))
(define Genny (make-humano "Genny Lopez" 'F 'A))
(define Diana (make-humano "Diana Maria Santacruz" 'F 'AB))
(define Jairo (make-humano "Jairo Perez" 'M 'B))

(define(tiposangre-hijo humano1 humano2)
  (cond
    ((and(= (humano-tiposangre humano1)'O)(= (humano-tiposangre humano2)'O))'O)
    ((and(= (humano-tiposangre humano1)'A)(= (humano-tiposangre humano2)'A))'A)
    ((and(= (humano-tiposangre humano1)'B)(= (humano-tiposangre humano2)'B))'B)
    ((and(= (humano-tiposangre humano1)'AB)(= (humano-tiposangre humano2)'AB))'AB)
    ((and(= (humano-tiposangre humano1)'O)(= (humano-tiposangre humano2)'B))'B)
    ((and(= (humano-tiposangre humano1)'B)(= (humano-tiposangre humano2)'O))'B)
    ((and(= (humano-tiposangre humano1)'O)(= (humano-tiposangre  humano2)'AB))'AB)
    ((and(= (humano-tiposangre humano1)'AB)(= (humano-tiposangre humano2)'O))'AB)
    ((and(= (humano-tiposangre humano1)'O)(= (humano-tiposangre humano2)'A))'A)
    ((and(= (humano-tiposangre humano1)'A)(= (humano-tiposangre humano2)'O))'A)
    ((and(= (humano-tiposangre humano1)'A)(= (humano-tiposangre humano2)'B))'AB)
    (else(and(= (humano-tiposangre humano1)'B)(= (humano-tiposangre humano2)'A)))
    ))
(tiposangre-hijo Andrea Camilo)


 

    