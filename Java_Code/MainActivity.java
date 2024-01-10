package com.cookandroid.dnf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner server;
    EditText nick;
    Button search;
    String ns, sChoice;
    String previousChoice = "cain"; // 이전 선택값을 저장하는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        server = findViewById(R.id.server);
        final String[] serverList = {"카인", "디레지에", "시로코", "프레이", "카시야스", "힐더", "안톤", "바칼"};
        search = findViewById(R.id.search);
        nick = findViewById(R.id.nick);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, serverList);
        server.setAdapter(adapter);

        server.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sChoice = serverList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ns = nick.getText().toString();
                Intent intent = new Intent(MainActivity.this, characterInfo.class);
                intent.putExtra("nickName", ns);

                // 이전 선택값을 업데이트
                previousChoice = convertToEnglish(sChoice);

                intent.putExtra("serverSelect", previousChoice);
                startActivity(intent);
            }
        });
    }

    // 서버 이름을 영문으로 변환하는 메서드
    private String convertToEnglish(String sChoice) {
        switch (sChoice) {
            case "카인":
                return "cain";
            case "디레지에":
                return "diregie";
            case "시로코":
                return "siroco";
            case "프레이":
                return "prey";
            case "카시야스":
                return "casillas";
            case "힐더":
                return "hilder";
            case "안톤":
                return "anton";
            case "바칼":
                return "bakal";
            default:
                return "cain"; // 기본값 설정
        }
    }
}
