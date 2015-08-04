(ns prime-multiplier.multiplier)

(defn multiply-row-by-int
  ([i row]
   (map (partial * i) row)))

(defn multiply-row-by-itself
  [row]
  (for [i row]
    (multiply-row-by-int i row)))
