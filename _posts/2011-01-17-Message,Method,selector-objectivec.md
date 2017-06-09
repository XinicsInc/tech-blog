---
layout: post
title: '메시지, 메소드, 셀렉터에 대해서'
author: wafe
date: 2011-01-17 23:55
tags: [Objective-c]
---

Objective-C 에 구현된 개체 중심(Object-Oriented, 보통은 객체 지향이라고 하죠) 패러다임 관점은 Smalltalk 언어에서 영향을 받았습니다. 그래서 프로그램이란 개체들과 그 개체들 사이에서 일어나는 메시지 교환으로 바라보는 것이 Objective-C 에서의 OOP 관점입니다.  클래스 조차도 개체로 생각하기 때문에, 클래스에도 메시지를 보낼 수 있게 되어 있습니다. C++의 static method 와 대응되는 개념이라고 볼 수도 있죠. 특정 클래스의 인스턴스를 생성할 때 사용하는 alloc이나 init 같은 것이 대표적입니다.

C++의 메소드 호출과 대응된다고 볼 수 있는 Objective-C의 메시지 표현식은 아래와 같은 형태입니다.
```
[receiver message]
```
수신자를 정해서 메시지를 보내는 것이지요. 

클래스에 정의된 함수들을 Objective-C 에서도 동일하게 메소드(method)라고 부릅니다. 개체들이 동작하는 방식을 결정하기 때문에 method(방식)이라고 부르는 것입니다.
```
[myRectangle display];

[myRectangle setWidth:20.0];

[myRectangle setOriginX: 30.0 y:50.0]
```
위의 세 가지 메시지 표현식은 인자(argument)를 지정하지 않았거나, 하나 지정했거나, 두 개 지정한 메시지 표현식을 보여주고 있습니다. 각각의 메시지 표현식에서 인자를 뺀 부분, 즉 display, setWidth:, setOriginX:y: 는 개체에 있을 메소드를 선택하는 역할을 하고 있으므로 선택자(selector)라고 합니다. 

참고로, Objective-C 에는 메시지 포워딩이라는 개념이 있는데, 특정 개체에 구현되지 않은 메시지를 받았을 때 다른 개체에게 메시지를 보내서 처리를 위임하는 개념을 의미합니다. COM에도 비슷한 개념이 있는데, 메시지를 주고 받는다는 개념에서 출발한 '메시지 포워딩'이라는 말이 좀 더 이해하기 좋다는 생각이 듭니다. 