package com.example.mariorun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView skyimg = (ImageView) findViewById(R.id.sky);
        int skyResource = getResources().getIdentifier("@drawable/sky", null, this.getPackageName());
        skyimg.setImageResource(skyResource);
    }
}
