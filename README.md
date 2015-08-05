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

It uses [Leiningen](https://github.com/technomancy/leiningen) for project automation. Go there for installation instructions.

Tests are written using [Speclj](https://github.com/slagyr/speclj).

## Running

### With Leiningen

Install Leiningen using the instructions in the link above.

Before running the app using *Leiningen*, run the following command form the project root:

`lein deps`

This will cause Leiningen to update all the dependencies listed in the project.clj file.

### Using `lein run`
Running without options produces a table of the products of the first ten prime numbers:
`$ lein run`

Running with an argument allows you to choose the number of primes to be multiplied:
`$ lein run <n-primes>`

For example:

`$ lein run 10` works fine

`$ lein run "10"` works fine too.

`n-primes` can be quoted `"10"` or unquoted `10` and will be parsed if necessary. 

### Using `lein uberjar`
You can create a runnable jar using:

`$ lein uberjar`
 
 You can then run it like any other Java app:

`$ java -jar prime-multiplier-0.1.0-SNAPSHOT-standalone.jar`

`$ java -jar prime-multiplier-0.1.0-SNAPSHOT-standalone.jar <n-primes>`

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

## tl;dr
Things to do:

- Improve command line arguments using [clojure.tools/cli](https://github.com/clojure/tools.cli)

- Give it a nice command besides `lein` or `java -jar`, something like `prime-table`

- Package as a [Docker](https://www.docker.com/) app