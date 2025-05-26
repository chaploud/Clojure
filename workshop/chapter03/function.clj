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