package com.kerrrusha.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoPlayer = findViewById(R.id.videoPlayer);

        String videoPath = getFilesDir().getAbsolutePath() + "/pubg.mp4";
        videoPlayer.setVideoPath(videoPath);

        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);

        Button goBackButton = findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(VideoActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    public void play(View view){
        videoPlayer.start();
    }

    public void pause(View view){
        videoPlayer.pause();
    }

    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }

}
