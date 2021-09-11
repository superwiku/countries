package com.example.superwiku.countries;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.ahmadrosid.svgloader.SvgLoader;

import java.util.List;

public class NegaraAllAdapter extends RecyclerView.Adapter<NegaraAllAdapter.AllViewHolder>{
    List<Negara>negaraList;
    Activity activity;

    public NegaraAllAdapter(List<Negara> negaraList, Activity activity) {
        this.negaraList = negaraList;
        this.activity = activity;
    }

    @Override
    public AllViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new AllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllViewHolder holder, final int position) {
        holder.txtNamaNegara.setText(negaraList.get(position).getName());
        holder.txtIbukotaNegara.setText(negaraList.get(position).getCapital());
        holder.txtNamaBenua.setText(negaraList.get(position).getRegion());
        SvgLoader.pluck().with(activity).load(negaraList.get(position).getFlag(),holder.imgBendera);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namanya=negaraList.get(position).getName();
                Intent pindah=new Intent(v.getContext(),NavDetailActivity.class);
                pindah.putExtra("namanya",namanya);
                v.getContext().startActivity(pindah);

            }
        });

    }

    @Override
    public int getItemCount() {
        return negaraList.size();
    }

    static class AllViewHolder extends RecyclerView.ViewHolder{
        TextView txtNamaNegara,txtIbukotaNegara,txtNamaBenua;
        ImageView imgBendera;

        public AllViewHolder(View itemView) {
            super(itemView);
            txtNamaNegara=(TextView)itemView.findViewById(R.id.txt_nama_negara);
            txtIbukotaNegara=(TextView)itemView.findViewById(R.id.txt_nama_ibukota);
            txtNamaBenua=(TextView)itemView.findViewById(R.id.txt_nama_benua);
            imgBendera=(ImageView)itemView.findViewById(R.id.img_bendera);
        }
    }
}
