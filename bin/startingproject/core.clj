(ns startingproject.core
(:require [clojure.data.json :as json]
          [org.httpkit.server :as kit]
          [compojure.core :refer [routes POST GET ANY]]))

;;(defonce *:private server (atom nil))
(defn remov-trailling-slash [handler]
  (fn [req]
    (let [uri (:uri req)
          not-root? (not= uri "/")
          ends-with-slash? (.endsWith ^String uri "/")
          fixed-uri (if (and not-root?
                             ends-with-slash?)
          (subs uri 0 (dec (count uri)))
          uri)
          fixed-req (assoc req :uri fixed-uri)
          ]
      (handler fixed-req)
    )
 ))



(defn app[]
  (routes
    (GET "/" [:as req]
         {:status 200
          ;;:headers {"Content-Type" "text/html"}
          ;;:body "<h1> ddsds dasd</h1>"
          :headers {"X-Api-Version" "2"}
          :content-type :json
          :body (json/write-str {:a 5 :b 2})
          :query-params {:a (json/write-str {:b {:c 5} :e {:f 6}})}
           :form-params {"q" "foo, bar"} ; 
          :data  (json/write-str {:a 1 :b 2})
          }
         )
    (GET "/:user-name" [user-name :as req]
         {:status 200
          :headers {"Content-Type" "json"}
           :form-params {"q" "foo, bar"} ;
           :body (json/write-str {:name 'req :b 2})
           ; use this for content-type json
 
          ;;:body (format "<h1> Hi %s </h1>" user-name)
          }
         )
    ))
(defn create-server []
  (println "ssdsa")
  (kit/run-server (remov-trailling-slash (app)) {:port 8080}))
 
  (defn stop-server [server]
    (server :timeout 1000))
(defn hello [n]
  (println "sssd," n))

;;(defn run-server []
 ;; (reset! server (create-server)
  ;;))
(defn -main
  "ss"
  [&args]
  (println "sss"))