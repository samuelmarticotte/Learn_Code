(ns my-webapp.views
  (:require [my-webapp.db :as db]
            [clojure.string :as str]
            [hiccup.page :as page]
            [ring.util.anti-forgery :as util]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Locations: " title)]
   (page/include-css "/css/styles.css")])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/add-location"} "Add Users and Passwords"]
   " | "
   [:a {:href "/all-locations"} "View Users and Passwords"]
   " ]"])

(defn home-page
  []
  (page/html5
   (gen-page-head "Home")
   header-links
   [:h1 "==========================================="]
   [:h1 "FIRST CLOJURE WEB APP : PASSWORD DATABASE"]
   [:h1 "==========================================="]
   [:p "Description: store and display users and passwords"]))

(defn add-location-page
  []
  (page/html5
   (gen-page-head "Add Users dans Passwords")
   header-links
   [:h1 "Add User and Password"]
   [:form {:action "/add-location" :method "POST"}
    (util/anti-forgery-field) ; prevents cross-site scripting attacks
    [:p "User : " [:input {:type "text" :name "x"}]]
    [:p "Password : " [:input {:type "text" :name "y"}]]
    [:p [:input {:type "submit" :value "submit to database"}]]]))

(defn add-location-results-page
  [{:keys [x y]}]
  (let [id (db/add-location-to-db x y)]
    (page/html5
     (gen-page-head "Added a User ")
     header-links
     [:h1 "Added User "]
     [:p "Added [" x ", " y "] (id: " id ") to the db. "
      [:a {:href (str "/location/" id)} "See for yourself"]
      "."])))

(defn location-page
  [loc-id]
  (let [{x :x y :y} (db/get-xy loc-id)]
    (page/html5
     (gen-page-head (str "Location " loc-id))
     header-links
     [:h1 "A Single Location"]
     [:p "id: " loc-id]
     [:p "x: " x]
     [:p "y: " y])))

(defn all-locations-page
  []
  (let [all-locs (db/get-all-locations)]
    (page/html5
     (gen-page-head "All Users and Passwords in the db")
     header-links
     [:h1 "All Users dans Passwords"]
     [:table
      [:tr [:th "id"] [:th "Users"] [:th "Passwords"]]
      (for [loc all-locs]
        [:tr [:td (:id loc)] [:td (:x loc)] [:td (:y loc)]])])))