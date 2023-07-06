package com.example.myapplication.Listener;
import android.view.View;
import android.content.Context;
import android.widget.AdapterView;
import android.widget.Toast;

public class ListenerLista implements AdapterView.OnItemClickListener{
Context ct;
    public ListenerLista(Context ct){
        this.ct=ct;
    }
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(ct, "TEXTO SELECCIONADO"+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
    }
}
