package com.example.mariorun;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.View;
import android.content.Context;


import java.io.IOException;

public class GameActivity extends AppCompatActivity {


    MovementState movement;
    ImageButton menuButton, jumpButton, walkLeftButton, walkRightButton;
    ImageView mario;

    Runnable updateIcon;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        movement = new MovementState(getResources(), getPackageName());
        mario = (ImageView) findViewById(R.id.mario);

        menuButton =(ImageButton)findViewById(R.id.menuButton);
        jumpButton =(ImageButton)findViewById(R.id.jump);
        walkLeftButton =(ImageButton)findViewById(R.id.walkleft);
        walkRightButton =(ImageButton)findViewById(R.id.walkright);

        handler = new Handler();

        updateIcon = new Runnable() {
            @Override
            public void run() {
                mario.setImageResource(movement.getCurrentState());
            }
        };



        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(GameActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(i);
            }
        });

        jumpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                movement.startJumping();

                handler.postDelayed(updateIcon, 300);
            }
        });

        walkLeftButton.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent me){
                printTrue();
                if(me.getAction() == MotionEvent.ACTION_DOWN){
                    movement.setLeft();
                    movement.startWalking();
                    handler.postDelayed(updateIcon, 300);
                    return true;
                }

                if(me.getAction() == MotionEvent.ACTION_UP){
                    movement.stopWalking();
                    handler.postDelayed(updateIcon, 300);
                    return true;
                }
                return false;
            }
        });

        walkRightButton.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent me){
                if(me.getAction() == MotionEvent.ACTION_DOWN){
                    movement.setRight();
                    movement.startWalking();
                    handler.postDelayed(updateIcon, 300);
                    return true;
                }

                if(me.getAction() == MotionEvent.ACTION_UP){
                    movement.stopWalking();
                    handler.postDelayed(updateIcon, 300);
                    return true;
                }
                return false;
            }

        });


    }

    public void printTrue(){

    }






}
