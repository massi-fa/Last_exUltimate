package com.example.last_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PswChange extends AppCompatActivity {

    TextView usr,psw;
    EditText pswi,pswicf;
    Button aggpsw,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psw_change);
        usr =  findViewById(R.id.usrshow);
        psw = findViewById(R.id.pswshow);
        pswi = findViewById(R.id.editnewpsw);
        pswicf = findViewById(R.id.editnewpswcf);

        aggpsw = findViewById(R.id.aggpsw);
        home = findViewById(R.id.Home);

        usr.setText(MainActivity.logged.getUsername());
        psw.setText(MainActivity.logged.getPassword());

        aggpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkpsw()){
                   MainActivity.logged.setPassword(pswi.getText().toString());
                    Intent home = new  Intent(PswChange.this,Home.class);
                    startActivity(home);
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new  Intent(PswChange.this,Home.class);
                startActivity(home);
            }
        });

    }

    private boolean checkpsw(){
        int i = 0;
        if(pswi.getText().toString().equals("")){
            pswi.setError("Campo vuoto");
            i++;
        }
        if(pswicf.getText().toString().equals("")){
            pswicf.setError("Campo vuoto");
            i++;
        }
        if(i > 0){
            return false;
        }
        if(pswi.getText().toString().equals(MainActivity.logged.getPassword())){
            pswi.setError("Password uguale alla precedente");
            return false;
        }
        if(!pswi.getText().toString().equals(pswicf.getText().toString())){
            pswi.setError("La password non coincide");
            return false;
        }

        return true;
    }
}