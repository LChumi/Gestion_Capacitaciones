package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.ista.gestion_capacitaciones.R;

public class RegistroCurso extends AppCompatActivity {

    String[] items = {"Si", "No"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_curso);

        autoCompleteTxt = findViewById(R.id.autocompleteTxt);
        adapterItems = new ArrayAdapter<>(this, R.layout.lista_items, items);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener((adapterView, view, i, l) -> {
            if (!isFinishing()) {
                String item = adapterView.getItemAtPosition(i).toString();
                Log.i("item", item);
            }
        });

    }

}


