---
layout: post
title: 'Android에서 SignalR 사용하기'
author: xinics
date: 2015-06-19 17:02
tags: [Android,SignalR]
---

# SignalR 이란?

웹 서버와 브라우저 간의 실시간 양방향 통신을 위해 HTML5 표준인 WebSocket이 있습니다. 그러나 아직 WebSocket이 지원되지 않는 환경이 많습니다. Signal R은 MS에서 만든, 추상화를 통해 단일한 API로 서버와 클라이언트 간의 실시간 양방향 통신을 가능하게 해주는 라이브러리입니다. 내부적으로는 환경에 따라서 WebSocket을 사용하기도 하고 Long Poliing을 사용하기도 하는 등 다양한 방식을 사용합니다. 또한, 이러한 기능을 하는 대표적인 라이브러리로는 Node.js 기반의 Socket.IO가 있습니다! 



# Android에서 SignalR 사용하기

## 만드려고 하는 예제

서버와 클라이언트 허브에 각각 'hello' 라는 메소드가 있고 이 메소드는 문자열 하나를 인자로 받습니다.
안드로이드 클라이언트에서 서버에 hello 메소드를 통해 문자열을 보내면 서버도 클라이언트로 hello 메소드를 통해 같은 문자열을 보냅니다.
안드로이드 앱은 서버로부터 문자열을 받으면 Toast 메시지로 이를 보여줍니다.

## 구현하기 

1. 라이브러리 추가
signalR 자바 및 안드로이드 버전 클라이언트 라이브러리와 gson이 필요합니다. signalR 라이브러리들은 현재 jar을 공식적으로 받을 수 있는 곳은 없고 github 저장소에서 소스를 빌드하여 사용하셔야 합니다. gson은 로컬에 jar이 없어도 jcenter나 maven 저장소의 dependency를 지정함으로써 사용할 수 있긴합니다. 일단 이 예제를 진행하면서 빌드해 놓은 라이브러리 파일들과 bintray에서 받은 gson jar 파일을 첨부합니다.
 
 [gson-2.3.1.jar](/files/2015/06/19/gson-2.3.1.jar)

 [signalr-client-sdk-android.aar](/files/2015/06/19/signalr-client-sdk-android.aar)

 [signalr-client-sdk-android.jar](/files/2015/06/19/signalr-client-sdk-android.jar)

 [signalr-client-sdk.jar](/files/2015/06/19/signalr-client-sdk.jar)

최종 build.gradle 파일은 아래와 같습니다.

``` 
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:22.2.0'
    compile 'com.google.code.gson:gson:2.3.1'
    compile files('libs/signalr-client-sdk.jar')
    compile files('libs/signalr-client-sdk-android.jar')
}
```



2. Permission 추가 

네트워크 통신을 사용하므로 
```
<uses-permission android:name="android.permission.INTERNET"/>
```
 를 Android Manifest 파일에 추가해 줍니다.



3. 멤버변수 선언
```
public class MainActivity extends ActionBarActivity {

    HubConnection mConnection;
    HubProxy mHub;
```
MainActivity.java를 생성하고 통신의 주체가 되는 모듈인 HubConnection 과 HubProxy를 선언해 줍니다. 여러 곳에서 사용되기 때문에 이번 예제에서 간편함을 위해 멤버변수로 선언하였습니다.



4. 연결 설정 및 초기화
```
    private void initialize() {
        String serverUrl = "http://server.url";
        String hubName = "hubName";

        Platform.loadPlatformComponent(new AndroidPlatformComponent());
        mConnection = new HubConnection(serverUrl);
        mHub = mConnection.createHubProxy(hubName);
    }
```
SignalR 서버 Url과 서버에서 사용하는 hubName을 설정합니다. 



5. 메시지 받을 준비 하기

 ```
    private void prepareGetMessage() {
        mHub.on("hello", new SubscriptionHandler1<String>() {
            @Override
            public void run(final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }, String.class);
    }
```

Hub의 on 메시지를 통해서 서버가 hello 메소드를 호출할 경우의 리스너를 등록합니다. 앞서 말씀드렸듯이 이 메소드는 인자를 하나만 받기 때문에 리스너로 SubscriptionHandler1을 사용하였습니다. 인자가 여러 개일 경우 개수에 따라서 SubscriptionHanlder2, SubscriptionHanlder3, ... 클래스를 사용하시고 알맞은 클래스 타입을 설정해주면 됩니다. 
( 안드로이드는 아직 Java8을 지원하지 않아 Lambda Expression을 사용하지 못하여 코드가 상당히 기네요ㅜㅜ ) 



6. 연결 성립하기
```
    private void connectToServer() {
        try {
            SignalRFuture<Void> awaitConnection = mConnection.start();
            awaitConnection.get();
            Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();
        } catch(Exception e) {
            Log.e("SignalR", "Failed to connect to server");
        }
    }
```

동기 방식(Synchronous)으로 연결을 합니다. 따라서 Exception 없이 awaitConnect.get() 구문이 수행되고 나면 연결이 성립되었다고 볼 수 있습니다. 안드로이드에서 네트워크 통신 작업은 UI Thread에서 수행이 불가능하지만 위 메소드는 UI Thread에서도 호출이 가능합니다. 왜냐하면 실질적인 통신작업은 사실상 비동기로 이루어지고 awaitConnect.get()이 세마포어를 획득하기 위해 기다리는 식으로 구현되었기 때문입니다. 



7. 메시지 보내기
```
    private void sendMessage(String msg) {
        try {
            mHub.invoke("hello", msg).get();
        } catch( Exception e ){
            Log.e("SignalR", "Fail to send message");
        }
    }
```

Hub의 invoke 메소드를 통해 서버 Hub 메소드를 호출하는 식으로 메시지를 보냅니다. 이 역시 연결 성립할 때와 같은 방식으로 동기로 진행되며 UI Thread에서도 사용 가능합니다.



8. 연결 해지
```
    @Override
    protected void onDestroy() {
        mConnection.stop();
        super.onDestroy();
    }
```
stop 메소드를 통해 연결을 해지합니다. 이 예제에서는 앱의 onDestory가 호출 될 때 연결 해지를 하였습니다! 



9. 최종 결과 앱



![Result](/files/2015/06/19/signalr.jpg)


지금까지 말씀드린 내용을 구현한 소스파일을 첨부합니다.

 [activity_main.xml](/files/2015/06/19/activity_main.xml)

 [MainActivity.java](/files/2015/06/19/MainActivity.java)



### 참조

[Github : SignalR/java-client](https://github.com/SignalR/java-client)

[Github : SignalR/java-samples](https://github.com/SignalR/java-samples/tree/master/signalr-sample-chat)

[Getting Started with the Java SignalR SDK](https://whathecode.wordpress.com/2014/03/20/getting-started-with-the-java-signalr-sdk/)