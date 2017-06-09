---
layout: post
title: '여러 개의 인자를 받는 메소드'
author: wafe
date: 2011.01.20 23:22
tags: [Objective-c]
---
Objective-C 에서 여러 개의 인자를 받는 메소드는 다음과 같은 모양으로 선언됩니다.
```
(void)setWidth:(float)width height:(float)height;
```
파라미터마다 반드시 하나씩 이름이 붙는 것처럼 보이기는 하지만, 이것은 Python이나 C# 에서 제공되는 Named Parameter 와는 달리 순서를 바꿔 쓸 수 없습니다. 아래와 같이 세 개의 인자를 받는 인스턴스 메소드가 있을 때,
```
(void)setCoordinatesX:(float)x y:(float)y z:(float)z; 
```
다음과 같은 메시지 표현식은 위에 있는 메소드와 대응되지 않습니다. (y: 와 z: 의 순서가 바뀌었지요)
```
[myCoordinates setCoordinatesX:1.0 z:2.0 y:3.0]
```
즉,    (void)setCoordinatesX:(float)x y:(float)y z:(float)z  라는 메서드와 (void)setCoordinatesX:(float)x z:(float)z y:(float)y  라는 메서드는 서로 다른 메서드이며, 한 클래스 안에 같이 정의될 수 있습니다.


여러 개의 인자를 받는 메소드에서 재미있는 부분이 또 하나 있는데, 동일한 파라미터 이름을 반복해서 쓸 수도 있습니다. 아래와 같은 메서드 선언이 가능한 것이지요.
```
(void)setValue:(int)v1 val:(int)v2 val:(int)v3; 
```
어차피 Objective-C 에서는 메소드의 파라미터 순서를 바꿔서 호출하거나, C++ 에서처럼 선언시에 파라미터 기본값을 설정해서 호출시에는 생략할 수 있는 기능이 제공되지 않기 때문에 위에서와 같은 메소드를 정의해도 별 문제가 없겠지요. 