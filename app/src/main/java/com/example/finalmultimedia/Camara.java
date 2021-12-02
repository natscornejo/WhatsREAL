package com.example.finalmultimedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Camara extends AppCompatActivity implements View.OnClickListener{
    AppCompatImageView Image1;
    FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
        Image1= (AppCompatImageView) findViewById(R.id.Image1);
        Image1.setOnClickListener(this);



        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();


        Glide.with(this)
                .load("https://elcomercio.pe/resizer/kXYM4ulKfZBqInCxzwC3yW1BgrE=/620x0/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/YLOLBDPNNBHKVDVOSNDAPGEH5I.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(8000))
                .apply(options)
                .into(Image1);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnBack:

                Intent mainActivity = new Intent(this, Mensaje.class);
                startActivity(mainActivity);
                break;

        }


    }



}