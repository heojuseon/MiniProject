package com.example.miniproject.main;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.miniproject.LoginActivity;
import com.example.miniproject.MainActivity;
import com.example.miniproject.R;
import com.example.miniproject.SignUpActivity;

public class Tab1_Home extends Fragment {

    TextView textView;
    Button backbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Fragment는 유저 인터페이스를 정의한 자신만의 뷰객체를 가지고 있지만 화면에 보여주기 위해서는 액티비티가 필요하기 때문에
        // Fragment를 Activity의 ViewGroup에 추가해주어야 합니다.

        //ex)ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tab_home, container, false);
        //        return rootView;
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab1__home, container, false);

        textView = rootView.findViewById(R.id.information);


        //버튼을 생성하여 다시 LoginActivity로 돌아가는 Intent 생성
        backbtn = rootView.findViewById(R.id.back);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fragment에서 activity 전환할때는 getActivity()사용
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                //fragment에서 activity 전환할때는 startActivity()사용
                startActivity(intent);
            }
        });


        //fragment에서 sharedPreferences 사용하려면 this.getActivity().getSharedPreferences 사용해야함
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared", MODE_PRIVATE);
        String IDvalue = sharedPreferences.getString("ID","");
        String PWvalue = sharedPreferences.getString("PW","");
        //.getString("호출할이름", "Default값");

        textView.setText(IDvalue + "\n" + PWvalue);

        return rootView;

    }

}