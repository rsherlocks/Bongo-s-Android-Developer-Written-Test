package com.example.androidshaper.androidvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayActivity extends AppCompatActivity {

    VideoView videoView;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        videoView=findViewById(R.id.videoView);
        position=getIntent().getExtras().getInt("position",-1);
//        Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),String.valueOf(MainActivity.fileArrayList.size()),Toast.LENGTH_SHORT).show();

        VideoPlay();


    }

    private void VideoPlay() {
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoPath(String.valueOf(MainActivity.fileArrayList.get(position)));
        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int check=MainActivity.fileArrayList.size();
                if((position+1)!=check)
                {

                    videoView.setVideoPath(String.valueOf(MainActivity.fileArrayList.get(position=position+1)));
                    videoView.start();
                }
                else
                {
                            videoView.setVideoPath(String.valueOf(MainActivity.fileArrayList.get(position=check-(position+1))));
                              videoView.start();
                }


            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position!=0)
                {
                    videoView.setVideoPath(String.valueOf(MainActivity.fileArrayList.get(position=position-1)));
                    videoView.start();
                }



            }
        });

        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.setVideoPath(String.valueOf(MainActivity.fileArrayList.get(position=position+1)));
                videoView.start();
            }
        });
        videoView.canSeekForward();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        videoView.stopPlayback();
    }

}