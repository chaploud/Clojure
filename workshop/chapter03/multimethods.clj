(defmulti strike (fn [m] (get m :weapon)))

(ns-unmap 'user 'strike)
(defmulti strike :weapon) ; weapon自体が関数

(defmethod strike :sword
  [{{:keys [:health]} :target}]
  (- health 100))

(defmethod strike :cast-iron-saucepan
  [{{:keys [:health]} :target}]
  (- health 100 (rand-int 50)))

(strike {:weapon :sword,  :target {:health 200}})
(strike {:weapon :cast-iron-saucepan, :target {:health 200}})