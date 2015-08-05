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

## Running

### With Leiningen
### Using `lein run`
Running without options produces a table of the products of the first ten prime numbers:
`$ lein run`

Running with options allows you to choose the `header` as well as the `numbers` to be multiplied:
`$ lein run <header> <numbers>`

For example:

`lein run "header" 1 "2" 3` works fine

`lein run header 1 2 3` works fine too.

So does `lein run :header 1 2 3`

The `header` can be given as a `"quoted-string"`, `:keyword`, or `un-quoted-string`. 

The `numbers` can be quoted (`"1"`) or unquoted (`1`) and will be parsed if necessary. 

## Running Tests (Specs)

### With Leiningen
Speclj includes a Leiningen task.

`$ lein spec`

### Using `lein run`
Speclj also includes a Clojure main namespace:

`$ lein run -m speclj.main`

### As a Java command
And sometimes it's just easier to run a Java command, like from an IDE.

`$ java -cp <...> speclj.main`

```
$ java -cp `lein classpath` speclj.main
```