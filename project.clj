(defproject clojureandhtmx "0.1.0-SNAPSHOT"
  :description "a simple clojure app with htmx"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.12.2"]
                 [ring/ring-jetty-adapter "1.12.2"]
                 [compojure "1.7.1"]
                 [hiccup "2.0.0-RC3"]
                 [org.slf4j/slf4j-nop "1.7.30"]]
  :main ^:skip-aot clojureandhtmx.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
