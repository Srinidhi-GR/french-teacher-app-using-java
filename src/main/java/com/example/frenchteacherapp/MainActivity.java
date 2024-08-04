package com.example.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button black,green,purple,red,yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textView = findViewById(R.id.textView);

        black = findViewById(R.id.button);
        green = findViewById(R.id.button2);
        purple = findViewById(R.id.button3);
        red = findViewById(R.id.button4);
        yellow = findViewById(R.id.button5);

        black.setOnClickListener(this);
        green.setOnClickListener(this);
        purple.setOnClickListener(this);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.button) playSound(R.raw.black);
        else if(id == R.id.button2) playSound(R.raw.green);
        else if(id == R.id.button3) playSound(R.raw.purple);
        else if(id == R.id.button4) playSound(R.raw.red);
        else if(id == R.id.button5) playSound(R.raw.yellow);
    }


    public void playSound(int soundId) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, soundId);
        mediaPlayer.start();
    }
}