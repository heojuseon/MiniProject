package com.example.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.miniproject.db.DataBaseHelper;
import com.example.miniproject.main.Tab1_Home;

public class LoginActivity extends AppCompatActivity {

    EditText editID;
    EditText editPW;

    DataBaseHelper dbHelper2;
    SQLiteDatabase database2;

    String tableName2 = "loginTBL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createDatabase2();
        createTable2(tableName2);


        Button logbtn = (Button) findViewById(R.id.login);
        Button signbtn = (Button)findViewById(R.id.signup);

        editID = findViewById(R.id.editid);
        editPW = findViewById(R.id.editpw);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editID.getText().toString();
                String pw = editPW.getText().toString();

                insertLogin(editID.getText().toString(), editPW.getText().toString());
                Log.d("로그인 정보", id + pw);

                loginQuery();


                SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //위에서 지정한 shared.xml에 어떤 key 값으로 저장할지 정하고
                editor.putString("ID", id);
                editor.putString("PW", pw);
                //key에 입력할 데이터를 뒤에 적습니다.
                editor.commit();
                //데이터를 저장하거나 삭제할때는 반드시 commit()를 해주셔야 합니다.


                //MainActivity로 화면 전환
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityResult.launch(intent);

            }
        });

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //SignUpActivity로 화면 전환
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityResult.launch(intent);
            }
        });

    }

    private void createDatabase2() {
        Log.d("DB","createDatabase 호출됨.");

        dbHelper2 = new DataBaseHelper(this);
        database2 = dbHelper2.getWritableDatabase();

        Log.d("DB","데이터베이스 생성함 ");
    }


    //로그인 테이블 하나 더 생성
    private void createTable2(String tableName2) {

        if (database2 == null) {
            Log.d("DB","데이터베이스를 먼저 생성하세요.");
            return;
        }

        database2.execSQL("create table if not exists " + tableName2 + "("
                + " _id2 integer PRIMARY KEY autoincrement, "
                + " id text, "
                + " pw text)");

        Log.d("DB","테이블 생성 : " + tableName2);
    }

    private void insertLogin(String userID, String userPW) {
        if (database2 == null) {
            Log.d("DB","데이터베이스를 생성하세요.");
            return;
        }

        database2.execSQL("insert into " + tableName2
                + " (Id, Pw) "
                + " values "
                + "("+ userID
                + ", "+ userPW
                + ")");

    }

    //로그인 정보 조회
    private void loginQuery() {

        Cursor cursor = database2.rawQuery("select _id2, Id, Pw from "+ tableName2, null);
        int recordCount = cursor.getCount(); //레코드 개수

        for (int i = 0; i < recordCount; i++) {
            //for문 사용시, getCount()메소드를 이용해 전체 레코드 개수를 알아내어 moveToNext()메소드 사용

            cursor.moveToNext();    //cursor를 다음으로 이동

            int _id2 = cursor.getInt(0);
            String Id = cursor.getString(1);
            String Pw = cursor.getString(2);

            Log.d("DB","레코드 " + i + " : " + _id2 + ", " + Id + ", " + Pw);

        }

        cursor.close();
    }




    //onActivityResult 예전 메소드는 현재 버전이 지원하지 않음
    //ActivityResultLauncher 메소드 사용해야함
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Bundle bundle = result.getData().getExtras();
                        String email  = (String)bundle.get("email");
                        String password = (String)bundle.get("password");
                        String repeat  = (String)bundle.get("repeat");

                        Log.d("email", email);
                        Log.d("password", password);
                        Log.d("repeat", repeat);
                    }
                }
            });
}