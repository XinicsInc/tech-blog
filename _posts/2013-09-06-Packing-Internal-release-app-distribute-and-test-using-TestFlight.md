---
layout: post
title: 'iOS 어플리케이션 배포하기 - (1) TestFlight를 이용한 내부 Release 버젼 배포 및 테스트'
author: xinics
date: 2013-09-06 20:51
tags: [.iOS,TestFlight]
---
# iOS 어플리케이션 배포하기

  ## (1) TestFlight를 이용한 내부 Release 버젼 배포 및 테스트



본 포스트에서 TestFlight를 이용한 내부 Release 버젼 배포 및 테스트 과정을 소개 한 후, 다음 포스트에서 앱스토어 등록을 위한 방법을 소개할 예정입니다. 이 포스트는 TestFlight에 가입하여 팀을 구성한 상태에서 읽어주시기 바랍니다.

1. TestFlight란?

    ![Introduce-TestFlight](/files/2013/09/06/TestFlight-1.png)


iOS 개발시 앱스토어에 등록하기 전 여러번의 테스트를 거치게 되는데, 그 때 마다 직접 기기에 연결 후 빌드해서 팀원들과 내부 테스터 분들에게 배포하기란 귀찮은 작업입니다. 또한 빌드시 Debug 모드 일 때와  Release 모드일 때는 다르죠. 그래서 Release 모드로 빌드된 앱을 배포하여 테스트를 할 필요가 있는데, 이 작업을 손쉽게 해주는 것이 바로 TestFlight 입니다.



2. Test Flight 설치하기

먼저 https://testflightapp.com 에 가입하여 Desktop App을 설치해 주세요 



3. Application Target 설정하기

새로운  배포용 앱(Archive)을 생성하는 것이므로 Version 과 Build 번호를 한단계씩 높여 줍니다. Summary -> iOS의 Application Target 에서 아래 그림과 같이 수정하시면 됩니다. Build번호는 같은 Release 버전에서도 몇 번 수정하여 배포할 수 있으니 소수점 뒤에 하나를 더 붙여줍니다. 

![SetupApplicationTarget](/files/2013/09/06/TestFlight-2.png)



4. Archive Build Configuration 설정

다음으로 Archive 를 생성할 때의 Build Configuration 을 설정해 주어야 됩니다. 아래 그림과 같이 Xcode 상단의 Scheme 에서 왼쪽에 앱이름이 적혀있는 부분을 클릭 하신후 Edit Scheme 으로 들어갑니다. 

![SetupArchiveBuildConfiguration](/files/2013/09/06/TestFlight-3.png)


Archive 탭의 Build  Configuration 항목에서 Release 로 설정이 되어 있는지 확인합니다. (Distribution은 앱스토어 배포용)


![CheckRelease](/files/2013/09/06/TestFlight-4.png)



5. Archive로 빌드하기

상단 메뉴바에서 Product -> Archive 를 누르시면 Release 모드로 빌드되어 Archive 가 생성됩니다. 


![ArchiveImg](/files/2013/09/06/TestFlight-5.png)

아래와 같이 Organizer 의 Archive 탭에서 정상적으로 생성된 것을 확인 하실 수 있습니다.


![CheckArchiveOrganizer](/files/2013/09/06/TestFlight-6.png)



6. Test Flight 에 어플리케이션 등록

아까 처음에 Test Flight 앱을 설치하셨으면 상단 메뉴바에 Test Flight 아이콘이 있습니다. 이를 클릭하시면 방금 Archive로 만든 앱목록이 나오는 것을 확인 하실수 있습니다. 이를 클릭하시고 확인 후 쭉 진행하시면 앱이 TestFligt 팀에 등록이 되고, 구성원들에게 메일이 전송됩니다.

2014.07.21 업데이트 : 정상적으로 앱을 등록했는데 설치 실패하는 기기가 발생하는 경우를 만났습니다. TestFlight App 에서 identity를 선택할 때, 해당 App의 App ID와 일치하는 iOS Team Provisioning Profile 을 선택하여 빌드를 등록하니 문제가 해결되었습니다.


![SetupProvisioningProfile](/files/2013/09/06/TestFlight-7.png)

그러면 아래와 같은 TestFlight 창이 뜨는데 이 때, 이 창에 있는 Identity와 Build Settings -> Code Signing 에 있는 Release 항목의 Provisioning Profile이 일치하는지 확인해 주세요. 


![checkCodeSigning](/files/2013/09/06/TestFlight-8.png)

 



7. 앱 설치하기

iOS 디바이스에 Archive 를 설치하는 방법입니다. 앱을 등록하는 시점에 미리 Device와 함께 Test Fligt 에 등록이 되어있던 사람은 받은 메일의 링크를 따라가면 앱을 설치할 수 있는 링크가 나옵니다. 

새로운 멤버나 장치에서 이 앱을 설치하고 싶으시다면 가지고 있는 Device 에서 "Safari" 를 통해 TestFlight 홈페이지에 접속하신 후 로그인을 합니다. 처음 들어가는 장치라면 로그인 직후 아래와 같은 하면이 나옵니다.


![LoginTestFlight](/files/2013/09/06/TestFlight-9.png)

Connect Device 버튼 을 누르시면 Provisioning Profile을 설치하라고 설정 창이 나오는데 설치해주시면 다시 웹 화면으로 돌아와서 "View All Apps" 란 탭이 생깁니다 이 탭을 클릭하시면


![ViewAllapps](/files/2013/09/06/TestFlight-10.png)

이러한 화면이 나오게되고, 여기서 INSTALL 을 하시면 설치가 됩니다

이제 내부테스트를 진행하시면 됩니다!