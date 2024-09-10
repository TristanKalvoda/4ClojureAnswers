(ns mini.playground 
  (:require [clojure.string :as str]))

;Problem 16: Hello World
(defn Answer16[x] (str "Hello, " x "!"))
(= (Answer16 "Dave") "Hello, Dave!")
(= (Answer16 "Jenn") "Hello, Jenn!")
(= (Answer16 "Rhea") "Hello, Rhea!")

;Problem 19: Last Element
(defn Answer19[x]
  (loop [lst x]
    (if (empty? (rest lst))
      (first lst)
    (recur (rest lst)))))
(= (Answer19 [1 2 3 4 5]) 5)
(= (Answer19 '(5 4 3)) 3)
(= (Answer19 ["b" "c" "d"]) "d")

;Problem 20: Penultimate Element
(defn Answer20[x]
  (loop [lst x]
    (if (empty? (rest (rest lst)))
      (first lst)
      (recur (rest lst)))))
(= (Answer20 (list 1 2 3 4 5)) 4)
(= (Answer20 ["a" "b" "c"]) "b")
(= (Answer20 [[1 2] [3 4]]) [1 2])

;Problem 21: Nth Element
(defn Answer21 [lst n]
  (loop [x lst
         n n]
    (if (= n 0)
      (first x)
      (recur (rest x) (- n 1)))))
(= (Answer21 '(4 5 6 7) 2) 6)
(= (Answer21 [:a :b :c] 0) :a)
(= (Answer21 [1 2 3 4] 1) 2)
(= (Answer21 '([1 2] [3 4] [5 6]) 2) [5 6])

;Problem 22: Count Elements
(defn Answer22 [x]
  (reduce (fn [count y] (inc count)) 0 x))
(= (Answer22 '(1 2 3 3 1)) 5)
(= (Answer22 "Hello World") 11)
(= (Answer22 [[1 2] [3 4] [5 6]]) 3)
(= (Answer22 '(13)) 1)
(= (Answer22 '(:a :b :c)) 3)

;Problem 26: Fibonacci Sequence
(defn Answer26 [x]
  (loop [n x
         a 0
         b 1
         result []]
    (if (= n 0)
      result
    (recur (- n 1) b (+ a b) (conj result b)))))
(= (Answer26 3) '(1 1 2))
(= (Answer26 6) '(1 1 2 3 5 8))
(= (Answer26 8) '(1 1 2 3 5 8 13 21))

;Problem 38: Maximum Value
;chose this problem to test out the let statement
(defn Answer38 [& x]
  (if (empty? x)
    nil
    (loop [lst (rest x)
           max (first x)]
      (if (empty? lst)
        max
        (let [current (first lst)]
          (if (> current max)
            (recur (rest lst) current)
            (recur (rest lst) max)))))))
(= (Answer38 45 67 11) 67)
(= (Answer38 1 8 3 4) 8)
(= (Answer38 30 20) 30)

;Problem 70: Word Sorting
;chose this problem to use reduce, as well as regular expressions and strings
(require '[clojure.string :as str])
(defn Answer70 [x]
  (into [] (sort-by #(str/lower-case %) (re-seq #"\w+" x))))
(= (Answer70  "Have a nice day.")
   ["a" "day" "Have" "nice"])
(= (Answer70  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])
(= (Answer70  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])