package com.example.miniproject.dbadapter.DbItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.R;
import com.example.miniproject.dbadapter.DBInsAdapter;
import com.example.miniproject.dbadapter.DbData.DbInsData;

public class DbIns_Item extends RecyclerView.ViewHolder{

    TextView dbimg;
    TextView dbimg2;

    TextView dbnm;
    TextView dblk;
    TextView dbtg;


    public DbIns_Item(View itemView, final DBInsAdapter listener) {
        super(itemView);

        dbimg = itemView.findViewById(R.id.dbimage);
        dbimg2 = itemView.findViewById(R.id.dbimage2);
        dbnm = itemView.findViewById(R.id.dbname);
        dblk = itemView.findViewById(R.id.dblike);
        dbtg = itemView.findViewById(R.id.dbtag);


        //아이템뷰에 OnClickListener 설정하기
        //아이템 뷰 클릭 시 미리 정의한 다른 리스너의 메소드 호출
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (listener != null){
                    listener.onInsItemClickListener(DbIns_Item.this, view, position);
                }
            }
        });

    }

    public void setItem(DbInsData item){

        dbimg.setText(item.getUserimg());
        dbimg2.setText(item.getMainimg());
        dbnm.setText(item.getName());
        dblk.setText(item.getLike());
        dbtg.setText(item.getTag());
    }
}
