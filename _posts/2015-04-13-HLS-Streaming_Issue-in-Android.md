---
layout: post
title: '안드로이드에서의 HLS 스트리밍 이슈들'
author: xinics
date: 2015-04-13 10:31
tags: [HLS,Android]
---
알려진 안드로이드 HLS 스트리밍 이슈들

안드로이드에서 HTML video 태그를 이용하여 HLS를 서비스할 경우 정상적인 시청 환경을 제공할 수 없을 정도로 이슈가 많다는 것은 널리 알려진 사실입니다. 아래는 대표적인 HTML5 동영상 플레이어 중 하나인 [JWPlayer에서 정리한 이슈](http://www.jwplayer.com/blog/the-pain-of-live-streaming-on-android/) 입니다.

Android 2.3 (Gingerbread)
  · 지원 안함
Android 3.0 (Honeycomb)
  · HLS 스트림이 장치와 충돌을 일으킨다.
Android 4.0 (ICS)
  · VOD에서 seek 불가능
  · 영상 가로세로 비율이 감지되지 않아 이미지 변형을 일으킨다.
  · 전체화면 진입시 영상이 처음부터 다시 시작된다.
Android 4.1+ (Jelly Bean)
  · 영상 가로세로 비율 이슈는 수정되었지만 여전히 seek이 불가능하다.
  · 크롬에서 HLS를 인식하지 못해 mimetype 을 감지하지 못한다.
  · 전체화면 진입 시 오류가 발생하고 장치가 멈춘다.

Seek 불가, 화면 비율 깨짐, 전체화면 진입시 오류 발생 등 굵직한 이슈들이 많이 보입니다. 



2015년 4월, 국내 주요 기기들에서의 안드로이드 HLS 이슈

위 JWPlayer 포스트는 약 2년전인 2013년 2월 27에 작성되었습니다. 모바일 세상에서의 변화의 속도를 감안하면 결코 짧지 않은 약 2년여의 시간이 지난 지금은 이슈들이 많이 없어졌을까요? 자이닉스에서 현재 사용되고 있는 국내 주요 기기들에서도 이슈들이 발생하는지 테스트를 진행해 보았습니다. 

## 테스트 환경

1) 서버 환경
 Wowza 3.6.2

2) 테스트 기기 목록


|번호|기기명|운영체제|제조사|발매일|
|---|---|---|---|---|
|①|Galaxy S3|4.1 (Jelly Bean)|삼성|2012.09|
|②|Galaxy Note2|4.4 (KitKat)|삼성|2012.09|
|③|Galaxy Note3|4.4 (KitKat)|삼성|2013.09|
|④|Galaxy S5|5.0 (Lollipop)|삼성|2014.03|
|⑤|VEGA Racer|4.1 (Jelly Bean)|팬텍|2011.06|
|⑥|VEGA IRON2|4.4 (KitKat)|팬텍|2014.05|
|⑦|Optimus LTE2|4.1 (Jelly Bean)|LG|2012.05|
|⑧|LG G Pro2|4.4 (KitKat)|LG|2014.02|
|⑨|Nexus5|5.1 (Lollipop)|LG|2013.10|

* 위 테스트 기기들에 대해 기본 브라우저 및 Chrome 에서 진행
* 단 Nexus5는 Chrome이 기본 브라우저여서 Chrome만 진행함.
* Chrome 버전은 41로 테스트를 진행

## 테스트 결과

|이슈 내용|발생한 환경|
|---|---|
|영상이 가로세로 비율이 무시되고 화면에 꽉찬다.|<li>① Galaxy S3-기본 브라우저</li><li> ② Galaxy Note2-기본 브라우저</li>|
|전체화면(전체화면은 video 엘리먼트의 webkitEnterfullscreen 메소드를 의미합니다.) 진입 시 영상의 끝으로 간다.|<li>① Galaxy S3-기본 브라우저</li>|
|현재 시간이 계속 0초로 남아있다.|<li>① Galaxy S3-Chrome</li> <li>⑤ VEGA Racer-Chrome</li>|
|Seek이 불가능하다.|<li>① Galaxy S3-Chrome</li> <li>② Galaxy Note2-Chrome</li> <li>⑤ VEGA Racer-Chrome</li>|
|영상 전체 길이가 짧아진다. ( 예: 59분 59초 영상 -> 56분 45초 )|<li>② Galaxy Note2-기본 브라우저</li><li> ③ Galaxy Note3-기본 브라우저, Chrome</li><li> ⑤ VEGA Racer-Chrome</li> <li>⑥ VEGA IRON2-기본,브라우저, Chrome</li>|


비교적 최신 기기들과 OS에서는 이슈가 없는 경향을 보이지만 테스트 표본이 작고 명시적으로 보장한다는 명세가 없어 확신은 할 수가 없습니다. 또한 나온지는 조금 지났어도 아직 제법 높은 점유율을 가지고 있는 Galaxy S3나 Note2등의 기기에서는 확실히 정상적인 시청이 불가능할 정도의 많은 이슈가 있습니다. 따라서 아직까지는 안드로이드 HTML5에서 HLS 스트리밍을 제공하기에는 많은 어려움이 따른다는 결론을 낼 수 있을 것 같습니다.



## 안드로이드 네이티브 App으로 HLS 스트리밍을 할 때의 이슈

안드로이드 HTML HLS 스트리밍의 대안으로써 네이티브 앱을 제작하는 방법이 종종 제안되고는 합니다. 간단히 시청만 가능한 프로토타입 앱(안드로이드 SDK의 VideoView를 사용)을 제작하여 위와 같은 테스트 환경에서 확인해 보았습니다. 다수의 기기에서 어느정도 시청은 가능한 수준이라고 볼 수 있으나, 아래와 같은 공통적인 이슈가 발생하였습니다. 또한 아래 이슈들은 내장 플레이어에서도 동일하게 발생함을 확인하였습니다.

이슈내용
 * 영상 전체 길이가 짧게 나타난다. (59분 59초 영상 -> 56분 45초)
 * Seek시 Seek한 시간보다 뒤로 이동한다. ( 25:00 Seek -> 26:30으로 이동 )
 * 작게 측정된 전체 시간 이후의 시간을 재생하고 있는 동안은 Seek이 안 되는 현상 발생

발생 기기
 ① GalaxyS3, ② Galaxy Note2, ③ Galaxy Note3, ⑤ VEGA Racer