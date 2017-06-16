---
layout: post
title: 'Xdebug를 이용한 PHP 디버그'
author: xinics
date: 2011-06-29 18:31
tags: [php, xdebug]
---

![Xdebug 실행화면](/files/2011/06/29/1.png)

Xdebug는 PHP 프로그램을 한 줄씩 실행시키며(line by line) 디버깅할 수 있는 PHP 확장 프로그램입니다.   

## Xdebug 설치

phpinfo() 를 실행시킵니다. 아래와 같은 코드를 포함하는 PHP 파일을 작성해서 브라우저에서 접속하면 됩니다.
   
```php
<?php
	phpinfo();
?>
```
   
![Xdebug 실행화면](/files/2011/06/29/2.png)

위와 같은 화면을 확인했으면 그 페이지의 소스 코드(HTML)를 복사합니다.
   
![](/files/2011/06/29/3.png)

Xdebug 홈페이지의 '[맞춤 설치](http://www.xdebug.org/find-binary.php)' 페이지에 접속합니다.

![](/files/2011/06/29/4.png)   

흰 텍스트박스에 아까 복사한 코드를 붙여 넣고, 아래의 ** Analyse my phpinfo() output ** 버튼을 누릅니다.   
   
![](/files/2011/06/29/5.png)   
결과 페이지의 아래에 다운받아야 하는 파일과 설치 방법이 설명되어 있으니 따라 하시면 됩니다.   
   
![](/files/2011/06/29/6.png)   
로컬 머신에서 작업한다고 가정했을 때, php.ini 에 디버깅을 위해 추가로 작성해야 하는 설정은 다음과 같습니다.   

```
xdebug.remote_enable=1
zend_debugger.allow_hosts=127.0.0.1
zend_debugger.expose_remotely=always
```

(IIS) 서버를 재시작하신 뒤 다시 phpinfo()의 결과를 확인했을 때, 아래와 같이 'with Xdebug…'라는 문구가 있으면 설치 성공입니다.   
![](/files/2011/06/29/7.png)  

   

## 이클립스에서 디버깅하기

1. 디버그하려는 프로젝트에서 Run>Debug Configurations 를 엽니다. (이클립스 Helios 버전 기준입니다. 버전에 따라 메뉴가 다른 곳에 위치할 수 있습니다)   
![](/files/2011/06/29/8.png)  

2. PHP Web Page 메뉴에서 New 를 선택합니다.   
![](/files/2011/06/29/9.png)  


3. 새 페이지가 만들어지면
Server Debugger: XDebug
File: (처음) 실행할 php 파일
으로 설정하고 Apply를 누릅니다.   
![](/files/2011/06/29/10.png)  

4. 이제부턴 F11 또는 메뉴의 벌레 버튼를 이용해서 디버그 모드를 실행하실 수 있습니다.
(처음 실행하시면 'debug perspective를 사용할 거냐'라고 물어보는데, Yes 하시면 됩니다)   
![](/files/2011/06/29/11.png)  


![디버그 모드](/files/2011/06/29/11.png)  
