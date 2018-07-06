package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.alherd.greatpeopleapp.model.KeyValues;

public class MainActivity extends AppCompatActivity {

    Button writersButton;
    Button artistsButton;
    Button scientistsButton;
    Button sportsmenButton;
    Button politicsButton;
    Button singersButton;
    public final static String PROFESSION = "PROFESSION";

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
                intent.putExtra(PROFESSION, DatabaseHelper.PROFESSION_WRITER);
                startActivity(intent);
            }
        });

        artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyValues.sProfession = "writer";
                startActivity(intent);
            }
        });

        scientistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyValues.sProfession = scientistsButton.getText().toString().toLowerCase();
                startActivity(intent);
            }
        });

        sportsmenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyValues.sProfession = sportsmenButton.getText().toString().toLowerCase();
                startActivity(intent);
            }
        });

        politicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyValues.sProfession = politicsButton.getText().toString().toLowerCase();
                startActivity(intent);
            }
        });

        singersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyValues.sProfession = singersButton.getText().toString().toLowerCase();
                startActivity(intent);
            }
        });
    }
}
