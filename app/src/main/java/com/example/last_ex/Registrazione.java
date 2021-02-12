package com.example.last_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Registrazione extends AppCompatActivity {
    TextView username, password, confPassword, dataNascita, cittaProv;
    Button registati,back;

    static ArrayList<Utente> utenti = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        username = findViewById(R.id.usernameEditTextreg);
        password = findViewById(R.id.passwordEditTextreg);
        confPassword = findViewById(R.id.confpasswordEditTextreg);
        dataNascita = findViewById(R.id.dataNascitaData);
        cittaProv = findViewById(R.id.cittaprovEditText);
        registati = findViewById(R.id.buttonLogin);
        back = findViewById(R.id.buttonBack);

        dataNascita.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDialog();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent succ = new Intent(Registrazione.this,MainActivity.class);
                startActivity(succ);
            }
        });
        registati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent succ = new Intent(Registrazione.this,MainActivity.class);
                if(checkInput()){
                    utenti.add(new Utente(username.getText().toString(),password.getText().toString(),cittaProv.getText().toString(),dataNascita.getText().toString()));
                    startActivity(succ);
                }
            }
        });

    }
    void showDialog() {
        DialogFragment newFragment = DataPickerFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick(Calendar date) {
        // Do stuff here.
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        dataNascita.setText(format.format(date.getTime())); //10/10/2020
    }

    public void doNegativeClick() {
        // Do stuff here.

    }

    private boolean checkInput(){
        int i = 0;
        if(username.getText().toString().equals("")){
            username.setError("Inserisci username");
            i++;
        }
        if(password.getText().toString().equals("")){
            password.setError("Inserisci password");
            i++;
        }
        if(confPassword.getText().toString().equals("")){
            cittaProv.setError("Inserisci password di conferma");
            i++;
        }
        if(cittaProv.getText().toString().equals("")){
            cittaProv.setError("Inserisci username");
            i++;
        }
        if(dataNascita.getText().toString().equals("")){
            dataNascita.setError("Inserisci data");
            i++;
        }

        for(Utente aux : utenti){
            if(aux.getUsername().equals(username.getText().toString())){
                username.setError("Username già registato");
                i++;
            }
        }
        if(!password.getText().toString().equals(confPassword.getText().toString())){
            password.setError("Le due password non coincidono");
            i++;
        }
        if(i > 0){
            return false;
        }
        return true;
    };

    Utente setUtente (String usr, String psw, String citta, String date, Boolean admin){
        Utente utn = new Utente();
        utn.setUsername(usr);
        utn.setPassword(psw);
        utn.setCitta(citta);
        utn.setDataNascita(date);
        utn.setAdmin(admin);
        return utn;
    };
}