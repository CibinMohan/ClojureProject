(ns handler

 (:use compojure.core)
      (:require [compojure.handler :as handler]
                [ring.middleware.json :as middleware]
      
                [compojure.route :as route]))

    (defroutes app-routes
      (GET "/" [] "Hello World")
      (route/not-found "Not Found"))

  (def app
      (-> (handler/api app-routes)
        (middleware/wrap-json-body)
        (middleware/wrap-json-response)))
  
 (defroutes app-routes   
   (context "/documents" [] (defroutes documents-routes
        (GET  "/" [] (get-all-documents)))
    (route/not-found "Not Found"))
  
  (def get-all-documents []
    (response "dasd"))