# The Clojure Workshop

## 感想

- Clojureの構造はとても美しい!

## REPL

- `*1`, `*2`, `*3`: 評価履歴の参照
- `*e`: 直前のスタックトレース
- `(doc SYMBOL)`: ドキュメントの表示
- `(find-doc #"(?i)hoge")`: ドキュメントの検索
- `(apropos "keyword")`: 関数名の検索

## Evaluation of Clojure Code

- `form`
- `expression`
- よく同じ意味で使われるが、Clojureにおいては
  - 「スペシャルフォームやマクロによる特別な処理を受けないすべてのフォーム(form)は、コンパイラによって式(expression)とみなされ、評価されて値を返します」

## Basic Special Forms

- 関数では表現しきれないものがスペシャルフォーム(orマクロ)
- それぞれ特別な評価ルールを持つ
- 変数ではないので変数(variables)ではなく束縛(bindings)と呼ぶ

- `do`
- `if`
- `when`: `if + do`マクロ trueの場合は連続する式を順次評価して最後の評価値を返す
- `def`: globalな束縛(binding), 常にグローバルスコープを束縛する
- `let`: localな束縛(binding) + do
- `fn`
- `defn`: `def` + `fn`マクロ

## Truthy / Falsey

- `nil`と`false`以外はtruthy => シンプル!
  - 他言語ではfalseyな`[]`や`0`や`""`などはすべてtruthy
  - 空リスト`'()`もtruthyなのには他のLispとの違いに注意

## Comparison

- Clojureでは基本的にequalityで比較
- identityで比較したい場合は`identical?`を使う

## Immutability (Persistent Data Structures)

- メモリもCPUも大幅に性能が向上した現在、immutableなデータ構造は利点のほうが多い
- ビデオゲームのようなハイパフォーマンスが要求される場合以外では、イミュータブルなデータ構造の受け渡し処理で多少のパフォーマンスの低下があっても気にならない

## Data Types

### String

- `java.lang.String`: `(type "hello")`
- `java.lang.Character`: `(type \h)`
- ClojureScriptではchar型はなく、String型のみ

### Number

- `java.lang.Long`: `(type 2)`
- `java.lang.BigInt`: `(type 2N)`
- `clojure.lang.Ratio`: `(type 1/2)`
- floating-pointは伝染していく
- `java.lang.Double`: `(type 1.0)`
- `java.math.BigDecimal`: `(type 1.0M)`
- ClojureScriptはNumber型のみ

## 出現したシンタックス・関数・マクロ・スペシャルフォーム

### シンタックス

- `"hello"`: 文字列リテラル
- `2`: 整数リテラル
- `true` `false`: 真偽値リテラル
- `nil`: nil(何もない)リテラル
- `'()`: クォートされたリスト
- `[]`: ベクタ
- falsyなのは`nil`と`false`だけでその他はいかなるものもすべてtruthy

### REPL専用

- `*1`, `*2`, `*3`: 評価履歴の参照
- `*e`: 直前のスタックトレース
- `doc`: ドキュメントの表示
- `find-doc`: ドキュメントの検索
- `apropos`: 関数名の検索
- `dir`: 名前空間の関数等の一覧表示

### スペシャルフォーム

- `(if true 1 2)`: 条件分岐, trueで1, falseで2を返す
- `(do (* 3 4) (+ 1 2))`: 複数式を順次評価して最後の評価値を返す
- `(def x 10)`: グローバルな束縛
- `(let [x 10 y 20]  (str x " and " y))`: ローカルな束縛, `let`の中で束縛された変数は`let`の外では参照できない
- `(fn [x] (* x x))`: 無名関数

### マクロ

#### clojure.core(マクロ)

- `(when true (* 3 4) (+ 1 2))`: `if`+`do`, true時順次評価, 最後の評価値を返す, false時はnilを返す
- `(defn name "doc" [args] body)`: `def`+`fn`, 関数定義, 様々な機能
- `(and (= 1 1) (= 2 2))`: falsyを含む=>その評価値(false/nil), truthyな間順次評価し最後の評価値を返す
- `(or (= 1 1) (= 2 2))`: falsyな間順次評価し最初のtruthyな評価値を返す. 最後までなければ最後の評価値を返す(false/nil)
- `(cond (true? x) 1 (false? x) 2 (nil? x) 3)`: リッチな条件分岐

### 関数

#### clojure.core(関数)

- `+`: 加算
- `-`: 減算
- `*`: 乗算
- `/`: 除算, 分数を表現できる
- `println`: 改行付き出力
- `inc`: インクリメント
- `str`: 文字列化
- `mod`: 剰余
- `rand`: 乱数生成(0～1)
- `true?`: trueかどうか
- `false?`: falseかどうか
- `nil?`: nilかどうか
- `=`: 等価
- `<`: 小なり
- `<=`: 小なりイコール
- `>`: 大なり
- `>=`: 大なりイコール
- `not`: 否定
- `int`: 整数化
- `char-array`: 文字列を`java.lang.Character`の配列に変換
- `first`: seqの先頭要素を取得
- `last`: seqの末尾要素を取得

#### clojure.string

- `clojure.string/upper-case`: 大文字化
- `clojure.string/capitalize`: 先頭大文字化
- `clojure.string/reverse`: 逆順
- `clojure.string/replace`: 置換
- `clojure.string/includes?`: 文字列に文字列が含まれているか

#### java.lang

- `System/exit`: プロセス終了
- `Math/PI`: 円周率
- `Math/random`: 乱数生成(0～1)
- `Math/sqrt`: 平方根
- `Math/round`: 四捨五入
- `Math/pow`: 指数
