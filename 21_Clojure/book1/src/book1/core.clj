(ns book1.core
  (:gen-class))


;; Here are the utility functions for the program

;;Welcome, main sections and goodbye banner
(defn banner
	[ban]
	(println "\033[1;32m\n===================================================\n================" 
			 ban 
			 "================\n===================================================\033[0m" ))
;;title to separate sections
(defn t 
	[message]
	(println "\033[4;31m\n------------" message "---------------\033[0m"))

;;print function 
(defn p
	[message & rest]
	(if (= nil rest)
	(println message) ;;if rest is nil
	(println message rest))) ;;else (rest if not nill)

;; Here is the main 
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (banner "Welcome to book 1")

  ;;=============================================================MAIN=================================
  (t "If true, otherwise next instruction")
  (if true
	"By Zeu's hammer!"
	"By Aquaman's trident!")

  (t "If true: do all dos")
  (if true
  	(do (println "Success!")
  				 "By Zeu's hammer")
  	(do (println "Failure")
  		"By Aquaman's trident!"))

  (t "When is when do all instruction on condition")
  (when true
	(println "Success!")
	"abra cadabra")

  (t "Use control-l to clear the screen")

  (t "Let's bind values")
  (def failed-protagonist-names
  	["Larry Potter" "Dorren the explorer" "The Incredible Bulk"])
  (println "Vector of failed protagonists names: " failed-protagonist-names)

  (t "Let's play with error messages")
  (defn error-message
  	[severity]
  	(str "OH GOD! IT'S A DISASTER! WE'RE "
  		(if (= severity :mild)
  			"MILDLY INCONVENIENCED!"
  			"DOOOMMED")))
  (println (error-message :mild))
  ;;=============================================================DATA STRUCTURES
  (banner "Data structures..")
  (t "Let's define strings")
  (def name "Chewbaca")
  (println (str "\"Ugglggglglglglglglglglll\" - " name))

  (t "Let's use the get function to retrieve a map value")
  (println (get {:a 0 :b 1} :c "unicorns?"))
  (p "The default value was taken because we couldn't find the key ':c'")

  (t "Vectors")
  (p "Taking 0th element of vectore [3 2 1]")
  (println (get [3 2 1] 0))

  (p "Lets use conj to add 4 to vecttor [1 2 3]")
  (println (conj [1 2 3 ] 4))

  (t "Lets learn lists")
  (def liste '(1 2 3 4) )
  (p "This is a list" liste)

  (t "Use 'nth' to retrieve nth=1 element from list (:a :b :c) ")
  (p (nth '(:a :b :c) 1))

  (t "Element added (4) to beginning of a list (1 2 3) with conj")
  (p (conj '(1 2 3) 4))

  (t "Let's look at sets")
  (def aset (hash-set 1 1 2 2))
  (p "This is a set: " aset)

  (p "Let's add to a set :a :b, :b")
  (p (conj #{:a :b} :b))
  (p "No change because it is already inside the set")

  (t "Let's look a contains")
  (def anotherset (set [ 3 3 4 4 5 5 6 6 7 8 9 10]))
  (p "Let's print a set: " (sort anotherset))
  (p "Does this set contain 3: " (contains? anotherset 3))
  (p "Does this set contain 4: " (contains? anotherset 4))
   (p "Does this set contain 12: " (contains? anotherset 12))
  ;;=============================================================FUNCTIONS
  (banner "Functions........")
  (t "Let's look at first and second")
  (p "Let's print the first element of [1 2 3 4] with : " (first [1 2 3 4]))
  (p "Let's print the second element of [1 2 3 4] with : " (second [1 2 3 4]))

  (t "Let's look at: map")
  (p "Let's increment all element of vector [0 1 2 3] by one: " (map inc [0 1 2 3]))

  (t "Let's define some functions")
  (defn too-enthusiastic
  	"Return a cheer that might be a bit too enthusiastic"
  	[name]
  	(println (str "OH MY GOD! ==> " name " <== YOU ARE MOST DEFINITELY LIKE THE BEST "
  	"MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE")))
  (too-enthusiastic "Zelda")
  (too-enthusiastic "Samuel Marticotte")

  (t "Let's look at arity")

  (defn no-params
  	[]
  	"I take no paramenters!")

  (defn one-param
  	[x]
  	(str "I take one parameter: " x ))

  (defn two-params
  	[x y ]
  	(str "Two parameters! That's nothing! Pah! I will smoosh them "
  		"together to spite you! " x y))

  (defn multi-arity
  	;; 3-arity arguments and body
  	([first-arg second-arg third-arg]
  		(p first-arg second-arg third-arg))
  	;; 2-arity arguments and body
  	([first-arg second-arg]
  		(p first-arg second-arg))
  	;; 1-arity arguments and body
  	([first-arg]
  		(p first-arg)))
  (multi-arity "hello ")
  (multi-arity "hello" "you")
  (multi-arity "hello" "you" "from three arity function")

  (defn x-chop
  	"Describe the kind of chop you're inflicting on someone"
  	([name chop-type]
  		(println (str "I " chop-type " chop " name "! Take that!")))
  	([name]
  		(x-chop name "karate")))
  (x-chop name "karate")
  (x-chop "Kanye West" "slap")

  (t "Let's look at the rest parameter: &")
  (defn codger-communication
  	[whippersnapper]
  	(str "\nGet off my lawn, " whippersnapper "!!!"))
  	
  	(println (codger-communication "Samuel"))

  (defn codger
  	[& whippersnapper]
  	(println (map codger-communication whippersnapper)))
	(codger "Billy" "Anne-Marrie" "The Incredible Hulk")

  (defn favorite-things
  	"Docstring: enumerste favorite things"
  	[name & things]
  	(str "Hi, " name ", here are my favorite things: "
  	(clojure.string/join ", "things)))

	(println (favorite-things "Samuel" "computers" "programming" "techno music"))

  (t "Let's look at destructuring")
  (p "Let's return the first element of a collection (oven, bike, war-axe")
  (defn my-first
  	"Docstring: returns the first element of a vector"
  	[[first-thing]] ;notice that first-thing is within a vector
  	first-thing)
  (println (my-first ["oven" "bike" "war-axe"]))

  (defn chooser 
  	[[first-choice second-choice & unimportant-choices]]
  	(println (str "Your first choice is: " first-choice))
  	(println (str "Your second choice is: " second-choice))
  	(println (str "We dont' really care about the rest..."
  					"\nHere they are in case you want to cry over them: "
  					(clojure.string/join ", " unimportant-choices))))
  (chooser ["Marmalde", "Handsome jack", "Pigpen" ,"Aquaman"])

  (defn announce-treasure-location
  	"Docstring: annoucnes the location of the treasure"
  	[{:keys [lat lng]}]
  	(println (str "Treasure lat: " lat))
  	(println (str "Treasure lng: " lng)))
  (announce-treasure-location {:lat 28.22 :lng 81.33})

  (t "Let's look at function bodies")
  (defn illustrative-function
  	"Docstring: this is just an illustrative function"
  	[]
  	(+ 1 304)
  	30
  	"joe")
  (p "The body of a function always returns the last evaluated element\nIn this case: " (illustrative-function))

  (t "Let's look at anonymous functions")
  (def my-special-multiplier (fn [x] (* x 3)))
  (p "Let's multipy 12 using a times 3 in an anonymous function: " (my-special-multiplier 12))

  (t "Let's look at returning functions")

  (defn inc-maker
  	"Create a custom incremator"
  	[inc-by]
	#(+ % inc-by))
  (def inc3 (inc-maker 3))
  (p "We use an first inc-maker function that will add arguments,\nThen we define a inc3 funtion that adds 3\nThen we call (inc3 7)\nThe result is: " (inc3 7))

  (banner "Let's build a hobbit")

  (def asym-hobbit-body-parts [{:name "head" :size 3}
  								{:name "left-eye" :size 1}
								{:name "left-ear" :size 1}
								{:name "mouth" :size 1}
								{:name "nose" :size 1}
								{:name "neck" :size 2}
								{:name "left-shoulder" :size 3}
								{:name "left-upper-arm" :size 3}
								{:name "chest" :size 10}
								{:name "back" :size 10}
								{:name "left-forearm" :size 3}
								{:name "abdomen" :size 6}
								{:name "left-kidney" :size 1}								
								{:name "left-hand" :size 2}
								{:name "left-knee" :size 2}
								{:name "left-thigh" :size 4}
								{:name "left-lower-leg" :size 3}
								{:name "left-achilles" :size 1}
								{:name "left-foot" :size 2}])

  (defn matching-part
  	[part]
  	{:name (clojure.string/replace (:name part) #"^left-" "right-")
	:size (:size part)})

  (defn symmetrize-body-parts
  	"Expects a seq of maps that have a :name and a :size"
  	[asym-body-parts]
  	(loop [remaining-asym-parts asym-body-parts
  		final-body-parts[]]
  		(if (empty? remaining-asym-parts)
  			final-body-parts
  			(let [[part & remaining] remaining-asym-parts]
  				(recur remaining
  					(into final-body-parts
  						(set [part (matching-part part)])))))))

 	(println (symmetrize-body-parts asym-hobbit-body-parts))

 	(t "Let's examine 'let'")
 	(def dalmatian-list
 		["Pongo" "Perdita" "Puupy 1" "Puppy2"])
 	(p "Let's take 2 dalmatians from the list: " (let [dalmatians (take 2 dalmatian-list)] dalmatians))

 	(t "Let's look at loop")
 	(time (loop [iteration 1]
 		(println (str "Iteration " iteration))
 		(if (> iteration 10)
 		(println "Goodbye!")
 		(recur (inc iteration)))))

 	(defn iteration
 		[itera]
 		(println "Iteration " itera)
 		(if (> itera 10)
 		(println "Goodbye!")
 		(iteration (inc itera))))

 	(time (iteration 1)) ;;Woups, this one leads to a stack overflow around itera=6000!
 	;;I think Den told me about this...

 	(t "Let's do another example: recursive printer")

 	(defn recursive-printer
 		([]
 			(recursive-printer 0))
 		([iteration]
 			(println iteration)
 			(if (> iteration 10)
 				(println "Goodbye!")
 				(recursive-printer (inc iteration)))))
 	(recursive-printer 1)

 	(t "Let's learn 'reduce'")
 	(p "Let's use reduce to add the elements of a vector [1 2 3 4]: " (reduce + [1 2 3 4]))

 	(t "Let's build our own reduce")
 	(defn my-reduce
 		([f initial coll]
 			(loop [result initial
 				remaining coll]
 				(if (empty? remaining)
 					result 
 					(recur (f result (first remaining))(rest remaining)))))
 		([f [head & tail]]
 			(my-reduce f head tail)))

 	
 	(t "Let's build a better symmetrize body parts function")
 	(defn better-symmetrize-body-parts
 		"Expects a seq of maps that have a :name and :size"
 		[asym-body-parts]
 		(reduce (fn [final-body-parts part]
 			(into final-body-parts (set [part (matching-part)])))
 		[]
 		asym-body-parts))	

 	(t "Let's build a hit hobbit funciton")
 	(defn hit
 		[asym-body-parts]
 		(let [sym-parts (better-symmetrize-body-parts asym-body-parts)
 			body-part-size-num (reduce + (map :size sym-parts))
 			target (rand body-part-size-num)]
 			(loop [[part & remaining] sym-parts
 				accumulated-size (:size part)]
 				(if (> accumulated-size target)
 					part 
 					(recur remaining (+ accumulated-size (:size (first remaining))))))))

 	;;(hit asym-hobbit-body-parts)
 	;;TODO: To review. Hit function not working. Compiles but logic bug.

 	(banner "Core functions......")

 	(t "First ,rest, cons")

 	(defn titleize
 		[topic]
 		(str topic " for the Brave and True"))
 	
 	(println "1: " (map titleize ["=Hamsters" "=Ragnarok"]))
 	(println "2: " (map titleize '("=Empathy" "=Decorating")))
 	(println "3: " (map titleize #{"=Elbows" "=Soap carving"}))

 	(t "Let's look at sequences")
 	(p (seq '(1 2 3)))
 	(p (seq [1 2 3]))
	(p (seq #{1 2 3})) ;; sets are not ordered
	(p (seq {:name "Bill Compton" :occupation "Dead mopey guy"}))

	(t "Let's convert a seq back into a map")
	(p (into {} (seq {:a 1 :b 2 :c 3})))

	(t "Let's look at map with seqs")
	(p (map inc [1 2 3]))
	(p (map str ["a" "b" "c"] ["A" "B" "C"]))
	(p (list (str "A" "a") (str "B" "b") (str "C" "c"))) ;;equivalent of above

	(t "Let's turn to vampires now")
	(def human-consumption [8.1 7.3 6.6 5.0])
	(def critter-consumption [0.0 0.2 0.3 1.1])
	(defn unify-diet-data
		[human critter]
		{:human human
		:critter critter})
	(p (map unify-diet-data human-consumption critter-consumption))

	(def sum #(reduce + %))
	(def avg #(/ (sum %) (count %)))
	(defn stats
		[numbers]
		(map #(% numbers) [sum count avg]))
	(p (stats [3 4 10]))

	;================================================================================================================================ 20 feb

	(def identities
		[{:alias "Batman" :real "Bruce Wayne"}
		 {:alias "Spider-Man" :real "Peter Parker"}
		 {:alias "Santa" :real "Your mom"}
		 {:alias "Easter Bunny" :real "Your dad"}])

	(t "Let's use map to retrieve all values from hashmap")
	(p (map :real identities))

	(t "Now let's use reduce")
	(p (reduce (fn [new-map [key val]]
		(assoc new-map key (inc val)))
	{}
	{:max 30 :min 30}))

	(p (reduce (fn [new-map [key val]]
		(if (> val 4)
		(assoc new-map key val)
		new-map))
	{}
	{:human 4.1
		:critter 3.9}))

	(t "Let's learn 'take'")
	(p (take 3 [1 2 3 4 5 6 7 8 9 10]))

	(t "Let's use drop")
	(p (drop 3 [1 2 3 4 5 6 7 8 9 10]))

	(t "Let's look at take-while and drop-while")
	(def food-journal 
		[{:month 1 :day 1 :human 5.3 :critter 2.3}
		 {:month 1 :day 2 :human 5.1 :critter 2.0}
		 {:month 2 :day 1 :human 4.9 :critter 2.1}
		 {:month 2 :day 2 :human 5.0 :critter 2.5}
		 {:month 3 :day 1 :human 4.2 :critter 3.8}
		 {:month 3 :day 2 :human 4.0 :critter 3.3}])

	(p (take-while #(< (:month %) 2) food-journal))
	(p (drop-while #(< (:month %) 2) food-journal))

	(t "Let's look at filter")

	(p (filter #(< (:human %) 5) food-journal))
	(p (filter #(< (:month %) 3) food-journal))

	(t "Let's look at some")
	(p (some #(and (> (:critter %) 3) %) food-journal))

	(t "Let's look at sort, sort-by and conccat")
	(p (sort [3 2 1]))
	(p (sort-by count ["aaa" "c" "bb"]))
	(p (concat [1 2] [3 4]))

	(t "Let's do more vampires now")
	(def vampire-database
		{0 {:makes-blood-puns? false, :has-pulse? true :name "McFishwich"}
		1 {:makes-blood-puns? false, :has-pulse? true :name "McMakson"}
		2 {:makes-blood-puns? true, :has-pulse? false :name "Damon Salvatore"}
		3 {:makes-blood-puns? true, :has-pulse? true :name "Mickey Mouse"}})

	(defn vampire-related-details
		[social-security-number]
		(Thread/sleep 1000)
		(p (get vampire-database social-security-number)))

	(defn vampire?
		[record]
		(and (:makes-blood-puns? record)
			(not (:has-pulse? record))
			record))

	(defn identify-vampire
		[social-security-number]
		(p (first (filter vampire?)
			(map vampire-related-details social-security-number))))

	;;(time (vampire-related-details 3))

	(time (def mapped-details (map vampire-related-details (range 0 4))))

	;;(time (first mapped-details))

	(t "Let's do some infinite sequences wtih repeat")
	(p (concat (take 8 (repeat "na")) ["Batman"]))

	(t "Let's print some random number with repeatedly")
	(p (take 3 (repeatedly (fn [] (rand-int 10 )))))

	(defn even-numbers
		([] (even-numbers 0))
		([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

	(p (take 10 (even-numbers)))

	(p (cons 0 '(1 4 6)))

	(banner "Collection Abstraction")
	(t "Empty keyword for checking emptiness of sequence")
	(p (empty? []))

	(t "Let's look at into")
	(p (map identity {:sunlight-reaction "Glitter"}))
	(p (into #{} (map identity [:garlic-clove :garlic-clove])))
	(p (into {:favorite-emotion "gloomy"} [[:sunlight-reaction "Glitter!"]]))
	(p (into ["cherry"] '("pine" "spruce")))

	(t "Let's look at conj")

	(p (conj [0] 1))
	(p (into [0] [1])) ;;equivalent to above

	(p (conj [0] 1 2 2 3 4))
	(p (conj {:time "midnight "} [:place "ye olde cemetarium"]))

	(t "Let's define our own conj")
	(defn my-conj 
		[target & additions]
		(into target additions))

	(p (my-conj [0] 1 2 3))

	(t "Let's look at apply")
	(p (max  1 2 3 4 5 6 7 89))
	(p (apply max [ 0 1 2 3 4 5 6]))

	(defn my-into 
		[target & additions]
		(apply conj target additions))
	(p (my-into [0] 1 2 3))
	
	(t "Let's look at partial")

	(def add10 (partial + 10))
	(p (add10 3))

	(def add-missing-elements
		(partial conj ["water" "earth" "air"]))

	(p (add-missing-elements "unobainium" "adamantium"))

	(defn my-partial 
		[partialized-fn & args]
		(fn [& more-args]
			(apply partialized-fn (into args more-args))))

	(def add20 (my-partial + 20))
	(p (add20 3))

	(defn lousy-logger 
		[log-level message]
		(condp = log-level
			:warn (clojure.string/lower-case message)
			:emergency (clojure.string/upper-case message)))

	(def warn (partial lousy-logger :warn))
	(def emerge (partial lousy-logger :emergency))
	(p (warn "Yellow light ahead"))
	(p (emerge "Red light ahead"))

	(t "Let's look at complement")
	(def my-pos? (complement neg?))
	(p (my-pos? 1))
	(p (my-pos? -1))

  ;;============================================================END=====================================
  (banner "Goodbye :  book 1")
  );;This is the end of the script

