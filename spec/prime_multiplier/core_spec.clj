(ns prime-multiplier.core-spec
  (:require [speclj.core :refer :all]
            [prime-multiplier.core :refer :all]
            [prime-multiplier.multiplier :refer [pprint-product-table]]
            [prime-multiplier.primes :refer [first-ten-primes]]))

(describe "main"
  (it "should call pprint-product-table with \"prime\" and first-ten-primes when no args given"
    (should-invoke pprint-product-table {:with ["prime" first-ten-primes]} (-main)))

  (it "throws an AssertionError if the first arg isn't a string"
    (should-throw AssertionError (-main :k))
    (should-throw AssertionError (-main 1)))

  (it "throws an AssertionError if the rest of the args are missing"
    (should-throw AssertionError (-main "header")))

  (it "throws an AssertionError if any of the other args are not numbers"
    (should-throw AssertionError (-main "string" :k))
    (should-throw AssertionError (-main "string" 'dummy_symbol)))

  (it "should not thorw an AssertionError if any of the other args can be parsed as a number"
    (should-not-throw (-main "string" "1" 2 3))
    (should-not-throw (-main "string" 1 "2" 3))
    (should-not-throw (-main "string" 1 2 "3"))
    (should-not-throw (-main "string" 1 2 3))))

(run-specs)