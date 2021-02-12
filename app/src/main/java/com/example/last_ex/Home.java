package com.example.last_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView usr,psw,city,birth,passchange,benvenuto,status;
    Button logout,gestisci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usr=findViewById(R.id.usrshow);
        psw=findViewById(R.id.pswshow);
        city=findViewById(R.id.cityshow);
        birth=findViewById(R.id.dateshow);
        logout=findViewById(R.id.logout);
        passchange=findViewById(R.id.modpas);
        benvenuto=findViewById(R.id.Benvenuto);
        gestisci=findViewById(R.id.gestisci);
        status=findViewById(R.id.Status);

        usr.setText(MainActivity.logged.getUsername());
        psw.setText(MainActivity.logged.getPassword());
        city.setText(MainActivity.logged.getCitta());
        birth.setText(MainActivity.logged.getDataNascita());
        benvenuto.setText("Benvenuto " + MainActivity.logged.getUsername());
        status.setText(MainActivity.logged.UtenteAdmin(MainActivity.logged.getAdmin()));

        if(MainActivity.logged.getAdmin()){
            status.setBackground(getResources().getDrawable(R.drawable.border2));
        }else{
            status.setBackground(getResources().getDrawable(R.drawable.border));
        }

        if(MainActivity.logged.getAdmin()){
            gestisci.setVisibility(View.VISIBLE);
        } else {
            gestisci.setVisibility(View.GONE);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.logged=null;
                Intent login = new  Intent(Home.this,MainActivity.class);
                startActivity(login);
            }
        });

        gestisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gestisci = new  Intent(Home.this,GestisciUtenti.class);
                startActivity(gestisci);
            }
        });

        passchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new  Intent(Home.this,PswChange.class);
                startActivity(change);
            }
        });
    }
}