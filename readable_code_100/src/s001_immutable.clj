(ns s001-immutable)

;;; ===== 良い例 =====
;; イミュータブルなデータ構造を使用した例
(defn add-element [coll element]
  ;; 新しいコレクションを返す
  (conj coll element))

(def original-coll [1 2 3])
(def new-coll (add-element original-coll 4))

(println "Original collection:" original-coll)
(println "New collection:" new-coll)
