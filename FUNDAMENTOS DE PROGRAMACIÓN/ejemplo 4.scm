"con el and"
(and (> 8 7) (< 6 4)) ; false
(and (> 8 7) (> 6 4)) ; true
(and (< 8 7) (< 6 4)) ; false
"con el or"
(or (> 8 7) (< 6 4)) ; true
(or (> 8 7) (> 6 4)) ; true
(or (< 8 7) (< 6 4)) ; false
"con el not"
(not (or (> 8 7) (< 6 4))) ; false
(not (or (> 8 7) (> 6 4))) ; false
(not (or (< 8 7) (< 6 4))) ; true