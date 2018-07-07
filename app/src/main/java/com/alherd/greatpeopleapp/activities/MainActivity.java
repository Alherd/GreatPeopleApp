package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    Button writersButton;
    Button artistsButton;
    Button scientistsButton;
    Button sportsmenButton;
    Button politicsButton;
    Button singersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writersButton = (Button) findViewById(R.id.writers_button);
        artistsButton = (Button) findViewById(R.id.artists_button);
        scientistsButton = (Button) findViewById(R.id.scientists_button);
        sportsmenButton = (Button) findViewById(R.id.sportsmen_button);
        politicsButton = (Button) findViewById(R.id.polititions_button);
        singersButton = (Button) findViewById(R.id.singers_button);

        final Intent intent = new Intent(MainActivity.this, SelectCountryActivity.class);

        writersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_WRITER);
                startActivity(intent);
            }
        });

        artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        scientistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        sportsmenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        politicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        singersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
