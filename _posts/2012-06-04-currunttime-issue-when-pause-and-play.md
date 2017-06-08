---
layout: post
title: '[Video/Audio] Pause/Play 했을 때, currentTime 오차가 발생하는 문제'
author: xinics
date: 2012-06-04 14:57
tags: [HTML5]
---

제목에는 일단 오차가 발생하다고 했지만, 표현이 좀 이상하네요.

여튼, 요즘은 HTML5 관련 작업을 하고 있는데,
마주한 문제가 발생했을 때마다 기록해보려고 합니다.


**크롬**에서 Video, Audio 태그를 사용하여 미디어를 재생하는 중에 Pause했다가, 다시 바로 Play를 시키면,
currentTime, 즉 재생 시간이 0.8 ~ 1.0초 뒤로 점프하는 경우가 생깁니다.
**예를 들어, 1.0초에서 Pause시킨 뒤, 바로 Play를 하면 2.0초쯤에서 재생이 시작됩니다.**
처음엔 잘 몰랐는데, 황당한 경우가 발생한거죠;

딱히 해결책을 찾기 어려워서, Seek를 해봤습니다. 즉 재생 콘트롤러에서 드래깅하여 재생 시간을 이동한 뒤 재생을 시작해보니 제시간에 재생을 하더군요.
혹시나해서, **Pause했을 때 currentTime을 0으로 설정했다가 다시 미디어 시간을 적용한 뒤 재생하니 점프하는 경우 없이 재생합니다.**

```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>TestPage</title>

	<script type="text/javascript">
	var mediaTime = 0;

	function onPause() {
		var media = document.getElementById('media');
		mediaTime = media.currentTime;
		media.currentTime = 0;
		media.currentTime = mediaTime;

	}
	</script>
</head>
<body>
	<video id="media" width="400" height="300" src="비디오 파일명" onpause="onPause()" controls></video>
</body>
</html>
```

이렇게 처리한 경우, 문제가 하나 있습니다.
Video 태그의 경우, Pause 했을 때 화면이 0초로 왔다 다시 제시간으로 돌아가는 모습을 볼 수 있습니다. -_-;
(꼼수는 꼼수일 뿐... )
