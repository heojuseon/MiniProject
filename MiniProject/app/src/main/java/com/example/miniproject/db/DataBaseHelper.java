package com.example.miniproject.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import com.example.miniproject.R;
import com.example.miniproject.dbadapter.DbData.DbInsData;
import com.example.miniproject.main.Tab3_Community;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static String dbName = "test2.db";

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
        db.execSQL("CREATE TABLE IF NOT EXISTS loginTBL (id2 integer PRIMARY KEY AUTOINCREMENT, nameid TEXT, password TEXT)");

        //회원가입 테이블 생성
        db.execSQL("CREATE TABLE IF NOT EXISTS signupTBL (id3 integer PRIMARY KEY AUTOINCREMENT, newid TEXT, newpassword TEXT, repassword TEXT)");

        //인스타 테이블 생성
        db.execSQL("CREATE TABLE IF NOT EXISTS insTBL (id integer PRIMARY KEY AUTOINCREMENT, userimg TEXT, name TEXT, mainimg TEXT, inslike TEXT, tag TEXT)");
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

        //회원가입 테이블(버전 2이상 기존테이블 loginTBL 삭제)
        if (newVersion > 1){
            db.execSQL("DROP TABLE IF EXISTS signupTBL");
        }

        //인스타 테이블(버전 2이상 기존테이블 loginTBL 삭제)
        if (newVersion > 1){
            db.execSQL("DROP TABLE IF EXISTS insTBL");
        }
    }

    //ISERT문
    public void insertRecord(String userName, String userHealth, int userCount){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("INSERT INTO groupTBL(name, health, count) VALUES('" + userName + "','" + userHealth + "','" + userCount + "');");

        Log.d("추가", userName + "\t" + userHealth + "\t" + userCount);
    }

    //INSERT문(로그인 정보)
    public void insertLogin(String userID, String userPD){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("INSERT INTO loginTBL(nameid, password) VALUES('" + userID + "','" + userPD + "');");

        Log.d("로그인 정보 추가", "\n" + userID + "\n" + userPD);
    }

    //INSERT문(회원가입 정보)
    public void insertSignup(String newuserID, String newuserPD, String reuserPD){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("INSERT INTO signupTBL(newid, newpassword, repassword) VALUES('" + newuserID + "','" + newuserPD + "','" + reuserPD + "');");

        Log.d("회원가입 정보 추가", "\n" + newuserID + "\n" + newuserPD + "\n" + reuserPD);
    }

    //INSERT문(인스타 정보)
    public  void insertIns(String userImage, String userName, String mainImage, String userLike, String usertag){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("INSERT INTO insTBL(userimg, name, mainimg, inslike, tag) VALUES('" + userImage + "','" + userName + "','" + mainImage + "','" + userLike + "','" + usertag + "');");

        Log.d("인스타 정보 추가", "\n" + userImage + "\n" + userName + "\n" + mainImage + "\n" + userLike + "\n" + usertag);
    }






    //UPDATE문
    public void updateRecord(String userName, String userHealth, int userCount){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("UPDATE groupTBL SET name='" + userName + "', health='" + userHealth + "', count='" + userCount + "' WHERE name='" + userName + "'");

        Log.d("수정", userName + "\t"+ userHealth + "\t" + userCount);
    }
    //UPDATE문(인스타 정보)
    public void updateIns(String userImage, String userName, String mainImage, String userLike, String usertag){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("UPDATE insTBL SET userimg='" + userImage + "', name='" + userName + "', mainimg='" + mainImage + "', inslike='" + userLike + "', tag='" + usertag + "' WHERE name='" + userName + "'");

        Log.d("인스타 정보 수정", userImage + "\t"+ userName + "\t" + mainImage +  "\t" + userLike + "\t" + usertag);
    }





    //DELETE문
    public void deleteRecord(String userName){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("DELETE FROM groupTBL WHERE name = '" + userName + "'");

        Log.d("삭제", userName);

    }
    //DELETE문(인스타 정보)
    public void deleteIns(String userImage){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("DELETE FROM insTBL WHERE userimg = '" + userImage + "'");

        Log.d("인스타 정보 삭제", userImage);
    }







    //SELECT문
    public Cursor userSelect(){
        //Tab3 화면 textview로 출력하기위해서 cursor retrun

        SQLiteDatabase database = getReadableDatabase();

        //Cursor 객체 생성
        Cursor cursor = database.rawQuery("SELECT * FROM groupTBL", null);  //SELECT * FROM : 모든 컬럼 가지고 온다

        return cursor;

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

            Log.d("loginDB","레코드 " + i + " : " + id2 + ", " + nameid + ", " + password);

        }
        cursor2.close();
    }

    //SELECT문(회원가입 정보)
    public  void signupQuery(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor3 = database.rawQuery("SELECT * FROM signupTBL", null);

        int recordCount3 = cursor3.getCount();

        for (int i = 0; i < recordCount3; i++){
            cursor3.moveToNext();

            int id3 = cursor3.getInt(0);
            String newid = cursor3.getString(1);
            String newpassword = cursor3.getString(2);
            String repassword = cursor3.getString(3);

            Log.d("signupDB","레코드 " + i + " : " + id3 + ", " + newid + ", " + newpassword + ", " + repassword);
        }
        cursor3.close();
    }

    //SELECT문(인스타 정보)
    //DbInsData클래스를 ArrayList객체에 담아서 메소드 생성
    public ArrayList<DbInsData> insQuery(){
        ArrayList<DbInsData> result = new ArrayList<DbInsData>();

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor4 = database.rawQuery("SELECT * FROM insTBL", null);

        int recordCount3 = cursor4.getCount();

        for (int i = 0; i < recordCount3; i++){
            cursor4.moveToNext();

            int id = cursor4.getInt(0);
            String userimg = cursor4.getString(1);
            String name = cursor4.getString(2);
            String mainimg = cursor4.getString(3);
            String inslike = cursor4.getString(4);
            String tag = cursor4.getString(5);

            Log.d("insDB","레코드 " + i + " : " + id + ", " + userimg + ", " + name + ", " + mainimg + ", " + inslike + ", " + tag);

            //DbInsData 클래스의 정보들을 불러오는 객체 생성하여 return으로 result값 반환
            DbInsData info = new DbInsData(userimg, name, mainimg, inslike, tag);
            result.add(info);
        }

        cursor4.close();

        return result;
    }

//    //SELECT문(인스타 정보)
//    public  Cursor insQuery(){
//        SQLiteDatabase database = getReadableDatabase();
//        Cursor cursor4 = database.rawQuery("SELECT * FROM insTBL", null);
//
////        int recordCount3 = cursor4.getCount();
////
////        for (int i = 0; i < recordCount3; i++){
////            cursor4.moveToNext();
////
////            int id = cursor4.getInt(0);
////            String userimg = cursor4.getString(1);
////            String name = cursor4.getString(2);
////            String mainimg = cursor4.getString(3);
////            String inslike = cursor4.getString(4);
////            String tag = cursor4.getString(5);
////
////            Log.d("insDB","레코드 " + i + " : " + id + ", " + userimg + ", " + name + ", " + mainimg + ", " + inslike + ", " + tag);
////        }
////        cursor4.close();
//        return cursor4;
//    }
}
