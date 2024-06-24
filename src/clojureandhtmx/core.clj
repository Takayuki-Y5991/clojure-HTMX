(ns clojureandhtmx.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [hiccup.page :as hi]))


(defn index-page[]
  (hi/html5 
   [:head
    [:title "HTMX click to edit"]
    (hi/include-js
     "https://unpkg.com/htmx.org@2.0.0")]
   [:body
    [:h1 "HTMX DEMO"]
    [:button {:hx-get "/api/hello" :hx-trigger "click" :hx-target "#result"} "Click Me"]
    [:div#result]]))


(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/api/hello" [] "<p>Hello from HTMX</p>")
  (route/not-found "Not Found"))

(def app
  (wrap-params app-routes))

(defn -main
  []
  (run-jetty app {:port 3000}))
