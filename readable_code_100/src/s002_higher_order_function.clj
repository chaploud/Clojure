(ns s002-higher-order-function)

;;; ===== 良い例 =====
;; 高階関数を使用した例
(defn apply-to-each [f coll]
  ;; コレクションの各要素に関数を適用する
  (map f coll))
(defn square [x]
  (* x x))
(def numbers-1 [1 2 3 4 5])

(def squared-numbers-1 (apply-to-each square numbers-1))
squared-numbers-1


;;; ===== 悪い例 =====
;; 高階関数を使用しない例
(defn square-each [coll]
  ;; コレクションの各要素を自前で2乗する
  (map (fn [x] (* x x)) coll))

(def numbers-2 [1 2 3 4 5])
(def squared-numbers-2 (square-each numbers-2))
squared-numbers-2

;; [TIPS]
;; Clojureの高階関数は、他の関数を引数として受け取ることができる関数です。
;; map, filter, reduceなどが標準ライブラリに含まれています。
