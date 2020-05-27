package com.example.constrainlayoutapp3;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder{
    CircleImageView image;
    TextView imageName;
    RelativeLayout parentLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        //Initialize the local variables above
        image = itemView.findViewById(R.id.image);
        imageName = itemView.findViewById(R.id.image_name);
        parentLayout = itemView.findViewById(R.id.parent_layout);

    }
}
