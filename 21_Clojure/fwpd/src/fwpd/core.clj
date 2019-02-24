(ns fwpd.core)


(def filename "suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
	[s]
	(Integer. (clojure.string/trim s)))

(def conversions {:name identity
				  :glitter-index str->int})

(defn convert 
	[vamp-key value]
	((get conversions vamp-key) value))

(defn parse 
	"Convert a CSV into rows of column"
	[string]
	(map #(clojure.string/split % #",")
		 (clojure.string/split string #"\n")))

(defn mapify 
	"Return a sq of maps  like {:name \"Edward Cullen\" :glitter-index 10}"
	[rows]
	(map (fn [unmapped-row]
		(reduce (fn [row-map [vamp-key value]]
			(assoc row-map vamp-key (convert vamp-key value)))
		{}
		(map vector vamp-keys unmapped-row)))
	rows))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

