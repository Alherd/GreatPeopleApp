package com.alherd.greatpeopleapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";

    /**
     * Таблица GREAT_PEOPLE
     */
    public static final String TABLE_PEOPLE = "people";
    public static final String COLUMN_ID_PEOPLE = "_id_people";
    public static final String COLUMN_PROFESSION_PEOPLE = "profession_people";
    public static final String COLUMN_CONCRETE_PROFY_PEOPLE = "concrete_profy_people";
    public static final String COLUMN_NAME_PEOPLE = "name_people";
    public static final String COLUMN_PHOTO_PEOPLE = "photo_people";
    public static final String COLUMN_DESCRIPTION_PEOPLE = "description_people";

    public static final String PROFESSION_WRITER = "writer";
    public static final String COUNTRY_RUSSIA = "Поэзия";
    public static final String NAME_MAN = "NAME";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PEOPLE
                + " (" + COLUMN_ID_PEOPLE
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROFESSION_PEOPLE + " TEXT, "
                + COLUMN_CONCRETE_PROFY_PEOPLE + " TEXT, "
                + COLUMN_NAME_PEOPLE + " TEXT, "
                + COLUMN_PHOTO_PEOPLE + " TEXT, "
                + COLUMN_DESCRIPTION_PEOPLE + " TEXT);");

        db.execSQL("INSERT INTO " + TABLE_PEOPLE + " (" + COLUMN_PROFESSION_PEOPLE
                + ", " + COLUMN_CONCRETE_PROFY_PEOPLE + ", " + COLUMN_NAME_PEOPLE
                + ", " + COLUMN_PHOTO_PEOPLE + ", " + COLUMN_DESCRIPTION_PEOPLE + ") VALUES ('" + PROFESSION_WRITER + "', '" + COUNTRY_RUSSIA + "', 'Пушкин Александр Сергеевич', 'res/drawable/pushkin.jpg', 'Родился...')," +
                "('художник','Италия', 'Леонардо Да Винчи','photo','Родился...');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
