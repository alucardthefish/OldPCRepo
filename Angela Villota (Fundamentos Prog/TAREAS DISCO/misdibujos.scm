;; The first three lines of this file were inserted by DrScheme. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname misdibujos) (read-case-sensitive #t) (teachpacks ((lib "draw.ss" "teachpack" "htdp"))) (htdp-settings #8(#t constructor repeating-decimal #f #t none #f ((lib "draw.ss" "teachpack" "htdp")))))
;(start 300 300)
;(draw-solid-line (make-posn 23 45) (make-posn 78 123) 'red)
;(draw-solid-rect (make-posn 56 78) 25 12 'blue)
;(draw-solid-disk (make-posn 209 209) 40 'black)
;(draw-circle (make-posn 170 50) 20 'green)

;(start 500 500)
;(clear-solid-line (make-posn 10 10) (make-posn 110 10) 'red)
;(clear-solid-rect (make-posn 10 30) 100 50 'blue)
;(clear-circle (make-posn 110 30) 30 'yellow)
;(clear-solid-disk (make-posn 10 80) 50 'green)
;(clear-solid-disk (make-posn 250 250) 40 'red)

(define ANCHO 50)
(define LARGO 160)
(define BOMBILLO-RADIO 20)
(define BOMBILLO-DISTANCIA 10)

(define X-BOMBILLOS (quotient ANCHO 2))
(define Y-RED (+ BOMBILLO-DISTANCIA BOMBILLO-RADIO))
(define Y-YELLOW (+ Y-RED BOMBILLO-DISTANCIA (* 2 BOMBILLO-RADIO)))
(define Y-GREEN (+ Y-YELLOW BOMBILLO-DISTANCIA (* 2 BOMBILLO-RADIO)))

(start 400 400)
(draw-solid-disk (make-posn X-BOMBILLOS Y-RED) BOMBILLO-RADIO 'red)
(draw-circle (make-posn X-BOMBILLOS Y-YELLOW) BOMBILLO-RADIO 'yellow)
(draw-circle (make-posn X-BOMBILLOS Y-GREEN) BOMBILLO-RADIO 'green)

