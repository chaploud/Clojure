;;  "記号で始まる関数・マクロ・スペシャルフォーム・グローバル束縛"

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

;; *supress-read*
;; [グローバル束縛]
;; 重要度: C
;; Reader向けの内部的な実装
*suppress-read*

;; <=
;; [関数]
;; 重要度: A
;; 数値が順に比較して、すべて左が小さいか等しいかどうかを判定する。引数1個だけだと常にtrue。
(<= 1) ;;=> true
(<= 1 2) ;;=> true
(<= 2 1) ;;=> false
(<= 1 2 3) ;;=> true
(<= 1 2 2) ;;=> true
(<= 2 3 1) ;;=> false
(<= 2 2.1) ;;=> true

;; -'
;; [関数]
;; 重要度: B
;; 引数のすべての差を任意精度で計算して返す。1引数の場合は符号を反転して返す。-はアンダーフローする
(-' 1) ;;=> -1
(-' 1 2) ;;=> -1
(-' 1 2 3) ;;=> -4
(-' Long/MIN_VALUE 1) ;;=> -9223372036854775809N
(- Long/MIN_VALUE 1)
;; Execution error (ArithmeticException) at java.lang.Math/subtractExact (Math.java:973).
;; long overflow

;; *
;; [関数]
;; 重要度: A
;; 引数のすべての積を任意精度で計算して返す。0引数の場合は1を返す。*はオーバーフローする
(* 1) ;;=> 1
(* 1 2) ;;=> 2
(* 1 2 3) ;;=> 6
(* 0.5 200) ;;=> 100.0
(* 8 1/2) ;;=> 4N
(* 2 Long/MAX_VALUE)
;; Execution error (ArithmeticException) at java.lang.Math/multiplyExact (Math.java:1032).
;; long overflow

;; *print-length*
;; [グローバル束縛]
;; 重要度: C
;; REPL形式の出力でコレクションの長さを制限する。
(binding [*print-length* 5]
  (prn (range 10)))
;; (0 1 2 3 4 ...)

;; *file*
;; [グローバル束縛]
;; 重要度: B
;; 現在のファイル名を示す。
*file* ;;=> "/home/chaploud/Documents/Clojure/clojuredocs/clojure_core/n0001_symbol.clj"

;; *use-context-classloader*
;; [グローバル束縛]
;; 重要度: C
;; スレッドのコンテキストクラスローダーを使用するかどうかを制御する。
*use-context-classloader* ;;=> true

;; ->
;; [マクロ]
;; 重要度: A
;; 引数を順に関数に適用していく。スレッディング(ファースト)マクロ。前の結果は次のフォームの最初の引数として渡される。
(-> "a b c d"
    .toUpperCase
    (.replace "A" "X")
    (.split " ")) ;;=> ["X", "B", "C", "D"]

;; *err*
;; [グローバル束縛]
;; 重要度: B
;; 標準エラー出力ストリームを示す。
*err* ;;=> #object[java.io.PrintWriter 0xc05802b "java.io.PrintWriter@c05802b"]

;; *default-data-reader-fn*
;; [グローバル束縛]
;; 重要度: C
;; デフォルトのデータリーダー関数を示す。
*default-data-reader-fn* ;;=> nil

;; *allow-unresolved-vars*
;; [グローバル束縛]
;; 重要度: C
;; 未解決の変数を許可するかどうかを制御する。
(binding [*allow-unresolved-vars* true]
  (eval '(def x 10))) ;;=> #'clojure-core.n0001-symbol/x

;; *print-meta*
;; [グローバル束縛]
;; 重要度: C
;; REPL形式の出力でメタデータを表示するかどうかを制御する。
(binding [*print-meta* true]
  (prn ^{:doc "This is a test"} {:a 1, :b 2}))
;; ^{:doc "This is a test"} {:a 1, :b 2}
(prn ^{:doc "This is a test"} {:a 1, :b 2})
;; {:a 1, :b 2}

;; >
;; [関数]
;; 重要度: A
;; 数値が順に比較して、すべて左が大きいかどうかを判定する。引数1個だけだと常にtrue。
(> 1) ;;=> true
(> 1 2) ;;=> false
(> 2 1) ;;=> true
(> 3 2 1) ;;=> true
(> 2 2 1) ;;=> false
(> 2.1 2) ;;=> true
(sort > (vals {:foo 5, :bar 2, :baz 10})) ;;=> (10 5 2)

;; ->VecSeq
;; [マクロ]
;; 重要度: C
;; Positional factory function for class clojure.core.VecSeq.
->VecSeq

;; *compile-files*
;; [グローバル束縛]
;; 重要度: C
;; コンパイルするファイルのリストを示す。
*compile-files* ;;=> false

;; *math-context*
;; [グローバル束縛]
;; 重要度: C
;; 数値計算の精度を制御するためのMathContextを示す。
*math-context* ;;=> nil

;; -
;; [関数]
;; 重要度: A
;; 引数のすべての差を任意精度で計算して返す。1引数の場合は符号を反転して返す。-はアンダーフローする
(- 1) ;;=> -1
(- 1 2) ;;=> -1
(- 1 2 3) ;;=> -4
(- Long/MIN_VALUE 1)
;; Execution error (ArithmeticException) at java.lang.Math/subtractExact (Math.java:973).
;; long overflow

;; *data-readers*
;; [グローバル束縛]
;; 重要度: C
;; データリーダーのマップを示す。
*data-readers*
;; {dbg #'cider.nrepl.middleware.debug/debug-reader,
;;  break #'cider.nrepl.middleware.debug/breakpoint-reader,
;;  break! #'cider.nrepl.middleware.debug/break-on-exception-reader,
;;  dbg! #'cider.nrepl.middleware.debug/debug-on-exception-reader,
;;  light #'cider.nrepl.middleware.enlighten/light-reader}

;; *e
;; [グローバル束縛]
;; 重要度: B
;; 直前の例外スタックトレースを参照する。
(try
  (/ 1 0)
  (catch Exception e
    (prn *e)))
;; #error {:cause "Unable to resolve symbol: *e* in this context"
;;         :via
;;         [{:type clojure.lang.Compiler$CompilerException
;;           :message "Syntax error compiling at (/home/chaploud/Documents/Clojure/clojuredocs/clojure_core/n0001_symbol.clj:285:5)."
;; ......

;; *clojure-version*
;; [グローバル束縛]
;; 重要度: C
;; Clojureのバージョンを示す。
*clojure-version* ;;=> {:major 1, :minor 12, :incremental 0, :qualifier nil}

;; *'
;; [関数]
;; 重要度: B
;; 引数のすべての積を任意精度で計算して返す。0引数の場合は1を返す。*はオーバーフローする
(*') ;;=> 1
(*' 3) ;;=> 3
(*' 2 3.2) ;;=> 6.4
(*' 2 3 4) ;;=> 24
(*' 2 Long/MAX_VALUE) ;;=> 18446744073709551614N
(* 2 Long/MAX_VALUE)
;; Execution error (ArithmeticException) at java.lang.Math/multiplyExact (Math.java:1032).
;; long overflow

;; ->Vec
;; [マクロ]
;; 重要度: C
;; Positional factory function for class clojure.core.Vec
->Vec

;; *unchecked-math*
;; [グローバル束縛]
;; 重要度: C
;; 数値計算でオーバーフローやアンダーフローをチェックするかどうかを制御する。
(unchecked-add Long/MAX_VALUE 1) ;;=> -9223372036854775808(オーバーフローして変な値)
(+ Long/MAX_VALUE 1)
;; Execution error (ArithmeticException) at java.lang.Math/addExact (Math.java:931).
;; long overflow
(set! *unchecked-math* true) ;; 破壊的設定変更
(+ Long/MAX_VALUE 1) ;;=> -9223372036854775808(オーバーフローして変な値)

;; *out*
;; [グローバル束縛]
;; 重要度: B
;; 標準出力ストリームを示す。
*out* ;;=> #object[java.io.PrintWriter 0x4b20f0ce "java.io.PrintWriter@4b20f0ce"]

;; *warn-on-reflection*
;; [グローバル束縛]
;; 重要度: C
;; リフレクション警告を表示するかどうかを制御する。
*warn-on-reflection* ;;=> false

;; *compile