# Calvaについて

## コマンド探索

- Calva Debug:
  - Instrument Top Level Form for Debugging
    - トップレベルの式をデバッグ用にインストゥルメント化する
    - `Ctrl + Alt + C` `I`

- Calva Format:
  - Dedent Line
    - インデントの逆を実行
    - `Shift + Tab`
  - Format and Align Current Form
    - 現在の式を整形・整列
    - `Ctrl + Alt + L`
  - Format Current Form
    - 現在の式を整形
    - `Tab`
  - Indent Line
    - 行をインデント
    - `Ctrl + I`
  - Infer Parens (from the indentation)
    - S式のカッコをインデントから推測して挿入
    - `Ctrl + Alt + P` `I`

- Calva Paredit:
  - Barf Sexp Backward
    - 今いるS式から先頭を吐き出す
    - `Ctrl + Shift + Alt + RightArrow`
  - Barf Sexp Forward
    - 今いるS式から末尾を吐き出す
    - `Ctrl + Alt + ,`
  - Convolute Sexp
    - 今いるS式内のカーソルより前を親S式の先頭に配置し、他も適切に配置
    - `Ctrl + Shift + C`
  - Delete Forward
    - 次の文字を1文字削除
    - `Delete`
  - Drag Sexp Backward
    - 直前のS式をその前のS式の前に移動
    - `Ctrl + Shift + Alt + B`
    - `Alt + UpArrow`
  - Drag Sexp Backward Down
    - 直前のS式を前にあるS式の末尾に入れ込む
    - `Ctrl + Shift + Alt + J`
  - Drag Sexp Backward Up
    - 直前のS式をそれが含まれるカッコの外の前に移動
    - `Ctrl + Shift + Alt + U`
  - Drag Sexp Forward
    - 直前のS式をその後のS式の後に移動
    - `Ctrl + Shift + Alt + F`
    - `Alt + DownArrow`
  - Drag Sexp Forward Down
    - 直前のS式を後にあるS式の先頭に入れ込む
    - `Ctrl + Shift + Alt + D`
  - Drag Sexp Forward Up
    - 直前のS式をそれが含まれるカッコの外の後に移動
    - `Ctrl + Shift + Alt + K`
  - Expand Selection
    - S式のレベル単位で、選択範囲を拡大
    - `Shift + Alt + RightArrow`
  - Force Delete Backward
    - 前の1文字削除
    - `Alt + Backspace`
  - Force Delete Forward
    - 次の1文字削除
    - `Alt + Delete`
  - Join Sexp
    - 2つのS式を一つのS式に結合
    - `Ctrl + Shift + J`
  - Kill/Delete Backward to Start of List
    - カーソル位置からS式内の先頭までを削除
    - `Ctrl + Backspace`
  - Kill/Delete Forward to End of List
    - カーソル位置からS式内の末尾までを削除
    - `Ctrl + Delete`
  - Kill/Delete Left
    - S式の中でカーソルより左をその行で削除
    - `Ctrl + K` `Ctrl + H`
  - Kill/Delete Right
    - S式の中でカーソルより右をその行で削除
    - `Ctrl + K` `Ctrl + K`
  - Kill/Delete Sexp Backward
    - カーソルより前にあるS式を削除
    - `Ctrl + Alt + Backspace`
  - Kill/Delete Sexp Forward
    - カーソルより後にあるS式を削除
    - `Ctrl + Shift + Delete`
  - Move Cursor Backward Down Sexp/Form
    - `Ctrl + Alt + UpArrow`
  - きりがない気がしてきたので、ここまでにしておく(Spacemacsを参考にする)

- Calva: Add Ritch Comment
  - `(comment ...)`を挿入
  - `Ctrl + Alt + R` `C`

- Calva: Clear Inline Evaluation Results
  - インライン評価結果をクリア
  - `Escapte`

- Calva: Connetct to a Running REPL Server in the Project
  - `Ctrl + Alt + C` `Ctrl + Alt + C`
- Calva: Connect to a Running REPL Server, not in the Project
  - `Ctrl + Alt + C` `Alt + C`

- Calva: Copy Last Evaluation Result to Clipboard

- Calva: Evaluate
  - Current Enclosing Form
    - `Ctrl + Shift + Enter`
  - Current Form (or selection, if any)
    - `Ctrl + Enter`
  - Current Form and Replace it with the Result
  - Current Form to Comment
  - Fiddle File for Current File
  - From Start of File to Cursor, Closing Brackets
    - `Ctrl + Shift + Alt + Enter`
  - From Start of List to Cursor, Closing Brackets
    - `Ctrl + Alt + Enter`
  - From Start of Top Level Form to Cursor, Closing Brackets
    - `Shift + ALt + Enter`
  - Selection, Closing Brackets
    - `Ctrl + Alt + Enter`
  - Top Level Form (defun)
    - `Alt + Enter`
  - Top Level Form (defun) to Comment
  - Interrupt Running Evaluations
  - Load/Evaluate Current File and its Requires/Dependencies
    - `Ctrl + Alt + C` `Enter`

- Calva: Open Fiddle File for Current File
  - Fiddle Fileとは、現在接続ているREPLに対して、ちょっとしたコードを実行するためのファイル
- Calva Source File for Current Fiddle File
- Open the REPL Menu (Start/Connect a REPL, etc.)

- Print clojuredocs.org examples to Rich Comment
- Print clojuredocs.org examples to OutputWindow
- Print Last Stcktrace to REPL Window

## 設定探索
