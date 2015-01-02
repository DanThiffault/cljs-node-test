(ns app.core)

(defn- abs [a] (if (neg? a) (- a) a))

(defn add-abs
  [a b]
  (+ (abs a) (abs b)))
