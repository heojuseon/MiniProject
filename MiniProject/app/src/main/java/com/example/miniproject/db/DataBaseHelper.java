package com.example.miniproject.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import com.example.miniproject.R;
import com.example.miniproject.main.Tab3_Community;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static String dbName = "groupTBL.db";

    public static int VERSION = 1;


    public DataBaseHelper(Context context) {
        //DataBaseHelper 생성자
        super(context, dbName, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //데이터베이스가 생성될 때 호출

        //테이블 생성
        //테이블 이름 : groupTBL
        db.execSQL("CREATE TABLE IF NOT EXISTS groupTBL (id integer PRIMARY KEY AUTOINCREMENT, name TEXT, health TEXT, count integer)");

        //테이블 하나 더 생성(로그인 정보 테이블)
        db.execSQL("CREATE TABLE IF NOT EXISTS loginTBL (id2 integer PRIMARY KEY AUTOINCREMENT, idname TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //테이블 업그레이드

        //int oldVersion : 이전 데이터베이스 버전
        //int newVersion : 새 데이터베이스 버전
        if (newVersion > 1) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
        }

        //로그인 테이블(버전 2이상 기존테이블 loginTBL 삭제)
        if (newVersion > 1){
            db.execSQL("DROP TABLE IF EXISTS loginTBL");
        }
    }

    //ISERT문
    public void insertRecord(String userName, String userHealth, int userCount){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("INSERT INTO groupTBL(name, health, count) VALUES('" + userName + "','" + userHealth + "','" + userCount + "');");

        Log.d("추가", userName + "\t" + userHealth + "\t" + userCount);
    }

    //INSERT문(회원가입 정보)
    public void insertLogin(String UserID, String UserPD){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("INSERT INTO loginTBL(nameid, password) VALUES('" + UserID + "','" + UserPD + "');");

        Log.d("회원가입 정보 추가", UserID + "\n" + UserPD);
    }


    //UPDAT문
    public void updateRecord(String userName, String userHealth, int userCount){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("UPDATE groupTBL SET name='" + userName + "', health='" + userHealth + "', count='" + userCount + "' WHERE name='" + userName + "'");

        Log.d("수정", userName + "\t"+ userHealth + "\t" + userCount);
    }

    //DELETE문
    public void deleteRecord(String userName){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("DELETE FROM groupTBL WHERE name = '" + userName + "'");

        Log.d("삭제", userName);

    }

    //SELECT문
    public void executeQuery(){

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM groupTBL", null);  //SELECT * FROM : 모든 컬럼 가지고 온다

        int recordCount = cursor.getCount(); //레코드 개수

        for (int i = 0; i < recordCount; i++) {
            //for문 사용시, getCount()메소드를 이용해 전체 레코드 개수를 알아내어 moveToNext()메소드 사용

            cursor.moveToNext();    //cursor를 다음으로 이동

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String health = cursor.getString(2);
            int count = cursor.getInt(3);


            Log.d("DB","레코드 " + i + " : " + id + ", " + name + ", " + health + ", " + count);
        }

        cursor.close();
    }

    //SELECT문(로그인 정보)
    public  void loginQuery(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor2 = database.rawQuery("SELECT * FROM loginTBL", null);

        int recordCount2 = cursor2.getCount();

        for (int i = 0; i < recordCount2; i++){
            cursor2.moveToNext();

            int id2 = cursor2.getInt(0);
            String nameid = cursor2.getString(1);
            String password = cursor2.getString(2);

            Log.d("DB2","레코드 " + i + " : " + id2 + ", " + nameid + ", " + password);
        }
    }
}
