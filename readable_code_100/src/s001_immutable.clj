(ns s001-immutable)

;;; ===== 良い例 =====
;; イミュータブルなデータ構造を使用した例
(defn add-element [coll element]
  ;; 新しいコレクションを返す
  (conj coll element))

(def original-coll-1 [1 2 3])
(def new-coll (add-element original-coll-1 4))

;; 元のコレクションは変更されない
original-coll-1
new-coll

;;; ===== 悪い例 =====
;; ミュータブルなデータ構造を使用した例
(defn add-element! [coll element]
  ;; 元のコレクションを変更する
  (conj! coll element))
(def original-coll-2 (transient [1 2 3]))
(add-element! original-coll-2 4)

;; 元のコレクションは変更される
(persistent! original-coll-2)

;; [TIPS]
;; Clojureのデータ構造(リスト、ベクタ、セット、マップなど)はイミュータブルです。
