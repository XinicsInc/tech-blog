---
layout: post
title: 'InstallShield X 사용법 1. 인스톨러 메타데이터 작성하기'
author: xinics
date: 2010-05-12 11:49
tags: [InstallShield]
---

### 준비물 : InstallShiled X, 배포할 프로그램 및 라이브러리
 
# 인스톨러 메타데이터 작성

### InstallShiled X 실행

###  새로운 프로젝트 작성
InstallShield X를 실행하면 다음과 같은 화면을 볼 수 있는데, 새로운 인스톨러를 작성하기 위해 하단의 그림에 표시된 ‘Create a new Project’를 클릭한다.

![createImage](/files/2010/05/12/Part-1/image1.png)

그 다음 생성된 다이얼로그에서, InstallScriptProject를 선택하고, Project Name에 배포할 프로그램의 이름을 기입하고, Location에는 프로젝트 파일을 저장할 폴더를 지정한다.

![createImage](/files/2010/05/12/Part-1/image2.png)

 

### 인스톨러 프로젝트 작성
 
![createProject](/files/2010/05/12/Part-1/image3.png)

프로젝트를 생성하면 상단과 같은 화면을 볼 수 있는데, 프로그램 상단의 탭중에서 Installation Designer를 선택한다. 좌측에 여러 항목들이 나열된 것을 볼 수 있는데, 각 항목별로 인스톨러 작성을 위한 설정을 해주어야 한다.
 
#### Installation Information

General Information은 말 그대로 일반적인 프로젝트의 정보들을 설정하는 항목이다. 프로젝트 이름이나 버전, 언어, 설치할 폴더 위치 등을 지정할 수 있다. 그리고 다음에 나올 스크립트 작성에서 사용할 문자열들을 설정할 수 있다. 여기서 주로 수정하는 부분은 Product Properties이다.

![ProductProperties](/files/2010/05/12/Part-1/image4.png)

여기서 배포할 프로그램의 이름이나 버전, 설치 경로, 회사 이름, 홈페이지 등을 설정할 수 있다. Executable File항목은 메인 실행파일의 이름을 등록하는 것으로, 다음(c.ii)에 나올 컴포넌트들을 추가한 다음에 작성하면 된다. Product GUID는 OS에서 설치된 프로그램을 구분하는 key값으로 같은 인스톨러라도 이 값이 다르면 OS에서는 서로 다른 프로그램으로 인식한다.
**(Update Service는 사용해 본 후에 작성하겠습니다.)**
 
#### Organization

설치할 프로그램의 구성을 설정하는 항목이다. Setup Design, Features, Components, Setup Types등의 항목을 포함하고 있는데, 각각의 항목은 프로그램을 구성하는 단위들이다. 여기서부터는 임시로 작성한 프로젝트를 가지고 설명하겠다. Component는 최하위 단위로 설치할 파일들을 포함하고, 설치에 관련된 설정을 할 수 있다.
![NewComponenetImage](/files/2010/05/12/Part-1/image5.png)

그림과 같이 Components 항목을 우클릭하면 ‘New Component’라는 항목이 나온다. 클릭하여 Component를 추가해주자. 컴포넌트를 추가한 후, 해당 컴포넌트를 클릭하면 다음과 같은 항목들을 볼 수 있다.
![NewComponenetPropertiesImage](/files/2010/05/12/Part-1/image6.png)



**Destination**은 파일들이 설치될 경로를 나타내고, <TARGETDIR>은 2.c.i에서 지정한 설치 폴더의 경로이다. 다른 프로그램과 공용으로 사용하는 라이브러리나 시스템 파일들의 컴포넌트는 Destination을 시스템 폴더인 <WINSYSDIR>로 지정해 주자.

**Shared**는 다른 프로그램과 해당파일들을 공유하는지의 여부이다. Ocx나 dll등 여러 프로그램에서 공용으로 사용하는 라이브러리나 리소스 파일들의 경우, 이 항목을 ‘Yes’로 해주지 않으면, 프로그램을 Uninstall할 때, 다른 프로그램의 사용여부에 관계없이 파일을 지워버리기 때문에 꼭 ‘Yes’로 해주어야 한다.

**Uninstall**은 uninstall시 해당 컴포넌트의 삭제 여부이다. 기본적으로 ‘Yes’로 설정되어 있다.

**.NET Scan at Build**의 경우 ‘None’외의 항목을 선택하면 빌드시 수많은 경고와 긴 시간을 소모하므로, 꼭 필요한 경우가 아니라면 ‘None’을 선택하자.

**Self-Register**항목은 registry에 자동으로 파일들을 등록하는지의 여부이다. OCX와 같은 active X들의 경우 ‘Yes’로 지정해 주자.

**Link Type**는 컴포넌트에 파일을 연결하는 방식을 말하는 것으로 ‘Static’과 ‘Dynamic’이 있다. Static의 경우, 폴더나 파일 하나하나를 추가하는 방식이고, Dynamic의 경우 경로를 지정해서 해당 폴더의 모든 하위 항목을 연결하는 방식이다.
 
컴포넌트의 속성들을 설정해 준 후, 컴포넌트를 append 하면 Static(or Dynamic)File Links항목을 볼 수 있는데, 여기에 다음과 같이 컴포넌트에 포함될 파일들을 추가해주자.
 
![ComponentFileList](/files/2010/05/12/Part-1/image7.png)
 

필요한 컴포넌트들을 모두 작성한 후, Setup Design항목을 클릭하여 작성한 컴포넌트들을 아래 그림과 같이 Feature에 연결해 주자.

![ComponentFileList](/files/2010/05/12/Part-1/image8.png)
 
 
Associate Components를 클릭하면 다음과 같이, 작성한 컴포넌트들의 목록이 나타난다. 여기서 연결할 컴포넌트를 선택하고 OK를 클릭하면 연결이 완료된다.
 
![ComponentFileList](/files/2010/05/12/Part-1/image9.png)
 

모든 컴포넌트들을 연결하고 나면, 추가적인 설정이나 프로그램설치가 필요 없는 경우, 여기서 인스톨러 작성이 끝날 수 도 있다.

#### System Configuration

시스템 구성에는 두가지 항목이 있는데, 하나는 인스톨시 바로가기를 작성해주는 Shorcuts와 레지스트리를 등록하는 Registry이다.
**Shortcuts**의 경우 아래와 같이 트리구조 상에서 폴더를 지정할 수 있다. 바로가기를 추가할 폴더를 우클릭하면, New Shortcut, New Internet Shortcut, New Shortcut to preexisting file세가지 항목이 나오는데, New Shortcut을 선택하면, 앞서 컴포넌트에 등록한 파일 중에 하나를 선택할 수 있고, New Internet Shortcut은 URL을 지정하여 웹페이지를 연결할 수 있다.
 
![ShortcutDescriptionImage](/files/2010/05/12/Part-1/image10.png)

**Registry**의 경우, 설치 후 Registry에 기록할 내용을 설정하는 항목이다. 현재 컴퓨터의 레지스트리 구조도 함께 표시되므로 참고하여 작성할 수 있다.
 
### Behavior and Logic

Behavior and Logic은 설치과정을 설정하는 항목으로, 예를들어 설치시에 컴포넌트들을 선택적으로 설치할 수 있게 해주는 typical등의 형식이나, 설치완료 후, 재부팅이나 프로그램 실행 등의 전반적인 설치과정을 설정할 수 있다.

**InstallScript**는 설치과정중에 필요한 사항들을 코드를 통해 작성하는 항목으로 작성하지 않고 빌드하면 기본적인 설치과정을 포함한다.

**Support Files/Billboards**는 설치시 언어별로 따로 설치를 해야 하거나, 추가적인 구성요소를 설치할 필요가 있을 때 설정하는 항목이다. 그리고 Splash Screen을 통해, 인스톨러를 실행했을 때, 처음에 나타나는 로고나 배경을 설정할 수 있다.
이 항목들은 작성자의 의도에 따라 매우 다양한 경우의 수를 포함하고 있기 때문에 예를 들어 설명하겠다. 만약에 해당 프로그램을 설치하는데, 반드시 필요한 구성요소가 있다면, 이미 로컬머신에 해당 구성요소가 설치되어있는지를 체크하고, 없다면 설치를 진행하는 경우를 설명하겠다. 캠을 이용해 동영상을 녹화하는 프로그램을 배포하는 경우, Windows Media Endcor(WME)가 필요하기 때문에, 먼저 Support Files에 다음과 같이 WME설치 파일을 추가한다.

![BehaviourAndLogicImage](/files/2010/05/12/Part-1/image11.png)

파일을 추가한 후에, InstallScript항목으로 이동해서, WME의 설치여부를 판단하고 없다면 설치를 진행하는 코드를 작성한다. 코드는 Visual Basic기반으로 작성한다.
아래의 코드는 WME 9.1의 설치여부를 체크해주는 메소드이다.

![BehaviourAndLogicImage](/files/2010/05/12/Part-1/image12.png)

코드를 보면, Registry를 검색해서 설치여부를 판단하는 것을 알 수 있다. WME외에 다른 프로그램들도 Registry에 버전정보나 설치정보를 기록하는 경우가 많기 때문에 이를 검색해서 사용할 수 있다. (기존 프로젝트의 코드를 참조하면 이해에 도움이 된다.)

![BehaviourAndLogicImage](/files/2010/05/12/Part-1/image13.png)

코드를 작성하는 Editor에서 상단을 보면 위와 같이 두개의 콤보박스가 있는데, 여기서 인스톨이 진행되는 동안 발생하는 기본적인 이벤트핸들러들을 추가할 수 있다. 인스톨러가 시작할 때 발생하는 OnBegin이벤트나 언인스톨을 진행할 때 발생하는 OnUninstallingFile등 각각의 경우에 대한 이벤트핸들러가 존재하기 때문에 필요에 따라 선택하여 추가해주면 된다. 

![BehaviourAndLogicImage](/files/2010/05/12/Part-1/image14.png)

위 코드의 경우, 첫번째 UI가 실행되기 전에 발생하는 이벤트인 OnFirstUIBefore에 WME의 설치여부를 체크하고, 설치를 진행하는 과정을 추가한 것으로, WME가 설치되어 있지 않거나 필요버전보다 하위버전인 경우 다이얼로그를 띄워서 유저에서 알려주고, Support Files에 추가한 WME설치파일을 실행한다. 그림에 보이는 여타 다른 코드들은 상단의 콤보박스에서 선택시 자동으로 추가된다.
여기까지하면 인스톨러 메타데이터 작성은 완료된 것이다.