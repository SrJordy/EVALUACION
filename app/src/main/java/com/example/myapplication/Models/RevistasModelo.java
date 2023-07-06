package com.example.myapplication.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RevistasModelo {
    private String Nombre;
    private String abrevi;
    private String urlLogo;

    private String id;

    public RevistasModelo(JSONObject a) throws JSONException {
        Nombre = a.getString("name").toString();
        abrevi = a.getString("abbreviation").toString() ;
        urlLogo = a.getString("portada").toString() ;
        id = a.getString("journal_id").toString();
    }
    public static ArrayList<RevistasModelo> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<RevistasModelo> Revis = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            Revis.add(new RevistasModelo(datos.getJSONObject(i)));
        }
        return Revis;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAbrevi() {
        return abrevi;
    }

    public void setAbrevi(String abrevi) {
        this.abrevi = abrevi;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
