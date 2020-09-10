package com.example.chapter3.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Exe3ViewHolder> {

    @NonNull
    @Override
    public Exe3ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        return new Exe3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Exe3ViewHolder exe3ViewHolder, int i) {
        exe3ViewHolder.textView.setText("user" + i);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class Exe3ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public Exe3ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
        }

    }
}
