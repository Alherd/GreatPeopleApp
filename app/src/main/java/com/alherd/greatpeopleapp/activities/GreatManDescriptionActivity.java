package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.alherd.greatpeopleapp.database.DatabaseHelperMethods;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;

import java.io.InputStream;

public class GreatManDescriptionActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    DatabaseHelperMethods mDatabaseHelperMethods;
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
