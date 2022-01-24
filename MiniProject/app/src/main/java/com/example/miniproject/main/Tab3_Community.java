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

    EditText edituserimg, editinsname, editmainimg, editlike, edittag;

    Button btnin;
    Button btnse;
    Button btnde;
    Button btnup;

    Button btninsin, btninssele;

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab3__community, container, false);

        editname = rootView.findViewById(R.id.editName);
        edithealth = rootView.findViewById(R.id.editHealth);
        editcount = rootView.findViewById(R.id.editCount);

        edituserimg = rootView.findViewById(R.id.insuserimage);
        editinsname = rootView.findViewById(R.id.insname);
        editmainimg = rootView.findViewById(R.id.insmainimage);
        editlike = rootView.findViewById(R.id.inslike);
        edittag = rootView.findViewById(R.id.instag);

        textView = rootView.findViewById(R.id.result);

        //헬퍼객체 생성
        dbHelper = new DataBaseHelper(this.getContext());   //Fragment에서 만들어서 this가 아니라 this.getContext()사용


        //인스타 INSERT Database
        btninsin = rootView.findViewById(R.id.insinsert);
        btninsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertIns(edituserimg.getText().toString()
                        , editinsname.getText().toString()
                        , editmainimg.getText().toString()
                        , editlike.getText().toString()
                        , edittag.getText().toString());
            }
        });

        //인스타 SELECT Database
        btninssele = rootView.findViewById(R.id.insselect);
        btninssele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insQuery();
            }
        });


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
               Cursor cursor =  dbHelper.userSelect();

                int recordCount = cursor.getCount(); //레코드 개수

                for (int i = 0; i < recordCount; i++) {
                    //for문 사용시, getCount()메소드를 이용해 전체 레코드 개수를 알아내어 moveToNext()메소드 사용

                    cursor.moveToNext();    //cursor를 다음으로 이동

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String health = cursor.getString(2);
                    int count = cursor.getInt(3);

                    textView.append(name + "\n" +health + "\n" + count);

                    Log.d("DB","레코드 " + i + " : " + id + ", " + name + ", " + health + ", " + count);

                }
                cursor.close();
            }
        });

        return rootView;
    }


}