package com.example.constrainlayoutapp3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    //Holds the list of image names
    private ArrayList<String> mImageNames = new ArrayList<>();

    //Holds the images
    private ArrayList<String> mImages = new ArrayList<>();

    //Context
    private Context mContext;

    //Constructor
    public RecyclerViewAdapter(ArrayList<String> imageNames, ArrayList<String> images, Context context){
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
    }

    //Responsible for inflating the view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //Prints as much data that you have (used for debugging)
        Log.d(TAG, "onBindViewHolder: called.");

        //Glide Library used to load images through urls
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "On Click: Clicked On: " + mImageNames.get(position));
                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Leaving this at 0 will not load any images onto the screen
    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


}
