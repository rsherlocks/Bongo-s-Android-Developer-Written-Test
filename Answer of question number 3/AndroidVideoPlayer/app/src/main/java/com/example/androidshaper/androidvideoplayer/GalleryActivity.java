package com.example.androidshaper.androidvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import static java.lang.Thread.sleep;

public class GalleryActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_gallary);
        lottieAnimationView=findViewById(R.id.animationView);

       animationSplashScreen();

    }

    private void animationSplashScreen() {
        lottieAnimationView.playAnimation();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent i=new Intent(GalleryActivity.this,MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });
        thread.start();
    }
}