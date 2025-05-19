;; Activity 2.01: Creating a Simple In-Memory Database
(def memory-db (atom {}))
(defn read-db [] @memory-db)
(defn write-db [new-db] (reset! memory-db new-db))

;; create-table
(defn create-table
  [table-name]
  (let [db (read-db)
        new-table {:data [] :indexes {}}]
    (if (contains? db table-name)
      (println "Table already exists.")
      (do
        (swap! memory-db assoc table-name new-table)
        (println "Table created.")))))

(create-table :clients)
(create-table :fruits)
(read-db)