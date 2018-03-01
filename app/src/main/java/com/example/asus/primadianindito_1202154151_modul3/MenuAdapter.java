package com.example.asus.primadianindito_1202154151_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;;

import java.util.ArrayList;

/**
 * Created by Asus on 2/25/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MinumanViewHolder> {
    public ArrayList<Model> datas;

    public MenuAdapter(ArrayList<Model> datas) {
        this.datas = datas;


        Log.d("JUMLAH_ARRAYLIST","Items: "+getItemCount());
    }

    @Override
    public MenuAdapter.MinumanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemlist, parent, false);
        return new MinumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MinumanViewHolder holder, int position) {
        final Model item = datas.get(position);
        holder.bindTo(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(view.getContext().getApplicationContext(),DetailMenu.class);
                go.putExtra("etitle",item.getNama());
                go.putExtra("edesc",item.getDeskripsi());
                go.putExtra("eimg",item.getGambar());
                view.getContext().startActivity(go);
            }
        });

    }

    @Override
    public int getItemCount() {

        return datas.size();
    }

    class MinumanViewHolder extends RecyclerView.ViewHolder {

        private TextView mLblMinumanJudul;
        private TextView mLblMinumanInfo;
        private ImageView mLblMinumanImg;
        private Model mCurrentMinuman;
        private Context mContext;

        public MinumanViewHolder(View itemView) {
            super(itemView);
            mLblMinumanJudul = (TextView)itemView.findViewById(R.id.titleList);
            mLblMinumanInfo = (TextView)itemView.findViewById(R.id.descList);
            mLblMinumanImg = (ImageView)itemView.findViewById(R.id.gambar);
    }

        public void bindTo(Model minuman) {
            mCurrentMinuman = minuman;
            mLblMinumanImg.setImageResource(minuman.getGambar());
            mLblMinumanJudul.setText(minuman.getNama());
            mLblMinumanInfo.setText(minuman.getInfo());
        }
    }
}


