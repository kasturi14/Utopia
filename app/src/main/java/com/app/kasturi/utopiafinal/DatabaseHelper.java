package com.app.kasturi.utopiafinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "data.db";
    public static final String TABLE_NAME = "store_data";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PHONE";
    public static final String COL_6 = "USERNAME";
    public static final String COL_7 = "PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,EMAIL TEXT,PHONE INTEGER,USERNAME TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String surname,String email,String phone,String username,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,phone);
        contentValues.put(COL_6,username);
        contentValues.put(COL_7,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public String searchPass(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select username,password from " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        String u, p;
        p = "not found";
        if (cursor.moveToFirst()) {
            do {
                u = cursor.getString(cursor.getColumnIndex("USERNAME"));
                if (u.equals(username)) {
                    p = cursor.getString(cursor.getColumnIndex("PASSWORD"));
                    break;
                }
            } while (cursor.moveToNext());
        }
        return p;
    }

    public boolean updateData(String id,String name,String surname,String email,String phone,String username,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,phone);
        contentValues.put(COL_6,username);
        contentValues.put(COL_7,password);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }
}