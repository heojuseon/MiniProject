package com.example.miniproject.lesson.Item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.R;
import com.example.miniproject.lesson.Data.InsData;

public class Ins_Item extends RecyclerView.ViewHolder{


    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;

    TextView textView;
    TextView textView2;
    TextView textView3;

    public Ins_Item(View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        imageView2 = itemView.findViewById(R.id.imageView2);
        imageView3 = itemView.findViewById(R.id.imageView3);
        imageView4 = itemView.findViewById(R.id.imageView4);
        imageView5 = itemView.findViewById(R.id.imageView5);

        textView = itemView.findViewById(R.id.name);
        textView2 = itemView.findViewById(R.id.like);
        textView3 = itemView.findViewById(R.id.tag);

    }

    public void setItem(InsData item) {
        imageView.setImageResource(item.getImage());
        imageView2.setImageResource(item.getImage2());
        imageView3.setImageResource(item.getImage3());
        imageView4.setImageResource(item.getImage4());
        imageView5.setImageResource(item.getImage5());

        textView.setText(item.getName());
        textView2.setText(item.getLike());
        textView3.setText(item.getTag());
    }
}

