package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public final class PeopleListActivity extends AppCompatActivity {
    private ListView userList;
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase db;
    private Cursor userCursor;
    private String profession;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        TextView header = (TextView) findViewById(R.id.header_map);
        userList = (ListView) findViewById(R.id.list_people);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        profession = intent.getStringExtra(DatabaseHelper.PROFESSION);
        header.setText(profession);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.adUnitId));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        db = mDatabaseHelper.getReadableDatabase();
        userCursor = db.rawQuery("select _id_people as _id, * from " + DatabaseHelper.TABLE_PEOPLE + " where "
                + DatabaseHelper.COLUMN_CONCRETE_PROFESSION_PEOPLE + " == '" + profession
                + "' ;", null);
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_NAME_PEOPLE};
        SimpleCursorAdapter userAdapter = new SimpleCursorAdapter(this, R.layout.one_line_list_item,
                userCursor, headers1, new int[]{R.id.text1_1_1}, 0);
        userList.setAdapter(userAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(PeopleListActivity.this, GreatManDescriptionActivity.class);
                TextView textView = (TextView) v.findViewById(R.id.text1_1_1);
                String name = textView.getText().toString();
                intent.putExtra(DatabaseHelper.NAME_MAN, name);
                startActivity(intent);

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d(getString(R.string.TAG), getString(R.string.interstitial_wasnt_loaded));
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
        userCursor.close();
    }
}
