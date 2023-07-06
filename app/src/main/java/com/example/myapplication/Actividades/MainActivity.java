package com.example.myapplication.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.myapplication.Listener.ListenerLista;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] datos =
                new
                        String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        datos);
        ListView lstOpciones =
                (ListView)findViewById(R.id.lst);
        lstOpciones.setAdapter(adaptador2);
        lstOpciones.setOnItemClickListener(new ListenerLista(this.getApplicationContext()));

    }

}