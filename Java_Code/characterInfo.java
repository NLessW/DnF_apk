package com.cookandroid.dnf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Pair;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.w3c.dom.Text;
import androidx.appcompat.app.AlertDialog;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class characterInfo extends AppCompatActivity {
    String characterName, server;
    String apiKey;
    TextView shdReinForce, shirtReinForce, pantsReinForce, beltReinForce, shoeReinForce, weaponReinForce, weaponInfo, handReinForce,
            neckReinForce, subReinForce, ringReinForce, earReinForce, stoneReinForce,userName, fameNum, shdMix, shirtMix, pantsMix,
            beltMix, shoeMix, weaponMix, handMix, neckMix, subMix, ringMix, earMix, stoneMix, handSun, neckSun, subSun, ringSun, earSun, stoneSun, advName;
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
        shdReinForce = findViewById(R.id.shdReinForce);
        shirtReinForce = findViewById(R.id.shirtReinForce);
        pantsReinForce = findViewById(R.id.pantsReinForce);
        beltReinForce = findViewById(R.id.beltReinForce);
        shoeReinForce = findViewById(R.id.shoeReinForce);
        weaponReinForce = findViewById(R.id.weaponReinForce);
        weaponInfo = findViewById(R.id.weaponInfo);
        handReinForce = findViewById(R.id.handReinForce);
        neckReinForce = findViewById(R.id.neckReinForce);
        subReinForce = findViewById(R.id.subReinForce);
        ringReinForce = findViewById(R.id.ringReinForce);
        earReinForce = findViewById(R.id.earReinForce);
        stoneReinForce = findViewById(R.id.stoneReinForce);
        handSun = findViewById(R.id.handSun);
        neckSun = findViewById(R.id.neckSun);
        subSun = findViewById(R.id.subSun);
        ringSun = findViewById(R.id.ringSun);
        earSun = findViewById(R.id.earSun);
        stoneSun = findViewById(R.id.stoneSun);
        userName = findViewById(R.id.userName);
        fameNum = findViewById(R.id.fameNum);
        shdMix = findViewById(R.id.shdMix);
        shirtMix = findViewById(R.id.shirtMix);
        pantsMix = findViewById(R.id.pantsMix);
        beltMix = findViewById(R.id.beltMix);
        shoeMix = findViewById(R.id.shoeMix);
        handMix = findViewById(R.id.handMix);
        neckMix = findViewById(R.id.neckMix);
        subMix = findViewById(R.id.subMix);
        ringMix = findViewById(R.id.ringMix);
        earMix = findViewById(R.id.earMix);
        stoneMix = findViewById(R.id.stoneMix);
        weaponMix = findViewById(R.id.weaponMix);
        advName = findViewById(R.id.advName);
        userName.setText(characterName);

        CharacterUtils.setCharWeapon(this, server, characterName, apiKey, eWeapon,
                eTitle, eShirt, ePants, eShd, eBelt, eShoe, eHand, eNeck, eRing, eSub, eEar, eStone, charPicture,
                weaponReinForce, shdReinForce, shirtReinForce, pantsReinForce, beltReinForce, shoeReinForce, handReinForce, neckReinForce,
                subReinForce, ringReinForce, earReinForce, stoneReinForce,weaponInfo, fameNum, shdMix, weaponMix, shirtMix, pantsMix, beltMix, shoeMix,
                handMix, neckMix, subMix, ringMix, earMix, stoneMix, handSun, neckSun, subSun, ringSun, earSun, stoneSun, advName);


    }

    public static class CharacterUtils {
        // 캐릭터 정보를 담는 클래스 정의
        public static class CharacterInfo {
            private final String characterId;
            private final int fame;
            private final String adventureName;

            public CharacterInfo(String characterId, int fame, String adventureName) {
                this.characterId = characterId;
                this.fame = fame;
                this.adventureName = adventureName;
            }

            public String getCharacterId() {
                return characterId;
            }

            public int getFame() {
                return fame;
            }

            public String getAdvName() {
                return adventureName;
            }
        }
        public static CharacterInfo getCharacterInfo(Context context, String server, String characterName, String apiKey) {
            try {
                // 캐릭터 정보를 조회하는 API 호출
                Connection.Response response = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters")
                        .data("characterName", characterName)
                        .data("limit", "1")  // 최대 1개의 결과만 필요
                        .data("wordType", "full")  // 전체 일치 검색
                        .data("apikey", apiKey)
                        .ignoreContentType(true)
                        .method(Connection.Method.GET)
                        .execute();

                String responseBody = response.body();
                JSONObject json = new JSONObject(responseBody);

                // API 응답에서 rows 배열 추출
                JSONArray rows = json.getJSONArray("rows");

                if (rows.length() > 0) {
                    JSONObject character = rows.getJSONObject(0);
                    String characterId = character.getString("characterId");
                    int fame = 0;
                    if (!character.isNull("fame")) {
                        fame = character.getInt("fame");
                    }
                    String advName = "";
                    if (!character.isNull("adventureName")) {
                        advName = character.getString("adventureName");
                    }
                    // CharacterInfo 객체 생성하여 반환
                    return new CharacterInfo(characterId, fame, advName);
                } else {
                    return null;
                }
            } catch(IOException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void setCharWeapon(Context context, String server, String characterName, String apiKey,
                                         ImageView eWeapon, ImageView eTitle, ImageView eShirt, ImageView ePants,
                                         ImageView eShd, ImageView eBelt, ImageView eShoe, ImageView eHand, ImageView eNeck,
                                         ImageView eRing, ImageView eSub, ImageView eEar, ImageView eStone, ImageView charPicture,
                                         TextView weaponReinForce, TextView shdReinForce, TextView shirtReinForce, TextView pantsReinForce,
                                         TextView beltReinForce, TextView shoeReinForce, TextView handReinForce, TextView neckReinForce,
                                         TextView subReinForce, TextView ringReinForce, TextView earReinForce, TextView stoneReinForce,
                                         TextView weaponInfo, TextView fameNum, TextView shdMix, TextView weaponMix, TextView shirtMix,
                                         TextView pantsMix, TextView beltMix, TextView shoeMix, TextView handMix, TextView neckMix, TextView subMix,
                                         TextView ringMix, TextView earMix, TextView stoneMix, TextView handSun, TextView neckSun, TextView subSun,
                                         TextView ringSun, TextView earSun, TextView stoneSun, TextView advName) {
            new Thread(() -> {
                try {
                    CharacterInfo characterInfo = getCharacterInfo(context, server, characterName, apiKey);
                    String characterId = "";

                    if(characterInfo != null) {
                       characterId = characterInfo.getCharacterId();
                    }

                    Connection.Response response = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters/" + characterId + "/equip/equipment")
                            .data("apikey", apiKey)
                            .ignoreContentType(true)
                            .method(Connection.Method.GET)
                            .execute();

                    if (characterInfo != null) {
                        int fame = characterInfo.getFame();
                        String adventureName = characterInfo.getAdvName();

                        fameNum.post(() -> {
                            fameNum.setText(String.valueOf(fame));
                        });

                        advName.post(() -> {
                            advName.setText(adventureName);
                        });

                        JSONObject jsonResponse = new JSONObject(response.body());
                        JSONArray equipmentArray = jsonResponse.getJSONArray("equipment");

                        for (int i = 0; i < equipmentArray.length(); i++) {
                            JSONObject equipment = equipmentArray.getJSONObject(i);
                            String itemId = equipment.getString("itemId");
                            String slotName = equipment.getString("slotName");
                            String upgradeInfo = equipment.isNull("upgradeInfo") ? null : equipment.getString("upgradeInfo");
                            String amplificationName = equipment.isNull("amplificationName") ? null : equipment.getString("amplificationName");
                            int reinforce = equipment.getInt("reinforce");
                            int refine = equipment.getInt("refine");

                            if ("무기".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap weaponBitmap = getBitmapFromURL(imageUrl);
                                int width = eWeapon.getWidth();
                                int height = (int) (width / (float) weaponBitmap.getWidth() * weaponBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(weaponBitmap, width, height, true);
                                eWeapon.post(() -> {
                                    eWeapon.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        String upgradeName = itemName.substring(0, 3);

                                        weaponMix.post(() -> {
                                            weaponMix.setText(upgradeName);
                                            weaponMix.setVisibility(View.VISIBLE);  // Make weaponMix visible
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();

                                        weaponMix.post(() -> {
                                            weaponMix.setText("");
                                            weaponMix.setVisibility(View.INVISIBLE);  // Hide weaponMix
                                        });
                                    }
                                } else {
                                    weaponMix.post(() -> {
                                        weaponMix.setText("");
                                        weaponMix.setVisibility(View.INVISIBLE);  // Hide weaponMix
                                    });
                                }

                                if (reinforce > 0) {
                                    weaponReinForce.post(() -> {
                                        weaponReinForce.setText("+" + reinforce);
                                        weaponReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    weaponReinForce.post(() -> {
                                        weaponReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    weaponReinForce.post(() -> {
                                        weaponReinForce.setText("+" + reinforce);
                                        weaponReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    weaponReinForce.post(() -> {
                                        weaponReinForce.setText("+" + reinforce);
                                        weaponReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }
                                if (refine > 0) {
                                    weaponInfo.post(() -> {
                                        weaponInfo.setText("/ " + refine);
                                        weaponInfo.setTextColor(context.getResources().getColor(R.color.pink));
                                    });
                                } else {
                                    weaponInfo.post(() -> {
                                        weaponInfo.setText("/ 0");
                                        weaponInfo.setTextColor(context.getResources().getColor(R.color.pink));
                                    });
                                }
                            }
                            else if ("칭호".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap titleBitmap = getBitmapFromURL(imageUrl);
                                int width = eTitle.getWidth();
                                int height = (int) (width / (float) titleBitmap.getWidth() * titleBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(titleBitmap, width, height, true);
                                eTitle.post(() -> {
                                    eTitle.setImageBitmap(scaledBitmap);
                                });
                            }
                            else if ("상의".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap shirtBitmap = getBitmapFromURL(imageUrl);
                                int width = eShirt.getWidth();
                                int height = (int) (width / (float) shirtBitmap.getWidth() * shirtBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(shirtBitmap, width, height, true);
                                eShirt.post(() -> {
                                    eShirt.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        String upgradeName = itemName.substring(0, 3);

                                        shirtMix.post(() -> {
                                            shirtMix.setText(upgradeName);
                                            shirtMix.setVisibility(View.VISIBLE);
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        shirtMix.post(() -> {
                                            shirtMix.setText("");
                                            shirtMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    shirtMix.post(() -> {
                                        shirtMix.setText("");
                                        shirtMix.setVisibility(View.INVISIBLE);
                                    });
                                }

                                if (reinforce > 0) {
                                    shirtReinForce.post(() -> {
                                        shirtReinForce.setText("+" + reinforce);
                                        shirtReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    shirtReinForce.post(() -> {
                                        shirtReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    shirtReinForce.post(() -> {
                                        shirtReinForce.setText("+" + reinforce);
                                        shirtReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    shirtReinForce.post(() -> {
                                        shirtReinForce.setText("+" + reinforce);
                                        shirtReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }
                            }
                            else if ("하의".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap pantsBitmap = getBitmapFromURL(imageUrl);
                                int width = ePants.getWidth();
                                int height = (int) (width / (float) pantsBitmap.getWidth() * pantsBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(pantsBitmap, width, height, true);
                                ePants.post(() -> {
                                    ePants.setImageBitmap(scaledBitmap);
                                });
                                ePants.post(() -> {
                                    ePants.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        String upgradeName = itemName.substring(0, 3);

                                        pantsMix.post(() -> {
                                            pantsMix.setText(upgradeName);
                                            pantsMix.setVisibility(View.VISIBLE);
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        pantsMix.post(() -> {
                                            pantsMix.setText("");
                                            pantsMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    pantsMix.post(() -> {
                                        pantsMix.setText("");
                                        pantsMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    pantsReinForce.post(() -> {
                                        pantsReinForce.setText("+" + reinforce);
                                        pantsReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    pantsReinForce.post(() -> {
                                        pantsReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    pantsReinForce.post(() -> {
                                        pantsReinForce.setText("+" + reinforce);
                                        pantsReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    pantsReinForce.post(() -> {
                                        pantsReinForce.setText("+" + reinforce);
                                        pantsReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }

                            }
                            else if ("머리어깨".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap shdBitmap = getBitmapFromURL(imageUrl);
                                int width = eShd.getWidth();
                                int height = (int) (width / (float) shdBitmap.getWidth() * shdBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(shdBitmap, width, height, true);
                                eShd.post(() -> {
                                    eShd.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        String upgradeName = itemName.substring(0, 3);

                                        shdMix.post(() -> {
                                            shdMix.setText(upgradeName);
                                            shdMix.setVisibility(View.VISIBLE);
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        shdMix.post(() -> {
                                            shdMix.setText("");
                                            shdMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    shdMix.post(() -> {
                                        shdMix.setText("");
                                        shdMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    shdReinForce.post(() -> {
                                        shdReinForce.setText("+" + reinforce);
                                        shdReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    shdReinForce.post(() -> {
                                        shdReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    shdReinForce.post(() -> {
                                        shdReinForce.setText("+" + reinforce);
                                        shdReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    shdReinForce.post(() -> {
                                        shdReinForce.setText("+" + reinforce);
                                        shdReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }
                            }
                            else if ("허리".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap beltBitmap = getBitmapFromURL(imageUrl);
                                int width = eBelt.getWidth();
                                int height = (int) (width / (float) beltBitmap.getWidth() * beltBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(beltBitmap, width, height, true);
                                eBelt.post(() -> {
                                    eBelt.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        String upgradeName = itemName.substring(0, 3);

                                        beltMix.post(() -> {
                                            beltMix.setText(upgradeName);
                                            beltMix.setVisibility(View.VISIBLE);
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        beltMix.post(() -> {
                                            beltMix.setText("");
                                            beltMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    beltMix.post(() -> {
                                        beltMix.setText("");
                                        beltMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    beltReinForce.post(() -> {
                                        beltReinForce.setText("+" + reinforce);
                                        beltReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    beltReinForce.post(() -> {
                                        beltReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    beltReinForce.post(() -> {
                                        beltReinForce.setText("+" + reinforce);
                                        beltReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    beltReinForce.post(() -> {
                                        beltReinForce.setText("+" + reinforce);
                                        beltReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }

                            }
                            else if ("신발".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap shoeBitmap = getBitmapFromURL(imageUrl);
                                int width = eShoe.getWidth();
                                int height = (int) (width / (float) shoeBitmap.getWidth() * shoeBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(shoeBitmap, width, height, true);
                                eShoe.post(() -> {
                                    eShoe.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        String upgradeName = itemName.substring(0, 3);

                                        shoeMix.post(() -> {
                                            shoeMix.setText(upgradeName);
                                            shoeMix.setVisibility(View.VISIBLE);
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        shoeMix.post(() -> {
                                            shoeMix.setText("");
                                            shoeMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    shoeMix.post(() -> {
                                        shoeMix.setText("");
                                        shoeMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    shoeReinForce.post(() -> {
                                        shoeReinForce.setText("+" + reinforce);
                                        shoeReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    shoeReinForce.post(() -> {
                                        shoeReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    shoeReinForce.post(() -> {
                                        shoeReinForce.setText("+" + reinforce);
                                        shoeReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    shoeReinForce.post(() -> {
                                        shoeReinForce.setText("+" + reinforce);
                                        shoeReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }
                            }
                            else if ("팔찌".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap handBitmap = getBitmapFromURL(imageUrl);
                                int width = eHand.getWidth();
                                int height = (int) (width / (float) handBitmap.getWidth() * handBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(handBitmap, width, height, true);
                                eHand.post(() -> {
                                    eHand.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        if (itemName.contains("仙")) {
                                            String upgradeName = itemName.substring(3, 6);
                                            handMix.post(() -> {
                                                handMix.setText(upgradeName);
                                                handMix.setVisibility(View.VISIBLE);
                                            });
                                            handSun.post(() -> handSun.setVisibility(View.VISIBLE));
                                        } else {
                                            String upgradeName = itemName.substring(0, 3);
                                            handMix.post(() -> {
                                                handMix.setText(upgradeName);
                                                handMix.setVisibility(View.VISIBLE);
                                            });
                                            handSun.post(() -> handSun.setVisibility(View.INVISIBLE));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        handMix.post(() -> {
                                            handMix.setText("");
                                            handMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    handMix.post(() -> {
                                        handMix.setText("");
                                        handMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    handReinForce.post(() -> {
                                        handReinForce.setText("+" + reinforce);
                                        handReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    handReinForce.post(() -> {
                                        handReinForce.setText("+0");
                                    });
                                }
                                if (reinforce > 0) {
                                    handReinForce.post(() -> {
                                        handReinForce.setText("+" + reinforce);
                                        handReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    handReinForce.post(() -> {
                                        handReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    handReinForce.post(() -> {
                                        handReinForce.setText("+" + reinforce);
                                        handReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    handReinForce.post(() -> {
                                        handReinForce.setText("+" + reinforce);
                                        handReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }
                            }
                            else if ("목걸이".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap neckBitmap = getBitmapFromURL(imageUrl);
                                int width = eNeck.getWidth();
                                int height = (int) (width / (float) neckBitmap.getWidth() * neckBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(neckBitmap, width, height, true);
                                eNeck.post(() -> {
                                    eNeck.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        if (itemName.contains("仙")) {
                                            String upgradeName = itemName.substring(4, 7);
                                            neckMix.post(() -> {
                                                neckMix.setText(upgradeName);
                                                neckMix.setVisibility(View.VISIBLE);
                                            });
                                            neckSun.post(() -> neckSun.setVisibility(View.VISIBLE));
                                        } else {
                                            String upgradeName = itemName.substring(0, 3);
                                            neckMix.post(() -> {
                                                neckMix.setText(upgradeName);
                                                neckMix.setVisibility(View.VISIBLE);
                                            });
                                            neckSun.post(() -> neckSun.setVisibility(View.INVISIBLE));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        neckMix.post(() -> {
                                            neckMix.setText("");
                                            neckMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    neckMix.post(() -> {
                                        neckMix.setText("");
                                        neckMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    neckReinForce.post(() -> {
                                        neckReinForce.setText("+" + reinforce);
                                        neckReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    neckReinForce.post(() -> {
                                        neckReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    neckReinForce.post(() -> {
                                        neckReinForce.setText("+" + reinforce);
                                        neckReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    neckReinForce.post(() -> {
                                        neckReinForce.setText("+" + reinforce);
                                        neckReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }

                            }
                            else if ("반지".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap ringBitmap = getBitmapFromURL(imageUrl);
                                int width = eRing.getWidth();
                                int height = (int) (width / (float) ringBitmap.getWidth() * ringBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(ringBitmap, width, height, true);
                                eRing.post(() -> {
                                    eRing.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        if (itemName.contains("仙")) {
                                            String upgradeName = itemName.substring(4, 7);
                                            ringMix.post(() -> {
                                                ringMix.setText(upgradeName);
                                                ringMix.setVisibility(View.VISIBLE);
                                            });
                                            ringSun.post(() -> ringSun.setVisibility(View.VISIBLE));
                                        } else {
                                            String upgradeName = itemName.substring(0, 3);
                                            ringMix.post(() -> {
                                                ringMix.setText(upgradeName);
                                                ringMix.setVisibility(View.VISIBLE);
                                            });
                                            ringSun.post(() -> ringSun.setVisibility(View.INVISIBLE));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        ringMix.post(() -> {
                                            ringMix.setText("");
                                            ringMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    ringMix.post(() -> {
                                        ringMix.setText("");
                                        ringMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    ringReinForce.post(() -> {
                                        ringReinForce.setText("+" + reinforce);
                                        ringReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    ringReinForce.post(() -> {
                                        ringReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    ringReinForce.post(() -> {
                                        ringReinForce.setText("+" + reinforce);
                                        ringReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    ringReinForce.post(() -> {
                                        ringReinForce.setText("+" + reinforce);
                                        ringReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }

                            }
                            else if ("보조장비".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap subBitmap = getBitmapFromURL(imageUrl);
                                int width = eSub.getWidth();
                                int height = (int) (width / (float) subBitmap.getWidth() * subBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(subBitmap, width, height, true);
                                eSub.post(() -> {
                                    eSub.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        if (itemName.contains("仙")) {
                                            String upgradeName = itemName.substring(4, 7);
                                            subMix.post(() -> {
                                                subMix.setText(upgradeName);
                                                subMix.setVisibility(View.VISIBLE);
                                            });
                                            subSun.post(() -> subSun.setVisibility(View.VISIBLE));
                                        } else {
                                            String upgradeName = itemName.substring(0, 3);
                                            subMix.post(() -> {
                                                subMix.setText(upgradeName);
                                                subMix.setVisibility(View.VISIBLE);
                                            });
                                            subSun.post(() -> subSun.setVisibility(View.INVISIBLE));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        subMix.post(() -> {
                                            subMix.setText("");
                                            subMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    subMix.post(() -> {
                                        subMix.setText("");
                                        subMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    subReinForce.post(() -> {
                                        subReinForce.setText("+" + reinforce);
                                        subReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    subReinForce.post(() -> {
                                        subReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    subReinForce.post(() -> {
                                        subReinForce.setText("+" + reinforce);
                                        subReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    subReinForce.post(() -> {
                                        subReinForce.setText("+" + reinforce);
                                        subReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }

                            }
                            else if ("귀걸이".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap earBitmap = getBitmapFromURL(imageUrl);
                                int width = eEar.getWidth();
                                int height = (int) (width / (float) earBitmap.getWidth() * earBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(earBitmap, width, height, true);
                                eEar.post(() -> {
                                    eEar.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        if (itemName.contains("仙")) {
                                            String upgradeName = itemName.substring(4, 7);
                                            earMix.post(() -> {
                                                earMix.setText(upgradeName);
                                                earMix.setVisibility(View.VISIBLE);
                                            });
                                            earSun.post(() -> earSun.setVisibility(View.VISIBLE));
                                        } else {
                                            String upgradeName = itemName.substring(0, 3);
                                            earMix.post(() -> {
                                                earMix.setText(upgradeName);
                                                earMix.setVisibility(View.VISIBLE);
                                            });
                                            earSun.post(() -> earSun.setVisibility(View.INVISIBLE));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        earMix.post(() -> {
                                            earMix.setText("");
                                            earMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    earMix.post(() -> {
                                        earMix.setText("");
                                        earMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    earReinForce.post(() -> {
                                        earReinForce.setText("+" + reinforce);
                                        earReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    earReinForce.post(() -> {
                                        earReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    earReinForce.post(() -> {
                                        earReinForce.setText("+" + reinforce);
                                        earReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    earReinForce.post(() -> {
                                        earReinForce.setText("+" + reinforce);
                                        earReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }
                            }
                            else if ("마법석".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap stoneBitmap = getBitmapFromURL(imageUrl);
                                int width = eStone.getWidth();
                                int height = (int) (width / (float) stoneBitmap.getWidth() * stoneBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(stoneBitmap, width, height, true);
                                eStone.post(() -> {
                                    eStone.setImageBitmap(scaledBitmap);
                                });
                                if (upgradeInfo != null && !upgradeInfo.isEmpty()) {
                                    try {
                                        JSONObject upgradeInfoJson = new JSONObject(upgradeInfo);
                                        String itemName = upgradeInfoJson.getString("itemName");
                                        if (itemName.contains("仙")) {
                                            String upgradeName = itemName.substring(4, 7);
                                            stoneMix.post(() -> {
                                                stoneMix.setText(upgradeName);
                                                stoneMix.setVisibility(View.VISIBLE);
                                            });
                                            stoneSun.post(() -> stoneSun.setVisibility(View.VISIBLE));
                                        } else {
                                            String upgradeName = itemName.substring(0, 3);
                                            stoneMix.post(() -> {
                                                stoneMix.setText(upgradeName);
                                                stoneMix.setVisibility(View.VISIBLE);
                                            });
                                            stoneSun.post(() -> stoneSun.setVisibility(View.INVISIBLE));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        stoneMix.post(() -> {
                                            stoneMix.setText("");
                                            stoneMix.setVisibility(View.INVISIBLE);
                                        });
                                    }
                                } else {
                                    stoneMix.post(() -> {
                                        stoneMix.setText("");
                                        stoneMix.setVisibility(View.INVISIBLE);
                                    });
                                }
                                if (reinforce > 0) {
                                    stoneReinForce.post(() -> {
                                        stoneReinForce.setText("+" + reinforce);
                                        stoneReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                } else {
                                    stoneReinForce.post(() -> {
                                        stoneReinForce.setText("+0");
                                    });
                                }
                                if (amplificationName != null) {
                                    stoneReinForce.post(() -> {
                                        stoneReinForce.setText("+" + reinforce);
                                        stoneReinForce.setTextColor(context.getResources().getColor(R.color.magenta));
                                    });
                                } else {
                                    stoneReinForce.post(() -> {
                                        stoneReinForce.setText("+" + reinforce);
                                        stoneReinForce.setTextColor(context.getResources().getColor(R.color.white));
                                    });
                                }
                            }

                        }

                        String charUrl = "https://img-api.neople.co.kr/df/servers/" + server + "/characters/" + characterId + "?zoom=1";
                        Bitmap charBitmap = getBitmapFromURL(charUrl);
                        int width = charBitmap.getWidth();
                        int height = (int) (width / (float) charBitmap.getWidth() * charBitmap.getHeight());
                        Bitmap charBit = Bitmap.createScaledBitmap(charBitmap, width, height, true);
                        charPicture.post(() -> {
                            charPicture.setImageBitmap(charBit);
                        });
                    }
                } catch (HttpStatusException e) {
                    int statusCode = e.getStatusCode();
                    String errorMessage;
                    switch (statusCode) {
                        case 400:
                        case 401:
                        case 404:
                        case 500:
                            errorMessage = "캐릭터를 찾을 수 없습니다.";
                            break;
                        case 503:
                            errorMessage = "현재 던전앤파이터 서버 점검 중입니다.";
                            break;
                        default:
                            errorMessage = "알 수 없는 오류가 발생했습니다.";
                    }
                    ((Activity) context).runOnUiThread(() -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("경고");
                        builder.setMessage(errorMessage);
                        builder.setPositiveButton("확인", (dialog, which) -> {
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                        });
                        builder.setIcon(R.drawable.fame);
                        builder.show();
                    });
                } catch (IOException | JSONException e){
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

