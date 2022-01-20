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

    DataBaseHelper dbHelper2;
    SQLiteDatabase database;

    EditText editID;
    EditText editPW;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button logbtn = (Button) findViewById(R.id.login);
        Button signbtn = (Button)findViewById(R.id.signup);

        editID = findViewById(R.id.editid);
        editPW = findViewById(R.id.editpw);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editID.getText().toString();
                String pw = editPW.getText().toString();



                SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //위에서 지정한 shared.xml에 어떤 key 값으로 저장할지 정하고
                editor.putString("ID", id);
                editor.putString("PW", pw);
                //key에 입력할 데이터를 뒤에 적습니다.
                editor.commit();
                //데이터를 저장하거나 삭제할때는 반드시 commit()를 해주셔야 합니다.


                //INSERT Database
                dbHelper2.insertLogin(editID.getText().toString(), editPW.getText().toString());


//                database = dbHelper2.getWritableDatabase();
//                database.execSQL("INSERT INTO loginTBL(nameid, password) VALUES('" + editID.getText().toString() + "','" + editPW.getText().toString() + "');");
//                database.close();


                //SELECT Database
                dbHelper2.loginQuery();


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