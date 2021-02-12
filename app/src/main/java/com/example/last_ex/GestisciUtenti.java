package com.example.last_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class GestisciUtenti extends AppCompatActivity {

    Button back;
    ListView lista;
    SearchView ricerca;
    String searchText="";
    ArrayList<Utente> arrayRicerca = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestisci_utenti);
        back=findViewById(R.id.back);
        lista=findViewById(R.id.Lista);
        ricerca=findViewById(R.id.ricerca);
        //AdapterGU adapter = new AdapterGU(this,R.layout.usercontainer,Registrazione.utenti);
        //lista.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new  Intent(GestisciUtenti.this,Home.class);
                startActivity(home);
            }
        });
        ricerca.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchText=query;
                Risultati();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchText=newText;
                Risultati();
                return false;
            }
        });
        Risultati();
    }
    public void Risultati(){
        arrayRicerca.clear();
         for(Utente aux : Registrazione.utenti){
             if(aux.getUsername().contains(searchText)){
                 arrayRicerca.add(aux);
             }
         }
        AdapterGU adapter = new AdapterGU(this,R.layout.usercontainer,arrayRicerca);
        lista.setAdapter(adapter);
    }
}