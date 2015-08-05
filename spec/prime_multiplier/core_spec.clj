(ns prime-multiplier.core-spec
  (:require [speclj.core :refer :all]
            [prime-multiplier.core :refer :all]
            [prime-multiplier.multiplier :refer [pprint-product-table]]
            [prime-multiplier.primes :refer [first-ten-primes primes]]))

(describe "main"
  (it "should call pprint-product-table with \"prime\" and first-ten-primes when no args given"
    (should-invoke pprint-product-table {:with ["prime" first-ten-primes]} (-main))
    (let [n 11]
      (should-invoke pprint-product-table {:with ["prime" (take n primes)]} (-main n))))

  (it "will throw an AssertionError if the arg given isn't a number"
    (should-throw AssertionError (-main "k"))
    (should-not-throw (-main "1"))
    (should-not-throw (-main 4))))

(run-specs)