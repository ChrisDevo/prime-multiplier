# prime-multiplier

### It's a solution to a code challenge, requiring a program:
* that prints out a multiplication table of the first 10 prime numbers
* that must run from the command line and print one table to STDOUT
* where the first row and column of the table should have the 10 primes, with each cell containing the product of the primes for the corresponding row and column

### Considerations:
* Complexity: How fast does your code run? How does it scale?
* Consider cases where we want *N* primes.
* Do not use the Prime class from stdlib (write your own code).
* Write tests. Try to demonstrate TDD/BDD

# Implementation
## Clojure
This is primarily written in [Clojure](http://clojure.org/).

It uses [Leiningen](http://leiningen.org/) for project automation.

Tests are written using [Speclj](https://github.com/slagyr/speclj).