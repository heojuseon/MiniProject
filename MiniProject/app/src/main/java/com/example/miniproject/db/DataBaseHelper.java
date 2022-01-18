package com.example.miniproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static String dbName = "groupTBL.db";
    public static int VERSION = 1;

//    String tableName2 = "loginTBL";

    public DataBaseHelper(Context context) {
        //DataBaseHelper 생성자
        super(context, dbName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        //로그인 테이블 하나 더 생성
//        String sqllgn = "create table if not exists " + tableName2 + "("
//                + " _id integer PRIMARY KEY autoincrement, "
//                + " id text, "
//                + " pw text);";
//
//        db.execSQL(sqllgn);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //테이블 업그레이드

        //int oldVersion : 이전 데이터베이스 버전
        //int newVersion : 새 데이터베이스 버전


        if (newVersion > 1) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
        }
    }

}
