package com.example.roomdatabase26112019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase26112019.model.database.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class SinhvienAdapter extends RecyclerView.Adapter<SinhvienAdapter.SinhvienViewHolder> {

    private List<Sinhvien> sinhviens = new ArrayList<>();

//    public SinhvienAdapter(List<Sinhvien> sinhviens) {
//        this.sinhviens = sinhviens;
//    }

    @NonNull
    @Override
    public SinhvienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sinhvien,parent,false);
        SinhvienViewHolder holder = new SinhvienViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SinhvienViewHolder holder, int position) {
        Sinhvien sinhvien = sinhviens.get(position);
        holder.mTvTen.setText(sinhvien.getTen());
        holder.mTvNamsinh.setText(sinhvien.getNamsinh());
        holder.mTvDiaChi.setText(sinhvien.getDiachi());

    }

    @Override
    public int getItemCount() {
        return sinhviens!= null ? sinhviens.size() : 0;
    }
    public void setSinhviens(List<Sinhvien> sinhviens)
    {
        this.sinhviens = sinhviens;
        notifyDataSetChanged();
    }
    class SinhvienViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTen, mTvNamsinh, mTvDiaChi;

        public SinhvienViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvTen = itemView.findViewById(R.id.tv_name);
            mTvNamsinh = itemView.findViewById(R.id.tv_year);
            mTvDiaChi = itemView.findViewById(R.id.tv_address);
        }
    }
}
