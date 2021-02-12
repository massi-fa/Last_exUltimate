package com.example.last_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.last_ex.Registrazione.utenti;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    TextView register;
    Button login;

    static Utente logged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        login = findViewById(R.id.buttonLogin);
        register = findViewById(R.id.linkRegistrazione);

        Utente admin = new Utente("admin","admin","Cagliari","01-12-1999");
        admin.setAdmin(true);
        if(!Registrazione.utenti.contains(admin)){
            Registrazione.utenti.add(admin);
            utenti.add(new Utente("asso","asso","Cagliari","01-11-1999"));
            utenti.add(new Utente("ale","ale","Pirri","01-10-1999"));
            utenti.add(new Utente("baldo","baldo","Elmas","01-03-1979"));
            utenti.add(new Utente("cri","cri","Sestu","01-12-2000"));
            utenti.add(new Utente("angi","angi","Cagliari","01-12-1965"));
            utenti.add(new Utente("lello","lello","Cagliari","01-12-1999"));
            utenti.add(new Utente("ked","ked","Elmas","01-12-2000"));
            utenti.add(new Utente("nay","nay","Cagliari","01-12-2001"));
            utenti.add(new Utente("vatti","vatti","Cagliari","01-11-1999"));
            utenti.add(new Utente("trudu","trudu","Pirri","01-01-2003"));
            utenti.add(new Utente("ciccio","ciccio","Cagliari","01-12-1999"));
            utenti.add(new Utente("anto","anto","Pirri","01-02-1800"));
            utenti.add(new Utente("gigi","gigi","Pirri","01-03-1979"));
            utenti.add(new Utente("pila","pila","Cagliari","01-10-1999"));
            utenti.add(new Utente("davide","baldo","Pirri","01-03-1979"));
            utenti.add(new Utente("vang","vang","Sestu","01-12-2000"));
            utenti.add(new Utente("vopo","vopo","Elmas","01-12-1965"));
            utenti.add(new Utente("red","red","Cagliari","01-12-1999"));
            utenti.add(new Utente("kedius","kedius","Elmas","01-12-2000"));
            utenti.add(new Utente("naylon","naylon","Cagliari","01-12-2001"));
            utenti.add(new Utente("vattino","vattino","Elmas","01-03-1979"));
            utenti.add(new Utente("trutru","trutru","Cagliari","01-01-2003"));
            utenti.add(new Utente("Gamer","Gamer","Elmas","01-12-1999"));
            utenti.add(new Utente("angelo","angelo","Pirri","01-02-1800"));

        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()){
                    ArrayList<Utente> utenti = Registrazione.utenti;
                    for(Utente aux : utenti){
                        Log.d("registered",aux.toString());
                        if(aux.getUsername().equals(username.getText().toString())&&aux.getPassword().equals(password.getText().toString())){
                            logged = aux;
                            Intent home = new  Intent(MainActivity.this,Home.class);
                            startActivity(home);
                        }
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new  Intent(MainActivity.this,Registrazione.class);
                startActivity(reg);
            }
        });
    }

    private boolean checkInput() {
        int i = 0,counter=0;
        if(username.getText().toString().equals("")){
            username.setError("Username vuoto");
            i++;
        }

        if(password.getText().toString().equals("")){
            password.setError("Password vuoto");
            i++;
        }
        for(Utente aux: utenti){
            if(!aux.getUsername().equals(username.getText().toString())){
                counter++;
            }
            Log.d("control",aux.toString());
            if(aux.getUsername().equals(username.getText().toString())){
                if(!aux.getPassword().equals(password.getText().toString())){
                    password.setError("Password errata");
                    i++;
                }
            }
        }
        if(counter == utenti.size()){
            username.setError("L'username non è registrato");
            i++;
        }
        if (i >0 ) {
            return false;
        }
        return true;
    }
}