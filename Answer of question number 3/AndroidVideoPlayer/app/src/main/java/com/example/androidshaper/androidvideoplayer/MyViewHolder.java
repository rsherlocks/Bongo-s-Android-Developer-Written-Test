package com.example.androidshaper.androidvideoplayer;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    LinearLayout linearLayoutVideo;
    ImageView imageViewVideo;
    TextView textViewVideoName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        linearLayoutVideo=itemView.findViewById(R.id.linearLayout);
        imageViewVideo=itemView.findViewById(R.id.videoImage);
        textViewVideoName=itemView.findViewById(R.id.videoName);

    }
}
