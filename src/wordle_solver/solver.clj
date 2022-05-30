(ns wordle-solver.solver
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as str]))

(def dictionary
  (filter
   #(= (count %) 5)
   (str/split-lines
    (slurp
     (io/resource "words_alpha.txt")))))

(defn letter-not-in-place [pattern]
  (let [pat (re-pattern "\\!(\\w)")
        matches (re-seq pat pattern)
        groups (map first (map #(drop 1 %) matches))]
    groups))

(defn not-in-place-pattern [pattern]
  (let [pat (re-pattern "\\!(\\w)")
        matches (re-seq pat pattern)
        groups (map first (map #(drop 1 %) matches))]
    (reduce
     #(str/replace-first %1 (re-pattern "\\!(\\w)") (str "[^" %2 "]"))
     pattern
     groups)))

(defn translate-pattern [pattern]
 (->
  (str/replace pattern "*" "\\w")
  (not-in-place-pattern)))

(defn contains-letters [letters input]
  (every? #(some (set input) (str %)) letters))

(defn solve-for [pattern exclude]
  (->>
   dictionary
   (filter
    #(not (some (set exclude) %)))
   (filter
       #(re-find (re-pattern (translate-pattern pattern)) %))
   (filter #(contains-letters (apply str (letter-not-in-place pattern)) %))))

(defn parse-nonexistent [input]
  (let [m (re-matcher (re-pattern "\\[(\\w+)\\]") input)]
    (re-find m)
    (second (re-groups m))))

(defn parse-pattern [input]
  (let [m (re-matcher (re-pattern "(.+)\\[") input)]
    (re-find m)
    (second (re-groups m))))