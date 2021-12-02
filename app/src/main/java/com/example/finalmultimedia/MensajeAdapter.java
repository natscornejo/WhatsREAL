package com.example.finalmultimedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MensajeAdapter extends RecyclerView.Adapter<MensajeHolder> {

    ArrayList<MensajeP> _mesajeList;

    public MensajeAdapter(Context c, ArrayList <MensajeP> mesajeList)
    {
        _mesajeList = mesajeList;
    }

    @NonNull
    @Override
    public MensajeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new MensajeHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MensajeHolder holder, int position) {
        holder.bind(_mesajeList.get(position));

    }

    @Override
    public int getItemCount() {
        return _mesajeList.size();
    }
}
