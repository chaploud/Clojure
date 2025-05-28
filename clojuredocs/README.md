# Clojure Docs

[Clojure Docs](https://clojuredocs.org/core-library/vars)を手元で実際に動かしてみる

## 重要度

- A: 必須級
- B: 普通
- C: 参考

## clojure.core

- [0001_symbol.clj](./clojure_core/0001_symbol.clj)
  - A `.`: Javaメンバへのアクセス
  - B `+'`: 数値の加算(任意精度・遅い)
  - C `*print-namespace-maps*`: REPLプリントで名前空間を表示するかどうか
  - A `=`: オブジェクトの等価性を比較(型一致)
  - A `<`: 小なり
  - C `*source-path*`: ソースパスの設定
  - B `..`: メソッドチェーン
  - C `*command-line-args*`: コマンドライン引数が格納
  - C `-cache-protocols`: プロトコルのキャッシュ(内部実装)
  - C `*read-eval*`: REPLでの評価を制御する
  - B `*1`, `*2`, `*3`: REPLの直前の評価結果を参照
  - C `-reset-methods`: メソッドのリセット(内部実装)
  - C `*verbose-defrecords*`: defrecordの詳細な出力を制御
  - C `*print-level*`: プリントのネストレベルを制御
  - C `*supress-read`: REPLでの読み取りを抑制(内部実装)
  - A `<=`: 小なりイコール
  - B `-'`: 数値の減算(任意精度・遅い)
  - A `*`: 乗算(オーバーフローする)
  - C `*print-length*`: プリントの長さを制御
  - B `*file*`: 現在のファイル名を取得
  - C `*use-context-classloader*`: コンテキストクラスローダーの使用を制御
  - A `->`: スレッドマクロ, 引数を最初の位置に移動
  - B `*err*`: 標準エラー出力を取得
  - C `*default-data-reader-fn*`: データリーダー関数のデフォルトを設定
  - C `*allow-unresolved-vars*`: 未解決の変数を許可するかどうか
  - C `*print-meta*`: メタデータのプリントを制御
  - A `>`: 大なり
  - C `->VecSec`: スレッドマクロ, ベクタを作成
  - C `*compile-files*`: コンパイルされたファイルのリストを取得
  - C `*math-context*`: 数値計算の精度の制御
  - A `-`: 数値の減算(アンダーフローする)
  - C `*data-readers*`: データリーダーのマップを取得
  - B `*e`: 直前のスタックトレースを取得
  - C `*clojure-version*`: Clojureのバージョンを取得
  - B `*'`: 数値の積(任意制度・遅い)
  - C `->Vec`: スレッドマクロ, ベクタを作成
  - C `*unchecked-math*`: オーバーフローをチェックするかどうか
  - B `*out*`: 標準出力を取得
