(ns mini.playground)

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
  (loop [lst x
         count 0]
    (if (empty? lst)
      count
      (recur (rest lst) (inc count)))))
(= (Answer22 '(1 2 3 3 1)) 5)
(= (Answer22 "Hello World") 11)
(= (Answer22 [[1 2] [3 4] [5 6]]) 3)
(= (Answer22 '(13)) 1)
(= (Answer22 '(:a :b :c)) 3)