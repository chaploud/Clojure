(ns mini.playground)

; This project has custom configuration.
; See .vscode/settings.json

; If you are new to Calva, you may want to use the command:
; Calva: Create a “Getting Started” REPL project
; which creates a project with a an interactive Calva (and Clojure) guide.

;; ===== Syntax =====

;; Literals

; 64-bit integer
42
; Arbitrary precision integer
42N
; Binary
2r101010
; Octal
052
; Hexadecimal
0x2A
; Ratio
22/7
; 64-bit float
-1.5
; Arbitrary precision float
-1.5M
; positive infinity
##Inf
; negative infinity
##-Inf
; Not a Number
##NaN

;; Character types

; string
"hello"
; character
\e
; regular expression
#"[0-9]+"  ; => Java.util.regex.Pattern
; special named characters
\newline
\space
\tab
; Unicode characters「あ」
\u3042

;; Symbols and idents
map ;;=> #function[clojure.core/map]
+ ;;=> #function[clojure.core/+]
clojure.core/+ ;;=> #function[clojure.core/+]
nil ;;=> nil
true ;;=> true
false ;;=> false
:alpha ;;=> :alpha
:release/alpha ;;=> :release/alpha
;; スラッシュで名前空間を区切ることができる

;; Literal Collections
; List
'(1 2 3)
; Vector
[1 2 3]
; Set
#{1 2 3}
; Map
{:a 1, :b 2}

; S-expressions
(+ 1 2)

; quote
'x
'(1 2)

;; REPL
(+ 3 4)
*1
*2
*3
(+ *1 *2)

(require '[clojure.repl :refer :all])
(doc doc)
