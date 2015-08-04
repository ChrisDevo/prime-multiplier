(ns prime-multiplier.primes)

(def first-prime 2)
(def first-ten-primes [2 3 5 7 11 13 17 19 23 29])

(def potential-primes
  "Returns a lazy-sequence of odd integers >= 3

   Using only odd numbers halves the search space,
   but we'll need to add the first prime if all primes are required."
  (iterate #(+ 2 %) 3))

(defn not-a-factor?
  "returns true if <potential-factor> isn't divisible by <current-prime>
   returns false if <potential-factor> is divisible by <current-prime>"
  [current-prime potential-factor]
  (not= 0 (mod potential-factor current-prime)))

(defn remove-non-factors
  "returns a vector of numbers in <potential-factors>
   that aren't multiples of the given <current-prime>"
  [current-prime potential-factors]
  (filter (partial not-a-factor? current-prime) potential-factors))

(defn lazy-prime-sieve
  "Returns a lazy-sequence of the prime numbers found in a set,
   provided the first number in the set is a known prime."
  [s]
  (let [current-prime (first s)
        potential-factors (rest s)]
    (cons current-prime
      (lazy-seq (lazy-prime-sieve (remove-non-factors current-prime potential-factors))))))

(def primes
  "Since we're feeding a sequence starting with 3
   to the lazy-prime-sieve, we need to insert the
   first prime at the beginning."
  (cons first-prime (lazy-prime-sieve potential-primes)))
