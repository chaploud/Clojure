# Clojureの学習リポジトリ

## インストール

- Ubuntu 24.04 LTSの場合

```bash
sudo apt install clojure
```

## Calva

### プロジェクト作成

- VSCodeのClojure拡張機能
- `Calva: Create a Getting Started REPL project`
  - 説明用のプロジェクトを作成
- `Calva: Create a mini Clojure project`
  - ミニマルな説明用プロジェクトを作成
- 実際は[`dep-new`](https://github.com/seancorfield/deps-new) を導入して利用するとよい

### REPLへの接続

- `.clj` と `.cljs` どちらも対応している
- 以下の設定に対応
  - Leiningen
  - deps.edn
  - shadow-cljs
  - Gradle
- とりあえずプロジェクトを開いたらまずやることはREPLへのJack-in

### コマンド

- `Ctrl + Enter` でカーソル直前の式を評価(Vimとちょっと相性悪い)
- `Alt + Enter` で今いるところのトップレベルの式を評価(これはしょっちゅう使いそう)

## 情報源

- [Clojure公式サイト](https://clojure.org/)
- [Calva(VSCode拡張)](https://calva.io/)
