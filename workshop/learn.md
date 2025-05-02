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
