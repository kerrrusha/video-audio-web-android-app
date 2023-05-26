package com.kerrrusha.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class InternetVideoActivity extends AppCompatActivity {

    VideoView videoPlayer;
    Button playButton;
    Button pauseButton;
    Button stopButton;
    EditText videoUrlEditText;
    String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_video);

        videoPlayer = findViewById(R.id.videoPlayer);
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        videoUrlEditText = findViewById(R.id.videoUrl);
        videoUrlEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Called before the text is changed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Called when the text is being changed
            }

            @Override
            public void afterTextChanged(Editable s) {
                videoUrl = s.toString();
                playButton.setEnabled(true);
            }
        });

        Button goBackButton = findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(InternetVideoActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    public void play(View view){
        videoPlayer.setVideoPath(getVideoUrl());
        videoPlayer.start();

        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
    }

    private String getVideoUrl() {
        if (videoUrl != null && videoUrl.length() > 0) {
            return videoUrl;
        }
        return videoUrlEditText.getText().toString();
    }

    public void pause(View view){
        videoPlayer.pause();

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

}
