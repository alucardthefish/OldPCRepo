;proposito: esta funcion calcula el
;area de un circulo
;cabezera
;area circulo: numero-numero
(define(areacirculo r)(* pi r r))
;ejemplos:
;(areacirculo 3): devuelve 28.274338....


;proposito: calcular el area de un anillo circular
;area de un anillo circular
;cabezera
;area anillo: numero-numero
(define(areanillo R r)(*(-(* R R)(* r r)) pi))
;ejemplos:
;(areanillo 5 3): devuelve 50.265482..