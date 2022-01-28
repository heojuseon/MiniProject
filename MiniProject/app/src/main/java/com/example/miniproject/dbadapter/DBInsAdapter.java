package com.example.miniproject.dbadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.R;
import com.example.miniproject.dbadapter.DbData.DbInsData;
import com.example.miniproject.dbadapter.DbItem.DbIns_Item;
import com.example.miniproject.home.OnInsItemClickListener;
import com.example.miniproject.lesson.Data.InsData;
import com.example.miniproject.lesson.Item.Ins_Item;

import java.util.ArrayList;


public class DBInsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnInsItemClickListener{

    ArrayList<DbInsData> dbItems = new ArrayList<>();

    OnInsItemClickListener listener;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.dbins_item, parent, false);

        return new DbIns_Item(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        DbInsData dbInsData = dbItems.get(position);
        DbInsData dbins = (DbInsData) dbInsData;
        DbIns_Item dbinsItem = (DbIns_Item) holder;
        dbinsItem.setItem(dbins);

    }

    @Override
    public int getItemCount() {
        return dbItems.size();
    }

    //연결한 어뎁터를 DbInsData클래스에 담겨있는 정보들을 불러와 화면 연결 위해 setItems라는 메소드 생성
    public void setItems(ArrayList<DbInsData> items){
        this.dbItems = items;
    }


    //Tab1 에서 OnItemClickListener메소드 사용할때 DbInsData의 값을 가져오기 위함
    public DbInsData getItem(int position) {
        return dbItems.get(position);
    }


    //외부에서(Tab1번 클래스) 리스너를 설정할 수 있도록 메소드 추가 ( setOnItemClickListener )
    //Tab1번 클래스에서 OnItemClickListener메소드 사용하기 위해 생성
    public void setOnItemClickListener(OnInsItemClickListener listener){

        this.listener = listener;
    }


    @Override
    public void onInsItemClickListener(RecyclerView.ViewHolder holder, View view, int position) {
        //onItemClick 메소드가 호출되었을 때 다시 외부에서 설정된 메소드가 호출
        if (listener != null){
            listener.onInsItemClickListener(holder, view, position);
        }
    }
}
