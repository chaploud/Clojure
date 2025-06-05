 (defn hello
  [name]
  (let [today (java.time.LocalDate/now)]
    #break
     (str "Hello, "
          name
          "! ("
          (.toString today)
          ")")))

(defn print-nums [n]
  (dotimes [i n]
    #break ^{:break/when (= i 7)}
     (prn i)))

(defn print-nums [n]
  (dotimes [i n]
    #break ^{:break/when (= i 7)}
     (prn i)))

(let [name "chaploud"]
  (println "Hello" name))