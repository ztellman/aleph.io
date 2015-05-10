(defproject server "0.1.0"
  :description "static site server"
  :url "aleph.io"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0-beta2"]
                 [aleph "0.4.0"]
                 [ring/ring-core "1.4.0-beta2"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.cli "0.3.1"]]
  :aot :all
  :main server.core)
