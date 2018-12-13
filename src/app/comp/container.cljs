
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> mutation-> <> div button textarea span a]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md comp-md-block]]
            [app.config :refer [dev?]]))

(defcomp
 comp-anchor
 (content-id title content)
 (div
  {:style {:margin "40px 0"}}
  (span {:id content-id})
  (=< nil 8)
  (div
   {:style {:background-color (hsl 0 0 98),
            :padding 16,
            :margin "40px 8px",
            :min-height 320}}
   (div {:style {:margin "16px 8px", :font-size 20}} (<> title))
   (comp-md-block content {:style {:font-size 16}}))))

(defcomp
 comp-link
 (text id)
 (a {:href (str "#" id), :style {:margin "0 8px"}, :inner-text text}))

(defcomp
 comp-suggest
 ()
 (div
  {:style {:position :fixed,
           :top 0,
           :left 0,
           :width "100%",
           :line-height "28px",
           :padding "16px 80px",
           :background-color "#E9E9E9",
           :text-align :center,
           :color "#323232",
           :font-size 16,
           :z-index 9999,
           :font-family "Chinese Quote,-apple-system,BlinkMacSystemFont,Segoe UI,PingFang SC,Hiragino Sans GB,Microsoft YaHei,Helvetica Neue,Helvetica,Arial,sans-serif"}}
  (<> "检测到您在使用低版本的浏览器访问，")
  (a
   {:style {:color "#2c85dd"},
    :inner-text "建议切换到谷歌浏览器",
    :href "_REPL_URL_CHROME_GUIDE_",
    :target "_blank"})
  (<> "。")
  (comment
   span
   {:class-name "chrome-guide-action",
    :inner-text "关闭",
    :style {:position :absolute, :right 8, :top 16, :cursor :pointer, :color "#2c85dd"}})))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global)}
    (comment comp-suggest)
    (div
     {:style {:max-width 800, :margin :auto, :padding 16}}
     (comp-md-block "这个页面会指导你对于不同的平台如何安装谷歌浏览器.\n" {:style {:font-size 16}})
     (=< nil 8)
     (div
      {}
      (comp-link "PC端" "on-pc")
      (comp-link "Android端" "on-android")
      (comp-link "iOS端" "on-ios")
      (comp-link "官网安装" "on-official"))
     (comp-anchor
      "on-pc"
      "PC 端安装"
      "Windows 用户可以到[腾讯电脑管家软件中心](https://pc.qq.com/detail/1/detail_2661.html)下载谷歌浏览器的安装文件.\n")
     (comp-anchor
      "on-android"
      "Android 端安装"
      "如果手机当中自带应用商店, 可以在里面搜索 \"Chrome\" 查找谷歌浏览器直接进行安装.\n\n也可以访问[应用宝的谷歌浏览器页面](https://android.myapp.com/myapp/detail.htm?apkName=com.android.chrome), 点击\"立即下载\"获得 APK 安装包, 下载以后即可安装.\n")
     (comp-anchor
      "on-ios"
      "iOS 端安装"
      "iOS 用户请到 [App Store](https://itunes.apple.com/us/app/google-chrome/id535886823?mt=8) 当中安装谷歌浏览器.\n")
     (comp-anchor
      "on-official"
      "官网安装"
      "网络稳定的条件下, 也可以访问[谷歌浏览器官网](https://www.google.com/chrome/)下载安装浏览器.")
     (=< nil 400))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
