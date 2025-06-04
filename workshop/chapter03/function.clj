(ns workshop.chapter03.function
  (:require [clojure.string]))

(defn welcome
  [player & friends]
  (println (str "Welcom to the Parenthmazes " player "!"))
  (when (seq friends)
    (println (str "Sending "
                  (count friends)
                  " friend request(s) to the following players: "
                  (clojure.string/join ", " friends)))))

(welcome "John")
(welcome "John" "Alice" "Bob" "Charlie")

(defn welcome
  ([player] (println (str "Welcom to the Parenthmazes (single-player mode), " player "!")))
  ([player & friends]
   (println (str "Welcom to the Parenthmazes (multi-player mode)" player "!"))
   (when (seq friends)
     (println (str "Sending "
                   (count friends)
                   " friend request(s) to the following players: "
                   (clojure.string/join ", " friends))))))

;; First-Class Functions
(update {:item "Tomato" :price 1.0} :price (fn [x] (/ x 2)))
(update {:item "Tomato" :price 1.0} :price / 2)
(update {:item "Tomato" :fruit false} :fruit not)

(defn operate [f x] (f x))
(operate inc 5) ;;=> 6

(defn operate [f & args] (f args))
(operate + 1 2 3)
;; Execution error (ClassCastException) at java.lang.Class/cast (Class.java:4067).
;; Cannot cast clojure.lang.ArraySeq to java.lang.Number

;; (+ [1 2 3]) のような状況になっている

(apply + [1 2 3]) ;;=> 6

(defn operate [f & args] (apply f args))
(operate + 1 2 3)

(defn random-fn [] (first (shuffle [+ - * /])))
(random-fn)
((random-fn) 2 4) ;;=> -2
;; 評価されないと
(fn? random-fn) ;;=> true
(fn? (random-fn)) ;;=> true

(let [mysterious-fn (random-fn)]
  (mysterious-fn 3 7))

(def marketing-adder (partial + 0.99)) ;; 引数1つ固定(defnではなくdef)
(marketing-adder 10 5)

(def format-price (partial str "€"))
(format-price "100")
(format-price 10 50)

(defn sample [coll] (first (shuffle coll)))
(sample [1 2 3 4])

(def sample (comp first shuffle))
(sample [1 2 3 4])

((comp inc *) 2 2)
((comp * inc) 2 2)
; Execution error (ArityException) at workshop.chapter03.function/eval10950 (REPL:70).
; Wrong number of args (2) passed to: clojure.core/inc

(def checkout (comp (partial str "Only ") format-price marketing-adder))
(checkout 10 5 15 6 9)

;; Multimethods