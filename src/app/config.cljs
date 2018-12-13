
(ns app.config (:require [app.util :refer [get-env!]]))

(def bundle-builds #{"release" "local-bundle"})

(def dev?
  (if (exists? js/window)
    (do ^boolean js/goog.DEBUG)
    (not (contains? bundle-builds (get-env! "mode")))))

(def site
  {:storage "workflow",
   :dev-ui "http://localhost:8100/main.css",
   :release-ui "http://cdn.tiye.me/favored-fonts/main.css",
   :cdn-url "http://cdn.tiye.me/chrome-download-guide/",
   :cdn-folder "tiye.me:cdn/chrome-download-guide",
   :title "Chrome download guide",
   :icon "https://jimeng.io/favicons/favicon.ico",
   :upload-folder "tiye.me:repo/chenyong/chrome-download-guide/"})
