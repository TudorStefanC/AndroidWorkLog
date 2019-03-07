package com.tudor.TudorLog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyShiftsAdapter extends RecyclerView.Adapter<MyShiftsAdapter.MyViewHolder> {
    private ArrayList<ShiftsItem> MyShiftsItemArrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView infoDate;
        private TextView infoStart;
        private TextView infoEnd;
        private TextView infoHours;

        private MyViewHolder(View itemView) {
            super(itemView);
            infoDate = itemView.findViewById(R.id.tvDate);
            infoStart = itemView.findViewById(R.id.tvStart);
            infoEnd = itemView.findViewById(R.id.tvEnd);
            infoHours = itemView.findViewById(R.id.tvHours);
        }
    }

    public MyShiftsAdapter (ArrayList<ShiftsItem> ShiftsItemArrayList){
        MyShiftsItemArrayList = ShiftsItemArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_shifts, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ShiftsItem currentShift = MyShiftsItemArrayList.get(position);
        holder.infoDate.setText(currentShift.getmDate());
        holder.infoStart.setText(currentShift.getmStart());
        holder.infoEnd.setText(currentShift.getmEnd());
        holder.infoHours.setText(currentShift.getmHours());
    }

    @Override
    public int getItemCount() {
        return MyShiftsItemArrayList.size();
    }
}
