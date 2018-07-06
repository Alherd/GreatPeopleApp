package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.model.KeyValues;

public class SelectCountryActivity extends AppCompatActivity {
    Button russiaButton;
    Button italyButton;
    Button scientistsButton;
    Button sportsmenButton;
    Button politicsButton;
    Button singersButton;
    public static final String COUNTRY = "COUNTRY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);
        final Intent intent = getIntent();

        final String profession = intent.getStringExtra(MainActivity.PROFESSION);

        russiaButton = (Button) findViewById(R.id.russia_button);
        russiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCountryActivity.this, PeopleListActivity.class);
                intent.putExtra(COUNTRY,"Russia");
                intent.putExtra(MainActivity.PROFESSION, profession);
                startActivity(intent);
            }
        });
    }
}
