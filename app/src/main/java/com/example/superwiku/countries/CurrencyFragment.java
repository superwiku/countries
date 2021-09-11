package com.example.superwiku.countries;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyFragment extends Fragment {
    public static String KEY_ACTIVITY_3="msg_activity";
    private RecyclerView currencyRecyclerView;
    private NegaraFull negaraFull;
    private List<Currency> currencyList;
    private RecyclerView.LayoutManager layoutManager;
    private CurrencyAdapter currencyAdapter;

    public CurrencyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_currency, container, false);
        currencyRecyclerView=(RecyclerView)view.findViewById(R.id.rv_currencies);
        negaraFull=(NegaraFull)this.getArguments().getSerializable(KEY_ACTIVITY_3);
        if (negaraFull != null){
            currencyList=negaraFull.getCurrencies();
            layoutManager=new LinearLayoutManager(getActivity());
            currencyRecyclerView.setLayoutManager(layoutManager);
            currencyAdapter=new CurrencyAdapter(currencyList,getActivity());
            currencyRecyclerView.setAdapter(currencyAdapter);

        }
        return view;
    }

}
