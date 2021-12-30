package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPassword;
    EditText editRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        editEmail = findViewById(R.id.editemail);
        editPassword = findViewById(R.id.editpassword);
        editRepeat = findViewById(R.id.editrepeat);


        Button canclebtn = (Button)findViewById(R.id.signcancel);
        Button signokbtn = (Button)findViewById(R.id.signok);


        canclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                String repeat = editRepeat.getText().toString();


                Intent intent = getIntent();

                intent.putExtra("email", email);
                intent.putExtra("password", password);
                intent.putExtra("repeat", repeat);

                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}