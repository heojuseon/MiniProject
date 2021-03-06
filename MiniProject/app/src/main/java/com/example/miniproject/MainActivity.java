package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.miniproject.main.Tab1_Home;
import com.example.miniproject.main.Tab2_Lesson;
import com.example.miniproject.main.Tab3_Community;
import com.example.miniproject.main.Tab4_Option;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Tab1_Home tab1_home;
    Tab2_Lesson tab2_lesson;
    Tab3_Community tab3_community;
    Tab4_Option tab4_option;

//    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tab1_home = new Tab1_Home();
        tab2_lesson = new Tab2_Lesson();
        tab3_community = new Tab3_Community();
        tab4_option = new Tab4_Option();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, tab1_home).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
//        bottomNavigationView.setOnNavigationItemSelectedListener(); --> deprecated 되었다.
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1home:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.frameLayout, tab1_home).commit();

//                        //DataBaseHelper클래스의 조회쿼리인 insQuery()메소드에 관한 insSelect()메소드를 호출
//                        tab1_home.insSelect();

                        return true;

                    case R.id.tab2lesson:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, tab2_lesson).commit();
                        return true;

                    case R.id.tab3community:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, tab3_community).commit();
                        return true;

                    case R.id.tab4option:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, tab4_option).commit();
                        return true;

                }
                return false;
            }
        });

    }
}