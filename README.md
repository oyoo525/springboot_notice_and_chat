# springboot_notice_and_chat
> 작업기간 : 2024.03.12 ~  <br>
> 개인프로젝트

## 프로젝트 소개
### 프로젝트 목적
- java에 대한 복습 및 springboot 숙련도 향상
- CRUD기능 외에 Websocket 등으로 채팅 기능 훈련

### 개발환경
- Windows 10
- Springboot 4.21.0.RELEASE
- Apache Tomact 9.0.86

### 사용언어
Java, Html, Javascript, JQuery, MySQL

### 진행상황
- day01 : 회원가입, 로그인, 전체글 조회, 게시글 상세보기
- dqy02 : 게시글 수정/삭제, 댓글 등록/수정/삭제, 쪽지보내기
- day03 : 채팅방 구현


### 구현화면
|회원가입|로그인|
|---|---|
|![screencapture-localhost-8080-join-2024-03-19-16_09_36](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/fb55d444-b44d-44c4-9d6d-478026f09a58)|![screencapture-localhost-8080-login-2024-03-19-16_09_45](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/b49926ad-09bf-4f2e-a2fe-b13d5fe0b622)|

|쪽지보내기|받은 쪽지함|
|---|---|
|![screencapture-localhost-8080-messageForm-2024-03-19-16_10_28](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/36f54b0e-67d0-418c-87a8-09ee1fc9460e)|![screencapture-localhost-8080-receivedMessage-2024-03-19-16_11_23](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/fb8eefa7-2e53-48ee-a8aa-8e3945174272)

|게시글리스트(홈화면)|게시글작성|
|---|---|
|![screencapture-localhost-8080-2024-03-19-16_09_56](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/a7bc2635-fcd8-4e86-90d5-cc7385804a20)|![screencapture-localhost-8080-writeBoard-2024-03-19-16_10_08](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/c1c901fc-6867-4902-81c4-69f6b74d03f1)|

|게시글 상세보기|채팅방 목록|
|---|---|
|![screencapture-localhost-8080-boardDetail-2024-03-19-16_10_19](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/bc93bbaa-76d3-43fc-85f5-be109820ed87)|![screencapture-localhost-8080-chatList-2024-03-19-16_11_32](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/c815069d-1ffb-41a3-9514-713839d87543)|

|채팅방|
|---|
|![캡처](https://github.com/oyoo525/springboot_notice_and_chat/assets/141537487/b8c3823c-d407-4f09-84a0-5db88b9b06b2)|










### 느낀점
- day01
  - 학원 수료 후 방황하면서 놓고 있었던 자바를 다시 시작했다. 2달동안 어떤걸 해야할지 갈피를 잡지 못했는데
  - 약 한 달가량 React를 해보면서 프론트단에 대해서도 생각해보았다. 물론 즐거웠지만 java를 하면서 느꼈던 희열보다는 덜하다는 느낌을 받았다.
  - 오히려 프론트를 하면서 더 스트레스를 받았던것도 같다. 두 달만에 하는 자바는 너무나도 생소한 느낌이었다.
  - 머리를 안쓰면 금방 굳는다는 말을 실감하게 했다. 다른사람들이 백엔드에 집중할 때 나는 그러지 못했으니 조금더 분발해야겠다는 생각이 들었다.
  - 지금 만들고 있는 CRUD 기능을 얼른 끝내고 얼른 다른 기능도 추가하고 싶다는 생각이 든다.
- day02
  - 가장 기초적인 부분은 구현해두었는데 앞으로 어떻게 기능을 추가해야할지가 막막하다
  - 우선 Websocket을 이용해서 채팅기능을 구현하려고 하는데 구글링해서 적용해봐도 오늘 하루종일 오류가 나는 것 같다.
  - 유튜브강의 중에 한가지를 테스트 했는데 정상작동이 되어서 우선 코드를 이해한 후 현재 프로젝트에 적용해야 할 것 같다.
  - Websocket을 처음 적용해보는거라 막히는 부분이 많은 것 같지만 웹사이트를 쓰면서 널리 쓰이는 기능이기 때문에 확실히 이해하는 게 중요한 것 같다.
  - Node.js에서 비교적 간결하게 사용할 수 있다고는 하는데 Node.js에서 적용 후 RestAPI로 연동시키는건 추후에 해봐야 할 것 같다.
  - 지금은 java로만 백엔드 서버 구축을 해보고 추후 다른 언어도 늘리는 게 좋을것 같다.
- day03
  - SockJS 를 사용해 채팅기능을 구현하였다.
  - 코드를 이해하는데 꽤나 시간이 걸린거 같다. 아직도 명확한 이해는 되지 않았지만 기능을 구현하는데는 성공했다.
  - HTTP랑 다르게 양방향 통신이라는 사실을 머리로는 이해하고 있었지만 데이터가 어떻게 왔다갔다하는지는 아직 어렵다.
  - 기술이라는게 처음에는 어렵고 막막하지만 계속 사용하면 나도 모르는 사이에 이해하게 될테니 조금더 해봐야겠다고 생각이 들었다.
  - 현재는 채팅방 하나를 구현했더니 여러방을 동시에 사용하는것도 하고 싶어서 추가로 구현했다.
  - 채팅방별로 auto_increament를 사용해서 고유번호가 있긴하지만 UUID를 하나 더 만들어서 UUID별로 채팅방을 나눴다.
  - 다른 페이지로 넘어가면서 구현하고 싶었는데 왜인지 페이지 이동하면서 웹소켓서버 연결이 안되었다.
    
  
