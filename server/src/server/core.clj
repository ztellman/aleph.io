(ns server.core
  (:require
    [aleph.http :as http]
    [clojure.tools.cli :as cli]
    [clojure.tools.logging :as log]
    [ring.middleware
     [file :refer [file-request]]
     [content-type :refer [wrap-content-type]]
     [not-modified :refer [wrap-not-modified]]
     [file-info :refer [wrap-file-info]]])
  (:gen-class))

(defn handler [root-path]
  (fn [req]
    (or
      (file-request req root-path)
      {:status 404
       :heaers {"content-type" "text/plain"}
       :body "no such thing"})))

(defn -main [& args]
  (try
    (http/start-server
      (-> (handler (first args))
        wrap-file-info
        wrap-not-modified)
      {:port 80})
    (log/info "listening on port 80")
    (catch Throwable e
      (log/error e "error starting server")
      (System/exit 0))))
