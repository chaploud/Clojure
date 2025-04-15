# Clojure Dartの学習

## Ubuntu上での環境構築

### Flutterのインストール

- Ubuntu 24.04 & Android

```bash
sudo apt-get update -y && sudo apt-get upgrade -y
sudo apt-get install -y curl git unzip xz-utils zip libglu1-mesa
sudo apt-get install libc6:amd64 libstdc++6:amd64 lib32z1 libbz2-1.0:amd64
```

- Android Studio

```bash
sudo apt-get install libc6:i386 libncurses5:i386 libstdc++6:i386 lib32z1 libbz2-1.0:i386
```

- [参考URL](https://developer.android.com/studio/install?hl=ja#linux)
  - ここを参考にインストールする

- VSCodeとの連携

## Mac上での環境構築

### 最初期

- Macのセットアップ
- 最初だけBluetoothでキーボードとタッチパッドを接続
- iCloud連携
- 日本語
- Apple Developer Accountに登録

### 設定変更

- ファイル共有 => ON
- 画面共有(VNC) => ON
- リモートログイン => ON
- 各種、自動でスリープしないための設定に変更
- ホスト名をを好きなものに変更(今後SSH時に使う)

### ソフトウェア

```zsh
# Xcode Command Line Toolsのインストール(後でXCode本体も入れるが、brewのために必要)
xcode-select --install

# GitHubからHomebrew-4.4.29.pkgをダウンロードしてクリック
# Homebrewインストール後、パス通し
echo 'eval "(/opt/homebrew/bin/brew shellenv)"' >> ~/.zprofile

# Rosettaのインストール
# Apple Silicon Macの場合、Rosettaをインストールする必要がある
# Rosettaは、IntelベースのアプリケーションをApple Silicon Macで実行するための互換レイヤー
sudo softwareupdate --install-rosetta --agree-to-license

# Flutter(注: 結局 fvmを利用)
brew install --cask flutter # 後でfvmに変更した
brew install cocoapods

# Google Chrome
brew install --cask google-chrome

# Android Studio
brew install --cask android-studio

# Android Studioを初回起動
# その後、Android SDK Command-line Toolsをポチポチでインストール

# XCode
# App StoreからXCodeをインストール
# XCodeを初回起動

# ここまででAndroidとiOSのエミュレータが使えるようになる
flutter doctor # すべてチェックされているか

# Clojure
brew install clojure
brew install zsh-completions
brew install coreutils # GNUコマンド

# .zshrcや.vimrcをリポジトリクローン後、シンボリックリンクを張る(vim-plug導入)
# GitHub認証用の公開鍵作成・登録

### Flutterの今後のバージョンのため、fvmをインストール
brew tap leoafarias/fvm
brew install fvm
fvm releases # 最新版のリストを表示
fvm global 3.29.3 # グローバルインストール

# .zshrcの設定
# fvm (flutter version manager)
alias flutter="fvm flutter"
alias dart="fvm dart"

# プロジェクト内で使うバージョン指定
fvm use 3.29.3 # プロジェクト内で使うバージョン指定(.fvmが作成される)
```

### 開発フロー

- UbuntuからVSCodeでSSH接続する(初回には`ssh-copy-id`を実行)
- エミュレータ確認のためには、RemminaからVNC接続する
