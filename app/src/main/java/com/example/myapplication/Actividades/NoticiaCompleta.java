package com.example.myapplication.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class NoticiaCompleta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_completa);
        Bundle b=new Bundle();
        b=this.getIntent().getExtras();
        TextView TxtTitu =(TextView)findViewById(R.id.txtTitulo);
        TxtTitu.setText(b.getString("TITULO"));
        TextView TXTSUbtit =(TextView)findViewById(R.id.txtSubtitulo);
        TXTSUbtit.setText(b.getString("SUBTITULO"));
    }
}