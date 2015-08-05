(ns prime-multiplier.multiplier-spec
  (:require [speclj.core :refer :all]
            [prime-multiplier.multiplier :refer :all]
            [prime-multiplier.primes :refer [first-ten-primes]]))

(describe "multiply-row-by-number"
  (it "will return a map with a the header mapped to the number given"
    (let [product-map (multiply-row-by-number "header" 1 [1])]
      (should= {"header" 1 "1" 1} product-map)
      (should= ["header" 1] (first product-map))
      (should== 1 (get product-map "header")))

    (let [another-product-map (multiply-row-by-number "prime" 2 [1])]
      (should= {"prime" 2 "1" 2} another-product-map)
      (should= ["prime" 2] (first another-product-map))
      (should== 2 (get another-product-map "prime"))))

  (it "will return a map of input values multiplied by the given integer"
    (should= {"header" 1 "1" 1 "2" 2} (multiply-row-by-number "header" 1 [1 2]))
    (should= {"header" 2 "1" 2 "2" 4} (multiply-row-by-number "header" 2 [1 2]))
    (should= {"header" 3 "1" 3 "2" 6 "3" 9} (multiply-row-by-number "header" 3 [1 2 3]))
    (should= {"header" 1 "2" 2 "3" 3 "5" 5 "7" 7 "11" 11 "13" 13 "17" 17 "19" 19 "23" 23 "29" 29}
             (multiply-row-by-number "header" 1 first-ten-primes))))

(describe "make-row-maps"
  (it "will return a map with the header given mapped as a key to the first value"
    (should= ["header" 1] (ffirst (make-row-maps "header" [1]))))

  (it "will return the square of a single value row"
    (should= {"header" 1 "1" 1} (first (make-row-maps "header" [1])))
    (should= {"header" 2 "2" 4} (first (make-row-maps "header" [2])))
    (should= {"header" 3 "3" 9} (first (make-row-maps "header" [3]))))

  (it "will return another map for every element"
    (should== 1 (count (make-row-maps "header" [3])))
    (should== 2 (count (make-row-maps "header" [3 2])))
    (should== 3 (count (make-row-maps "header" [3 2 1]))))

  (it "will return a row mutiplied by each element for each element"
    (should= [{"header" 1 "1" 1 "2" 2 "3" 3}
              {"header" 2 "1" 2 "2" 4 "3" 6}
              {"header" 3 "1" 3 "2" 6 "3" 9}]
             (make-row-maps "header" [1 2 3]))

    (should= [{"header" 2  "2" 4  "3" 6  "5" 10  "7" 14  "11" 22  "13" 26  "17" 34  "19" 38  "23" 46  "29" 58}
              {"header" 3  "2" 6  "3" 9  "5" 15  "7" 21  "11" 33  "13" 39  "17" 51  "19" 57  "23" 69  "29" 87}
              {"header" 5  "2" 10 "3" 15 "5" 25  "7" 35  "11" 55  "13" 65  "17" 85  "19" 95  "23" 115 "29" 145}
              {"header" 7  "2" 14 "3" 21 "5" 35  "7" 49  "11" 77  "13" 91  "17" 119 "19" 133 "23" 161 "29" 203}
              {"header" 11 "2" 22 "3" 33 "5" 55  "7" 77  "11" 121 "13" 143 "17" 187 "19" 209 "23" 253 "29" 319}
              {"header" 13 "2" 26 "3" 39 "5" 65  "7" 91  "11" 143 "13" 169 "17" 221 "19" 247 "23" 299 "29" 377}
              {"header" 17 "2" 34 "3" 51 "5" 85  "7" 119 "11" 187 "13" 221 "17" 289 "19" 323 "23" 391 "29" 493}
              {"header" 19 "2" 38 "3" 57 "5" 95  "7" 133 "11" 209 "13" 247 "17" 323 "19" 361 "23" 437 "29" 551}
              {"header" 23 "2" 46 "3" 69 "5" 115 "7" 161 "11" 253 "13" 299 "17" 391 "19" 437 "23" 529 "29" 667}
              {"header" 29 "2" 58 "3" 87 "5" 145 "7" 203 "11" 319 "13" 377 "17" 493 "19" 551 "23" 667 "29" 841}]
             (make-row-maps "header" first-ten-primes))))

(run-specs)
