package com.example.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button logbtn = (Button) findViewById(R.id.login);
        Button signbtn = (Button)findViewById(R.id.signup);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //MainActivity로 화면 전환
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