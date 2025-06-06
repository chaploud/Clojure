# The Clojure Workshop

## 感想

- Clojureの構造はとても美しい!

## REPL

- `*1`, `*2`, `*3`: 評価履歴の参照
- `*e`: 直前のスタックトレース
- `(doc SYMBOL)`: ドキュメントの表示
- `(find-doc #"(?i)hoge")`: ドキュメントの検索
- `(apropos "keyword")`: 関数名の検索
- `(source SYMBOL)`: ソースコードの表示

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

### Boolean

- `java.lang.Boolean`: `(type true)`
  - true/false
- ClojureSctiptではBoolean

### Symbol

- `clojure.lang.Symbol`: `(type 'hello)`
- 束縛された名前など

### Keyword

- `clojure.lang.Keyword`: `(type :hello)`

### Collection

- クラスの肥大化はいいことないぞと
- Clojureにおいては、型は少なく、みんなが知る型のみで操作する

#### Map

- `clojure.lang.PersistentArrayMap`: `(type {:a 1 :b 2})`
  - 挿入順序は保持されない(9個以上だと以下に変わる)
  - `clojure.lang.PersistentHashMap`
- `(get favorite-fruit :name "default")`: マップから値を取得
- `(favorite-fruit :name "default")`: マップから値を取得
- `(:name favorite-fruit "default")`: マップから値を取得
- `(assoc favorite-fruit :shape "egg-like")`: マップに値を追加(非破壊的)
- `(update favorite-fruit :kcal_per_100g dec)`: マップの値を更新(非破壊的)
- `(dissoc favorite-fruit :name)`: マップから値を削除(非破壊的)

#### Set

- `clojure.lang.PersistentHashSet`: `(type #{1 2 3})`
  - 挿入順序を保持しない
- `(currencies :name)`: セットから値を取得
- `(:name currencies "default")`: セットから値を取得
- `(conj currencies :name)`: セットに値を追加(非破壊的)
- `(disj currencies :name)`: セットから値を削除(非破壊的)

#### Vector

- アイテムは末尾に追加していくのが効率的
- `clojure.lang.PersistentVector`: `(type [1 2 3])`
- `(fibonacci 6)`: ベクタから値を取得
- `(conj fibonacci 8)`: ベクタに値を追加(非破壊的)
- `(assoc fibonacci 6 8)`: ベクタの値を更新(インデックス指定)(非破壊的)

#### List

- アイテムは先頭に追加していく
- `clojure.lang.PersistentList`: `(type '(1 2 3))`
- conjすると先頭に追加される
- listは、LinkedListのようなものなので、インデックスによるアクセスはベクタより遅い

## Destructuring

- 順序に従ったデストラクチャリング(Vector)
- キーに従ったデストラクチャリング(Map)

```clojure
;; Vector
; _ 無視
; & xxx 残りをseqに入れる
(let [[a b c _ & rest] [1 2 3 4 5 6]]
  (println a b c rest)) ; 1 2 3 (5 6)

;; List
(let [[a b c] '(1 2 3)]
  (println a b c)) ; 1 2 3

;; 入れ子にもできる
(def flight [[48.9615, 2.4372], [37.742, -25.6976]])
(let [[[lat1 lon1] [lat2 lon2]] flight]
    (println (str "Lat " lat1 " Lon " lon1 " - Lat " lat2 " Lon " lon2)))

;; defnの引数の段階でDestructuringできる
(defn print-flight
  [[[lat1 lon1] [lat2 lon2]]]
  (println (str "Lat " lat1 " Lon " lon1 " - Lat " lat2 " Lon " lon2)))

;; Map
(let [{lat :lat lon :lon} {:lat 35 :lon 135}]
  (println lat lon)) ;; 35 135

(let [{:keys [lat lon]} {:lat 35 :lon 135}]
  (println lat lon)) ;; 35 135

;; 入れ子にもできる
(def flight [{:from {:lat 48.9615 :lon 2.4372},
              :to {:lat 37.742 :lon -25.6976}},
             {:from {:lat 37.742 :lon -25.6976},
              :to {:lat 48.9615 :lon 2.4372}}])
(let [{{lat1 :lat lon1 :lon} :from,
       {lat2 :lat lon2 :lon} :to} flight]
    (println (str "Lat " lat1 " Lon " lon1 " - Lat " lat2 " Lon " lon2)))

;; defnの引数の段階でDestructuringできる
(defn print-mapjet-flight
  [{{lat1 :lat lon1 :lon} :from
    {lat2 :lat lon2 :lon} :to}]
  (println (str "Lat " lat1 " Lon " lon1 " - Lat " lat2 " Lon " lon2)))
```

- デストラクチャリングはVectorとMap入れ子にしてもいい
- letの上から順次パースしていく形でもいいし、 外側から一気に入れ子でパースしてもいい
- 状況に応じて読みやすい方を採用しよう

## アリティオーバーロード

- 引数の数が違う場合は`defn`の引数`[]`とbodyを`()`で囲んだものを複数並べることができる
- アリティ(Arity)に応じて呼び出されるものが変わる

```clojure
(defn overloading
  ([]
   (println "No argument"))
  ([x]
   (println "One argument: " x))
  ([x y]
   (println "Two arguments: " x", " y)))
```

## 引数内のキーワードによる意味

```clojure
(defn strike
  "target引数が1個だけだと、strike関数をtarget :fistsを引数にして呼び出し
  targetとweaponが与えられたとき、:asでtargetとして元のオブジェクトを格納
  targetの:campをcampに、:armorをarmorに格納、armorがnilかなければarmorを0に設定"
  ([target] (strike target :fists))
  ([{:keys [camp armor], :or {armor 0}, :as target} weapon]
   (let [points (weapon weapon-damage)]
     (if (= :gnomes camp)
       (update target :health + points)
       (let [damage (* points (- 1 armor))]
         (update target :health - damage))))))

```

## 第一級関数

- 関数は値として扱える
- 関数を引数に取ることができる
- 関数を返すことができる
- 関数を変数に束縛できる
- 様々な組み込みの高階関数がある

```clojure
(def marketing-adder (partial + 0.99)) ;; 引数1つ固定(defnではなくdef)
(def format-price (partial str "€"))
(def sample (comp first shuffle)) ;; 関数合成
(def checkout (comp (partial str "Only ") format-price marketing-adder))
```

## Multimethods

- Clojureのマルチメソッドは、引数の型や値に応じて異なる実装を呼び出すことができる
- 動的ディスパッチともいう
- `defmulti`: マルチメソッドの定義
- `defmethod`: マルチメソッドの実装を定義

## 出現したシンタックス・関数・マクロ・スペシャルフォーム

### シンタックス

- `"hello"`: 文字列リテラル
- `2`: 整数リテラル
- `true` `false`: 真偽値リテラル
- `nil`: nil(何もない)リテラル
- `'()`: クォートされたリスト
- `[]`: ベクタ
- falsyなのは`nil`と`false`だけでその他はいかなるものもすべてtruthy
- `2N`: BigIntリテラル
- `2.0M`: BigDecimalリテラル
- `\h`: 文字リテラル
- `'hello`: シンボルリテラル
- `:hello`: キーワードリテラル
- `{:a 1 :b 2}`: マップ
- `#{1 2 3}`: セット
- `(:a some-map)`: マップから値を取得
  - `(some-map :a)`: マップから値を取得
- `(:a some-set)`: セットから値を取得
  - `(some-set :a)`: セットから値を取得
- `@memory-db`: アトムの値を取得
- `#(- % 100)`: 無名関数リテラル `= (fn [x] (- x 100))`
- `#(+ %1 %2)`: 無名関数リテラル `= (fn [x y] (+ x y))`
- `#(println %1 %2 %&)`: 無名関数リテラル `= (fn [x y & more] (println x y more))`

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
- `(if-let [x (str "hoge" "fuga")] (println (str "x is " x)) (println "x is falsy"))`

### 関数

#### clojure.core(関数)

- `+`: 加算
- `-`: 減算
- `*`: 乗算
- `/`: 除算, 分数を表現できる
- `println`: 改行付き出力
- `inc`: インクリメント
- `dec`: デクリメント
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
- `subs`: 文字列の部分取得
- `char`: char型に変換
- `count`: 要素数を取得
- `hash-map`: マップを作成(挿入順序を保持しない)
- `get`: マップ・セット・ベクタから値を取得(なければnil)
- `assoc`: マップに値を追加
- `update`: マップの値を更新
- `dissoc`: マップから値を削除
- `hash-set`: セットを作成
- `set`: seqをセット化
- `sorted-set`: キーでソートされたセットを作成
- `contains?`: セット・マップに値が含まれているか
- `conj`: seqに要素を追加
- `disj`: seqから要素を削除
- `vector`: ベクタを作成
- `vec`: seqをベクタ化
- `list`: リストを作成
- `rest`: seqの先頭要素を除いたものを取得
- `nth`: seqのn番目の要素を取得
- `cons`: seqの先頭に要素を追加
- `empty?`: seqが空かどうか
- `seq`: sequenceに変換
- `map`: sequenceに関数を適用
- `filter`: sequenceに関数を適用し、truthyなものを取得
- `reduce`: sequenceに関数を適用し、1つの値にまとめる
- `into`: collectionに別のcollectionを追加
- `concat`: collectionを連結
- `sort`: collectionをソート
- `get-in`: ネストしたマップから値を取得
- `assoc-in`: ネストしたマップに値を結びつける
- `update-in`: ネストしたマップの値を更新
- `pprint`: pretty print
- `set!`: 変数の束縛を変更
- `atom`: メモリ上で常に1つの値を持つ変数を作成
- `reset!`: アトムの値をまるっと与えられた値で上書き
- `swap!`: アトムの値を与えられた関数に与え、その処理結果で上書き
- `apply`: 第1引数に関数を取り、第2引数のコレクションをその関数の引数として展開して与える
- `shuffle`: コレクションの要素をランダムに並び替える
- `fn?`: 引数が関数かどうかを判定
- `partial`: 関数の一部の引数を固定して新しい関数を作成
- `comp`: 複数の関数を合成して新しい関数を作成
- `rand-int`: 整数の乱数を生成
- `identity`: 引数をそのまま返す
- `vals`: マップの値をseqで取得
- `ns-unmap`: 名前空間からシンボルを削除

#### clojure.string

- `clojure.string/upper-case`: 大文字化
- `clojure.string/capitalize`: 先頭大文字化
- `clojure.string/reverse`: 逆順
- `clojure.string/replace`: 置換
- `clojure.string/includes?`: 文字列に文字列が含まれているか
- `clojure.string/split`: 文字列を分割

#### java.lang

- `System/exit`: プロセス終了
- `Math/PI`: 円周率
- `Math/random`: 乱数生成(0～1)
- `Math/sqrt`: 平方根
- `Math/round`: 四捨五入
- `Math/pow`: 指数
- `Integer/parseInt`: 整数化

### グローバル変数・定数

- `*print-level*`: REPLの出力階層レベル
