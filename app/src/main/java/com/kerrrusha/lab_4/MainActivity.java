package com.kerrrusha.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openVideoButton = findViewById(R.id.open_video_button);
        openVideoButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VideoActivity.class);
            startActivity(intent);
        });

        Button openAudioButton = findViewById(R.id.open_audio_button);
        openAudioButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AudioActivity.class);
            startActivity(intent);
        });

        Button openInternetVideoButton = findViewById(R.id.open_internet_video_button);
        openInternetVideoButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InternetVideoActivity.class);
            startActivity(intent);
        });
    }

}
