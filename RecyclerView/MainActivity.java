package com.example.constrainlayoutapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //Vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private void initImageBitmaps(){
        //Used for Debugging
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        //Syntax for creating a view holder
        mImageUrls.add("https://bit.ly/2TLdkuW");
        mNames.add("Tales of Phantasia");

        mImageUrls.add("https://bit.ly/2TEUbL9");
        mNames.add("Tales of Xillia");

        mImageUrls.add("https://bit.ly/2B8AF3f");
        mNames.add("Tales of Destiny DC");

        mImageUrls.add("https://bit.ly/2TK8nTf");
        mNames.add("Tales of Symphonia");

        mImageUrls.add("https://bit.ly/3cav8G9");
        mNames.add("Tales of Zestiria");

        mImageUrls.add("https://bit.ly/3gt5Arc");
        mNames.add("Tales of Innocence");

        mImageUrls.add("https://bit.ly/2ZHQc4f");
        mNames.add("Tales of Hearts");

        mImageUrls.add("https://bit.ly/2X6WBEd");
        mNames.add("Tales of Abyss");

        mImageUrls.add("https://bit.ly/2M7ZCOg");
        mNames.add("Tales of Vesperia");

        mImageUrls.add("https://bit.ly/3c7mIiW");
        mNames.add("Tales of Berseria");

        mImageUrls.add("https://bit.ly/2ZGo2qa");
        mNames.add("Tales of Rays");

        mImageUrls.add("https://bit.ly/2M437Wb");
        mNames.add("Tales of Arise");


        initRecyclerView();

    }

    private void initRecyclerView(){
        //Used for Debugging
        Log.d(TAG, "initRecyclerView: init recyclerview.");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter  adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);

        //Sets an adapter to the recycler view to load images
        recyclerView.setAdapter(adapter);

        //Linear Layout manager is used to manage the position of each view holder (making decisions like putting them back into data or leaving them there for faster seeing)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Improves performance if all elements will be the same size (which is also design friendly)
        recyclerView.setHasFixedSize(true);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();

    }
}
