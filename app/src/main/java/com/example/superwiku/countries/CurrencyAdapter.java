package com.example.superwiku.countries;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder>{
    List<Currency>currencyList;
    Activity activity;

    public CurrencyAdapter(List<Currency> currencyList, Activity activity) {
        this.currencyList = currencyList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(activity).inflate(R.layout.rv_currency,parent,false);
        return new CurrencyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {
        holder.code.setText(currencyList.get(position).getCode());
        holder.name.setText(currencyList.get(position).getName());
        holder.symbol.setText(currencyList.get(position).getSymbol());
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    static class CurrencyHolder extends RecyclerView.ViewHolder{
        TextView code, name, symbol;
        public CurrencyHolder(View itemView) {
            super(itemView);
            code=(TextView)itemView.findViewById(R.id.txt_currency_code);
            name=(TextView)itemView.findViewById(R.id.txt_currency_name);
            symbol=(TextView)itemView.findViewById(R.id.txt_currency_symbol);
        }

    }
}