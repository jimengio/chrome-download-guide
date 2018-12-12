
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> mutation-> <> div button textarea span a]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]))

(defcomp
 comp-suggest
 ()
 (div
  {:class-name "chrome-guide-container",
   :style {:position :fixed,
           :top 0,
           :left 0,
           :width "100%",
           :line-height "48px",
           :background-color (hsl 50 70 70),
           :text-align :center,
           :color (hsl 0 0 50),
           :font-size 16,
           :z-index 9999,
           :font-family "Chinese Quote,-apple-system,BlinkMacSystemFont,Segoe UI,PingFang SC,Hiragino Sans GB,Microsoft YaHei,Helvetica Neue,Helvetica,Arial,sans-serif"}}
  (<> "本网站建议使用谷歌浏览器打开, 推荐下载: ")
  (a
   {:inner-text "桌面版",
    :href "https://pc.qq.com/detail/1/detail_2661.html",
    :target "_blank"})
  (<> ", ")
  (a
   {:inner-text "移动版",
    :href "https://android.myapp.com/myapp/detail.htm?apkName=com.android.chrome",
    :target "_blank"})
  (comment
   a
   {:class-name "chrome-guide-action",
    :inner-text "关闭",
    :style {:position :absolute, :right 8, :top 0, :cursor :pointer}})))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/row)}
    (comp-suggest)
    (when dev? (cursor-> :reel comp-reel states reel {})))))
