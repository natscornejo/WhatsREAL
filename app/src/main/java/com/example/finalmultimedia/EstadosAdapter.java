package com.example.finalmultimedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EstadosAdapter extends RecyclerView.Adapter<EstadosHolder> {

    ArrayList<EstadosP> _estadoList;

    public EstadosAdapter(Context c, ArrayList<EstadosP> estadoList)
    {
        _estadoList = estadoList;
    }

    @NonNull
    @Override
    public EstadosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.status, parent, false);
        return new EstadosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadosHolder holder, int position) {
        holder.bind(_estadoList.get(position));
    }

    @Override
    public int getItemCount() {
        return _estadoList.size();
    }
}
