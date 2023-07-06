package com.example.myapplication.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Adapters.AdaptadorRevistas;
import com.example.myapplication.Adapters.AdaptadorUsuarios;
import com.example.myapplication.Models.RevistasModelo;
import com.example.myapplication.Models.Usuario;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.WebService;

import WebService.Asynchtask;
public class Revistas extends AppCompatActivity implements Asynchtask {
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_web);
        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, Revistas.this, Revistas.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        JSONArray lista=new JSONArray(result);
        ArrayList<RevistasModelo> Revista;
        ListView lstRevis=(ListView)findViewById(R.id.lstRevistas);
        JSONArray JSONlistaRevistas= JSONlista.getJSONArray("");
        Revista = RevistasModelo.JsonObjectsBuild(JSONlistaRevistas);
        AdaptadorRevistas adaptrevis = new AdaptadorRevistas(this, Revista);
        lstRevis.setAdapter(adaptrevis);
    }
}