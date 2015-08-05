(ns prime-multiplier.multiplier
  (:require [prime-multiplier.primes :refer [first-ten-primes]]
            [clojure.pprint :refer [print-table]]))

(defn multiply-row-by-number
  [header i row]
  (into {header i}
    (for [j row]
      [(str j) (* i j)])))

(defn make-row-maps
  [header row]
  (for [i row]
    (multiply-row-by-number header i row)))

(defn table-keys
  [header row]
  (let [column-keys (map str row)]
    (cons header column-keys)))

(defn pprint-product-table
  [header numbers]
  (print-table (table-keys header numbers) (make-row-maps header numbers)))