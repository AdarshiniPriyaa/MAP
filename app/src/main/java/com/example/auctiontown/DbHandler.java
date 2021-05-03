package com.example.auctiontown;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DbHandler extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "user_database";


    public DbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table if not exists reg (name text, email text primary key,"
                + " password text)";
        db.execSQL(qry);


        String q1 = "create table if not exists seller (name text, username text primary key, email text, pass text)";
        db.execSQL(q1);

        String q2 = "create table if not exists details (name text ,  amount integer)";
        db.execSQL(q2);

        String q3= "create table if not exists product (name text, category text, seller text, price integer)";
        db.execSQL(q3);

        String q4="create table if not exists det (description text, time integer, pricing integer)";
        db.execSQL(q4);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertDet(String u, int u1, int u2){
        ContentValues cv = new ContentValues();
        cv.put("description", u);
        cv.put("time", u1);
        cv.put("pricing", u2);
        SQLiteDatabase db= getWritableDatabase();
        db.insert("det", null, cv);
        db.close();
    }
    public void insertPro(String r, String r1, String r2, int r3){
        ContentValues b= new ContentValues();
        b.put("name", r);
        b.put("category", r1);
        b.put("seller", r2);
        b.put("price", r3);
        SQLiteDatabase db= getWritableDatabase();
        db.insert("product", null, b);
        db.close();
    }

    public void inserting(String a, String a1, String a2, String a3){
        ContentValues cv1 = new ContentValues();
        cv1.put("name", a);
        cv1.put("username", a1);
        cv1.put("email", a2);
        cv1.put("pass", a3);
        SQLiteDatabase db= getWritableDatabase();
        db.insert("seller", null, cv1);
        db.close();
    }

    public String selectRows(){
        String rows=" ";
        String qry="select * from reg";
        SQLiteDatabase db= getWritableDatabase();
        Cursor c= db.rawQuery(qry, null);
        while (c.moveToNext()){
            rows+="NAME:" +c.getString(0)+"\n ";
            rows+="EMAIL:" + c.getString(1);
            rows+="\n";
        }
        c.close();
        db.close();
        return rows;
    }
    public  void insertValues(String s, String s1, String s2){
        ContentValues cv = new ContentValues();
        cv.put("name", s);
        cv.put("email", s1);
        cv.put("password", s2);
        SQLiteDatabase db= getWritableDatabase();
        db.insert("reg", null, cv);
        db.close();
    }

    public void insertDetails(String k1, int k2) {
        ContentValues v = new ContentValues();
        v.put("name", k1);
        v.put("amount", k2);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("details", null, v);
        db.close();
    }

    public String selectRows1() {
        String rows = " ";
        String q2 = "select * from details";
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(q2, null);
        while (c.moveToNext()) {
            rows += "NAME:" + c.getString(0) + "\n";
            rows += "AMOUNT:" + c.getInt(1);
            rows += "\n";
        }
        c.close();
        db.close();
        return rows;

    }

    public boolean user(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor C= db.rawQuery("select * from seller where username=?", new String[]{username});
        if(C.getCount()>0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkdata(String username, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from seller where username=? and pass=?", new String[]{username, pass});
        if (c.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }

    }
    public boolean email(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor C= db.rawQuery("select * from reg where email=?", new String[]{email});
        if(C.getCount()>0){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkAll(String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("select * from reg where email=? and password=?", new String[]{email, password});
        if (c.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }

    }
}