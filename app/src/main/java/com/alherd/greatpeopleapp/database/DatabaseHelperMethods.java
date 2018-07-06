package com.alherd.greatpeopleapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bykov on 06.07.2018.
 */

public class DatabaseHelperMethods extends DatabaseHelper {
    public DatabaseHelperMethods(Context context) {
        super(context);
    }

    public String getImage(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_PEOPLE +
                " where " + COLUMN_NAME_PEOPLE + " = '" + id + "' ;", null);
        b.moveToFirst();
        String photoDoctor = b.getString(b.getColumnIndex(COLUMN_PHOTO_PEOPLE));
        b.close();
        return photoDoctor;
    }

    public String getDescription(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_PEOPLE +
                " where " + COLUMN_NAME_PEOPLE + " = '" + id + "' ;", null);
        b.moveToFirst();
        String photoDoctor = b.getString(b.getColumnIndex(COLUMN_DESCRIPTION_PEOPLE));
        b.close();
        return photoDoctor;
    }
}
