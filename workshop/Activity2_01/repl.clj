;; Activity 2.01: Creating a Simple In-Memory Database
(def memory-db (atom {:clients {:data [{:id 1, :name "Bob", :age 30}
                                       {:id 2, :name "Alice", :age 24}]
                                :indexes {:id {1 0, 2 1}}}
                      :fruits {:data [{:name "Lemon" :stock 10}
                                      {:name "Coconut" :stock 3}]
                               :indexes {:name {"Lemon" 0, "Coconut" 1}}}
                      :purchases {:data [{:id 1, :user-id 1, :item "Coconut"}
                                         {:id 2, :user-id 2, :item "Lemon"}]
                                  :indexes {:id {1 0, 2 1}}}}))
(defn read-db [] @memory-db)
(defn write-db [new-db] (reset! memory-db new-db))

(read-db)
(def sample-new-db
  {:clients {:data [{:id 1, :name "Bob", :age 31}
                    {:id 2, :name "Alice", :age 25}]
             :indexes {:id {1 0, 2 1}}}
   :fruits {:data [{:name "Lemon" :stock 10}
                   {:name "Coconut" :stock 3}]
            :indexes {:name {"Lemon" 0, "Coconut" 1}}}
   :purchases {:data [{:id 1, :user-id 1, :item "Coconut"}
                      {:id 2, :user-id 2, :item "Lemon"}]
               :indexes {:id {1 0, 2 1}}}})
(write-db sample-new-db)
(read-db)