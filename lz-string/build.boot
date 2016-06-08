(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/lz-string
        :version     +version+
        :description "LZ-based compression algorithm for JavaScript"
        :url         "https://github.com/pieroxy/lz-string"
        :license     {"License" "https://raw.githubusercontent.com/pieroxy/lz-string/master/LICENSE.txt"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
         (comp
           (download :url (format "https://github.com/pieroxy/lz-string/archive/%s.zip" +lib-version+)
                     :checksum "5E0CED6CF08520D4A36EC604D6D9655F"
                     :unzip true
                     )
           (sift :move {#"^lz-string-.*/libs/lz-string.js$" "cljsjs/development/lz-string.inc.js"})
           (sift :move {#"^lz-string-.*/libs/base64-string.js$" "cljsjs/development/base64-string.inc.js"})
           (sift :move {#"^lz-string-.*/libs/lz-string.min.js$" "cljsjs/production/lz-string.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.lz-string")
           (pom)
           (jar)))
