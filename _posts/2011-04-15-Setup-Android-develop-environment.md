---
layout: post
title: 'Android 개발환경 설정'
author: xinics
date: 2011-04-15 12:21
tags: [Android]
---
# Android 개발환경 설정
 
자 이제 우리도 안드로이드 개발을 해봅시다.
안드로이드 개발에 앞서 필요한 환경은 일단 세가지 입니다.
 
제일 먼저, 안드로이드는 JAVA를 기반으로 구현된 플랫폼 입니다.
그러니 JAVA개발환경부터 세팅을 해야하지요.
자 일단, JDK를 설치해 봅시다.

## 1. JAVA개발환경 설정

### 1.1  JAVA SDK설치

JDK에는 세가지 버전이 있는데, 가장 보편적인 SE(Standard Edition)을 사용하도록 합시다.
https://cds.sun.com/is-bin/INTERSHOP.enfinity/WFS/CDS-CDS_Developer-Site/en_US/-/USD/ViewProductDetail-Start?ProductRef=jdk-6u24-oth-JPR@CDS-CDS_Developer
이 링크를 따라가서 자신의 OS환경에 맞춰 다운을 받으시면 됩니다.
대략 80MB정도의 용량입니다.
다운받고 설치를 하시면, 이제 JAVA를 개발할 수 있습니다!
 

### 1.2 환경변수 설정

하지만, JAVA의 컴파일은 커맨드 기반으로 진행되기 때문에, 편의를 위해서 환경변수 등록을 해줍시다.
왜 환경변수 설정을 하느냐?
일단, JAVA개발에 있어서 가장 자주 사용하는 커맨드는 두개, 컴파일하는 javac, 실행하는 java 입니다.
이것을 환경변수를 설정하지 않고, 사용하려고 하면
 
![javacError](/files/2011/04/15/Setting-Android-Develop-Enviroment-1.jpg)
 
이런 오류가 나옵니다.
커맨드를 사용하려면 실행파일이 있는 폴더까지 가서 실행해야 하는 불편함이 있지요.
현재 위치에 상관없이 어느 위치에서나 커맨드를 사용 가능하도록 하기 위해 환경변수를 설정하는 것입니다.
그럼 어디가서 환경변수를 설정하느냐?

![EnvironmentPath](/files/2011/04/15/Setting-Android-Develop-Enviroment-2.jpg)


시스템 속성창을 여시면 고급탭 하단에 환경변수 버튼이 보입니다.
버튼을 클릭하게 되면,

![EnvironmentPath2](/files/2011/04/15/Setting-Android-Develop-Enviroment-3.jpg)


이런 창이 뜹니다.
여기서 아래 시스템 변수 영역에서 path변수에 JAVA의 실행파일들이 위치한 폴더를 추가해줍시다.

![AddEnviromentPath](/files/2011/04/15/Setting-Android-Develop-Enviroment-4.jpg)

경로는 JDK가 설치된 폴더 하위의 bin폴더 입니다.
이렇게 환경변수를 설정하고 나서 다시 커맨드를 실행해봅시다.
 

![javacOK](/files/2011/04/15/Setting-Android-Develop-Enviroment-5.jpg)
 
아까와는 다르게 실행방법에 대한 설명이 주루루룩 나옵니다.
이제 JAVA개발환경은 준비가 되었습니다.

 
## 2.     Android SDK설치하기

이제 기반이 되는 JAVA는 설치를 마쳤으니, Android도 설치를 해봅시다.
http://developer.android.com/sdk/index.html
JDK와 마찬가지로 자신의 OS에 맞춰 Android SDK를 다운 받아봅시다.
현재 설치형 버전과 압축형 버전 두가지가 제공되고 있는데, 별 차이는 없습니다.
다만 설치형이 조금더 편하기에 설치형을 사용해 봅시다.
40MB가 조금 못되는 용량입니다. 다운을 받고 설치를 진행하게 되면 다음과 같은 창이 뜹니다.


![SDKManager](/files/2011/04/15/Setting-Android-Develop-Enviroment-6.jpg)

여기서 Android OS버전별 업데이트를 진행할 수 있습니다.
필수적으로 해야하는 업데이트는 Android SDK Tools, Android SDK Platform-tools 입니다.
업데이트까지 진행하고 나면, Android SDK설치는 완료되었습니다.
 
## 3. Eclipse 설치하기

### 3.1 Eclipse 설치

자 그럼 Android개발에 사용할 툴을 설치해봅시다.
Android가 지원하는 개발툴은 Eclipse입니다.
그럼 이것도 설치를 해봅시다.
http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/helios/SR2/eclipse-jee-helios-SR2-win32.zip
대략 300MB정도 됩니다. 가장 크죠.
 
Eclipse는 설치가 필요없이 다운받아서 압축만 풀어서 사용할 수 있습니다.
다운받은 파일의 압축을 풀어봅시다.
압축을 풀게되면, 다음과 같은 파일들을 보실 수 있습니다.
 
![Explorer](/files/2011/04/15/Setting-Android-Develop-Enviroment-7.jpg)


이중에서 딱 봐도 아이콘이 있는 eclipse.exe를 실행해 봅시다.
 

![LaunchEclipse](/files/2011/04/15/Setting-Android-Develop-Enviroment-8.jpg)

처음 실행하게 되면, 위와 같은 창이 뜹니다. 프로젝트를 저장할 작업 폴더를 설정해줘야 합니다.
사용할 작업 폴더 경로를 입력하고 OK를 클릭합시다.
 
 
![LaunchEclipse2](/files/2011/04/15/Setting-Android-Develop-Enviroment-9.jpg)

자 그러면 Eclipse는 설치가 완료되었습니다.
 

### 3.2 Toolkit설치

하지만, Android개발을 위해서는 또, 설정을 해줘야합니다.
뭐가 참 많죠? ㅠㅠ
일단 Android SDK와 연결을 위한 Toolkit을 설치해야 합니다.
 
메뉴의 Help -> Install New Software를 선택합니다.


![InstallNewSoftware](/files/2011/04/15/Setting-Android-Develop-Enviroment-10.jpg)

그리고 화면 상단의 ADD버튼을 클릭하여, Toolkit을 다운 받을 경로를 설정해줍시다.

![ToolkitPath](/files/2011/04/15/Setting-Android-Develop-Enviroment-11.jpg)


 
경로를 설정하게 되면, 설치가능한 툴킷목록이 주루룩 나옵니다.
  

![ToolkitList](/files/2011/04/15/Setting-Android-Develop-Enviroment-12.jpg)


일단 네가지 다 설치합니다.
 
다 설치하고 나면, 프로그램을 재시작하라는 다이얼로그가 뜹니다.
재시작!

 
### 3.3 Android SDK 경로 설정

다시 실행된 Eclipse를 보면 뭔가 Android스러운 아이콘들이 몇 개 보이기 시작합니다.
하지만 아직 끝나지 않았습니다.
이제 마지막 입니다.
Eclipse와 2번에서 설치한 Android SDK를 연결하기 위해서 Android SDK가 설치된 폴더경로를 지정해 주어야 합니다.
메뉴의 Window -> preferences 를 클릭해보시면
 
![EclipsePreferences](/files/2011/04/15/Setting-Android-Develop-Enviroment-13.jpg)



이런 창이 뜹니다.
목록중에 Android가 보이시죠?
저기에서 설정하면 됩니다.
 
![EclipsePreferences2](/files/2011/04/15/Setting-Android-Develop-Enviroment-14.jpg)



이렇게 SDK가 설치된 폴더경로를 설정해주고, Apply를 클릭하면 설치된 Android버전들이 주루룩 나타납니다.
OK를 누르시면 종료!
자 이제 Android개발을 위한 환경 설정을 마쳤습니다.
 
## 4. Hello! World!

### 4.1 프로젝트 생성하기

자 그럼 다 설치했으니, 설레는 마음으로 Hello! World!를 해봅시다.
먼저 프로젝트를 생성합니다.

![CreateProject](/files/2011/04/15/Setting-Android-Develop-Enviroment-15.jpg)

좌측의 Package Explorer에서 우클릭을 통해 메뉴를 열거나 상단 메뉴의 File -> New 에 보시면 Android Project가 보입니다! (보이지 않는 경우에는 맨 아래의 Other를 클릭하시면 Android -> Android Project를 찾으실 수 있습니다) 꾹 눌러주시죠.

![CreateProject2](/files/2011/04/15/Setting-Android-Develop-Enviroment-16.jpg)

나타나는 창에서 어플리케이션에 대한 대략적인 설정을 해줘야 합니다.
OS버젼, 어플리케이션 이름, 패키지 명, Activity(Main 역할을 합니다.)등을 작성하고 Finish를 클릭합니다.
프로젝트를 생성하면 기본적으로 Hello World가 템플릿 형식으로 구현되어 있습니다.
그래서 바로 실행을 해보도록 합시다.
Package Explorer영역의 프로젝트에서 우클릭후 Run As-> Android Application을 클릭합니다.
 

### 4.2 Virtual Device 생성하기
 
 
![VirtualDevice1](/files/2011/04/15/Setting-Android-Develop-Enviroment-17.jpg)


실행하려고 하면 위와 같이 다이얼로그가 뜹니다.
아직 만들어진 에뮬레이터가 없어서 만들라는 얘기지요. Yes를 클릭해서 한번 만들어봅시다.
  

![VirtualDevice2](/files/2011/04/15/Setting-Android-Develop-Enviroment-18.jpg)

우측 상단의 New를 클릭합니다.
에뮬레이터의 이름과 대상OS버젼, SD카드 사이즈를 설정하고 Create AVD를 클릭합시다.


![VirtualDevice3](/files/2011/04/15/Setting-Android-Develop-Enviroment-19.jpg)

이제 에뮬레이터가 만들어졌습니다.
 

### 4.3 Hello! World!

자 이제 준비는 끝났습니다. 좀 전과 같이 프로젝트를 실행하면


![LaunchVirtualDevice](/files/2011/04/15/Setting-Android-Develop-Enviroment-20.jpg)

짜잔 에뮬레이터가 실행됩니다. (대략 시간이 좀 걸립니다 -_-)
 
![LaunchVirtualDevice](/files/2011/04/15/Setting-Android-Develop-Enviroment-21.jpg)


Hello World!! 이렇게 대략적으로 Android 개발 준비를 마쳤습니다!!
이제 다함께 삽질의 세계로~