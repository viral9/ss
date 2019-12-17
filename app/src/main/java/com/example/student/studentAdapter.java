package com.example.student;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class studentAdapter extends RecyclerView.Adapter<studentAdapter.viewholder> {
    ArrayList<card> mdtatalist;
    private OnItemClickLisne mLisner;
    public void setOnItemClickLisner(OnItemClickLisne lisner)
    {
        mLisner = lisner;
    }
    public interface OnItemClickLisne
    {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        viewholder vh = new viewholder(v,mLisner);
        return vh;
    }
    public  studentAdapter(ArrayList<card> datalist )
    {
        mdtatalist = datalist;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        card current = mdtatalist.get(position);
        holder.tvstudentname.setText(current.getStuddata());
        holder.tvstudentroll.setText(current.getRoll());
        holder.studentdob.setText(current.getBod());

    }

    @Override
    public int getItemCount() {
        return mdtatalist.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder
    {
        TextView tvstudentname,tvstudentroll,studentdob;


        public viewholder(@NonNull View itemView, final OnItemClickLisne lisne) {
            super(itemView);
            tvstudentname = itemView.findViewById(R.id.tvstudentname);
            tvstudentroll = itemView.findViewById(R.id.tvstudentroll);
            studentdob = itemView.findViewById(R.id.tvstudentdob);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(lisne != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            lisne.onItemClick(position);
                        }
                    }


                }
            });
        }
    }



}
