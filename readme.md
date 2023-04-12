<div align="center">

# Sduty+

<img src="https://user-images.githubusercontent.com/49026286/202903659-84b39720-96f9-4a7c-8ea8-80c8e299ad35.png" width="200" height="200"/>

<br/>

**공부 인증 스터디앱**
<br>
  <a href="https://play.google.com/store/apps/details?id=com.d205.sdutyplus">
    <img alt="Get it on Google Play" title="Google Play" src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png' width="180">
  </a>
</div>

<br/>

# 목차

[1. 개요](#개요)

[2. 담당역할 및 구현](#담당역할-및-구현)

<br>

## 개요

- Timer를 통해 학습 시간을 관리하고 SNS로 인증하고 공유할 수 있는 Android 앱
- Rest 서버와 통신하며, MVVM과 Clean Architecture를 기반으로 유지보수성을 향상시키고자 함

<br/>

## 구축 인원 및 기간

<b> - 기간 : 2022-010 ~ 2022-11+ (총 7주+) </b> <br/>
<b> - 인원 : 6명 (Android 4, Backend 2) </b>

<br>

## 프로젝트 기능 소개

<br>

### ⏱ 타이머

<img src="https://user-images.githubusercontent.com/49026286/202905679-e269b04f-0b62-4d92-94bb-3be739a6eaa1.gif" width="300" height="610"/>
<img src="https://user-images.githubusercontent.com/49026286/202933761-d9f2ba67-d668-4be4-b5a7-0a1ef1fa6feb.gif" width="300" height="610"/>

실제 공부하는 시간을 측정하는 타이머를 통해 공부 시간을 측정하고 기록을 저장할 수 있어요.

<br>

### 📙 리포트

<img src="https://user-images.githubusercontent.com/49026286/202905787-523feaa6-f498-4983-911c-bfe87f69b0d6.gif" width="300" height="610"/>
<img src="https://user-images.githubusercontent.com/49026286/203218539-42078568-8495-4031-83d6-4777f75c977b.png" width="300" height="610"/>

타이머로 기록된 특정 일자의 공부 시간과 내용을 리포트를 통해 확인할 수 있어요.

<br>

### ⌛ 타임라인

<img src="https://user-images.githubusercontent.com/49026286/202906189-e0fcc9c0-6187-4199-bbe7-ab8a1c0e4872.png" width="300" height="610"/>
<img src="https://user-images.githubusercontent.com/49026286/202933701-c05e504a-9d1d-4491-95cc-faefd2954f0c.jpg" width="300" height="610"/>

다른 사람들과 공부한 내용을 공유할 수 있어요.

<br>

### 📊 통계

<img src="https://user-images.githubusercontent.com/49026286/202933789-ed946a7a-5a5d-4f03-a24b-29f4d204e8cb.gif" width="300" height="610"/>

오늘 하루 공부한 결과를 통계 자료를 통해 시각적으로 볼 수 있어요.

<br>

## 시스템 구조도

<div align="center">

<img src="https://user-images.githubusercontent.com/49026286/202906377-f1317e67-ebb5-4aef-a444-806d1eee1bab.png" width="720" height="480"/>

</div>
<br>

## 기술 스택

<table>
<tr><th rowspan="1">🐬Front-end</th><td>Android, Kotlin, Jetpack, Figma, Clean Architecture</td></tr>
<tr><th rowspan="1">🍀Back-end</th><td>Spring Boot, Spring Security, JPA, Querydsl, JWT, MariaDB, Firebase, JUnit, JMeter</td></tr>
<tr><th rowspan="1">🛠Server</th><td>EC2, Docker, Jenkins, Nginx, Certbot</td></tr>
<tr><th rowspan="1">👨‍👩‍👦‍👦Collaboration</th><td>Gitlab, Jira Software, Mattermost, Notion</td></tr>

</table>

<br>

## Git 사용 규칙

🌐 Git Flow

```
master : 제품으로 출시될 수 있는 브랜치
release : 이번 출시 버전을 준비하는 브랜치
develop : 다음 출시 버전을 개발하는 브랜치
feature : 기능을 개발하는 브랜치
hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치

```

🌐 Git branch 생성 규칙

master  ← (release) ← develop ← be/fe ← feat  **순서대로 머지** 한다.

개발 시 **feat-기능 이름** 으로 브랜치를 만들어 상위에 머지한다.

- BE/**feat/naver-login**
- FE/**feat/naver-login**

UI만 작업을 할때는 가장 뒤에 UI를 작성한다.

- FE/**feat/naver-login-UI**

🌐 Git 커밋 컨벤션 생성 규칙

```
feat : 기능 추가
fix : 버그 수정
docs : 문서 수정
style : 단순 수정 (세미콜론, 코드 이동, 띄어 쓰기, 이름 변경)
rename: 추가된 기능, 별 내용 없이 폴더 및 파일만 추가, 폴더 및 파일 이름 수정, 옮기기
refactor : 코드 리팩토링
test : 테스트 추가
study : 학습 내용

```

**ver01(간략) : commit type: Epic/대분류 | 작업 단위 [Jira 이슈 번호]**

feat: 회원관리 | 네이버 로그인 기능 추가  [Jira 이슈번호]

**ver02(설명) : ver01양식(Jira 번호 빼고) - 본문 - [Jira 이슈 번호]**

feat: 회원관리 | 네이버 로그인 기능 추가

본문은 위, 아래 한 줄 띄우고 원하는 대로 작성한다.

=> 이런 식으로 특수기호를 쓰거나 이모티콘을 쓰는 것도 가능하다. 😄

단, 한 줄에 너무 길지 않도록 작성하자.

[Jira 이슈 번호]

<br/>

## 담당역할 및 구현

### 사용 기술
```
AndroidStudio Kotlin MVVM Retrofit OKHttp Paging Coroutine
Bottom-Navigation RecyclerView DataBinding ViewModel LiveData

CleanArchitecture Coroutine-Flow BaseActivity ResultState Hilt 

Git Git-Flow Jira Notion Mattermost Swagger Figma GanttChart
```

### MVVM과 Clean Architecture를 이용한 Application 구조 설계

```
구현 :

모듈을 3개로 나누어 각 모듈이 책임을 나눠서 가지도록 하였습니다.
ㄴPresentation(View, ViewModel 등 Android 종속성이 높은 UI 관련)
ㄴData(Datasource, ResponseDto, API 등 Data 처리와 서버 통신 관련)
ㄴDomain(Usecase, Dto, Repository Interface 등 Android 종속성이 없는 비즈니스 로직 관련)

느낀점 :

DB 변경, Local과 Remote 변경 등 데이터 저장 방식의 변경이 간편해지고, Server의 데이터 Response가 변경되어도 Mapper를 두어 다른 계층에의 영향이 적어지는 등 UI, Domain, Data가 변경되더라도 서로에 대한 수정이 적어졌음을 크게 느꼈습니다.

또 통일된 구조로 앱 구조 파악 용이, Usecase 등으로 인한 코드 재사용성 강화, 각 모듈의 역할 분담에 따른 코드 유지보수성 향상을 확인했습니다.

전체적으로 기존의 방식과의 비교(ResultState, Mapper, Flow 와 LiveData, Clean Architecture 등)로 진행하여 각 기능들에 대해서 보다 이해할 수 있게 되었습니다.
```

### Timer를 이용한 학습 시간 측정 기능

```
구현 :

학습 시간 측정 시 기기 시간이 다를 것을 고려하여 Server로부터 시간을 받아 저장하고, Timer로 학습 시간을 측정하도록 하였습니다.
1초마다 현재 시간을 갱신하여 화면에 표시하도록 하였습니다.
측정이 종료되면 학습 내용을 입력받아 경과시간을 계산하여 Rest Server에 저장하도록 하였습니다.

느낀점 :

Data <-> String 변환과 같이 전체적으로 사용되는 함수는 Utils 등에 따로 두고 함께 사용하는 것을 설계 단계 부터 고민하는 것이 좋을 것 같습니다.

Timer와 같은 Background 기능 구현 시 안드로이드 버전에 따른 Background 제한 정책이 있음을 확인하였습니다. 
해당 내용과 해결을 위한 WorkManager, ForegroundService 등을 학습하여 Bacground Limit, Doze Mode 등에서도 Background 기능이 정상 동작하도록 이해를 높이고자 하였습니다.

```

### Paging을 이용한 타임라인 조회 기능

```
구현 :

Paging을 이용하여 유저들이 등록한 게시물을 조회할 수 있도록 하였습니다.

느낀점 :

Paing의 구현 방식에 따라 조회 시간에 차이가 남을 확인하였습니다.
Server 담당자와 기능 구현을 논의하여 기존 방식보다 Paging 조회를 빠르게 구현하는 방법에 대해 이해를 높이고자 하였습니다.
```

### Project 진행
```
진행 :

기능 명세서, API 명세서, Figma, Notion, GanttChart 등을 이용하여 문서화하여 소통하고자 하였습니다.

Git과 Jira Convention을 정하고 Git Flow에 따라 진행하고자 하였습니다.

Google Playstore 출시 및 사용자 피드백을 받아 유지보수를 하고자 하였습니다.

코드 리뷰를 통해 코드를 개선하고자 노력하였습니다.


느낀점 : 

문서화하여 소통하니 보다 확실히 진행이 가능했습니다.
ㄴ 가령 Backend가 우선 진행하고 Android가 진행하는 것이 이상적이나, Infra 세팅 및 DB 등으로 인해 그러지 못하는 경우 API 명세서를 미리 작성하면 이후 크게 수정하지 않고도 진행할 수 있었습니다.

활발한 의견 교류가 프로젝트의 완성도를 높인다는 것을 느꼈습니다.
ㄴ 같은 부분을 학습하거나 함께 구현할 기능을 정하여도 모두 다르게 이해하는 부분이 생겼지만, 활발한 의견 교류와 토의를 통해 미리 파악하고 의견을 좁힐 수 있었습니다. 이로인해 프로젝트 진행 시 서로의 이해와 구현을 확인하고 정리하기위해 끊임없이 소통하려는 노력이 중요함을 느꼈습니다.
ㄴ 오류를 해결할 때도 Front나 Back에서 문제가 생기면 각 자의 부분만 확인하기보다는 의견 교류를 하는 것이 효과적인 경우가 많았습니다.

Playstore에 출시할 시 고려해야 할 문서, 권한 등에 대해 이해하게 되었습니다. 또 Git Flow를 이용한 버전관리와 Playstore 버전업데이트 방법에 대해서도 알게 되었습니다.

코드 리뷰를  코드를 더 신경쓰게되없습니다.
```
