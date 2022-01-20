package com.example.miniproject.main;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniproject.R;
import com.example.miniproject.db.DataBaseHelper;
import com.example.miniproject.lesson.Data.InsData;


public class Tab3_Community extends Fragment {
    DataBaseHelper dbHelper;
//    SQLiteDatabase database;

    EditText editname;
    EditText edithealth;
    EditText editcount;

    Button btnin;
    Button btnse;
    Button btnde;
    Button btnup;

    TextView textView;

//
//    String tableName = "groupTBL";
//
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab3__community, container, false);

        editname = rootView.findViewById(R.id.editName);
        edithealth = rootView.findViewById(R.id.editHealth);
        editcount = rootView.findViewById(R.id.editCount);

        textView = rootView.findViewById(R.id.result);

        dbHelper = new DataBaseHelper(this.getContext());   //Fragment에서 만들어서 this가 아니라 this.getContext()사용


        //INSERT Database
        btnin = rootView.findViewById(R.id.insert);
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertRecord(editname.getText().toString()
                        ,edithealth.getText().toString()
                        ,Integer.parseInt(editcount.getText().toString()));

            }
        });

        //UPDATE Database
        btnup = rootView.findViewById(R.id.update);
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateRecord(editname.getText().toString()
                        ,edithealth.getText().toString()
                        ,Integer.parseInt(editcount.getText().toString()));

            }
        });

        //DELETE Database
        btnde = rootView.findViewById(R.id.delete);
        btnde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteRecord(editname.getText().toString());

//                deleteRecord(editname.getText().toString()
//                        ,edithealth.getText().toString()
//                        ,Integer.parseInt(editcount.getText().toString()));
            }
        });

        //SELECT Database
        btnse = rootView.findViewById(R.id.query);
        btnse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.executeQuery();
            }
        });

        return rootView;
    }


}