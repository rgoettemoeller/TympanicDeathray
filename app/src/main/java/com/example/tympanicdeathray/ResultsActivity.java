package com.example.tympanicdeathray;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultsActivity extends Activity {
    private ImageView earImage;
    private MediaPlayer laserSound;
    private TextView previousText;
    private TextView currentText;

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
        previousText = (TextView) findViewById(R.id.previousText);
        currentText = (TextView) findViewById(R.id.currentText);
    }

    public void refreshResults(View view) {
        ResultsActivity obj = new ResultsActivity();
        earImage.setVisibility(View.VISIBLE);
        laserSound.start();
        previousText.setText("Holy fuck, your child is dying");
        currentText.setText("Call the undertaker");
    }

}
