---
layout: post
title: 'Windows Service 프로젝트 만들기'
author: xinics
date: 2010-09-01 17:46
tags: [.NET]
---

빠른 공유를 위해 내용보다는 이미지를 주로 이용하여 기본적인 사항만을 전해드리도록 하겠습니다.

**서비스 프로젝트 만들기**
-   Visual C# > Windows > Windows 서비스를 선택.
    ![새 프로젝트 만들기](/files/2013/09/clip_image001_8b9d3714-b49e-45d4-a189-ee9f426f0ff4.png)
-   솔루션 탐색기에서 Service1.cs 이름을 적절한 이름으로 변경.
-   솔루션 탐색기에서 Service1.cs 를 오른쪽으로 클릭하여 코드 보기를 한다. 다음과 같은 메서드에 필요한 작업을 넣으면 된다.
    -   서비스를 시작할 때에는 그리 길지 않은 시간의 타임아웃 제한이 있으므로, 오래 걸리는 작업은 OnStart 에 넣지 않는 것이 좋다.
        ```csharp
protected override void OnStart(string[] args)
{
}

protected override void OnStop()
{
}
        ```

-   이벤트 로그는 다음과 같이 기록할 수 있다.
    ```csharp
void LogEvent(string message, EventLogEntryType type)
{
    string source = "Service1";
    string log = "Application";
    if (!EventLog.SourceExists(source))
    {
        EventLog.CreateEventSource(source, log);
    }

    EventLog evLog = new EventLog();
    evLog.Source = source;
    evLog.WriteEntry(message, type);
}
    ```

**서비스 설치 기능 추가**
-   Service1.cs의 디자인 모드에서 오른쪽 클릭하여 "설치 관리자 추가"를 선택한다.
    ![설치 관리자 추가](/files/2013/09/clip_image004_5880fb8e-ab9c-4b54-8af5-a9f3faa87693.png)
-   그러면 ProjectInstaller.cs 가 추가되어 디자인 모드로 표시된다.
-   serviceProcessInstaller1 을 선택하고 속성 패널에서 속성을 설정한다.
    -   Account의 기본값은 User로 되어 있는데, 보통 서비스는 LocalSystem을 사용한다.
    ![serviceProcessInstaller1 속성 설정](/files/2013/09/clip_image005_a592805a-fe7d-45db-854a-21ba9b05b2df.png)
-   serviceInstaller1 을 선택하고 속성 패널에서 속성을 설정한다.
    -   Description : 서비스 관리 목록에서 표시되는 서비스 설명
    -   ServiceName : 서비스 관리 목록에서 표시되는 서비스 이름
    -   StartType : Atomatic - 시스템 부팅 시 서비스가 시작되도록 설정
    ![serviceProcessInstaller1 속성 설정](/files/2013/09/clip_image006_56983b5f-cfb9-471d-beba-da3c7cce99c3.png)

**서비스 설치 및 제거**
-   서비스를 빌드한 후, Visual Studio Command Prompt 에서 다음과 같은 명령을 실행한다.
    -   installutil "서비스 EXE 경로"
    ![서비스 설치](/files/2013/09/clip_image007_8916078d-5bc0-4696-b730-1cd1c1158fca.png)
-   서비스 관리 도구에 추가된 것을 볼 수 있다.
    ![서비스 관리 도구에 추가됨](/files/2013/09/clip_image008_2dfe6ddf-5704-43e6-b737-6600cf182f23.png)
-   서비스 제거 시에는 /u 옵션을 추가하면 된다.
    -   installutil /u "서비스 EXE 경로"
    ![서비스 제거](/files/2013/09/clip_image009_e06b694e-b333-4757-87f0-65ba69456ab6.png)