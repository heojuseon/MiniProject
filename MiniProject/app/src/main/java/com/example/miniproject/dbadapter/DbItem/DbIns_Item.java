package com.example.miniproject.dbadapter.DbItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.R;
import com.example.miniproject.dbadapter.DbData.DbInsData;

public class DbIns_Item extends RecyclerView.ViewHolder{

    TextView dbimg;
    TextView dbimg2;

    TextView dbnm;
    TextView dblk;
    TextView dbtg;


    public DbIns_Item(View itemView) {
        super(itemView);

        dbimg = itemView.findViewById(R.id.dbimage);
        dbimg2 = itemView.findViewById(R.id.dbimage2);
        dbnm = itemView.findViewById(R.id.dbname);
        dblk = itemView.findViewById(R.id.dblike);
        dbtg = itemView.findViewById(R.id.dbtag);
    }

    public void setItem(DbInsData item){

        dbimg.setText(item.getUserimg());
        dbimg2.setText(item.getMainimg());
        dbnm.setText(item.getName());
        dblk.setText(item.getLike());
        dbtg.setText(item.getTag());
    }
}
