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

public final class GreatManDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_great_man_description);

        ImageView photoPeople = (ImageView) findViewById(R.id.photo_doctor);
        TextView descriptionPeople = (TextView) findViewById(R.id.description_textview);

        DatabaseHelperMethods databaseHelperMethods = new DatabaseHelperMethods(this);
        Intent intent = getIntent();
        TextView namePeopleTextView = (TextView) findViewById(R.id.name_man_textView);

        String namePeople = intent.getStringExtra(DatabaseHelper.NAME_MAN);
        namePeopleTextView.setText(namePeople);

        InputStream is = getClass().getClassLoader().getResourceAsStream(databaseHelperMethods.getImage(namePeople));
        Bitmap bm = BitmapFactory.decodeStream(is);
        photoPeople.setImageBitmap(bm);

        descriptionPeople.setText(databaseHelperMethods.getDescription(namePeople));

        AdView adView = (AdView) findViewById(R.id.adView_1);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
