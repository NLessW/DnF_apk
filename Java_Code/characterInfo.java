package com.cookandroid.dnf;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import androidx.appcompat.app.AlertDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.http.GET;

public class characterInfo extends TabActivity {
    String characterName, server;
    String apiKey;
    public static TextView shdReinForce, shirtReinForce, pantsReinForce, beltReinForce, shoeReinForce,
            weaponReinForce, weaponInfo, handReinForce, neckReinForce, subReinForce,
            ringReinForce, earReinForce, stoneReinForce, userName, fameNum, shdMix,
            shirtMix, pantsMix, beltMix, shoeMix, weaponMix, handMix, neckMix, subMix,
            ringMix, earMix, stoneMix, handSun, neckSun, subSun, ringSun, earSun, stoneSun,
            advName, jobName, serve, guild, hp, mp, phyDefense, magDefense, strStat,
            healthStat, phyAttack, phyCritical, soloAttack, brainStat, brainPower,
            magicAttack, magicCritical, atkSpeed, moveSpeed, castingSpeed, fire, water,
            light, dark,buffWeaponName, buffShirtName, buffShdName, buffPantsName, buffBeltName, buffShoeName,
            buffHandName, buffNeckName, buffRingName, buffSubName, buffEarName, buffStoneName,buffTitleName, skillCri,
            avatarWeaponName, weaponEmblem, avatarHatName, hatEmblem, avatarHairName, hairEmblem, avatarFaceName, faceEmblem,
            avatarShirtName, shirtEmblem, avatarPantsName, pantsEmblem, avatarShoeName, shoeEmblem,
            avatarNeckName, neckEmblem, avatarBeltName, beltEmblem, avatarSkinName, skinEmblem, avatarOraName, oraEmblem;
            ;

    public static ImageView eShd, eShirt, ePants, eBelt, eShoe, eWeapon, eTitle, eHand, eNeck, eSub, eRing, eEar, eStone, charPicture,
            shdMist, shirtMist, pantsMist, beltMist, shoeMist, handMist, neckMist, subMist, ringMist, earMist, stoneMist,
            buffWeapon, buffTitle, buffShirt, buffPants, buffBelt, buffShoe, buffShd, buffHand, buffNeck, buffRing, buffSub, buffEar, buffStone,
            skillIcon, avatarWeapon, avatarHat, avatarHair, avatarFace, avatarShirt, avatarPants, avatarShoe, avatarNeck, avatarBelt, avatarSkin, avatarOra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinfo);
        Intent intent = getIntent();
        characterName = intent.getStringExtra("nickName");
        server = intent.getStringExtra("serverSelect");
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
        jobName = findViewById(R.id.jobName);
        serve = findViewById(R.id.serve);
        guild = findViewById(R.id.guild);
        shdMist = findViewById(R.id.shdMist);
        shirtMist = findViewById(R.id.shirtMist);
        pantsMist = findViewById(R.id.pantsMist);
        beltMist = findViewById(R.id.beltMist);
        shoeMist = findViewById(R.id.shoeMist);
        handMist = findViewById(R.id.handMist);
        neckMist = findViewById(R.id.neckMist);
        subMist = findViewById(R.id.subMist);
        ringMist = findViewById(R.id.ringMist);
        earMist = findViewById(R.id.earMist);
        stoneMist = findViewById(R.id.stoneMist);
        hp = findViewById(R.id.hp);
        mp = findViewById(R.id.mp);
        phyDefense = findViewById(R.id.phyDefense);
        magDefense = findViewById(R.id.magDefense);
        strStat = findViewById(R.id.strStat);
        healthStat = findViewById(R.id.healthStat);
        phyAttack = findViewById(R.id.phyAttack);
        phyCritical = findViewById(R.id.phyCritical);
        soloAttack = findViewById(R.id.soloAttack);
        brainStat = findViewById(R.id.brainStat);
        brainPower = findViewById(R.id.brainPower);
        magicAttack = findViewById(R.id.magicAttack);
        magicCritical = findViewById(R.id.magicCritical);
        atkSpeed = findViewById(R.id.atkSpeed);
        moveSpeed = findViewById(R.id.moveSpeed);
        castingSpeed = findViewById(R.id.castingSpeed);
        buffShirt = findViewById(R.id.buffShirt);
        buffShirtName = findViewById(R.id.buffShirtName);
        buffTitle = findViewById(R.id.buffTitle);
        buffTitleName = findViewById(R.id.buffTitleName);
        buffWeapon = findViewById(R.id.buffWeapon);
        buffWeaponName = findViewById(R.id.buffWeaponName);
        buffShd = findViewById(R.id.buffShd);
        buffShdName = findViewById(R.id.buffShdName);
        buffPants = findViewById(R.id.buffPants);
        buffPantsName = findViewById(R.id.buffPantsName);
        buffBelt = findViewById(R.id.buffBelt);
        buffBeltName = findViewById(R.id.buffBeltName);
        buffShoe = findViewById(R.id.buffShoe);
        buffShoeName = findViewById(R.id.buffShoeName);
        buffHand = findViewById(R.id.buffHand);
        buffHandName = findViewById(R.id.buffHandName);
        buffNeck = findViewById(R.id.buffNeck);
        buffNeckName = findViewById(R.id.buffNeckName);
        buffRing = findViewById(R.id.buffRing);
        buffRingName = findViewById(R.id.buffRingName);
        buffSub = findViewById(R.id.buffSub);
        buffSubName = findViewById(R.id.buffSubName);
        buffEar = findViewById(R.id.buffEar);
        buffEarName = findViewById(R.id.buffEarName);
        buffStone = findViewById(R.id.buffStone);
        buffStoneName = findViewById(R.id.buffStoneName);
        skillCri = findViewById(R.id.skillCri);
        skillIcon = findViewById(R.id.skillIcon);
        fire = findViewById(R.id.fire);
        water = findViewById(R.id.water);
        light = findViewById(R.id.light);
        dark = findViewById(R.id.dark);
        avatarWeapon = findViewById(R.id.avatarWeapon);
        avatarWeaponName = findViewById(R.id.avatarWeaponName);
        weaponEmblem = findViewById(R.id.weaponEmblem);
        avatarHat = findViewById(R.id.avatarHat);
        avatarHatName = findViewById(R.id.avatarHatName);
        hatEmblem = findViewById(R.id.hatEmblem);
        avatarHair = findViewById(R.id.avatarHair);
        avatarHairName = findViewById(R.id.avatarHairName);
        hairEmblem = findViewById(R.id.hairEmblem);
        avatarFace = findViewById(R.id.avatarFace);
        avatarFaceName = findViewById(R.id.avatarFaceName);
        avatarShirt = findViewById(R.id.avatarShirt);
        avatarShirtName = findViewById(R.id.avatarShirtName);
        shirtEmblem = findViewById(R.id.shirtEmblem);
        avatarPants = findViewById(R.id.avatarPants);
        avatarPantsName = findViewById(R.id.avatarPantsName);
        pantsEmblem = findViewById(R.id.pantsEmblem);
        avatarShoe = findViewById(R.id.avatarShoe);
        avatarShoeName = findViewById(R.id.avatarShoeName);
        shoeEmblem = findViewById(R.id.shoeEmblem);
        avatarNeck = findViewById(R.id.avatarNeck);
        avatarNeckName = findViewById(R.id.avatarNeckName);
        neckEmblem = findViewById(R.id.neckEmblem);
        avatarBelt = findViewById(R.id.avatarBelt);
        avatarBeltName = findViewById(R.id.avatarBeltName);
        beltEmblem = findViewById(R.id.beltEmblem);
        avatarSkin = findViewById(R.id.avatarSkin);
        avatarSkinName = findViewById(R.id.avatarSkinName);
        skinEmblem = findViewById(R.id.skinEmblem);
        avatarOra = findViewById(R.id.avatarOra);
        avatarOraName = findViewById(R.id.avatarOraName);
        oraEmblem = findViewById(R.id.oraEmblem);
        userName.setText(characterName);

        ImageView famepng = findViewById(R.id.famepng);
        famepng.setImageDrawable(getResources().getDrawable(R.drawable.fame));
        shdMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        shirtMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        pantsMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        beltMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        shoeMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        handMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        neckMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        ringMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        subMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        earMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));
        stoneMist.setImageDrawable(getResources().getDrawable(R.drawable.mist));

        TabHost tabHost = getTabHost();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("Stats").setIndicator("Stats");;
        spec1.setContent(R.id.tab1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("버프강화").setIndicator("버프강화");
        spec2.setContent(R.id.tab2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab3").setIndicator("Tab 3");
        spec3.setContent(R.id.tab3);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        tabHost.setCurrentTab(0);

        if(server.equals("cain")){
            serve.setText("서버 : 카인");
        }
        else if(server.equals("diregie")){
            serve.setText("서버 : 디레지에");
        }
        else if(server.equals("siroco")){
            serve.setText("서버 : 시로코");
        }
        else if(server.equals("prey")){
            serve.setText("서버 : 프레이");
        }
        else if(server.equals("casillas")){
            serve.setText("서버 : 카시야스");
        }
        else if(server.equals("hilder")){
            serve.setText("서버 : 힐더");
        }
        else if(server.equals("anton")){
            serve.setText("서버 : 안톤");
        }
        else if(server.equals("bakal")){
            serve.setText("서버 : 바칼");
        }
        else{
            serve.setText("아라드주민?");
        }


        CharacterUtils.setCharWeapon(this, server, characterName, apiKey);

        CharacterUtils.setCharStats(this, server, characterName,apiKey);

        CharacterUtils.setCharBuff(this, server, characterName, apiKey);

        CharacterUtils.setAvatar(this, server, characterName, apiKey);
    }

    public static class CharacterUtils {
        // 캐릭터 정보를 담는 클래스 정의
        public static class CharacterInfo {
            private final String characterId;
            private final int fame;

            public CharacterInfo(String characterId, int fame) {
                this.characterId = characterId;
                this.fame = fame;
            }

            public String getCharacterId() {
                return characterId;
            }
            public int getFame() {
                return fame;
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
                JSONArray rows = json.getJSONArray("rows");

                if (rows.length() > 0) {
                    JSONObject character = rows.getJSONObject(0);
                    String characterId = character.getString("characterId");
                    int fame = 0;
                    if (!character.isNull("fame")) {
                        fame = character.getInt("fame");
                    }
                    return new CharacterInfo(characterId, fame);
                } else {
                    return null;
                }
            } catch(IOException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        public static void setCharWeapon(Context context, String server, String characterName, String apiKey) {
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
                        fameNum.post(() -> {
                            fameNum.setText(String.valueOf(fame));
                        });

                        JSONObject jsonResponse = new JSONObject(response.body());
                        JSONArray equipmentArray = jsonResponse.getJSONArray("equipment");
                        final String adventureName;

                        if (jsonResponse.has("adventureName")) {
                            adventureName = jsonResponse.getString("adventureName");
                        } else {
                            adventureName = "";
                        }
                        advName.post(() -> {
                            advName.setText(adventureName);
                        });
                        final String jobGrowName;
                        if (jsonResponse.has("jobGrowName")) {
                            jobGrowName = jsonResponse.getString("jobGrowName");
                        } else {
                            jobGrowName = "";
                        }
                        jobName.post(() -> {
                            jobName.setText(jobGrowName);
                        });
                        final String guildName;
                        if (jsonResponse.has("guildName") && !jsonResponse.isNull("guildName")) {
                            guildName = jsonResponse.getString("guildName");
                        } else {
                            guildName = null;
                        }

                        guild.post(() -> {
                            if (guild != null) {
                                if (guildName != null) {
                                    guild.setText("길드 : " + guildName);
                                } else {
                                    guild.setText("길드 : 없음");
                                }
                            }
                        });



                        for (int i = 0; i < equipmentArray.length(); i++) {
                            JSONObject equipment = equipmentArray.getJSONObject(i);
                            String itemId = equipment.getString("itemId");
                            String slotName = equipment.getString("slotName");
                            String upgradeInfo = equipment.isNull("upgradeInfo") ? null : equipment.getString("upgradeInfo");
                            String amplificationName = equipment.isNull("amplificationName") ? null : equipment.getString("amplificationName");
                            boolean pureMistGear = equipment.isNull("pureMistGear") ? false : equipment.getBoolean("pureMistGear");
                            boolean refinedMistGear = equipment.isNull("refinedMistGear") ? false : equipment.getBoolean("refinedMistGear");
                            boolean mistGear = equipment.isNull("mistGear") ? false : equipment.getBoolean("mistGear");
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

                                if (mistGear || pureMistGear || refinedMistGear) {
                                    shirtMist.post(() -> {
                                        shirtMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    shirtMist.post(() -> {
                                        shirtMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    pantsMist.post(() -> {
                                        pantsMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    pantsMist.post(() -> {
                                        pantsMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    shdMist.post(() -> {
                                        shdMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    shdMist.post(() -> {
                                        shdMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                            else if ("신발".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap shoeBitmap = getBitmapFromURL(imageUrl);
                                int width = eShoe.getWidth();
                                int height = (int) (width / (float) shoeBitmap.getWidth() * shoeBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(shoeBitmap, width, height, true);
                                eShoe.post(() -> {
                                    eShoe.setImageBitmap(scaledBitmap);
                                });
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    shoeMist.post(() -> {
                                        shoeMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    shoeMist.post(() -> {
                                        shoeMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                            else if ("벨트".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap beltBitmap = getBitmapFromURL(imageUrl);
                                int width = eBelt.getWidth();
                                int height = (int) (width / (float) beltBitmap.getWidth() * beltBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(beltBitmap, width, height, true);

                                eBelt.post(() -> {
                                    eBelt.setImageBitmap(scaledBitmap);
                                });
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    beltMist.post(() -> {
                                        beltMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    beltMist.post(() -> {
                                        beltMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                            else if ("팔찌".equals(slotName)) {
                                String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                Bitmap handBitmap = getBitmapFromURL(imageUrl);
                                int width = eHand.getWidth();
                                int height = (int) (width / (float) handBitmap.getWidth() * handBitmap.getHeight());
                                Bitmap scaledBitmap = Bitmap.createScaledBitmap(handBitmap, width, height, true);
                                eHand.post(() -> {
                                    eHand.setImageBitmap(scaledBitmap);
                                });
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    handMist.post(() -> {
                                        handMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    handMist.post(() -> {
                                        handMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    neckMist.post(() -> {
                                        neckMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    neckMist.post(() -> {
                                        neckMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    ringMist.post(() -> {
                                        ringMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    ringMist.post(() -> {
                                        ringMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    subMist.post(() -> {
                                        subMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    subMist.post(() -> {
                                        subMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                            String upgradeName = itemName.substring(0, 2);
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
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    earMist.post(() -> {
                                        earMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    earMist.post(() -> {
                                        earMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                            String upgradeName = itemName.substring(0, 2);
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
                                if (mistGear || pureMistGear || refinedMistGear) {
                                    stoneMist.post(() -> {
                                        stoneMist.setVisibility(View.VISIBLE);
                                    });
                                } else {
                                    stoneMist.post(() -> {
                                        stoneMist.setVisibility(View.INVISIBLE);
                                    });
                                }
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
                                            String upgradeName = itemName.substring(0, 2);
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
        public static void setCharStats(Context context, String server, String characterName, String apiKey) {
            new Thread(() -> {
                try {
                    CharacterInfo characterInfo = getCharacterInfo(context, server, characterName, apiKey);
                    String characterId = "";
                    if (characterInfo != null) {
                        characterId = characterInfo.getCharacterId();
                    }

                    Connection.Response response = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters/" + characterId + "/status")
                            .data("apikey", apiKey)
                            .ignoreContentType(true)
                            .method(Connection.Method.GET)
                            .execute();
                    String responseBody = response.body();
                    JSONObject statusObject = new JSONObject(responseBody);
                    JSONArray statusArray = statusObject.getJSONArray("status");
                    for (int i = 0; i < statusArray.length(); i++) {
                        JSONObject statusItem = statusArray.getJSONObject(i);
                        String name = statusItem.getString("name");
                        int value = statusItem.getInt("value");
                        double fValue = statusItem.getDouble("value");

                        if ("HP" .equals(name)) {
                            hp.post(() -> hp.setText(String.valueOf("❤ HP   "+value)));
                        }
                        else if ("MP" .equals(name)) {
                            mp.post(() -> mp.setText(String.valueOf("\uD83D\uDC99 MP   "+value)));
                        }
                        else if ("물리 방어율".equals(name)) {
                            phyDefense.post(() -> {
                                String formattedValue = String.format("\uD83D\uDEE1 물리방어률   %.1f %%", fValue);
                                phyDefense.setText(formattedValue);
                            });
                        }
                        else if ("마법 방어율".equals(name)){
                            magDefense.post(() -> {
                                String formattedValue = String.format("\uD83D\uDD2E 마법방어률   %.1f %%", (float) fValue);
                                magDefense.setText(formattedValue);
                            });
                        }
                        else if("힘".equals(name)){
                            strStat.post(() -> {
                                strStat.setText("\uD83D\uDCAA 힘   " + value);
                            });
                        }
                        else if("지능".equals(name)){
                            brainStat.post(() -> {
                               brainStat.setText("\uD83D\uDC41 지능   "+value);
                            });
                        }
                        else if("체력".equals(name)){
                            healthStat.post(() -> {
                                healthStat.setText("\uD83D\uDC64 체력   " + value);
                            });
                        }
                        else if("정신력".equals(name)){
                            brainPower.post(() -> {
                                brainPower.setText("\uD83E\uDDE0 정신력   " + value);
                            });
                        }
                        else if("물리 공격".equals(name)){
                            phyAttack.post(() -> {
                               phyAttack.setText("\uD83D\uDDE1 물리공격   " + value);
                            });
                        }
                        else if("마법 공격".equals(name)){
                            magicAttack.post(() -> {
                                magicAttack.setText("\uD83E\uDE84 마법공격   " + value);
                            });
                        }
                        else if("물리 크리티컬".equals(name)){
                            phyCritical.post(() -> {
                                phyCritical.setText("\uD83D\uDCA5 물리크리티컬   +"+ fValue + "%");
                            });
                        }
                        else if("마법 크리티컬".equals(name)){
                            magicCritical.post(() -> {
                               magicCritical.setText("\uD83E\uDDFF 마법크리티컬   +"+fValue+"%");
                            });
                        }
                        else if("독립 공격".equals(name)){
                            soloAttack.post(() -> {
                               soloAttack.setText("\uD83D\uDD2A 독립공격   "+value);
                            });
                        }
                        else if("공격 속도".equals(name)){
                            atkSpeed.post(() -> {
                                atkSpeed.setText("\uD83E\uDD1B 공격속도   "+fValue +" %");
                            });
                        }
                        else if("캐스팅 속도".equals(name)){
                            castingSpeed.post(() -> {
                                castingSpeed.setText("⚡ 캐스팅속도   "+fValue +" %");
                            });
                        }
                        else if("이동 속도".equals(name)){
                            moveSpeed.post(() -> {
                               moveSpeed.setText("\uD83D\uDC5F 이동속도   " + fValue +" %");
                            });
                        }
                        else if("화속성 강화".equals(name)){
                            fire.post(() -> {
                               fire.setText("화("+value+") / ");
                            });
                        }
                        else if("수속성 강화".equals(name)){
                            water.post(() -> {
                               water.setText("수("+value+") / ");
                            });
                        }
                        else if("명속성 강화".equals(name)){
                            light.post(() -> {
                               light.setText("명(" + value +") / ");
                            });
                        }
                        else if("암속성 강화".equals(name)){
                            dark.post(() -> {
                               dark.setText("암("+value+")");
                            });
                        }
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        public static void setCharBuff(Context context, String server, String characterName, String apiKey){

            new ThreadTask<String, String>() {

                ArrayList<String> nameArr = new ArrayList<String>();
                ArrayList<Bitmap> bitmapArr = new ArrayList<Bitmap>();

                @Override
                protected void onPreExecute() {

                }

                @Override
                protected String doInBackground(String arg) {
                    try {
                        CharacterInfo characterInfo = getCharacterInfo(context, server, characterName, apiKey);
                        String characterId = "";
                        if (characterInfo != null) {
                            characterId = characterInfo.getCharacterId();
                        }

                        Connection.Response response = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters/" + characterId + "/skill/buff/equip/equipment")
                                .data("apikey", apiKey)
                                .ignoreContentType(true)
                                .method(Connection.Method.GET)
                                .execute();

                        JSONObject jsonResponse = new JSONObject(response.body());

                        if (jsonResponse.has("skill")) {
                            JSONObject skillObject = jsonResponse.getJSONObject("skill");

                            if (skillObject.has("buff")) {
                                JSONObject buffObject = skillObject.getJSONObject("buff");
                                Connection.Response response2 = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters/" + characterId + "/skill/style")
                                        .data("apikey", apiKey)
                                        .ignoreContentType(true)
                                        .method(Connection.Method.GET)
                                        .execute();

                                JSONObject jsonResponse2 = new JSONObject(response2.body());
                                if (jsonResponse2.has("skill")) {
                                    JSONObject skillInfoObject = jsonResponse2.getJSONObject("skill");

                                    if (skillInfoObject.has("style")) {
                                        JSONObject styleObject = skillInfoObject.getJSONObject("style");

                                        if (styleObject.has("active")) {
                                            JSONArray activeArray = styleObject.getJSONArray("active");

                                            for (int i = 0; i < activeArray.length(); i++) {
                                                JSONObject activeObject = activeArray.getJSONObject(i);
                                                String aSkillId = activeObject.getString("skillId");
                                                int  aLevel = activeObject.getInt("level");

                                                if (buffObject.has("skillInfo")) {
                                                    JSONObject sInfoObject = buffObject.getJSONObject("skillInfo");
                                                    String skillName = sInfoObject.getString("name");
                                                    String skillId = sInfoObject.getString("skillId");
                                                    JSONObject optionObject = sInfoObject.getJSONObject("option");
                                                    int skillLevel = optionObject.getInt("level");
                                                    JSONArray valuesArray = optionObject.getJSONArray("values");
                                                    String skillPercentage = valuesArray.getString(1);
                                                    if(skillId.equals(aSkillId)){
                                                        skillCri.post(() -> {
                                                            skillCri.setText("  + " + (skillLevel - aLevel) + "렙 " + skillPercentage + " %");
                                                        });
                                                    }
                                                    if ("오버드라이브".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.overdrive);
                                                        });
                                                    }
                                                    else if ("폭주".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.berserker);
                                                        });
                                                    }
                                                    else if ("잔영의 케이가".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.soul);
                                                        });
                                                    }
                                                    else if ("살의의 파동".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.asura);
                                                        });
                                                    }
                                                    else if ("귀혼일체".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.sword);
                                                        });
                                                    }
                                                    else if ("역혈기공".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.mannen);
                                                        });
                                                    }
                                                    else if ("뒷골목 싸움법".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manstreet);
                                                        });
                                                    }
                                                    else if ("반드시 잡는다!".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.grapler);
                                                        });
                                                    }
                                                    else if ("강권".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.striker);
                                                        });
                                                    }
                                                    else if ("데스 바이 리볼버".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.deathbyrevolver);
                                                        });
                                                    }
                                                    else if ("로보틱스".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.robotics);
                                                        });
                                                    }
                                                    else if ("미라클 비전".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.miraclevision);
                                                        });
                                                    }
                                                    else if ("오버차지".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.overcharge);
                                                        });
                                                    }
                                                    else if ("블러드 번".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manblood);
                                                        });
                                                    }
                                                    else if ("마나 폭주".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manelmental);
                                                        });
                                                    }
                                                    else if ("공명".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manbingyul);
                                                        });
                                                    }
                                                    else if ("경계망상".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.mandimention);
                                                        });
                                                    }
                                                    else if ("윈드니스".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manswift);
                                                        });
                                                    }
                                                    else if ("성령의 메이스".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.mancru);
                                                        });
                                                    }
                                                    else if ("광명의 챠크라".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manghosthunter);
                                                        });
                                                    }
                                                    else if ("섀도우 박서".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.maninfighter);
                                                        });
                                                    }
                                                    else if ("추락하는 영혼".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manavenger);
                                                        });
                                                    }
                                                    else if ("신검합일".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.swordmaster);
                                                        });
                                                    }
                                                    else if ("광폭화".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.demonslayer);
                                                        });
                                                    }
                                                    else if ("컨제스트".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.darktempler);
                                                        });
                                                    }
                                                    else if ("오기조원".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.vegabond);
                                                        });
                                                    }
                                                    else if ("트레이스".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.blade);
                                                        });
                                                    }
                                                    else if ("카이".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.girlnen);
                                                        });
                                                    }
                                                    else if ("독 바르기".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.girlstreet);
                                                        });
                                                    }
                                                    else if ("엘레멘탈 번".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.elementalburn);
                                                        });
                                                    }
                                                    else if ("고대의 도서관".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.ancientlibrary);
                                                        });
                                                    }
                                                    else if ("환수 폭주".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.hwansupokju);
                                                        });
                                                    }
                                                    else if ("전장의 여신".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.wargod);
                                                        });
                                                    }
                                                    else if ("금단의 저주".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.inchantris);
                                                        });
                                                    }
                                                    else if ("용맹의 축복".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.gircru);
                                                        });
                                                    }
                                                    else if ("광적인 믿음".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.crazybelive);
                                                        });
                                                    }
                                                    else if ("일곱개의 대죄".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.sevenbigmiss);
                                                        });
                                                    }
                                                    else if ("신탁의 기원".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.godpray);
                                                        });
                                                    }
                                                    else if ("셰이크 다운".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.shakedown);
                                                        });
                                                    }
                                                    else if ("화둔 : 홍염".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.kunoichi);
                                                        });
                                                    }
                                                    else if ("암살자의 마음가짐".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.shadowdancer);
                                                        });
                                                    }
                                                    else if ("암흑의 의식".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.saryung);
                                                        });
                                                    }
                                                    else if ("워크라이".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.warcry);
                                                        });
                                                    }
                                                    else if ("브레인 스톰".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.chaos);
                                                        });
                                                    }
                                                    else if ("폭음폭식".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.dragonknight);
                                                        });
                                                    }
                                                    else if ("페이스풀".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.facepull);
                                                        });
                                                    }
                                                    else if ("마창 해방".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.bangguard);
                                                        });
                                                    }
                                                    else if ("오러 랜스".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.oralance);
                                                        });
                                                    }
                                                    else if ("다크니스".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.darkness);
                                                        });
                                                    }
                                                    else if ("마나 익스트랙트".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.manaextract);
                                                        });
                                                    }
                                                    else if ("임무 시작".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.missionstart);
                                                        });
                                                    }
                                                    else if ("역전의 숭부사".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.troubleshooter);
                                                        });
                                                    }
                                                    else if ("전술 지휘".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.hitman);
                                                        });
                                                    }
                                                    else if ("코어 프렉시스".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.speciallist);
                                                        });
                                                    }
                                                    else if ("러블리 템포".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.lovelytempo);
                                                        });
                                                    }
                                                    else if ("익사이팅".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.exiting);
                                                        });
                                                    }
                                                    else if ("오버플로우".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.overflow);
                                                        });
                                                    }
                                                    else if ("증폭".equals(skillName)) {
                                                        skillIcon.post(() -> {
                                                            skillIcon.setImageResource(R.drawable.creator);
                                                        });
                                                    }
                                                }
                                            }

                                if (buffObject.has("equipment")) {
                                    JSONArray equipmentArray = buffObject.getJSONArray("equipment");
                                    String[] equipArr = {"무기", "칭호", "상의", "머리어깨", "하의", "신발", "벨트", "목걸이", "팔찌", "반지", "보조장비", "마법석", "귀걸이"};

                                    for (int i = 0; i < equipmentArray.length(); i++) {
                                        JSONObject equipment = equipmentArray.getJSONObject(i);
                                        String slotName = equipment.getString("slotName");
                                        String itemName = equipment.getString("itemName");
                                        String itemId = equipment.getString("itemId");
                                        if(slotName.equals(equipArr[i])) {
                                            String imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                            Bitmap bit = getBitmapFromURL(imageUrl);
                                            bitmapArr.add(bit);
                                            nameArr.add(itemName);

                                        }
                                        }
                                    }
                                        }
                                    }
                                }
                            }
                        }

                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(String result) {

                    if(bitmapArr.size() != 0 && nameArr.size() != 0) {
                        buffWeapon.setImageBitmap(bitmapArr.get(0));
                        buffWeaponName.setText(nameArr.get(0));

                        buffTitle.setImageBitmap(bitmapArr.get(1));
                        buffTitleName.setText(nameArr.get(1));

                        buffShirt.setImageBitmap(bitmapArr.get(2));
                        buffShirtName.setText(nameArr.get(2));

                        buffShd.setImageBitmap(bitmapArr.get(3));
                        buffShdName.setText(nameArr.get(3));

                        buffPants.setImageBitmap(bitmapArr.get(4));
                        buffPantsName.setText(nameArr.get(4));

                        buffShoe.setImageBitmap(bitmapArr.get(5));
                        buffShoeName.setText(nameArr.get(5));

                        buffBelt.setImageBitmap(bitmapArr.get(6));
                        buffBeltName.setText(nameArr.get(6));

                        buffNeck.setImageBitmap(bitmapArr.get(7));
                        buffNeckName.setText(nameArr.get(7));

                        buffHand.setImageBitmap(bitmapArr.get(8));
                        buffHandName.setText(nameArr.get(8));

                        buffRing.setImageBitmap(bitmapArr.get(9));
                        buffRingName.setText(nameArr.get(9));

                        buffSub.setImageBitmap(bitmapArr.get(10));
                        buffSubName.setText(nameArr.get(10));

                        buffStone.setImageBitmap(bitmapArr.get(11));
                        buffStoneName.setText(nameArr.get(11));

                        buffEar.setImageBitmap(bitmapArr.get(12));
                        buffEarName.setText(nameArr.get(12));
                    }
                }
            }.execute("");

        }
        public static void setAvatar(Context context, String server, String characterName, String apiKey) {
            new Thread(() -> {
                try {
                    CharacterInfo characterInfo = getCharacterInfo(context, server, characterName, apiKey);
                    String characterId = "";
                    if (characterInfo != null) {
                        characterId = characterInfo.getCharacterId();
                    }

                    Connection.Response response = Jsoup.connect("https://api.neople.co.kr/df/servers/" + server + "/characters/" + characterId + "/equip/avatar")
                            .data("apikey", apiKey)
                            .ignoreContentType(true)
                            .method(Connection.Method.GET)
                            .execute();

                    JSONObject jsonResponse = new JSONObject(response.body());
                    JSONArray avatarArray = jsonResponse.getJSONArray("avatar");

                    if (avatarArray.length() == 0) {
                        setAvatarInvisible();
                    }else {

                        boolean headgearFound = false;
                        boolean hairFound = false;
                        boolean faceFound = false;
                        boolean shirtFound = false;
                        boolean pantsFound = false;
                        boolean shoesFound = false;
                        boolean neckFound = false;
                        boolean beltFound = false;
                        boolean skinFound = false;
                        boolean oraFound = false;
                        boolean weaponFound = false;
                        for (int i = 0; i < avatarArray.length(); i++) {
                            JSONObject avatar = avatarArray.getJSONObject(i);
                            String slotId = avatar.getString("slotId");
                            String itemId = avatar.getString("itemId");
                            String itemName = avatar.getString("itemName");
                            JSONObject clone = avatar.optJSONObject("clone");
                            String itemIdClone = null;
                            String itemNameClone = null;

                            if (clone != null) {
                                itemIdClone = clone.optString("itemId");
                                itemNameClone = clone.optString("itemName");
                            }

                            if ("HEADGEAR".equals(slotId)) {
                                headgearFound = true;

                                String imageUrl;
                                Bitmap headBitmap;

                                if (itemIdClone == null || "null".equals(itemIdClone)) {
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    headBitmap = getBitmapFromURL(imageUrl);
                                    avatarHatName.setText(itemName);
                                } else {
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    headBitmap = getBitmapFromURL(imageUrl);
                                    avatarHatName.setText(itemName + "\nㄴ " + itemNameClone);
                                }
                                if (headBitmap != null) {
                                    avatarHat.setImageBitmap(headBitmap);
                                }
                            }
                            else if("HAIR".equals(slotId)){
                                hairFound = true;

                                String imageUrl;
                                Bitmap hairBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    hairBitmap = getBitmapFromURL(imageUrl);
                                    avatarHairName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    hairBitmap = getBitmapFromURL(imageUrl);
                                    avatarHairName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (hairBitmap != null){
                                    avatarHair.setImageBitmap(hairBitmap);
                                }
                            }
                            else if("FACE".equals(slotId)){
                                faceFound = true;

                                String imageUrl;
                                Bitmap faceBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    faceBitmap = getBitmapFromURL(imageUrl);
                                    avatarFaceName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    faceBitmap = getBitmapFromURL(imageUrl);
                                    avatarFaceName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (faceBitmap != null){
                                    avatarFace.setImageBitmap(faceBitmap);
                                }
                            }
                            else if("JACKET".equals(slotId)){
                                shirtFound = true;

                                String imageUrl;
                                Bitmap shirtBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    shirtBitmap = getBitmapFromURL(imageUrl);
                                    avatarShirtName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    shirtBitmap = getBitmapFromURL(imageUrl);
                                    avatarShirtName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (shirtBitmap != null){
                                    avatarShirt.setImageBitmap(shirtBitmap);
                                }
                            }
                            else if("PANTS".equals(slotId)){
                                pantsFound = true;

                                String imageUrl;
                                Bitmap pantsBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    pantsBitmap = getBitmapFromURL(imageUrl);
                                    avatarPantsName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    pantsBitmap = getBitmapFromURL(imageUrl);
                                    avatarPantsName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (pantsBitmap != null){
                                    avatarPants.setImageBitmap(pantsBitmap);
                                }
                            }
                            else if("SHOES".equals(slotId)){
                                shoesFound = true;

                                String imageUrl;
                                Bitmap shoesBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    shoesBitmap = getBitmapFromURL(imageUrl);
                                    avatarShoeName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    shoesBitmap = getBitmapFromURL(imageUrl);
                                    avatarShoeName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (shoesBitmap != null){
                                    avatarShoe.setImageBitmap(shoesBitmap);
                                }
                            }
                            else if("BREAST".equals(slotId)){
                                neckFound = true;

                                String imageUrl;
                                Bitmap neckBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    neckBitmap = getBitmapFromURL(imageUrl);
                                    avatarNeckName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    neckBitmap = getBitmapFromURL(imageUrl);
                                    avatarNeckName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (neckBitmap != null){
                                    avatarNeck.setImageBitmap(neckBitmap);
                                }
                            }
                            else if("WAIST".equals(slotId)){
                                beltFound = true;

                                String imageUrl;
                                Bitmap beltBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    beltBitmap = getBitmapFromURL(imageUrl);
                                    avatarBeltName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    beltBitmap = getBitmapFromURL(imageUrl);
                                    avatarBeltName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (beltBitmap != null){
                                    avatarBelt.setImageBitmap(beltBitmap);
                                }
                            }
                            else if("SKIN".equals(slotId)){
                                skinFound = true;

                                String imageUrl;
                                Bitmap skinBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    skinBitmap = getBitmapFromURL(imageUrl);
                                    avatarSkinName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    skinBitmap = getBitmapFromURL(imageUrl);
                                    avatarSkinName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (skinBitmap != null){
                                    avatarSkin.setImageBitmap(skinBitmap);
                                }
                            }
                            
                            else if("WEAPON".equals(slotId)){
                                weaponFound = true;

                                String imageUrl;
                                Bitmap weaponBitmap;

                                if(itemIdClone == null || "null".equals(itemIdClone)){
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemId;
                                    weaponBitmap = getBitmapFromURL(imageUrl);
                                    avatarWeaponName.setText(itemName);
                                }else{
                                    imageUrl = "https://img-api.neople.co.kr/df/items/" + itemIdClone;
                                    weaponBitmap = getBitmapFromURL(imageUrl);
                                    avatarWeaponName.setText(itemName +"\nㄴ "+ itemNameClone);
                                }
                                if (weaponBitmap != null){
                                    avatarWeapon.setImageBitmap(weaponBitmap);
                                }
                            }
                        }

                        if (!headgearFound) {
                            avatarHat.setVisibility(View.INVISIBLE);
                            avatarHatName.setText("모자 아바타 없음");
                        }else if(!hairFound){
                            avatarHair.setVisibility(View.INVISIBLE);
                            avatarHairName.setText("머리 아바타 없음");
                        }else if(!faceFound){
                            avatarFace.setVisibility(View.INVISIBLE);
                            avatarFaceName.setText("얼굴 아바타 없음");
                        }else if(!shirtFound){
                            avatarShirt.setVisibility(View.INVISIBLE);
                            avatarShirtName.setText("상의 아바타 없음");
                        }else if(!pantsFound){
                            avatarPants.setVisibility(View.INVISIBLE);
                            avatarPantsName.setText("하의 아바타 없음");
                        }else if(!shoesFound){
                            avatarShoe.setVisibility(View.INVISIBLE);
                            avatarShoeName.setText("신발 아바타 없음");
                        }else if(!neckFound){
                            avatarNeck.setVisibility(View.INVISIBLE);
                            avatarNeckName.setText("목가슴 아바타 없음");
                        }else if(!beltFound){
                            avatarBelt.setVisibility(View.INVISIBLE);
                            avatarBeltName.setText("허리 아바타 없음");
                        }else if(!skinFound){
                            avatarSkin.setVisibility(View.INVISIBLE);
                            avatarSkinName.setText("피부 아바타 없음");
                        }else if(!weaponFound){
                            avatarWeapon.setVisibility(View.INVISIBLE);
                            avatarWeaponName.setText("무기 아바타 없음");
                        }

                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        private static void setAvatarInvisible() {
            avatarWeapon.setVisibility(View.INVISIBLE);
            avatarWeaponName.setText("무기 아바타 없음");
            weaponEmblem.setVisibility(View.INVISIBLE);
            avatarHat.setVisibility(View.INVISIBLE);
            avatarHatName.setText("모자 아바타 없음");
            hatEmblem.setVisibility(View.INVISIBLE);
            avatarHair.setVisibility(View.INVISIBLE);
            avatarHairName.setText("머리 아바타 없음");
            hairEmblem.setVisibility(View.INVISIBLE);
            avatarFace.setVisibility(View.INVISIBLE);
            avatarFaceName.setText("얼굴 아바타 없음");
            faceEmblem.setVisibility(View.INVISIBLE);
            avatarShirt.setVisibility(View.INVISIBLE);
            avatarShirtName.setText("상의 아바타 없음");
            shirtEmblem.setVisibility(View.INVISIBLE);
            avatarPants.setVisibility(View.INVISIBLE);
            avatarPantsName.setText("하의 아바타 없음");
            pantsEmblem.setVisibility(View.INVISIBLE);
            avatarNeck.setVisibility(View.INVISIBLE);
            avatarNeckName.setText("목가슴 아바타 없음");
            neckEmblem.setVisibility(View.INVISIBLE);
            avatarBelt.setVisibility(View.INVISIBLE);
            avatarBeltName.setText("허리 아바타 없음");
            beltEmblem.setVisibility(View.INVISIBLE);
            avatarSkin.setVisibility(View.INVISIBLE);
            avatarSkinName.setText("피부 아바타 없음");
            skinEmblem.setVisibility(View.INVISIBLE);
            avatarOra.setVisibility(View.INVISIBLE);
            avatarOraName.setText("오라 없음");
            oraEmblem.setVisibility(View.INVISIBLE);
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
