---
layout: post
title: 'Android Studio에서 Junit 기반 단위 테스트(Unit Test) 환경 구축하기'
author: xinics
date: 2015-07-09 18:29
tags: [Android]
---


## <span style="color:green">**Android Studio에서 Junit 기반 단위 테스트(Unit Test) 환경 구축하기**</span>

안드로이드 Instrumentation 테스트의 경우에는 안드로이드 장치 또는 시뮬레이터에 직접 테스트 코드를 올려서 테스트가 진행됩니다. 이러한 과정 때문에 비교적 느립니다. 다른 방식으로 데스크탑 환경에서도 테스트를 할 수 있습니다. 이 방식에서는 보통 Junit을 기반으로 다양한 Mocking 라이브러리 또는 Robolectric과 같은 프레임워크를 사용하여 테스트가 진행됩니다. 이 포스트에서는 이런 방식의 가장 기본이 되는 Junit 테스트 환경을 구축하는 방법에 대해 설명하겠습니다.



### **진행환경**

\* Window 8.1  /  * Android Studio 1.2.2



### **1. 프로젝트 생성**

Blank Activity 프로젝트를 기본 옵션으로 하나 생성합니다.



### **2. Unit Test 폴더 구조 생성**

안드로이드에서 **Instrumentation 테스트의 경우는 src/androidTest/java**를, **Junit 테스트의 경우에는 src/test/java**를 기본 테스트 폴더로 인식합니다. 

프로젝트를 생성하시면 기본적으로 androidTest 폴더가 생성되어있을 것입니다. 상단 좌측의 프로젝트 구조 보기를 'Project'로 선택하시고 **androidTest폴더에서 우클릭 -> Refactor -> Rename** 을 통해 test로 이름을 변경하면 됩니다.

![img1_changeFolderName](/files/2015/07/09/img1_changeFolderName.jpg)

### **3. 빌드 스크립트에 Junit 추가**

app의 build.gradle 파일을 열어서 dependency에 testCompile 구문을 추가합니다.
```java
dependencies {
　　...
　　testCompile 'junit:junit:4.12'
　　...
} 
```
메뉴에서 **Tools -> Android -> Sync Project with Gradle Files** 를 선택해 Gradle 파일을 Sync 시켜 줍니다.


### **4. Test Artifact 설정**

좌측 하단 **Build Variant 탭을 클릭한 후 Test Artifact를 Unit Tests로 설정해 줍니다.**

![img2_setTestArtifact](/files/2015/07/09/img2_setTestArtifact.jpg)

여기까지 하시면 안드로이드가 java 폴더를 테스트 폴더로 인식하여 첫번째 사진과 같이 **초록색** 아이콘 으로 표시되어야 합니다.



### **5. Unit Test 코드 작성**

이제 환결 설정은 다 끝났습니다! 작동하는지 알아보기 위해 간단히 Calculator 클래스를 만들어서 두 정수를 더하는 메소드를 테스트 해보겠습니다.

아래와 같이 Calculator랑 CalculatorTest 클래스를 생성하고 코드를 써줍니다.

![img3_srcStructure](/files/2015/07/09/img3_srcStructure.jpg)


<table>
<tr>
<td>
Calculator.java
</td>
<td>
CalculatorTest.java
</td>
</tr>
<tr>
<td>
   <pre lang="java">
public class Calculator {
    public int add(int a, int b) {
　　　　return a+b;
　　}
}
   </pre>
</td>
<td>
  <pre lang="java">
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
　　@Test
　　public void testAdd() {
　　　　Calculator calculator = new Calculator(); 
　　　　int actual = calculator.add(10, 10); 
　　　　int expected  = 10+10;
　　　　assertTrue(actual == expected);
　　}
}
  </pre>
</td>
</tr>
</table>

### **6. 테스트하기**

테스트 java 폴더에서 **우클릭 -> Run -> All Tests**를 통해 테스트를 실행할 수 있습니다. 성공하면 아래와 같은 결과가 나옵니다.

![img5_testResult](/files/2015/07/09/img5_testResult.jpg)

끝!

참조

[https://developer.android.com/training/testing/unit-testing/local-unit-tests.html](https://developer.android.com/training/testing/unit-testing/local-unit-tests.html)

[http://tools.android.com/tech-docs/unit-testing-support](http://tools.android.com/tech-docs/unit-testing-support)
