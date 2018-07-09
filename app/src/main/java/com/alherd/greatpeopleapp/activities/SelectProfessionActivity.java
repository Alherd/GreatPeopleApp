package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.constants.StringConstants;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.alherd.greatpeopleapp.database.DatabaseHelperMethods;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.InputStream;

public class SelectProfessionActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    String profession;
    String country;
    DatabaseHelperMethods mDatabaseHelperMethods;
    ImageView mImageView;
    String imagePath;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_profession);
        final Intent intent = getIntent();
//        MobileAds.initialize(this, "ca-app-pub-7248798470579066~6127475603");

        profession = intent.getStringExtra(DatabaseHelper.PROFESSION);
        imagePath = intent.getStringExtra(StringConstants.IMAGE_PATH);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        mDatabaseHelperMethods = new DatabaseHelperMethods(getApplicationContext());
        mDatabaseHelperMethods = new DatabaseHelperMethods(this);

        userList = (ListView) findViewById(R.id.list_people);
        mImageView = (ImageView) findViewById(R.id.image_profession);
        InputStream is = getClass().getClassLoader().getResourceAsStream(imagePath);
        Bitmap bm = BitmapFactory.decodeStream(is);
        mImageView.setImageBitmap(bm);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onResume() {
        super.onResume();
        db = mDatabaseHelper.getReadableDatabase();
        userCursor = db.rawQuery("select _id_people as _id, * from " + DatabaseHelper.TABLE_PEOPLE + " where "
                + DatabaseHelper.COLUMN_PROFESSION_PEOPLE + " == '" + profession
                + "'GROUP BY concrete_profy_people;", null);
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_CONCRETE_PROFY_PEOPLE};
        userAdapter = new SimpleCursorAdapter(this, R.layout.one_line_list_item,
                userCursor, headers1, new int[]{R.id.text1_1_1}, 0);
        userList.setAdapter(userAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(SelectProfessionActivity.this, PeopleListActivity.class);
                TextView textView = (TextView) v.findViewById(R.id.text1_1_1);
                String name = textView.getText().toString();
                intent.putExtra(DatabaseHelper.PROFESSION, name);
                startActivity(intent);
            }
        });
    }
}
