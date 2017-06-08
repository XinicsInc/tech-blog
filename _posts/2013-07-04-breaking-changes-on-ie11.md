---
layout: post
title: 'Internet Explorer 11의 Breaking Changes'
author: xinics
date: 2013-07-04 12:30
tags: [HTML5]
---

![IE11](/files/2013/07/04/internetexplorer_large_verge_medium_landscape.png)

요즈음 Windows 8.1과 Windows Server 2012 R2 출시로 많은 이야기들이 오고 가고 있는데, 그 중에서도 Internet Explorer 11에 대한 이야기도 많이 눈에 띕니다.

Internet Explorer 11에 등장하는 새로운 기능들도 많지만, 기존 버전과 확연히 달라지고 제거되는 기능들 중에 호환성에서 문제를 일으킬만한 요소들이 많이 눈에 띕니다. 이러한 부분들을 잘 정리한 아티클이 있어 소개합니다. ([http://www.nczonline.net/blog/2013/07/02/internet-explorer-11-dont-call-me-ie/](http://www.nczonline.net/blog/2013/07/02/internet-explorer-11-dont-call-me-ie/))

이 아티클에서 이야기하는 내용을 요약하면 다음과 같습니다.

* 11부터 User Agent 문자열에서 MSIE 문자열이 사라집니다. Internet Explorer인지 확인하기 위하여 User Agent 문자열을 검사하는 시나리오에 의존하는 모든 종류의 프로그램 및 로직은 MSIE 문자열 대신 Trident 문자열을 검사하도록 패턴을 수정하는 것이 구 버전부터 11.0까지 모두 지원할 수 있는 정확한 방법일 것입니다.
* navigator 객체의 appName 속성은 'Netscape', product 속성은 'Gecko' 문자열을 반환합니다. 이러한 속성에 의존하여 IE 인지 아닌지를 판단하는 코드에서는 이런 이유로 IE 11을 IE가 아닌 Gecko 렌더링 엔진을 사용하는 브라우저로 오판할 수 있습니다.
* typeof document.all 식을 사용하여 결과값을 평가하면 'undefined'로 반환되지만, 실제 document.all 속성에 대한 호출은 정상적으로 작동합니다. 달리 말하면, Modernizer와 같은 Presence Test Framework에서는 document.all 속성을 IE11이 지원하지 않는 것으로 해석하지만, 호환성을 이유로 document.all을 평가 과정 없이 직접 호출하는 Legacy Web Page들은 문제없이 잘 실행됩니다. 그러나 Legacy Web Page이더라도 typeof document.all 과 같은 표현식의 값을 의존하는 경우 역시 호환성 문제가 발생할 수 있습니다.
* 같은 이유로 element.attachEvent 메서드의 Presence를 확인하기 위해서 typeof 연산자를 사용하면 'undefined'로 평가되지만 실제로는 호출이 가능합니다. 이러한 평가 사실에 의존하는 코드는 역시 호환성 문제가 발생할 수 있습니다.
* window.execScript 메서드, window.doScroll 메서드, script.onreadystatechange 이벤트, script.readyState 속성, document.selection 속성, document.createStyleSheet 메서드, style.styleSheet 속성은 완전히 제거되었으므로 typeof 식은 물론 실제로도 작동하지 않습니다.


Windows 8.1에 대한 호환성을 점검하고 계시다면, 위의 사항들을 잘 참고하시어 대비하는 것이 필요해보입니다.