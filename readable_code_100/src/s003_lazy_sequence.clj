(ns s003-lazy-sequence)

;;; ===== 良い例 =====
;; 遅延シーケンスを使用した大規模データ処理
(defn process-large-data [data]
  ;; map, filter, takeなどの遅延シーケンス操作を使用
  (->> data
       (map #(* % 2))
       (filter even?)
       (take 100)))

(def large-data (range 1000000))

(process-large-data large-data)


;;; ===== 悪い例 =====
;; 遅延シーケンスを使用しない大規模データ処理
(defn process-large-data-bad [data]
  (let [processed (map #(* % 2) data)
        filtered (filter even? processed)]
    (take 100 filtered)))

(def large-data-bad (range 1000000))

(process-large-data-bad large-data-bad)

;; [TIPS]
;; 遅延シーケンスで必要なときに初めて計算を行うようにしよう
