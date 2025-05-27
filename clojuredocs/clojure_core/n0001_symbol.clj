(ns clojure-core.n0001-symbol
  "記号で始まる関数・マクロ・スペシャルフォーム・グローバル束縛")

;; .
;; [スペシャルフォーム]
;; 重要度: A
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
;; 重要度: B
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
;; [グローバル束縛]
;; 重要度: C
;; REPL形式の出力で名前空間マップを表示するかどうかを制御する。
(prn {:num/val 1, :num/name "one"}) ;; #:num{:val 1, :name "one"}
(binding [*print-namespace-maps* false]
  (prn {:num/val 1, :num/name "one"})) ;; {:num/val 1, :num/name "one"}

;; =
;; [関数]
;; 重要度: A
;; 引数のすべてが型も含めて等しいかどうかを判定する。引数1個だけだと常にtrue。
(= 1) ;;=> true
(= 1 1) ;;=> true
(= 1 2) ;;=> false
(= 1/2 2/4 3/6) ;;=> true
(= 1 1.0) ;;=> false

;; <
;; [関数]
;; 重要度: A
;; 数値が順に比較して、すべて左が小さいかどうかを判定する。引数1個だけだと常にtrue。
(< 1) ;;=> true
(< 1 2) ;;=> true
(< 2 1) ;;=> false
(< 1 2 3) ;;=> true
(< 2 3 1) ;;=> false
(< 2 2.1) ;;=> true

;; *source-path*
;; [グローバル束縛]
;; 重要度: C
;; コンパイルパス
(binding [*compile-path* "."]
  (compile 'clojure-core.n0001-symbol))

;; ..
;; [マクロ]
;; 重要度: B
;; メソッドチェーン(2回)
(.. "fooBAR" toLowerCase (contains "ooba")) ;;=> true

;; *command-line-args*
;; [グローバル束縛]
;; 重要度: C
;; コマンドライン引数
(doseq [arg *command-line-args*]
  (printf "arg='%s'\n" arg))
;; $ clojure n0001_symbol.clj  xxx yyy
;; arg='xxx'
;; arg='yyy'

;; -cache-protocol-fn
;; [関数]
;; 重要度: C
;; (内部実装)プロトコルのメソッドをキャッシュする。
-cache-protocol-fn

;; *read-eval*
;; [グローバル束縛]
;; 重要度: C
;; 読み込み時にevalを有効にするかどうかを制御する。(デフォルト: true)
(binding [*read-eval* false]
  (read-string "(def x 3)")) ;;=> (def x 3)
x ;; Unable to resolve symbol: x in this context

;; *1, *2, *3
;; [グローバル束縛]
;; 重要度: B
;; 直前の評価結果を参照する。
;; *1は直前の評価結果、*2はその前の評価結果、*3はその前の評価結果を参照する。
*1
*2
*3

;; -reset-methods
;; [関数]
;; 重要度: C
;; (内部実装)メソッドをリセットする。
-reset-methods

;; *verbose-defrecords*
;; [グローバル束縛]
;; 重要度: C
;; defrecordの定義時に、フィールドの型を表示するかどうかを制御する。
(binding [*verbose-defrecords* true]
  (defrecord Person [name age])) ;;=> clojure_core.n0001_symbol/Person

;; *print-level*
;; [グローバル束縛]
;; 重要度: C
;; REPL形式の出力でネストの深さを制限する。
(binding [*print-level* 2]
  (prn {:a 1, :b {:c 2, :d {:e 3}}}))
;; {:a 1, :b {:c 2, :d #}}