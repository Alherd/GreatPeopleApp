package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.constants.StringConstants;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {
    Button writersButton;
    Button artistsButton;
    Button scientistsButton;
    Button sportsmenButton;
    Button politicsButton;
    Button singersButton;
    private RewardedVideoAd mRewardedVideoAd;
    boolean isLoad;

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
        MobileAds.initialize(this, "ca-app-pub-7248798470579066~6127475603");

        final Intent intent = new Intent(MainActivity.this, SelectProfessionActivity.class);
        if (isLoad) {
            startActivity(intent);
        }
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());

        writersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    isLoad = true;
                    mRewardedVideoAd.show();
                } else {
                    intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_WRITER);
                    intent.putExtra(StringConstants.IMAGE_PATH, "res/drawable/writers.jpg");
                    startActivity(intent);
                }
            }
        });

        artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_ARTIST);
                intent.putExtra(StringConstants.IMAGE_PATH, "res/drawable/artist.jpg");
                startActivity(intent);
            }
        });

        scientistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_SCIENTIST);
                intent.putExtra(StringConstants.IMAGE_PATH, "res/drawable/scientist.jpg");
                startActivity(intent);
            }
        });

        sportsmenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_SPORTSMAN);
                intent.putExtra(StringConstants.IMAGE_PATH, "res/drawable/sportsman.png");
                startActivity(intent);
            }
        });

        politicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_POLITICIAN);
                intent.putExtra(StringConstants.IMAGE_PATH, "res/drawable/politician.jpg");
                startActivity(intent);
            }
        });

        singersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_SINGER);
                intent.putExtra(StringConstants.IMAGE_PATH, "res/drawable/singer.jpg");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "Ready", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }
}
