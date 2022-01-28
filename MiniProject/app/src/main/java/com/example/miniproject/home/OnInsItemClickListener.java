package com.example.miniproject.home;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.dbadapter.DBInsAdapter;

public interface OnInsItemClickListener {

    public void onInsItemClickListener(RecyclerView.ViewHolder holder, View view, int position);

}
