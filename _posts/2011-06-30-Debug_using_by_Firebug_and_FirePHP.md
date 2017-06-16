---
layout: post
title: 'XE 개발, Firebug + FirePHP로 디버그하기'
author: xinics
date: 2011-06-30 12:45
tags: [php, xdebug]
---

## Firebug + FirePHP 설치

1. Firefox를 다운받아 설치합니다.
[FireFox 다운로드](http://www.mozilla.com/firefox)

2. 도구>부가 기능에 들어가서
![](/files/2011/06/30/063011_0350_XEFirebug1.png)

Firebug와 FirePHP를 검색해 설치하고 브라우저를 재시작합니다.

![](/files/2011/06/30/063011_0350_XEFirebug2.png)

3. 브라우저 우하단의 벌레를 클릭합니다.

![](/files/2011/06/30/063011_0350_XEFirebug3.png)

4. Firebug 메뉴에서 Net 탭을 클릭하고 Enable을 눌러 Net 패널을 활성화시킵니다.

![](/files/2011/06/30/063011_0350_XEFirebug4.png)
   

## Firebug를 이용해 XE 디버그하기

1. XE 프로젝트에서 /config/config.user.inc.php 를 만들어서 열고 다음과 같이 설정합니다.

![](/files/2011/06/30/063011_0350_XEFirebug5.png)

각 설정값에 대해서는 /config/config.user.php 에 자세히 설명되어 있으나, 간략히 설명하면 다음과 같습니다.

__DEBUG__ == 1: debugPrint() 함수를 통해 메시지 출력

__DEBUG_OUTPUT__ == 2: Firebug 콘솔에 출력

__DEBUG_PROTECT__ == 0: 모든 IP에서 디버그 메시지 확인 가능


2. 디버깅 메시지를 출력하고 싶은 php 파일을 열고 다음과 같이 debugPrint() 함수에 메시지를 설정합니다.
![](/files/2011/06/30/063011_0350_XEFirebug6.png)


3. Firefox에서 해당 페이지에 접속하면 설정해 둔 메시지가 Firebug 콘솔에 출력되는 것을 확인할 수 있습니다.
![](/files/2011/06/30/063011_0350_XEFirebug7.png)


만약 Firebug가 아니라 파일에 메시지를 출력하고 싶다면 /config/config.user.inc.php 에서 __DEBUG_OUTPUT__을 0으로 설정합니다. 그러면 메시지가 Firebug 콘솔 대신 /files/_debug_message.php 파일에 저장됩니다.
![](/files/2011/06/30/063011_0350_XEFirebug8.png)