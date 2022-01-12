package com.example.miniproject.lesson.Item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.R;
import com.example.miniproject.lesson.Data.CfData;

public class Cf_Item extends RecyclerView.ViewHolder{
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    public Cf_Item(View itemView2){
        super(itemView2);
        imageView = itemView2.findViewById(R.id.cf_imageView);
        imageView2 = itemView2.findViewById(R.id.cf_imageView2);
        imageView3 = itemView2.findViewById(R.id.cf_imageView3);
        imageView4 = itemView2.findViewById(R.id.cf_imageView4);

        textView = itemView2.findViewById(R.id.cf_name);
        textView2 = itemView2.findViewById(R.id.brand_name);
        textView3 = itemView2.findViewById(R.id.brand_color);
        textView4 = itemView2.findViewById(R.id.brand_price);
    }

    public void setItem(CfData item) {
        imageView.setImageResource(item.getImage());
        imageView2.setImageResource(item.getImage2());
        imageView3.setImageResource(item.getImage3());
        imageView4.setImageResource(item.getImage4());

        textView.setText(item.getName());
        textView2.setText(item.getBrand_name());
        textView3.setText(item.getBrand_color());
        textView4.setText(item.getBrand_price());

    }
}
