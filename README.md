# DnF_apk
Dungeon and Fighter apk code with neople api.<br/><br/>

# README is..
(한국어)<br/>
이 README.md는 제가 앱을 개발하면서 적는 개발 일기장입니다.<br/>
제작과정 및 발생했던 오류, 오류 해결했던 방식을 적어 기록하는 용도입니다.<br/>
쓸모없는 README 이므로 관심이 있으시다면 읽으셔도 되고, 없으시다면 안 읽으셔도 무방합니다.<br/>
제 코드는 공개해두겠습니다.<br/><br/>

(Eng)<br/>
This README.md is a development diary that I write while developing the app.<br/>
It is intended to write down the manufacturing process, errors that occurred, and how errors were resolved.<br/>
It's a useless README, so you can read it if you're interested, or if you're not, you don't have to.<br/>
I'll keep my code open.<br/><br/>

(中國語)<br/>
這個 README.md 是我在開發應用程序時寫的一個開發日記。<br/> 簡體中文
它旨在記錄製造過程，發生的錯誤以及如何解決錯誤。<br/> 簡體中文
<br/> 媽媽,你若是不喜歡我,我一定不會去想你的。 <br/> <br/>
我會打開我的代碼。聯繫我們
<br/><br/>

(日本語)<br/>
このREADME.md は、アプリの開発中に書いている開発日誌です。<br/>
製造プロセス、発生したエラー、およびエラーの解決方法を記録することを目的としています。<br/>
役に立たないREADMEなので、興味があるなら読んでもいいし、ないなら読まなくてもいいです。<br/>
コードを開いておきます。<br/><br/>

1일차(Day 1, 第1天, 1日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/781d7924-48cd-4257-8325-3c55e2d9760b)
<br/>
기본적인 캐릭터 장비 UI 레이아웃 구성<br/>
Configure basic character equipment UI layout<br/>
配置基本字符設備UI佈局<br/>
基本的な文字機器のUIレイアウトを設定します<br/>
<br/><br/>

2일차(Day 2, 第2天, 2日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/b5f8545c-f9fd-4cd9-b9a8-2f70f9f590ab)
<br/>
강화/증폭 구분 후 수치 적용 + 닉네임 적용 <br/>
Apply enhanced/amplified figures and nicknames<br/>
應用增強/放大數字和暱稱<br/>

<br/><br/>
3일차(Day 3, 第3天, 3日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/e07e3ead-0d48-4bdf-a620-589dfe4e4eaa)
<br/>
2일차까진 큰 문제는 없었지만 3일차 명성과 융합을 추가하면서 오류가 발생하기 시작함.<br/>
명성을 추가하니까 characterId 가져오는 부분이 에러가 났었고 함수로 가져오는 방식이 아닌 바로 다이렉트로 <br/> 값을 받아오는 것으로 수정함. 명성을 추가하니 일부러 없는 이름을 검색했음에도
HTTP ERROR Code와 경고창이 띄워지지 않음.<br/>
이유를 찾아보니 HTTP ERROR CODE를 받아오는 곳이 장비 id 호출쪽에 들어가있어서 명성이 받아오는 에러를 넘겨받지 못했었음. 위치 조정으로 수정함.<br/><br/>
There were no major problems until day 2, but errors started to occur as we added the fame and fusion on day 3.<br/>
When I added a fame, there was an error in the part where I got characterId, and I corrected it to get the value of <br/> directly rather than the method of importing it as a function. When I added a frame, even though I searched for a name that didn't exist on purpose
HTTP ERROR Code and warning window not displayed.<br/>
I found out the reason, the place where HTTP ERROR CODE is received is on the equipment id call side, so I didn't take over the error that the fame was receiving. I corrected it by adjusting the location.
<br/><br/> 
在第2天之前沒有大問題，但隨着我們在第3天添加名氣和融合，開始出現錯誤。<br/>
當我添加名聲時，我得到characterId的部分出現了一個錯誤，我更正它以直接獲取值，而不是將其導入函數的方法。 當我添加一個框架時，即使我搜索了一個不存在的名字。<br/>
HTTP ERROR 代碼和警告窗口未顯示。<br/>
我找到了原因，HTTP ERROR CODE被接收的地方在設備ID呼叫端，所以我沒有接管名氣接收的錯誤。 我通過調整位置來糾正它。<br/><br/>

2日目までは大きな問題はありませんでしたが、3日目に名声と融合を加えてエラーが発生し始めました。<br/>
fameを追加した際に、characterIdを取得した部分にエラーがあり、関数としてインポートするメソッドではなく<br/>の値を直接取得するように修正しました。 わざと存在しない名前を検索しても、フレームを追加したとき
HTTP ERROR Code と警告ウィンドウが表示されません。<br/>
理由がわかりました、HTTP ERROR CODEを受信する場所は機器IDコール側なので、fameが受信しているエラーを引き継いでいません。 場所を調整して修正しました。

<br/><br/>
4일차(Day 4, 第4天, 4日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/511cf0a1-4a45-4b5d-bcfd-6ce729e6cc20)
<br/>
모험단을 추가했지만.. 허리가 고장나서 하루종일 고치다가 끝..<br/>
I've added an adventure group, but the belt's gone wrong, so I've been fixing it all day, and it's over..<br/>
我增加了一個冒險小組，但腰帶出了問題，所以我整日都在修理它，一切都結束了。<br/>
アドベンチャーグループを追加したのですが、ベルトがおかしくなってしまい、一日中修理していたら終わりです..<br/>

<br/><br/>
5일차(Day 5, 第5天, 5日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/acbaf51b-8561-4653-866b-0af3cf074dae)
<br/>
길드, 서버, 전직이름 구현, 미스트 기어 장비 여부 추가<br/>
(허리 부분 작동 안한 이유 : 네오플 api 측 허리 제공 데이터 이름 허리 -> 벨트로 변경)<br/>
Guild, server, implement ex-name, add mist gear or not<br/>
(Reason for not working waist: Provide waist to neople api Data Name change to waist -> belt)<br/>
行會、服務器、實現前名、添加霧齒輪或不添加霧齒輪<br/>
（不工作腰的原因:提供腰給neople api數據名稱改爲腰->腰帶）<br/>
ギルド、サーバー、元の名前を実装、ミストギアを追加するかどうか<br/>
(腰が働かない理由: Neople api データ名を腰に変更 -> ベルト)<br/>

<br/><br/>
6일차 진행중 (Day 6 in progress, 第6天 進行中, 1日目 進行中)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/71f39a7d-af12-42f6-959e-ad43bb49aef9)
TabHost UI 추가. 추가를 하는데 계속 NullPointer 문제 발생.<br/>
문제되는 부분을 재작성하였음. 적용을 하고 나니 명성 아이콘 이미지가 사라짐.<br/>
XML에 있는 이미지를 id 적용시켜 Java 코드에서 한번 더 적용시켜서 고침<br/>
 
