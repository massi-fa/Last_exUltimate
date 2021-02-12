package com.example.last_ex;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterGU extends ArrayAdapter<Utente>{

    Context myContext;
    int resource;
    ArrayList<Utente> utenteArrayList;

    public AdapterGU (Context myContext, int resource, ArrayList<Utente> utenteArrayList ){
        super(myContext,resource,utenteArrayList);
        this.myContext = myContext;
        this.resource = resource;
        this.utenteArrayList = utenteArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(myContext);

        View view = inflater.inflate(resource, null);

        TextView textView = view.findViewById(R.id.UsrCard);
        ImageView imageView = view.findViewById(R.id.Icona);
        Button button = view.findViewById(R.id.StatusButton);

        Utente utente = utenteArrayList.get(position);
        imageView.setImageResource(R.drawable.user);
        textView.setText(utente.getUsername());
        button.setText(utente.UtenteAdmin(utente.getAdmin()));
        if(utente.getAdmin()){
            button.setBackgroundColor(Color.parseColor("#32a852"));
        }else{
            button.setBackgroundColor(Color.parseColor("#405fad"));
        }

        view.findViewById(R.id.StatusButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!utente.getUsername().equals("admin")){
                    if(utente.getAdmin()){
                        utente.setAdmin(false);
                        button.setBackgroundColor(Color.parseColor("#405fad"));
                    }else{
                        utente.setAdmin(true);
                        button.setBackgroundColor(Color.parseColor("#32a852"));
                    }
                    button.setText(utente.UtenteAdmin(utente.getAdmin()));
                }
            }
        });

        return view;
    }
}
