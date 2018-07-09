package com.alherd.greatpeopleapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alherd.greatpeopleapp.R;
import com.alherd.greatpeopleapp.database.DatabaseHelper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public final class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {
    Button writersButton;
    Button artistsButton;
    Button scientistsButton;
    Button sportsmenButton;
    Button politicsButton;
    Button singersButton;
    private RewardedVideoAd mRewardedVideoAd;

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


        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mRewardedVideoAd.loadAd(getString(R.string.unitId), new AdRequest.Builder().build());

        writersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    final Intent intent = new Intent(MainActivity.this, SelectProfessionActivity.class);
                    intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_WRITER);
                    intent.putExtra(DatabaseHelper.IMAGE_PATH, getString(R.string.path_writers));
                    startActivity(intent);
                }
            }
        });

        artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    final Intent intent = new Intent(MainActivity.this, SelectProfessionActivity.class);
                    intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_ARTIST);
                    intent.putExtra(DatabaseHelper.IMAGE_PATH, getString(R.string.path_artists));
                    startActivity(intent);
                }
            }
        });

        scientistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    final Intent intent = new Intent(MainActivity.this, SelectProfessionActivity.class);
                    intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_SCIENTIST);
                    intent.putExtra(DatabaseHelper.IMAGE_PATH, getString(R.string.path_scientists));
                    startActivity(intent);
                }
            }
        });

        sportsmenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    final Intent intent = new Intent(MainActivity.this, SelectProfessionActivity.class);
                    intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_SPORTSMAN);
                    intent.putExtra(DatabaseHelper.IMAGE_PATH, getString(R.string.path_sportsman));
                    startActivity(intent);
                }
            }
        });

        politicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    final Intent intent = new Intent(MainActivity.this, SelectProfessionActivity.class);
                    intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_POLITICIAN);
                    intent.putExtra(DatabaseHelper.IMAGE_PATH, getString(R.string.path_politician));
                    startActivity(intent);
                }
            }
        });

        singersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    final Intent intent = new Intent(MainActivity.this, SelectProfessionActivity.class);
                    intent.putExtra(DatabaseHelper.PROFESSION, DatabaseHelper.PROFESSION_SINGER);
                    intent.putExtra(DatabaseHelper.IMAGE_PATH, getString(R.string.path_singers));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onRewardedVideoAdLoaded() {
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
