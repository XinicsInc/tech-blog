---
layout: post
title: 'EXC_BAD_ACCESS 메모리 문제 디버깅하기'
author: xinics
date: 2011-03-12 09:38
tags: [iOS,Objective-C]
---

EXC_BAD_ACCESS 오류가 나면서 프로그램이 종료되는 현상은 이미 소멸된 개체의 포인터에 메시지를 보낸 것이 원인입니다.

문제는 이렇게 종료되었을 때 코드의 어느 부분에서 그러한 메시지 전달이 시도되었는지 알려주지 않아서 디버깅이 정말 힘들다는거죠. 

이럴 때 NSZombie를 사용해야 합니다. 

XCode 왼편 목록에서 Executables 중 디버깅하려는 항목의 Get Info로 들어갑니다. 거기서 Arguments에 NSZombieEnabled 를 YES로 성장하는 항목을 추가해줍니다. 그리고 디버깅을 하면 됩니다. 

이렇게 설정하면 개체가 소멸된 그자리에 좀비가 남아서 잘못된 메시지 전달 시도라는 것을 알려줍니다. 

문제에 대한 디버깅을 마치면 위에서 추가한 NSZombieEnabled Argument를 지우거나 체크 해제해줍니다. 
