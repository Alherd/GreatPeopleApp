package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.alherd.greatpeopleapp.model.KeyValues;

public class PeopleListActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    String profession;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        header = (TextView) findViewById(R.id.header_map);
        userList = (ListView) findViewById(R.id.list_people);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        profession = intent.getStringExtra(MainActivity.PROFESSION);
        country = intent.getStringExtra(SelectCountryActivity.COUNTRY);
    }

    @Override
    public void onResume() {
        super.onResume();
        db = mDatabaseHelper.getReadableDatabase();
        userCursor = db.rawQuery("select _id_people as _id, * from " + DatabaseHelper.TABLE_PEOPLE + " where "
                + DatabaseHelper.COLUMN_PROFESSION_PEOPLE + " == '" + profession
                + "' AND " + DatabaseHelper.COLUMN_COUNTRY_PEOPLE + " == '" + country
                + "' ;", null);
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_NAME_PEOPLE};
        userAdapter = new SimpleCursorAdapter(this, R.layout.one_line_list_item,
                userCursor, headers1, new int[]{R.id.text1_1_1}, 0);
        userList.setAdapter(userAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}
