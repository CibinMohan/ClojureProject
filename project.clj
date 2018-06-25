(defproject startingproject "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [ring "1.6.0"]
                 [compojure "1.6.0"]
                 [ring/ring-json "0.1.2"]
                 [c3p0/c3p0 "0.9.1.2"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [com.h2database/h2 "1.3.168"]
                 [cheshire "4.0.3"]
                 [org.clojure/data.json "0.2.6"]]
  :plugins [[lein-ring "0.12.4"]]
      :ring {:handler clojure-rest.handler/app}
      :profiles
      {:dev {:dependencies [[ring/ring-mock "0.3.2"]]}})


