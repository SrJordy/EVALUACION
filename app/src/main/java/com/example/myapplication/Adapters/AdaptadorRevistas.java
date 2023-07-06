package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.Models.RevistasModelo;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AdaptadorRevistas extends ArrayAdapter<RevistasModelo> {
    public AdaptadorRevistas(Context context, ArrayList<RevistasModelo> datos) {
        super(context, R.layout.lyrevistas, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyrevistas, null);
        TextView Titu = (TextView)item.findViewById(R.id.lblTitulo);
        Titu.setText(getItem(position).getNombre());
        TextView abrev = (TextView)item.findViewById(R.id.lblAbreviatura);
        abrev.setText(getItem(position).getAbrevi());
        ImageView imageView=(ImageView) item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext()).load(getItem(position).getUrlLogo()).into(imageView);
        return(item);
    }
}
