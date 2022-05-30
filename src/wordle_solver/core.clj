(ns wordle-solver.core
  (:gen-class)
  (:require [wordle-solver.solver :refer [solve-for
                                          parse-nonexistent
                                          parse-pattern]]))

(defn -main
  [& args]
  (println "Enter pattern:\n")
  (let [input  (read-line)
        pattern (parse-pattern input)
        exclude (parse-nonexistent input)]
    (println (solve-for pattern exclude))))

(-main)

