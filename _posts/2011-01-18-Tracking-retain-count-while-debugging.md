---
layout: post
title: '디버그 시 retain count 보는 방법'
author: xinics
date: 2011-01-18 18:39
tags: [Objective-C]
---

XCode의 디버거에서는 변수의 retain count를 볼 수가 없어서 불편한데요, 디버깅 중에 볼 수 있는 방법이 없지는 않습니다. gdb의 디버깅 콘솔을 띄워서 다음과 같이 입력하면 theObj의 retain count 가 출력됩니다.


```print (unsigned int)[theObj retainCount]```



참고로, 재미삼아 위의 문장에서 (unsigned int) 부분을 지우고 실행해보면 '리턴 타입 정보가 없어서 "objc_msgSend" 함수를 호출할 수 없다'는 오류 메시지가 표시됩니다. Objective-C 에서 메시지 표현식이 내부적으로 어떻게 구현되는지 엿볼 수 있는 부분이겠네요. ^^