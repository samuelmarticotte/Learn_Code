(ns clojure-query.core
  (:require [clojure.java.io :as io]))
;;============================READ AND CLEAN DATA
(defn clean [strings noise]
  ;;remove noise from list of strings
  (for [s strings]
    (-> s ((apply comp (for [n noise] #(.replace %1 n "")))))))
;;============================QUESTIONS
  (defn ask-question
    "Ask a question, takes to possible answers and returns one"
    [question ans-one ans-two]
    (println question)
    (let [ans (read-line)]
      (if (some #(= ans %) [ans-one ans-two])
        ans
        (recur question ans-one ans-two))))
;;============================BUILD QUERY
(defn build-query
  "This function takes a list of items, and noise to be removed, and returns a formatted query"
  [items noise]
  (let [[left right] (if (= (ask-question "Do you want some regexes? (y/n): " "y" "n") "y")
                       ["/.*" , ".*/"]
                       ["\""  , "\"" ])
        regexed-list (for [i items] (str left i right))
        booleaned-list (interpose
                         (ask-question "Do you want AND or OR:" "AND" "OR")
                         regexed-list)]
        (if (= (ask-question "Clean ALL special characters? (y/n)" "y" "n") "y")
          (clean booleaned-list noise)
          booleaned-list)))
;;============================MAIN DEF
(defn -main
  "The main function returns a formatted query. "
  [] ;;/Volumes/128HDD/6_Programming/0_Git_Repositories/Learn_Code/21_Clojure/clojure-query/resources/list.txt
  (println "============================\nWelcome to IOCS query maker\n=============================")
  (println "Usage: Supply a list of iocs called list.txt")
  ;;Read iocs
  (let [iocs-file "/Volumes/128HDD/6_Programming/0_Git_Repositories/Learn_Code/21_Clojure/clojure-query/resources/list.txt"
        iocs (clojure.string/split-lines (slurp iocs-file))
        noise ["!" "$" "" "[" "-" "(" ")" "{" "}" "," "\"" "?" "<" ">" "@" "`" "^"]
        field "ips:"]
  ;;Ask for input
  (println field (build-query iocs noise))))
(-main)