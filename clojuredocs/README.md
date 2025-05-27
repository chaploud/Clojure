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
