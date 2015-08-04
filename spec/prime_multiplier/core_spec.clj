(ns prime-multiplier.core-spec
  (:require [speclj.core :refer :all]
            [prime-multiplier.core :refer :all]))

(describe "main"
          (it "returns nil when no args given"
              (should= nil (-main)))
          (it "returns [\"arg1\"] when given \"arg1\""
              (should= (list "arg1") (-main "arg1")))
          (it "returns [\"arg1\" \"arg2\"] when given \"arg1\" \"arg2\""
              (should= (list "arg1" "arg2") (-main "arg1" "arg2")))
          (it "returns [arg1 arg2] when given arg1"
              (should= (list 'arg1 'arg2) (-main 'arg1 'arg2))))

(run-specs)