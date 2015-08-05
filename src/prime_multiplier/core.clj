(ns prime-multiplier.core
  (:require [prime-multiplier.multiplier :refer [pprint-product-table]]
            [prime-multiplier.primes :refer [first-ten-primes primes]])
  [:gen-class])

(defn -main
  ([]
   (pprint-product-table "prime" first-ten-primes))
  ([n]
   {:pre [(if (string? n)
            (number? (read-string n))
            (number? n))]}
   (let [primes (if (string? n)
                  (take (read-string n) primes)
                  (take n primes))]
     (pprint-product-table "prime" primes))))


