package com.example.miniproject.dbadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.R;
import com.example.miniproject.dbadapter.DbData.DbInsData;
import com.example.miniproject.dbadapter.DbItem.DbIns_Item;
import com.example.miniproject.lesson.Data.InsData;
import com.example.miniproject.lesson.Item.Ins_Item;

import java.util.ArrayList;


public class DBInsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ArrayList<DbInsData> dbItems = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.dbins_item, parent, false);

        return new DbIns_Item(itemView);
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

    public void setItems(ArrayList<DbInsData> items){
        this.dbItems = items;
    }

}
