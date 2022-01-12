package com.example.miniproject.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miniproject.R;
import com.example.miniproject.lesson.Data.CfData;
import com.example.miniproject.lesson.Data.InsData;
import com.example.miniproject.lesson.InstagramAdapter;


public class Tab2_Lesson extends Fragment {
    //여기에 내가 만든 Rrecyclerview_instargram 메인엑티비티 추가

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab2__lesson, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        //레이아웃 매니저는 리싸이클러뷰가 보일 기본적인 형태를 설정할 때 사용한다.
        //LinearLayoutManager : 세로방향(Vertical), 가로방향(Horizontal)
        //GridLayoutManager : 격자모양
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());//현재 실행되고 있는 View의 context를 return 하는데 보통은 현재 활성화된 activity의 context가 된다.
        recyclerView.setLayoutManager(layoutManager);

        InstagramAdapter adapter = new InstagramAdapter();

        adapter.addItem(new InsData(R.mipmap.ic_launcher, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, 0, "허주선", "200개", "#팔로우 #맞팔 #선팔"));

        adapter.addItem2(new CfData(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, 1, "인스타", "나이키", "색상", "100원"));

        adapter.addItem(new InsData(R.mipmap.ic_launcher, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, 0, "믓쨍이", "171개", "팔로우 #맞팔 #선팔"));

        adapter.addItem(new InsData(R.mipmap.ic_launcher, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, 0, "여행", "20K", "팔로우 #맞팔 #선팔"));

        adapter.addItem(new InsData(R.mipmap.ic_launcher, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, 0, "운동", "48개", "팔로우 #맞팔 #선팔 #헬린"));

        adapter.addItem(new InsData(R.mipmap.ic_launcher, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, 0, "음식", "67개", "팔로우 #맞팔 #선팔 #맛집"));



        //recyclerview 화면 연결
        recyclerView.setAdapter(adapter);


        return rootView;
    }
}