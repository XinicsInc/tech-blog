---
layout: post
title: 'SCPlugin'
author: xinics
date: 2011-01-18 16:03
tags: [iOS,SCPlugin]
---
오랜만에 글을 쓰네요. 연말 중에는 정신 없어서 방치했던 개발부 블로그님...

요즘 Xcode를 뚝딱거리느라 -_-; iOS에서 svn을 사용하는 방법을 __wafe__ 과장님께서 알려주셨습니다.
**iOS에서 Tortoise SVN처럼 폴더 메뉴를 이용하여 svn에서 업데이트하고, 커밋할 수 있는 놈**이 있더군요.
바로 **SCPlugin**인인데요.

설치 방법과 사용법은 굉장히 간단합니다.

[SCPlugin 사이트](http://scplugin.tigris.org/)에서 **Download 탭을 누르신 뒤, 가장 최신 설치 파일을 다운로드 받으셔서 설치**하시면 됩니다.

![createImage](/files/2011/01/18/image1.png)

설치를 마쳤으면, *Application(응용 프로그램)폴더로 이동하여 SCToolbarButton을 마우스로 클릭한 채로 Finder 윈도우 상단으로 드래그* 하여 이동시킵니다.

![createImage](/files/2011/01/18/image2.png)

svn에서 체크아웃 받을 폴더로 이동하여,**SCToolbarButton을 클릭하면, svn 관련하여 익숙한 메뉴들이 나열**됩니다.

![createImage](/files/2011/01/18/image3.png)

여기서 당연히 Checkout을 클릭하시면 되겠죠? ' ㅅ')/
Checkout을 클릭하면, **저장소 주소(Repository URL), 본인 계정(Username, Password), Checkout받을 프로젝트 폴더 경로(Checkout to)를 설정**해주시면 됩니다.

![createImage](/files/2011/01/18/image4.png)

모든 설정을 완료한 뒤, **Checkout 버튼을 클릭**하면 끝!
간단하죠잉 ' ㅅ')/
이후부터는, SCToolbarButton을 통해 업데이트, 커밋을 사용하시면 됨돠.

그럼 저는 이만 뿅!