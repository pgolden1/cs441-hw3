package com.example.mariorun;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    public class MarioView extends SurfaceView implements Runnable{

        MovementState movement;
        ImageView mario;
        //ImageButton jumpButton, walkLeftButton, walkRightButton, menuButton;
        SurfaceHolder ourHolder;
        Canvas canvas;
        Paint paint;
        Thread gameThread = null;

        public MarioView(Context c, String pkgnm) {
            super(c);
            movement = new MovementState(getResources(), pkgnm);
            ourHolder = getHolder();
            paint = new Paint();


        }

        @Override
        public void run(){
            while(true) draw();
        }

        public void draw(){

            if (ourHolder.getSurface().isValid()) {
                // Lock the canvas ready to draw
                canvas = ourHolder.lockCanvas();


                // Draw the background color
                canvas.drawColor(Color.argb(255, 160, 177, 250));

                /* Choose the brush color for drawing

                paint.setColor(Color.argb(255, 255, 255, 255));
                canvas.drawLine(0, 0, 300, y, paint);


                canvas.drawCircle(posx, posy, 30l, paint);*/

                ourHolder.unlockCanvasAndPost(canvas);
            }
        }

        public void onResume(){
            gameThread = new Thread(this);
            gameThread.start();
        }

        public void pause(){
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                Log.e("Error:", "joining thread");
            }
        }
    }


    MarioView marioview;
    ImageButton menuButton;
    ImageView sky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);


        marioview = new MarioView(this, this.getPackageName());
        setContentView(marioview);

    }

    @Override
    public void onResume(){
        super.onResume();
        marioview.onResume();
    }
            //mario.setImageResource(movement.getCurrentState());


    @Override
    protected void onPause() {
        super.onPause();

        // Tell the gameView pause method to execute
        marioview.pause();
    }






}
