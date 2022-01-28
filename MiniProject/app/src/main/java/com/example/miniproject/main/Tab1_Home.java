package com.example.miniproject.main;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniproject.LoginActivity;
import com.example.miniproject.MainActivity;
import com.example.miniproject.R;
import com.example.miniproject.SignUpActivity;
import com.example.miniproject.db.DataBaseHelper;
import com.example.miniproject.dbadapter.DBInsAdapter;
import com.example.miniproject.dbadapter.DbData.DbInsData;
import com.example.miniproject.home.OnInsItemClickListener;

import java.util.ArrayList;

public class Tab1_Home extends Fragment {

    TextView textView;
    Button backbtn;

    DataBaseHelper dbHelper;

    RecyclerView recyclerView;
    DBInsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Fragment는 유저 인터페이스를 정의한 자신만의 뷰객체를 가지고 있지만 화면에 보여주기 위해서는 액티비티가 필요하기 때문에
        // Fragment를 Activity의 ViewGroup에 추가해주어야 합니다.

        //ex)ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tab_home, container, false);
        //        return rootView;
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab1__home, container, false);

        textView = rootView.findViewById(R.id.information);

        //헬퍼객체 생성
        dbHelper = new DataBaseHelper(this.getContext());


        //insQuery()메소드 호출하기위한 객체 생성(ArrayList 형태로 메소드를 만들었기 때문에)
        ArrayList<DbInsData> result = dbHelper.insQuery();

        recyclerView = rootView.findViewById(R.id.dbinsrecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //어뎁터 객체 생성
        adapter = new DBInsAdapter();
        recyclerView.setAdapter(adapter);

        //setItems메소드를 어뎁터랑 연결
        adapter.setItems(result);

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


        //onItemClickListener사용 메소드
        adapter.setOnItemClickListener(new OnInsItemClickListener() {
            @Override
            public void onInsItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
                DbInsData item = adapter.getItem(position);
                Toast.makeText(holder.itemView.getContext(), "name : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });




        //fragment에서 sharedPreferences 사용하려면 this.getActivity().getSharedPreferences 사용해야함
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared", MODE_PRIVATE);
        String IDvalue = sharedPreferences.getString("ID", "");
        String PWvalue = sharedPreferences.getString("PW","");
        //.getString("호출할이름", "Default값");

        textView.setText(IDvalue + "\n" + PWvalue);

        return rootView;

    }


//    public  void insSelect(){
//        Cursor cursor4 = dbHelper.insQuery();
//
//        int recordCount3 = cursor4.getCount();
//
//        for (int i = 0; i < recordCount3; i++){
//            cursor4.moveToNext();
//
//            int id = cursor4.getInt(0);
//            String userimg = cursor4.getString(1);
//            String name = cursor4.getString(2);
//            String mainimg = cursor4.getString(3);
//            String inslike = cursor4.getString(4);
//            String tag = cursor4.getString(5);
//
//            Log.d("insDB","레코드 " + i + " : " + id + ", " + userimg + ", " + name + ", " + mainimg + ", " + inslike + ", " + tag);
//        }
//
//        cursor4.close();
//    }

}