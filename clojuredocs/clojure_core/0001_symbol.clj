;; .
;; [スペシャルフォーム]
;; Javaメンバへのアクセス
(def date (java.util.Date.)) ;;=> #'user/date
(. date getMonth) ;;=> 4

(import 'java.awt.Point) ;;=> java.awt.Point
(. (Point. 1 2) x) ;;=> 1
(.x (Point. 3 4)) ;;=> 3
(. (Point. 5 6) (getX)) ;;=> 5.0
(.-x (Point. 7 8)) ;;=> 7

;; +'
;; [関数]
;; 引数のすべての和を任意精度で計算して返す。0引数の場合は0を返す。+はオーバーフローする
(+') ;;=> 0
(+' 1) ;;=> 1
(+' 1 2) ;;=> 3
(+' 1 2 3) ;;=> 6
(+ 1 Long/MAX_VALUE)
;; Execution error (ArithmeticException) at java.lang.Math/addExact (Math.java:931).
;; long overflow
(+' 1 Long/MAX_VALUE) ;;=> 9223372036854775808N

;; *print-namespace-maps*
;; [グローバル変数]
;; REPL形式の出力で名前空間マップを表示するかどうかを制御する。
(prn {:num/val 1, :num/name "one"}) ;; #:num{:val 1, :name "one"}
(binding [*print-namespace-maps* false]
  (prn {:num/val 1, :num/name "one"})) ;; {:num/val 1, :num/name "one"}

;; =
;; [関数]
;; 引数のすべてが型も含めて等しいかどうかを判定する。引数1個だけだと常にtrue。
(= 1) ;;=> true
(= 1 1) ;;=> true
(= 1 2) ;;=> false
(= 1/2 2/4 3/6) ;;=> true
(= 1 1.0) ;;=> false