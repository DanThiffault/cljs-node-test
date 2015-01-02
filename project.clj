(defproject hipper "0.1.0-SNAPSHOT"
  :description "Example of testing with clojurescript using node"
  :url "https://github.com/DanThiffault/cljs-node-test"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2665"]]
  :plugins  [[lein-cljsbuild "1.0.4"]]
  :source-paths ["src"]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/cljs/app.js"
                                   :output-dir "target/cljs/app/"
                                   :optimizations :none
                                   :cache-analysis true
                                   :target :nodejs
                                   :source-map "target/cljs/app.js.map"}}]
              :test-commands {"test" ["nodejs" "node-test/runner.js" "target/cljs/app" "/../app.js" "/app/core_test"]}})
