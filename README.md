# Clojureの学習リポジトリ

## インストール

- Ubuntu 24.04 LTSの場合

```bash
curl -L -O https://github.com/clojure/brew-install/releases/latest/download/linux-install.sh
chmod +x linux-install.sh
sudo ./linux-install.sh```
```

```text
Installing libs into /usr/local/lib/clojure
Installing clojure and clj into /usr/local/bin
Installing man pages into /usr/local/share/man/man1
```

## 拡張子

- `.clj` : Clojureのソースコード
- `.cljs` : ClojureScriptのソースコード
- `.cljc` : ClojureとClojureScriptの両方で使えるソースコード
- `.edn` : Clojureのデータフォーマット

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

### 基本動作

- インラインコード評価
- Pareditによる構造を保ったままの編集
- コードフォーマット
- コードナビゲーション(定義ジャンプ)
- デバッガー
- リント
- シンタックスハイライト
- Clojureの機能に準じたレインボーブラケット
- テストランナー
- リファクタリング

### コマンドの確認

### 設定項目の確認

### Vimとの親和性を高める

- コマンド実行
- 移動
- Paredit

## 情報源

- [Clojure公式サイト](https://clojure.org/)
- [Calva(VSCode拡張)](https://calva.io/)
