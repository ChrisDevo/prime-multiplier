(ns prime-multiplier.core
  (:require [prime-multiplier.multiplier :refer [pprint-product-table]]
            [prime-multiplier.primes :refer [first-ten-primes]])
  [:gen-class])

(defn -main
  ([]
   (pprint-product-table "prime" first-ten-primes))
  ([& args]
   {:pre [(string? (first args))
          (not-empty (rest args))
          (every? #(or (string? %) (number? %)) (rest args))
          (every? number? (map read-string (filter string? (rest args))))]}
   (let [header (first args)
         numbers (rest args)
         parsed-numbers (map (fn [i]
                               (if (number? i)
                                 i
                                 (read-string i))) numbers)]
     (pprint-product-table header parsed-numbers))))


