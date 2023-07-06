package com.example.myapplication.Models;

public class Noticia {
    private String titulo;
    private String subtitulo;
    public Noticia(String tit, String subtit){
        this.titulo = tit;
        this.subtitulo = subtit;
    }
    public String getTitulo(){

        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
    @Override
    public String toString(){
        return titulo+ " "+subtitulo;
    }
}