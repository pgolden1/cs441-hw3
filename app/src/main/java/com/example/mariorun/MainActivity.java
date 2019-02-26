package com.example.mariorun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.View;
import android.content.Context;

public class MainActivity extends AppCompatActivity {


    ImageView mario;
    ImageButton playButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mario = (ImageView) findViewById(R.id.mario);
        playButton =(ImageButton)findViewById(R.id.play);



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, GameActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(i);
            }
        });



    }





}
