(ns de.friemen.samples.awesome)

(defn hello-world [] 
  (println "Hello World"))

(defn map-inc
  [ints]
  (map inc ints))

(defn sum-by 
  [f employees]
  (reduce (fn [sums e]
            (update-in sums [(f e)] #(+ (or % 0) (:salary e))))
         {}
         employees))