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

;Problem 23: Reverse a Sequence
(defn Problem23 [x]
  (reduce conj '() x))
(= (Problem23 [1 2 3 4 5]) [5 4 3 2 1])
(= (Problem23 (sorted-set 5 7 2 7)) '(7 5 2))
(= (Problem23 [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])

;Problem 24: Sum It All Up
(defn Answer24 [x]
  (reduce + x))
(= (Answer24 [1 2 3]) 6)
(= (Answer24 (list 0 -2 5 5)) 8)
(= (Answer24 #{4 2 1}) 7)
(= (Answer24 '(0 0 -1)) -1)
(= (Answer24 '(1 10 3)) 14)

;Problem 25 Find the odd numbers
(defn Problem25 [x]
  (filter odd? x))
(= (Problem25 #{1 2 3 4 5}) '(1 3 5))
(= (Problem25 [4 2 1 6]) '(1))
(= (Problem25 [2 2 4 6]) '())
(= (Problem25 [1 1 1 3]) '(1 1 1 3))

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

;Problem 30: Compress a Sequence
(defn Answer30 [x]
  (loop [list x
         result []]
    (if (empty? list)
      result
      (let [current (first list)]
        (if (= current (first (rest list)))
          (recur (rest list) result)
          (recur (rest list) (conj result current)))))))
;Problem 30: Compress a Sequence (with reduce)
(defn Answer30 [x]
  (reduce (fn [vec elem]
            (if (= elem (last vec))
              vec
              (conj vec elem)))
          []
          x))
(= (apply str (Answer30 "Leeeeeerrroyyy")) "Leroy")
(= (Answer30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (Answer30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
(Answer30 [1 2 3 3 4 3 5 6 7 8 9])

;Problem 32: Duplicate a Sequence
(defn Answer32 [x]
  (loop [lst x
         result []]
    (if (empty? lst)
      result
      (let [current (first lst)]
        (recur (rest lst) (-> result 
                              (conj current) 
                              (conj current)))))))
;Problem 32: Duplicate a Sequence (with reduce)
(defn Answer32 [x]
  (reduce (fn [vec elem]
            (conj vec elem elem)) [] x))
(= (Answer32 [1 2 3]) '(1 1 2 2 3 3))
(= (Answer32 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (Answer32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (Answer32 [44 33]) [44 44 33 33])

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

;Problem 134: A nil key
(defn Answer134 [x y]
  (if (contains? y x)
    (if (nil? (get y x))
      true
      false)
    false))
(true?  (Answer134 :a {:a nil :b 2}))
(false? (Answer134 :b {:a nil :b 2}))
(false? (Answer134 :c {:a nil :b 2}))

;Problem 156: Map Defaults
(defn Answer156 [x y]
  (reduce (fn [result key] (assoc result key x)) {} y))
(= (Answer156 0 [:a :b :c]) {:a 0 :b 0 :c 0})
(= (Answer156 "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
(= (Answer156 [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})