package com.example.finalmultimedia;

import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textview.MaterialTextView;

public class EstadosHolder extends RecyclerView.ViewHolder{

    ImageButton imgStatusJAVA;
    MaterialTextView usuarioStatusJAVA;
    MaterialTextView fechayhoraStatusJAVA;

    public EstadosHolder(@NonNull View itemView) {
        super(itemView);

        imgStatusJAVA = (ImageButton) itemView.findViewById(R.id.imgStatusXML);
        usuarioStatusJAVA = (MaterialTextView) itemView.findViewById(R.id.usuarioStatusXML);
        fechayhoraStatusJAVA = (MaterialTextView) itemView.findViewById(R.id.fechayhoraStatusXML);
    }

    public void bind(EstadosP post) {

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

        Glide.with(itemView)
                .load(post.getImgStatusXML())
                .apply(options)
                .into(imgStatusJAVA);

        usuarioStatusJAVA.setText(post.getUsuarioStatusXML());
        fechayhoraStatusJAVA.setText(post.getFechayhoraStatusXML());
    }
}
