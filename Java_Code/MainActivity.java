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
                sChoice = serverList[position]; // 선택한 서버 값을 sChoice 변수에 할당
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

                // 서버 선택에 따라 값을 설정
                switch (sChoice) {
                    case "카인":
                        sChoice = "cain";
                        break;
                    case "디레지에":
                        sChoice = "diregie";
                        break;
                    case "시로코":
                        sChoice = "siroco";
                        break;
                    case "프레이":
                        sChoice = "prey";
                        break;
                    case "카시야스":
                        sChoice = "casillas";
                        break;
                    case "힐더":
                        sChoice = "hilder";
                        break;
                    case "안톤":
                        sChoice = "anton";
                        break;
                    case "바칼":
                        sChoice = "bakal";
                        break;
                    default:
                        sChoice = "카인";  // 기본값 설정
                        break;
                }

                intent.putExtra("serverSelect", sChoice);
                startActivity(intent);

            }
        });
    }
}
