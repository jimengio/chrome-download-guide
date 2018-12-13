(function() {
  var snippet =
    '<div class="chrome-guide-container" style="background-color: rgb(232, 214, 125); color: rgb(128, 128, 128); font-size: 16px; left: 0px; line-height: 28px; position: fixed; text-align: center; top: 0px; width: 100%; z-index: 9999; font-family: &quot;Chinese Quote&quot;, -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; padding: 16px 80px;"><span>本网站建议使用谷歌浏览器打开, 推荐下载: </span><a href="https://pc.qq.com/detail/1/detail_2661.html" target="_blank">PC版</a><span>，</span><a href="https://android.myapp.com/myapp/detail.htm?apkName=com.android.chrome" target="_blank">移动版</a><span>，</span><a href="https://itunes.apple.com/us/app/google-chrome/id535886823?mt=8" target="_blank">iOS版</a><span class="chrome-guide-action" style="color: rgb(24, 133, 242); cursor: pointer; position: absolute; right: 8px; top: 16px;">关闭</span></div>';

  var hookGuideAction = "chrome-guide-action";

  var isChrome =
    /Chrome/.test(navigator.userAgent) && /Google Inc/.test(navigator.vendor);

  function displaySuggestion() {
    var container = document.createElement("div");
    container.innerHTML = snippet;
    document.body.appendChild(container);

    var closeButton = container.querySelector("." + hookGuideAction);
    closeButton.addEventListener("click", function() {
      container.parentElement.removeChild(container);
    });
  }

  if (!isChrome) {
    displaySuggestion();
  } else if (isChrome) {
    var raw = navigator.userAgent.match(/Chrom(e|ium)\/([0-9]+)\./);
    var version = raw ? parseInt(raw[2], 10) : null;
    if (version < 40) {
      displaySuggestion();
    } else {
      // console.info("Chrome is fine.");
    }
  }
})();
