package com.kerrrusha.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button playButton, pauseButton, stopButton;
    boolean mediaPlayerIsNotPrepared = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        Button goBackButton = findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(AudioActivity.this, MainActivity.class);
            startActivity(intent);
        });

        String filePath = getFilesDir().getAbsolutePath() + "/metallica.mp3";
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(filePath);
        } catch (IOException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

    public void stopPlay() {
        mediaPlayer.stop();
        mediaPlayerIsNotPrepared = true;

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

    public void play(View view) {
        try {
            if (mediaPlayerIsNotPrepared) {
                mediaPlayer.prepare();
                mediaPlayerIsNotPrepared = false;
            }
        } catch (IOException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        mediaPlayer.start();

        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
    }

    public void pause(View view){
        mediaPlayer.pause();

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    public void stop(View view){
        stopPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            stopPlay();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            stopPlay();
        }
    }

}
