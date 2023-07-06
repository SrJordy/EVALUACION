package com.example.myapplication.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapters.AdaptadorNoticias;
import com.example.myapplication.Models.Noticia;
import com.example.myapplication.R;

public class MainActivityAdaptado extends AppCompatActivity implements AdapterView.OnItemClickListener{

    public Noticia[] noticias;
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_adaptado);
        //data
        noticias = new Noticia[]{
                new Noticia("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                new Noticia("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                new Noticia("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                new Noticia("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4")};

        //Adaptador
        AdaptadorNoticias adaptadornoticias = new AdaptadorNoticias(this,noticias);

        //Vistas
        lstOpciones=findViewById(R.id.lstOchi);
        View header =
                getLayoutInflater().inflate(R.layout.lyheader, null);
        lstOpciones.addHeaderView(header);

        lstOpciones.setAdapter(adaptadornoticias);
        //llamar desde la clase
       //lstOpciones.setOnItemClickListener(new ListenerLista(this.getApplicationContext()));
        //llamar desde aqui
        lstOpciones.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivityAdaptado.this, NoticiaCompleta.class);
        Bundle b = new Bundle();
        b.putString("TITULO",((Noticia)adapterView.getItemAtPosition(i)).getTitulo());
        b.putString("SUBTITULO",((Noticia)adapterView.getItemAtPosition(i)).getSubtitulo());
        intent.putExtras(b);
        startActivity(intent);
    }
}