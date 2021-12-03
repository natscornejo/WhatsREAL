package com.example.finalmultimedia;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatHolder extends RecyclerView.ViewHolder {

    TextView mensaje_enviadoJAVA,
            horaMensajeJAVA,
            idMensaje1JAVA;

    public ChatHolder(@NonNull View itemView) {
        super(itemView);

        mensaje_enviadoJAVA = (TextView) itemView.findViewById(R.id.mensaje_enviadoXML);
        horaMensajeJAVA = (TextView) itemView.findViewById(R.id.horaMensaje);
        idMensaje1JAVA = (TextView) itemView.findViewById(R.id.idMensaje);
    }

    public void bind (ChatP post) {
        mensaje_enviadoJAVA.setText(post.getMensaje_enviadoXML());
        horaMensajeJAVA.setText(post.getHoraMensaje());
        idMensaje1JAVA.setText(post.getIdMensaje());
    }
}
