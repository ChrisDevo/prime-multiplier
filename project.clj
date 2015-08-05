(defproject prime-multiplier "0.1.0-SNAPSHOT"
  :description "It's a solution to a code challenge, requiring a program:
                  * that prints out a multiplication table of the first 10 prime number
                  * that must run from the command line and print one table to STDOUT
                  * where the first row and column of the table should have the 10 primes,
                    with each cell containing the product of the primes for the corresponding row and column\n"
  :url "https://github.com/ChrisDevo/prime-multiplier"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]]
  :test-paths ["spec"]
  :aot :all
  :main prime_multiplier.core)
