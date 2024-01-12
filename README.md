# DnF_apk
Dungeon and Fighter apk code with neople api.
<br/>
1일차 <br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/781d7924-48cd-4257-8325-3c55e2d9760b)
<br/>
기본적인 캐릭터 장비 UI 레이아웃 구성
<br/><br/>
2일차<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/b5f8545c-f9fd-4cd9-b9a8-2f70f9f590ab)
<br/>
강화/증폭 구분 후 수치 적용 + 닉네임 적용 
<br/><br/>
3일차<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/e07e3ead-0d48-4bdf-a620-589dfe4e4eaa)
<br/>
2일차까진 큰 문제는 없었지만 3일차 명성과 융합을 추가하면서 오류가 발생하기 시작함.<br/>
명성을 추가하니까 characterId 가져오는 부분이 에러가 났었고 함수로 가져오는 방식이 아닌 바로 다이렉트로 <br/> 값을 받아오는 것으로 수정함. 명성을 추가하니 일부러 없는 이름을 검색했음에도
HTTP ERROR Code와 경고창이 띄워지지 않음.<br/>
이유를 찾아보니 HTTP ERROR CODE를 받아오는 곳이 장비 id 호출쪽에 들어가있어서 명성이 받아오는 에러를 넘겨받지 못했었음. 위치 조정으로 수정함.<br/>
<br/><br/>
4일차<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/511cf0a1-4a45-4b5d-bcfd-6ce729e6cc20)
<br/>
모험단을 추가했지만.. 허리가 고장나서 하루종일 고치다가 끝..
<br/><br/>
5일차<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/acbaf51b-8561-4653-866b-0af3cf074dae)
<br/>
길드, 서버, 전직이름 구현, 미스트 기어 장비 여부 추가<br/>
(허리 부분 작동 안한 이유 : 네오플 api 측 허리 제공 데이터 이름 허리 -> 벨트로 변경)
<br/><br/>
6일차 (진행중)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/71f39a7d-af12-42f6-959e-ad43bb49aef9)
TabHost UI 추가
