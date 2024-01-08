package com.cookandroid.dnf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class characterInfo extends AppCompatActivity {
    String characterName, server;
    String apiKey;
    ImageView eShd, eShirt, ePants, eBelt, eShoe, eWeapon, eTitle, eHand, eNeck, eSub, eRing, eEar, eStone, charPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinfo);
        Intent intent = getIntent();
        characterName = intent.getStringExtra("nickName");
        server = intent.getStringExtra("serverSelect");
        Log.d("cJava", "cName : " + characterName + "server : " + server);
        apiKey = "apiKey";

        eShd = findViewById(R.id.eShd);
        eShirt = findViewById(R.id.eShirt);
        ePants = findViewById(R.id.ePants);
        eBelt = findViewById(R.id.eBelt);
        eShoe = findViewById(R.id.eShoe);
        eWeapon = findViewById(R.id.eWeapon);
        eTitle = findViewById(R.id.eTitle);
        eHand = findViewById(R.id.eHand);
        eNeck = findViewById(R.id.eNeck);
        eSub = findViewById(R.id.eSub);
        eRing = findViewById(R.id.eRing);
        eEar = findViewById(R.id.eEar);
        eStone = findViewById(R.id.eStone);
        charPicture = findViewById(R.id.charPicture);

        CharacterUtils.setCharWeapon(server, characterName, apiKey, eWeapon, eTitle, eShirt, ePants, eShd, eBelt, eShoe, eHand, eNeck, eRing, eSub, eEar, eStone,charPicture);

    }

    public static class CharacterUtils {
        public static String getCharacterId(String server, String characterName, String apiKey) {
            try {
                Connection.Response response = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters")
                        .data("characterName", characterName)
                        .data("limit", "<limit>")
                        .data("wordType", "<wordType>")
                        .data("apikey", apiKey)
                        .ignoreContentType(true)
                        .method(Connection.Method.GET)
                        .execute();

                String responseBody = response.body();
                JSONObject json = new JSONObject(responseBody);
                JSONArray rows = json.getJSONArray("rows");
                if (rows.length() > 0) {
                    JSONObject character = rows.getJSONObject(0);
                    String characterId = character.getString("characterId");
                    return characterId;
                } else {
                    return null;
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void setCharWeapon(String server, String characterName, String apiKey, ImageView eWeapon, ImageView eTitle, ImageView eShirt, ImageView ePants, ImageView eShd, ImageView eBelt, ImageView eShoe, ImageView eHand, ImageView eNeck, ImageView eRing, ImageView eSub, ImageView eEar, ImageView eStone, ImageView charPicture) {
            new Thread(() -> {
                try {
                    String characterId = getCharacterId(server, characterName, apiKey);

                    Connection.Response response = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters/" + characterId + "/equip/equipment")
                            .data("apikey", apiKey)
                            .ignoreContentType(true)
                            .method(Connection.Method.GET)
                            .execute();

                    JSONObject jsonResponse = new JSONObject(response.body());
                    JSONArray equipmentArray = jsonResponse.getJSONArray("equipment");



                    for (int i = 0; i < equipmentArray.length(); i++) {
                        JSONObject equipment = equipmentArray.getJSONObject(i);
                        String itemId = equipment.getString("itemId");
                        String slotName = equipment.getString("slotName");
                        Log.d("asd","슬롯 이름 : " + slotName + "\nitemId : " + itemId + "\n\n");
                        if ("무기".equals(slotName)) {
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap weaponBitmap = getBitmapFromURL(imageUrl);
                            int width = eWeapon.getWidth();
                            int height = (int) (width / (float) weaponBitmap.getWidth() * weaponBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(weaponBitmap, width, height, true);
                            eWeapon.post(() -> {
                                eWeapon.setImageBitmap(scaledBitmap);
                            });
                        }else if("칭호".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap titleBitmap = getBitmapFromURL(imageUrl);
                            int width = eTitle.getWidth();
                            int height = (int) (width / (float) titleBitmap.getWidth() * titleBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(titleBitmap, width, height, true);
                            eTitle.post(() -> {
                                eTitle.setImageBitmap(scaledBitmap);
                            });
                        }else if("상의".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap shirtBitmap = getBitmapFromURL(imageUrl);
                            int width = eShirt.getWidth();
                            int height = (int) (width / (float) shirtBitmap.getWidth() * shirtBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(shirtBitmap, width, height, true);
                            eShirt.post(() -> {
                                eShirt.setImageBitmap(scaledBitmap);
                            });
                        }else if("하의".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap pantsBitmap = getBitmapFromURL(imageUrl);
                            int width = ePants.getWidth();
                            int height = (int) (width / (float) pantsBitmap.getWidth() * pantsBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(pantsBitmap, width, height, true);
                            ePants.post(() -> {
                                ePants.setImageBitmap(scaledBitmap);
                            });
                        }else if("머리어깨".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap shdBitmap = getBitmapFromURL(imageUrl);
                            int width = eShd.getWidth();
                            int height = (int) (width / (float) shdBitmap.getWidth() * shdBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(shdBitmap, width, height, true);
                            eShd.post(() -> {
                                eShd.setImageBitmap(scaledBitmap);
                            });
                        }else if("허리".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap beltBitmap = getBitmapFromURL(imageUrl);
                            int width = eBelt.getWidth();
                            int height = (int) (width / (float) beltBitmap.getWidth() * beltBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(beltBitmap, width, height, true);
                            eBelt.post(() -> {
                                eBelt.setImageBitmap(scaledBitmap);
                            });
                        }else if("신발".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap shoeBitmap = getBitmapFromURL(imageUrl);
                            int width = eBelt.getWidth();
                            int height = (int) (width / (float) shoeBitmap.getWidth() * shoeBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(shoeBitmap, width, height, true);
                            eShoe.post(() -> {
                                eShoe.setImageBitmap(scaledBitmap);
                            });
                        }else if("팔찌".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap handBitmap = getBitmapFromURL(imageUrl);
                            int width = eHand.getWidth();
                            int height = (int) (width / (float) handBitmap.getWidth() * handBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(handBitmap, width, height, true);
                            eHand.post(() -> {
                                eHand.setImageBitmap(scaledBitmap);
                            });
                        }else if("목걸이".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap neckBitmap = getBitmapFromURL(imageUrl);
                            int width = eNeck.getWidth();
                            int height = (int) (width / (float) neckBitmap.getWidth() * neckBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(neckBitmap, width, height, true);
                            eNeck.post(() -> {
                                eNeck.setImageBitmap(scaledBitmap);
                            });
                        }else if("반지".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap ringBitmap = getBitmapFromURL(imageUrl);
                            int width = eRing.getWidth();
                            int height = (int) (width / (float) ringBitmap.getWidth() * ringBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(ringBitmap, width, height, true);
                            eRing.post(() -> {
                                eRing.setImageBitmap(scaledBitmap);
                            });
                        }else if("보조장비".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap subBitmap = getBitmapFromURL(imageUrl);
                            int width = eSub.getWidth();
                            int height = (int) (width / (float) subBitmap.getWidth() * subBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(subBitmap, width, height, true);
                            eSub.post(() -> {
                                eSub.setImageBitmap(scaledBitmap);
                            });
                        }else if("귀걸이".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap earBitmap = getBitmapFromURL(imageUrl);
                            int width = eEar.getWidth();
                            int height = (int) (width / (float) earBitmap.getWidth() * earBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(earBitmap, width, height, true);
                            eEar.post(() -> {
                                eEar.setImageBitmap(scaledBitmap);
                            });
                        }else if("마법석".equals(slotName)){
                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                            Bitmap stoneBitmap = getBitmapFromURL(imageUrl);
                            int width = eStone.getWidth();
                            int height = (int) (width / (float) stoneBitmap.getWidth() * stoneBitmap.getHeight());
                            Bitmap scaledBitmap = Bitmap.createScaledBitmap(stoneBitmap, width, height, true);
                            eStone.post(() -> {
                                eStone.setImageBitmap(scaledBitmap);
                            });
                        }

                    }

                    String charUrl = "https://img-api.neople.co.kr/df/servers/"+server+"/characters/"+characterId+"?zoom=1";
                    Bitmap charBitmap = getBitmapFromURL(charUrl);
                    int width = charBitmap.getWidth();
                    int height = (int) (width / (float) charBitmap.getWidth() * charBitmap.getHeight());
                    Bitmap charBit = Bitmap.createScaledBitmap(charBitmap, width, height, true);
                    charPicture.post(() ->{
                        charPicture.setImageBitmap(charBit);
                    });
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        private static Bitmap getBitmapFromURL(String url) {
            try {
                HttpsURLConnection httpURLConnection = (HttpsURLConnection) new URL(url).openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setReadTimeout(2000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
