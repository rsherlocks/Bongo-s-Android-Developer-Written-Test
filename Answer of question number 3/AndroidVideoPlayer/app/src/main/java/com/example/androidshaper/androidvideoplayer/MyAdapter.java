package com.example.androidshaper.androidvideoplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public Context context;
    ArrayList<File> arrayListVideo;

    public MyAdapter(Context context, ArrayList<File> arrayListVideo) {
        this.context = context;
        this.arrayListVideo = arrayListVideo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.textViewVideoName.setText(arrayListVideo.get(position).getName());
        Bitmap bitmapThumbnail= ThumbnailUtils.createVideoThumbnail(arrayListVideo.get(position).getPath(), MediaStore.Images.Thumbnails.MINI_KIND);
        holder.imageViewVideo.setImageBitmap(bitmapThumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VideoPlayActivity.class);
                intent.putExtra("position",holder.getAdapterPosition());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {

        if (arrayListVideo.size()>0)
        {
            return arrayListVideo.size();
        }
        else{
            return 1;
        }

    }
}
