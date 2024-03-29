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
기본적인 캐릭터 장비 UI 레이아웃 구성<br/><br/>
Configure basic character equipment UI layout<br/><br/>
配置基本字符設備UI佈局<br/><br/>
基本的な文字機器のUIレイアウトを設定します<br/>
<br/><br/>

2일차(Day 2, 第2天, 2日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/b5f8545c-f9fd-4cd9-b9a8-2f70f9f590ab)
<br/>
강화/증폭 구분 후 수치 적용 + 닉네임 적용 <br/><br/>
Apply enhanced/amplified figures and nicknames<br/><br/>
應用增強/放大數字和暱稱<br/><br/>
拡張または増幅された数値とニックネームを適用<br/>
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
모험단을 추가했지만.. 허리가 고장나서 하루종일 고치다가 끝..<br/><br/>
I've added an adventure group, but the belt's gone wrong, so I've been fixing it all day, and it's over..<br/><br/>
我增加了一個冒險小組，但腰帶出了問題，所以我整日都在修理它，一切都結束了。<br/><br/>
アドベンチャーグループを追加したのですが、ベルトがおかしくなってしまい、一日中修理していたら終わりです..<br/>

<br/><br/>
5일차(Day 5, 第5天, 5日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/acbaf51b-8561-4653-866b-0af3cf074dae)
<br/>
길드, 서버, 전직이름 구현, 미스트 기어 장비 여부 추가<br/>
(허리 부분 작동 안한 이유 : 네오플 api 측 허리 제공 데이터 이름 허리 -> 벨트로 변경)<br/><br/>
Guild, server, implement ex-name, add mist gear or not<br/>
(Reason for not working waist: Provide waist to neople api Data Name change to waist -> belt)<br/><br/>
行會、服務器、實現前名、添加霧齒輪或不添加霧齒輪<br/>
（不工作腰的原因:提供腰給neople api數據名稱改爲腰->腰帶）<br/><br/>
ギルド、サーバー、元の名前を実装、ミストギアを追加するかどうか<br/>
(腰が働かない理由: Neople api データ名を腰に変更 -> ベルト)<br/>

<br/><br/>
6일차(Day 6, 第6天, 6日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/6878e802-996a-42fd-8483-e67c3f3bcd92)
<br/>
TabHost UI 추가. 추가를 하는데 계속 NullPointer 문제 발생.<br/>
문제되는 부분을 재작성하였음. 적용을 하고 나니 명성 아이콘 이미지가 사라짐.<br/>
XML에 있는 이미지를 id 적용시켜 Java 코드에서 한번 더 적용시켜서 고침<br/>
기본 스탯 제작 시작</br>
<br/>
Add TabHost UI. Continue to have nullPointer issues while adding.<br/>
I've rewritten the part in question. After applying it, the reputation icon image disappears.<br/>
Apply the image in XML with id to fix it by applying it again in Java code<br/>
Start building basic capability values</br>
<br/> 
添加 TabHost UI。 在添加時繼續出現 nullPointer 問題。<br/>
我重寫了這個部分。 應用它後，聲譽圖標圖像消失。<br/>
在 XML 中使用 id 應用圖像，通過在 Java 代碼中再次應用它來修復它。<br/>
開始建立基本能力值<br/>
<br/>
TabHost UIを追加します。 追加中にnullPointerの問題が発生し続けます。<br/>
問題の部分を書き直しました。 適用すると評判アイコンの画像が消えます。<br/>
ID を持つ XML でイメージを適用し、Java コードで再度適用して修正します<br/>
基本的な機能値の構築を開始します<br/>
<br/><br/>

7일차 (Day 7, 第7天, 7日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/528b85dd-57d0-4ea7-8999-0b68f7a579ef)
<br/>
기본 스탯 레이아웃 완성 및 구현까지 완료<br/><br/>
Complete basic stat layout and implementation<br/><br/>
完成基本統計佈局和實施<br/><br/>
統計の基本的なレイアウトと実装の完了<br/>

8일차 (Day 8, 第8天, 8日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/ad9f181a-0b5a-4e6b-853c-e68e2ab4aaa1)
<br/>
버프 강화 추가 완료 및 기능 구현 중 순서와 사진, 이름이 꼬이는 현상 발생..<br/><br/>
Buff enhancement additions completed and functional implementation, resulting in order, photos, and name twists..<br/><br/>
Buff增強添加完成和功能實現，導致順序，照片和名稱扭曲。<br/><br/>
バフ強化の追加が完了し、機能的な実装が完了し、結果として順序、写真、名前のねじれが発生します..<br/><br/>

9일차 (Day 9, 第9天, 9日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/a7cc0e64-f8cf-4db6-96be-590d770531bf)
<br/>
버프 강화 수정 완료, 매개 변수 전송 과정에서 문제 발생이였음.<br/>
버프 레벨 및 증가 퍼센트 구현<br/><br/>
Buff enhancement modification completed, problem occurred in the process of sending parameters.<br/>
Implement buff level and increase percentage.<br/><br/>
Buff增強修改完成，發送參數過程中出現問題。<br/>
實現buff級別並增加百分比<br/><br/>
バッファ拡張の変更が完了しました。パラメータを送信する過程で問題が発生しました。<br/>
バフレベルの実装とパーセンテージの向上<br/>
<br/>

10일차 (Day 10, 第10天, 10日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/ec151c06-9a32-452e-b349-75082eda143d)
<br/>
아바타 탭 추가 <br/><br/>
Add Avatar Tab<br/><br/>
添加頭像選項卡<br/><br/>
[Add Avatar] タブ <br/><br/>
발견된 버그 : 버프강화 탭의 scrollview가 작동 안함<br/>
Bug found: scrollview of buff reinforcement tab does not work<br/>
發現錯誤: 滾動視圖的 buff reforcement 選項卡不起作用<br/>
バグが見つかりました:バフ強化タブのスクロールビューが機能しません<br/>

11일차 (Day 11, 第11天, 11日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/5ccc9060-3e0e-4505-81a6-673ed20459b8)
<br/>
scrollview 버그 수정 및 아바타 출력 양식 변경<br/><br/>
Fix scrollview bugs and change avatar output forms<br/><br/>
修復scrollview錯誤並更改頭像輸出表單<br/><br/>
スクロールビューのバグを修正し、アバター出力フォームを変更する<br/>

12일차 (Day 12, 第12天, 12日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/94a5fa86-23de-44ad-8b05-931f280e3780)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/eb987759-2ed1-4daf-8541-44b2f7aaed91)<br/>
앱 아이콘 및 이름 변경, 아바타 엠블렘 구현 <br/><br/>
App icon and name change, Avatar Emblem implementation <br/><br/>
應用程序圖標和名稱更改，頭像徽章實現 <br/><br/>
アプリアイコンと名称変更、アバターエンブレム実装<br/>

13일차 (Day 13, 第13天, 13日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/59410b42-ef49-49d4-aefc-bf1c4051c4c4)<br/>
장비탭 추가 및 장비 강화 수치, 이미지, 이름, 미스트 기어 여부 구현 <br/><br/>
Add equipment tabs and implement equipment enhancement figures, images, names, mist gears.<br/><br/>
添加設備選項卡和實施設備增強數字, 圖像, 名稱, 霧齒輪.<br/><br/>
機器タブを追加し、機器拡張図、画像、名前、ミストギアを実装します。<br/>

14일차 (Day 14, 第14天, 14日目)<br/>
![image](https://github.com/NLessW/DnF_apk/assets/63160418/347e75e5-d9a6-40ab-9b22-fbdfebdd9455)<br/>
장비 마법부여 구현 완료 <br/><br/>
Equipment Enchanted Implementation Completed<br/><br/>
裝備魔法實施完成<br/><br/>
機器の実装が完了<br/><br/>
