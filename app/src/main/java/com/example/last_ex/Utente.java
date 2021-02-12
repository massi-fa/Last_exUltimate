package com.example.last_ex;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Calendar;

public class Utente implements Serializable{

    private String username,password,citta;
    private String dataNascita;
    private Boolean admin;

    public Utente (){
    this.username= "";
    this.password="";
    }

    public Utente (String username, String password, String citta, String dataNascita){
        this.username=username;
        this.password=password;
        this.citta=citta;
        this.dataNascita=dataNascita;
        this.admin=false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof Utente){
            Utente aux = (Utente) obj;
            if(this.getUsername().equals(aux.getUsername())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", citta='" + citta + '\'' +
                ", dataNascita='" + dataNascita + '\'' +
                ", status='" + UtenteAdmin(getAdmin()) + '\'' +
                '}';
    }

    String UtenteAdmin (Boolean value){
        if(value){
            return "Admin";
        } else {
            return "User";
        }
    };
}
