package com.example.bridginghealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appandroid.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private  static int splashTimeOut = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo=(ImageView)findViewById(R.id.Logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation myanimation = AnimationUtils.loadAnimation(this, R.anim.splashanimation);
        logo.startAnimation(myanimation);


    }

}