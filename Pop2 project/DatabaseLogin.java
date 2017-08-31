package com.example.admin.classmanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by admin on 4/1/2017.
 */
public class DatabaseLogin extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME="ClassManager.db";
    private static final String TABLE_NAME="LoginInfo";
    private static final String COL2="Password";
    private static final String COL1="Roll_no";
    private static final String COL3="CR";
    public DatabaseLogin(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String BUNKDB_CREATE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
                COL1+" TEXT PRIMARY KEY NOT NULL , "+
                COL2+" TEXT NOT NULL , "+ COL3+" INT NOT NULL "+" );";
        db.execSQL(BUNKDB_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL(" DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(db);
    }
    public void addStudent(String Roll_num,String Password,int cr){
        Boolean crbool;
        if(cr==0)
            crbool=Boolean.FALSE;
        else
            crbool=Boolean.TRUE;
        Student s = new Student(Roll_num,Password,crbool);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COL1,s.getRoll_no());
        val.put(COL2,s.getPassword());
        val.put(COL3,cr);
        db.insertOrThrow(TABLE_NAME,null,val);
        db.close();
    }
    public int verify(String roll,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        String passdb;
        int cr=0;
        String q1= "SELECT * "/*+ COL2 */+" FROM " +TABLE_NAME+" WHERE " +COL1+"="+roll+";";
        try {
            Cursor c = db.rawQuery(q1, null);
            if (c != null && c.moveToFirst()) {
                passdb = c.getString(c.getColumnIndex(COL2));
                cr=c.getInt(c.getColumnIndex(COL3));
                c.close();
                db.close();
            }
            else{
                passdb ="@#$%^";
            }

        }
        catch(android.database.sqlite.SQLiteException e){
            return -1;
        }

        if(pass.equals(passdb)){
            if(cr==1)
                return 1;
            else
                return 0;
        }
        else{
            return -1;
        }
    }
}
