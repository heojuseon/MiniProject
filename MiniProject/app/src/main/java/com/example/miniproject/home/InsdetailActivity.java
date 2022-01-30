package com.example.miniproject.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniproject.R;
import com.example.miniproject.dbadapter.DbData.DbInsData;

public class InsdetailActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insdetail);

        textView = findViewById(R.id.detail);

        Intent i = getIntent();
        DbInsData item = (DbInsData) i.getSerializableExtra("insData");

        textView.setText(item.getUserimg() + "\n" + item.getName() + "\n" + item.getMainimg() + "\n" + item.getLike() + "\n" + item.getTag());


//        Intent intent = getIntent();
//
//        String userimg = intent.getExtras().getString("InsUserimg");
//        String name = intent.getExtras().getString("InsName");
//        String mainimg = intent.getExtras().getString("InsMainimg");
//        String like = intent.getExtras().getString("InsLike");
//        String tag = intent.getExtras().getString("InsTag");
//
//        textView.setText(userimg + "\n" + name + "\n" + mainimg + "\n" + like + "\n" + tag);

    }
}