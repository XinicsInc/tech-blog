---
layout: post
title: 'Xcode 4에서 NSZombie 사용하는 방법'
author: xinics
date: 2011-07-21 11:39
tags: [Objective-C,NSZombie,iOS]
---

Xcode 4는 이전 버전과 UI가 완전히 달라져서 힘드네요 orz

전에 EXC_BAD_ACCESS 를 디버깅하는 방법을 포스팅한 적이 있는데, 달라진 UI에 맞추어 다시 설명해보도록 하지요.

Environment 설정이 이제는 Scheme 쪽으로 통합되었습니다. 좌측 상단에 있는 시뮬레이터로 실행할지 실제 장비에서 실행할지 선택하는 부분이 Scheme 선택 UI 입니다.

![createImage](/files/2011/07/21/NSZombie-1.jpg)


여기서 Edit Scheme... 을 고릅니다.

![createImage](/files/2011/07/21/NSZombie-2.jpg)

그 후 뜨는 대화창에서 좌측의 Run <앱 이름> 항목을 선택합니다. 그리고 Arguments 탭으로 가서 Environment Variables 섹션에 NSZombieEnabled 를 추가해주면 됩니다. 한 번 추가해놓고 필요할 때에만 체크박스에 체크해서 사용하면 됩니다.

![createImage](/files/2011/07/21/NSZombie-3.jpg)