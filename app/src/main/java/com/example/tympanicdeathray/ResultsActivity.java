package com.example.tympanicdeathray;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ResultsActivity extends Activity {
    private ImageView earImage;
    private MediaPlayer laserSound;
    private int loopCounter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        earImage = (ImageView) findViewById(R.id.ear_image);
        laserSound = MediaPlayer.create(ResultsActivity.this, R.raw.laser_sound);
        laserSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                earImage.setVisibility(View.GONE);
            }
        });
        loopCounter = 0;
    }

    public void refreshResults(View view) {
        ResultsActivity obj = new ResultsActivity();
        earImage.setVisibility(View.VISIBLE);
        laserSound.start();

    }

    private void hideImage() {

    }



}
