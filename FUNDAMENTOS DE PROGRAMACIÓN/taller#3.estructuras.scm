(define-struct humano (nombre sexo tiposangre))
(define Andrea (make-humano "Andrea Gomez" 'F 'O))
(define Genny (make-humano "Genny Lopez" 'F 'A))
(define Diana (make-humano "Diana Maria Santacruz" 'F 'AB))
(define Camilo (make-humano "Camilo Diaz" 'M 'O))
(define Jairo (make-humano "Jairo Perez" 'M 'B))

(define (tiposangre-hijo humano1 humano2)
  (cond
    ((symbol=?(humano-tiposangre humano1)(humano-tiposangre humano2))(humano-tiposangre humano1))
    ((and(symbol=?(humano-tiposangre humano1)'O)(symbol=?(humano-tiposangre humano2)'A))(humano-tiposangre humano2))
    ((and(symbol=?(humano-tiposangre humano1)'A)(symbol=?(humano-tiposangre humano2)'O))(humano-tiposangre humano1))
    ((and(symbol=?(humano-tiposangre humano1)'O)(symbol=?(humano-tiposangre humano2)'B))(humano-tiposangre humano2))
    ((and(symbol=?(humano-tiposangre humano1)'B)(symbol=?(humano-tiposangre humano2)'O))(humano-tiposangre humano1))
    ((and(symbol=?(humano-tiposangre humano1)'O)(symbol=?(humano-tiposangre humano2)'AB))(humano-tiposangre humano2))
    ((and(symbol=?(humano-tiposangre humano1)'AB)(symbol=?(humano-tiposangre humano2)'O))(humano-tiposangre humano1))
    ((and(symbol=?(humano-tiposangre humano1)'A)(symbol=?(humano-tiposangre humano2)'B))'AB)
    ((and(symbol=?(humano-tiposangre humano1)'B)(symbol=?(humano-tiposangre humano2)'A))'AB)
    (else(symbol=?(humano-tiposangre humano1)(humano-tiposangre humano2)))
    ))
(tiposangre-hijo Andrea Camilo)
(tiposangre-hijo Andrea Jairo)
(tiposangre-hijo Diana Camilo)
(tiposangre-hijo Jairo Genny)
