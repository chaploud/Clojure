(require '[clojure.string :as str])

;; 標準入力から N を読み取る (この問題では N の値自体は使わない)
(read-line)

;; 標準入力から数列 A を読み取り、整数のベクターに変換
(let [a (-> (read-line)
            (str/split #" ")
            (->> (mapv #(Integer/parseInt %))))]

  ;; partition でサイズ3、ステップ1の部分列を作成し、
  ;; some で各部分列の要素がすべて同じか (apply =) をチェック
  (if (some #(apply = %) (partition 3 1 a))
    ;; 条件を満たす部分列が1つでもあれば "Yes" を出力
    (println "Yes")
    ;; なければ "No" を出力
    (println "No")))