package com.example.superwiku.countries;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageHolder>{
    List<Language> languageListList;
    Activity activity;

    public LanguageAdapter(List<Language> languageListList, Activity activity) {
        this.languageListList = languageListList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public LanguageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(activity).inflate(R.layout.rv_language,parent,false);
        return new LanguageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageHolder holder, int position) {
        holder.namaBahasa.setText(languageListList.get(position).getName());
        holder.namaAsliBahasa.setText(languageListList.get(position).getNativeName());
        holder.iso_1.setText(languageListList.get(position).getIso639_1());
        holder.iso_2.setText(languageListList.get(position).getIso639_2());

    }

    @Override
    public int getItemCount() {
        return languageListList.size();
    }

    static class LanguageHolder extends RecyclerView.ViewHolder{
        TextView namaBahasa, namaAsliBahasa, iso_1, iso_2;

        public LanguageHolder(View itemView) {
            super(itemView);
            namaBahasa=(TextView)itemView.findViewById(R.id.txt_dtlbhsname);
            namaAsliBahasa=(TextView)itemView.findViewById(R.id.txt_dtlbhsnative);
            iso_1=(TextView)itemView.findViewById(R.id.txt_dtlbhsiso_1);
            iso_2=(TextView)itemView.findViewById(R.id.txt_dtlbhsiso_2);
        }
    }
}
