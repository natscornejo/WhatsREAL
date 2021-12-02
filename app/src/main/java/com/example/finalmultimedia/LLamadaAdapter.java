package com.example.finalmultimedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LLamadaAdapter extends RecyclerView.Adapter<LLamadaHolder> {

    ArrayList<LLamadaP> _llamadaList;

    public LLamadaAdapter(Context c, ArrayList <LLamadaP> llamadaList)
    {
        _llamadaList = llamadaList;
    }

    @NonNull
    @Override
    public LLamadaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calls, parent, false);

        return new LLamadaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LLamadaHolder holder, int position) {
        holder.bind(_llamadaList.get(position));
    }

    @Override
    public int getItemCount() {
        return _llamadaList.size();
    }
}
