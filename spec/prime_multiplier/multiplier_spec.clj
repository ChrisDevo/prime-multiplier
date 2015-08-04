(ns prime-multiplier.multiplier-spec
  (:require [speclj.core :refer :all]
            [prime-multiplier.multiplier :refer :all]
            [prime-multiplier.primes :refer [first-ten-primes]]))

(describe "multiply-row-by-int"
  (it "will return a vector with a single product"
    (should= [1] (multiply-row-by-int 1 [1])))
  (it "will return a vector of input values multiplied by the given integer"
    (should= [1 2] (multiply-row-by-int 1 [1 2]))
    (should= [2 4] (multiply-row-by-int 2 [1 2]))
    (should= [3 6 9] (multiply-row-by-int 3 [1 2 3]))
    (should= first-ten-primes (multiply-row-by-int 1 first-ten-primes))))

(describe "multiply-row-by-itself"
  (it "will return the square of a single value row"
    (should= [1] (first (multiply-row-by-itself [1])))
    (should= [4] (first (multiply-row-by-itself [2])))
    (should= [9] (first (multiply-row-by-itself [3]))))
  (it "will return another row for every element"
    (should== 1 (count (multiply-row-by-itself [3])))
    (should== 2 (count (multiply-row-by-itself [3 2])))
    (should== 3 (count (multiply-row-by-itself [3 2 1]))))
  (it "will return a row mutiplied by each element for each element"
    (should= [[1 2 3]
              [2 4 6]
              [3 6 9]] (multiply-row-by-itself [1 2 3]))
    (should= [[4 6 10 14 22 26 34 38 46 58]
              [6 9 15 21 33 39 51 57 69 87]
              [10 15 25 35 55 65 85 95 115 145]
              [14 21 35 49 77 91 119 133 161 203]
              [22 33 55 77 121 143 187 209 253 319]
              [26 39 65 91 143 169 221 247 299 377]
              [34 51 85 119 187 221 289 323 391 493]
              [38 57 95 133 209 247 323 361 437 551]
              [46 69 115 161 253 299 391 437 529 667]
              [58 87 145 203 319 377 493 551 667 841]]
      (multiply-row-by-itself first-ten-primes))))

(run-specs)
