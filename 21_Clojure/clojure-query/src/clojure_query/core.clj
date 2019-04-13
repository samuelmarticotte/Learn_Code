(ns clojure-query.core
  (:require [clojure.java.io :as io]))

(defn banner [title]
  (println "==================================\\n" title "\\n=================================="))
(defn usage [message]
  (println "Usage:\n" message))
;;============================READ AND CLEAN DATA
(defn clean [strings noise]
  ;;remove noise from list of strings
  (for [s strings]
                (-> s ((apply comp
                              (for [n noise] #(.replace %1 n "")))))))
;;============================QUESTIONS

(defn ask-question [question ans-one ans-two]
  ;;ask a question, takes two possible answers and returns one.
  (def ans "?")
  (while (and (not= ans ans-one) (not= ans ans-two))        ;;while not one answer or the other
    (println question)
    (def ans (read-line)))
  ans)

;;============================MAIN DEF
(defn -main []
  (banner "Welcome to BELL QUICK QUERY MAKER")
  (usage "Supply a list of iocs called list.txt")
  (def iocs (clojure.string/split-lines (slurp "C:\\Users\\samuel.marticotte\\Desktop\\5_Development\\clojure-query\\resources\\list.txt")))
  ;(def regex-noregex (ask-question "Do you want some regexes? (y/n): " "y" "n"))
  ;(def clean-yes-clean-no (ask-question "Do you want to clean some characters? (y/n): " "y" "n"))
  ;(if (= clean-yes-clean-no "y")(println (clean iocs ["!" "$" "/"])))
  (def and-or (ask-question "Do you want AND or OR:" "AND" "OR"))
  (if (= and-or "AND")
    (println (interpose "AND" (clean iocs ["!" "$" "/"])))
    (println (interpose "OR" (clean iocs ["!" "$" "/"])))))

;;============================MAIN RUN
(-main)



