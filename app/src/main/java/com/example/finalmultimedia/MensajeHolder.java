package com.example.finalmultimedia;

import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textview.MaterialTextView;


public class MensajeHolder extends RecyclerView.ViewHolder {

    ImageButton imgJAVA;
    MaterialTextView usuarioJAVA;
    MaterialTextView mensajeJAVA;
    MaterialTextView horaJAVA;


    public MensajeHolder(@NonNull View itemView) {
        super(itemView);

        imgJAVA = (ImageButton) itemView.findViewById(R.id.imgXML);
        usuarioJAVA = (MaterialTextView) itemView.findViewById(R.id.usuarioXML);
        mensajeJAVA = (MaterialTextView) itemView.findViewById(R.id.mensajeXML);
        horaJAVA = (MaterialTextView) itemView.findViewById(R.id.horaXML);
    }

    public void bind(MensajeP post)
    {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

        Glide.with(itemView)
                .load(post.getImgXML())
                .apply(options)
                .into(imgJAVA);

        usuarioJAVA.setText(post.getUsuarioXML());
        mensajeJAVA.setText(post.getMensajeXML());
        horaJAVA.setText(post.getHoraXML());
    }

}

