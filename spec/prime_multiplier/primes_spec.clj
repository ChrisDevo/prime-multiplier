(ns prime-multiplier.primes-spec
  (:require [speclj.core :refer :all]
            [prime-multiplier.primes :refer :all]))

(describe "first-prime"
  (it "is 2"
    (should== 2 first-prime)))

(describe "first-ten-primes"
  (it "consists of 2 3 5 7 11 13 17 19 23 29"
    (should= [2 3 5 7 11 13 17 19 23 29] first-ten-primes)))

(describe "potential-primes"
  (it "returns a lazy-sequence of odd integers >= 3"
    (should= [3] (take 1 potential-primes))
    (should= [3 5] (take 2 potential-primes))
    (should= [3 5 7] (take 3 potential-primes))
    (should= [3 5 7 9 11] (take 5 potential-primes))))

(describe "not-a-factor?"
  (it "returns true if <potential-factor> isn't divisible by <current-prime>"
    (should (not-a-factor? 3 11)))
  (it "returns false if <potential-factor> is divisible by <current-prime>"
    (should-not (not-a-factor? 2 8))))

(describe "remove-non-factors"
  (it "returns only the numbers from a given set that aren't multiples of the given integer"
    (should= [3 5 7 9] (remove-non-factors 2 [3 4 5 6 7 8 9]))
    (should= [4 5 7 8] (remove-non-factors 3 [3 4 5 6 7 8 9]))))

(describe "lazy-prime-sieve"
  (it "returns a lazy-seq of prime numbers >= 3"
    (should= [3] (take 1 (lazy-prime-sieve potential-primes)))
    (should= [3 5] (take 2 (lazy-prime-sieve potential-primes)))
    (should= (rest first-ten-primes) ; first-prime is added later by `primes`
      (take 9 (lazy-prime-sieve potential-primes))))
  (it "will return non-primes if you give it one first or second"
    (should= [4 5 6 7] (take 4 (lazy-prime-sieve [4 5 6 7 8 9 10 11 12 13])))
    (should= [3 4 5 7] (take 4 (lazy-prime-sieve [3 4 5 6 7 8 9 10 11 12 13]))))
  (it "will return non-primes if you give it numbers in decreasing order"
    (should= [15 13 11] (take 3 (lazy-prime-sieve [15 13 11 9 7 5 3])))))

(describe "primes"
  (it "returns the first-prime if you only take 1"
    (should= [first-prime] (take 1 primes)))
  (it "returns as many primes as you take"
    (should= [2 3] (take 2 primes))
    (should= first-ten-primes (take 10 primes)))
  (it "will throw a StackOverflowError if you take too many"
    (should-throw StackOverflowError (doall (take 10000000 primes)))))

(run-specs)