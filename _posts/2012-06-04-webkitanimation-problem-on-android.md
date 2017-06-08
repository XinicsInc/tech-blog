---
layout: post
title: '[WebkitAnimation]Android 에서 scale 애니메이션이 동작되지 않는 문제'
author: xinics
date: 2012-06-04 15:14
tags: [HTML5, webkit]
---

Webkit Keyframes Animation 실컷 구현해놓고, 안드로이드에서 돌렸을 때,
심장이 철렁한 경험을 했었는데요
Keyframe Animation에 translate과 scale 속성이 변경되도록 해두었는데, translate만 동작하더라고요.
지금 생각해도 벌렁벌렁한 일이었네요. 아이폰에서만 확인했다가 =ㅅ=) 예상치 못한 난관을 맞닥뜨렸을 때의 심정이란...

WebkitTransition은 동작하기 때문에 구현 방식을 변경해야하는 고민이 있었습니다만...
저를 구원하는 [사이트](http://blog.webcreativepark.net/2012/02/12-141313.html)를 찾을 수 있었습니다.

위의 사이트에 한 일본 개발자 분께서 친절하게 안드로이드에서 Webkit Keyframes Animation을 적용하는 방법을 상세히 적어주셨습니다. 안드로이드에서도 Scale Aniamtion이 된다는 사실을 알게 된 저는 굉장히 기뻐했었는데요. (부끄부끄) 샘플 코드를 분석해서 문제를 찾을 수 있었습니다.
구현한 내용에는 문제가 없었습니다. css 에 적은 한 줄을 제거해야하더군요.

```css
-webkit-backface-visibility: hidden;
backface-visibility: hidden;
```

backface-visibility 속성을 설정해 둔 한 줄을 제거하니 Scale Animation이 동작합니다. (감동)
혹여, 저처럼 안드로이드에서 scale 애니메이션이 동작하지 않아서 당황스러운 분들이 있을까 공유합니다...
(너밖에 없어 퍽!)
