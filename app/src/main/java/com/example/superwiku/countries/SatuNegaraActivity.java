package com.example.superwiku.countries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SatuNegaraActivity extends AppCompatActivity {
    TextView txtdtlnama,txtdtlibukota,txtdtlbenua,txtdtlsubbenua,
            txtdtlmatauangcode,txtdtlmatauangname,txtdltmatauangsymbol,
            txtdtlbhsiso1,txtdtlbhsiso2,txtdtlbhsname,txtdtlbhsnative;
    ImageView imgdtlbendera;
    Button btnmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satu_negara);
        txtdtlnama=(TextView)findViewById(R.id.txt_dtlnama);
        txtdtlibukota=(TextView)findViewById(R.id.txt_dtlibukota);
        txtdtlbenua=(TextView)findViewById(R.id.txt_dtlbenua);
    }
}
