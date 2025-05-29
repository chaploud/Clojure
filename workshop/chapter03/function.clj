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