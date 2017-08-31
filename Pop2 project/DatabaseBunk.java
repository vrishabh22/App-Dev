package com.example.admin.classmanager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseBunk extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME="ClassManager.db";
    private static final String TABLE_NAME="Number_of_Bunks";
    private static final String COL1="sub";
    private static final String COL2="num";
    String s;

    public DatabaseBunk(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
         String BUNKDB_CREATE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
                COL1+" INT PRIMARY KEY AUTOINCREMENT NOT NULL , "+
                COL2+" INT "+");";
        db.execSQL(BUNKDB_CREATE);
        s="end";
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXIST"+TABLE_NAME);
        onCreate(db);
    }
    public void addSub(Bunk sub){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COL1,sub.get_id());
        val.put(COL2,sub.getBunk());
        try{
            db.insertOrThrow(TABLE_NAME,null,val);
        }
        catch(android.database.sqlite.SQLiteException e){
            String BUNKDB_CREATE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
                    COL1+" INT PRIMARY KEY AUTOINCREMENT NOT NULL , "+
                    COL2+" INT "+");";
            db.execSQL(BUNKDB_CREATE);
            db.insertOrThrow(TABLE_NAME,null,val);
        }
        db.close();
    }
    public void IncBunk(int sub){
        SQLiteDatabase db = this.getWritableDatabase();
        String q1= "SELECT "+ COL2 +" FROM " +TABLE_NAME+" WHERE " +COL1+"="+sub+";";
        Cursor c = db.rawQuery(q1,null);
        int bunk = 0;
        if (c != null && c.moveToFirst()) {
            bunk = c.getInt(c.getColumnIndex(COL2));
            c.close();
        }
            bunk++;
        String Update="UPDATE "+TABLE_NAME+" SET "+COL2 +" = "+ bunk+ " WHERE "+COL1+" ="+sub;
        db.execSQL(Update);
        db.close();
    }
    public void DecBunk(int sub){
        SQLiteDatabase db = this.getWritableDatabase();
        String q1= "SELECT "+ COL2 +" FROM " +TABLE_NAME+" WHERE " +COL1+"="+sub+";";
        Cursor c = db.rawQuery(q1,null);
        int bunk= 0;
        if (c != null && c.moveToFirst()) {
            bunk = c.getInt(c.getColumnIndex(COL2));
            c.close();
        }
        if(bunk>0)
            bunk--;
        String Update="UPDATE "+TABLE_NAME+" SET "+COL2+" = "+ bunk+ " WHERE "+COL1 +" = "+sub;
        db.execSQL(Update);
        db.close();
    }

    public String toString(int x){
        String dbString;
        SQLiteDatabase db = getWritableDatabase();
        try {
            String query = "SELECT " + COL2 + " FROM " + TABLE_NAME + " WHERE " + COL1 + "=" + x + ";";
            Cursor c = db.rawQuery(query, null);
            if (c != null && c.moveToFirst()) {
                dbString = c.getString(c.getColumnIndex(COL2));
                c.close();
            }
            else
                dbString="else ...";
        }
        catch(android.database.sqlite.SQLiteException e){
            String BUNKDB_CREATE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
                    COL1+" INT PRIMARY KEY NOT NULL , "+
                    COL2+" INT "+");";
            db.execSQL(BUNKDB_CREATE);
            dbString="0";
            Bunk sub1=new Bunk(1);
            Bunk sub2=new Bunk(2);
            Bunk sub3=new Bunk(3);
            Bunk sub4=new Bunk(4);
            Bunk sub5=new Bunk(5);
            Bunk sub6=new Bunk(6);
            addSub(sub1);
            addSub(sub2);
            addSub(sub3);
            addSub(sub4);
            addSub(sub5);
            addSub(sub6);
        }
        db.close();
        return dbString;
    }
}





