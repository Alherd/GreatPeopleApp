package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.alherd.greatpeopleapp.database.DatabaseHelperMethods;

import java.io.InputStream;

public class GreatManDescriptionActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    DatabaseHelperMethods mDatabaseHelperMethods;
    SimpleCursorAdapter userAdapter;
    ListView userListDoctor;
    SQLiteDatabase db;
    Cursor userCursor;
    Button button_1;
    ImageView photoPeople;
    TextView descriptionPeople;
    String namePeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_great_man_description);
        photoPeople = (ImageView) findViewById(R.id.photo_doctor);
        descriptionPeople = (TextView) findViewById(R.id.description_textview);

        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        mDatabaseHelperMethods = new DatabaseHelperMethods(getApplicationContext());
        mDatabaseHelperMethods = new DatabaseHelperMethods(this);
        Intent intent = getIntent();
        namePeople = intent.getStringExtra(DatabaseHelper.NAME_MAN);

        InputStream is = getClass().getClassLoader().getResourceAsStream(mDatabaseHelperMethods.getImage(namePeople));
        Bitmap bm = BitmapFactory.decodeStream(is);
        photoPeople.setImageBitmap(bm);

        descriptionPeople.setText(mDatabaseHelperMethods.getDescription(namePeople));
    }
}
