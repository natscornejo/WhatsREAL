package com.example.finalmultimedia;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textview.MaterialTextView;

public class LLamadaHolder extends RecyclerView.ViewHolder {

    ImageButton imgCallsJAVA;
    MaterialTextView usuarioCallsJAVA;
    MaterialTextView fechayhoraCallsJAVA;
    ImageView mrCallJAVA;

    public LLamadaHolder(@NonNull View itemView) {
        super(itemView);

        imgCallsJAVA = (ImageButton) itemView.findViewById(R.id.imgCallsXML);
        usuarioCallsJAVA = (MaterialTextView) itemView.findViewById(R.id.usuarioCallsXML);
        fechayhoraCallsJAVA = (MaterialTextView) itemView.findViewById(R.id.fechayhoraCallsXML);
        mrCallJAVA = (ImageView) itemView.findViewById(R.id.mrCallXML);
    }

    public void bind (LLamadaP post) {

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

        Glide.with(itemView)
                .load(post.getImgCallsXML())
                .apply(options)
                .into(imgCallsJAVA);

        usuarioCallsJAVA.setText(post.getUsuarioCallsXML());
        fechayhoraCallsJAVA.setText(post.getFechayhoraCallsXML());
    }
}
