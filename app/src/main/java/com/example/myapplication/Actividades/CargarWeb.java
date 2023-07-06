package com.example.myapplication.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication.Adapters.AdaptadorUsuarios;
import com.example.myapplication.Models.Usuario;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class CargarWeb extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_cargar_web);
        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, CargarWeb.this, CargarWeb.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        ArrayList<Usuario> usuario;
        ListView lstUser=(ListView)findViewById(R.id.lstUsuario);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");
        usuario = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorUsuarios adapatorUsuario = new AdaptadorUsuarios(this, usuario);
        lstUser.setAdapter(adapatorUsuario);
    }
}