package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.alherd.greatpeopleapp.database.DatabaseHelperMethods;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.InputStream;

public class GreatManDescriptionActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    DatabaseHelperMethods mDatabaseHelperMethods;
    ImageView photoPeople;
    TextView descriptionPeople;
    TextView namePeopleTextView;
    String namePeople;
    private AdView mAdView;

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
        namePeopleTextView = (TextView) findViewById(R.id.name_man_textView);
        namePeople = intent.getStringExtra(DatabaseHelper.NAME_MAN);
        namePeopleTextView.setText(namePeople);
        InputStream is = getClass().getClassLoader().getResourceAsStream(mDatabaseHelperMethods.getImage(namePeople));
        Bitmap bm = BitmapFactory.decodeStream(is);
        photoPeople.setImageBitmap(bm);

        descriptionPeople.setText(mDatabaseHelperMethods.getDescription(namePeople));

        mAdView = (AdView) findViewById(R.id.adView_1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
