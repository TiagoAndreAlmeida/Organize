package com.example.organize.activity.model;

import android.util.Log;

import com.example.organize.activity.config.FirebaseConfig;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

public class Usuario {
    private String UUDI, nome, email, senha;
    private Double despesaTotal= 0.0, receitaTotal = 0.0;

    public Usuario() {}

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void salvar() {
        DatabaseReference databaseReference = FirebaseConfig.getDatabaseReference();
        try {
            databaseReference.child("usuarios")
                    .child(UUDI)
                    .setValue(this);
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

    }

    public Double getDespesaTotal() {
        return despesaTotal;
    }

    public void setDespesaTotal(Double despesaTotal) {
        this.despesaTotal = despesaTotal;
    }

    public Double getReceitaTotal() {
        return receitaTotal;
    }

    public void setReceitaTotal(Double receitaTotal) {
        this.receitaTotal = receitaTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Exclude
    public String getUUDI() {
        return UUDI;
    }

    public void setUUDI(String UUDI) {
        this.UUDI = UUDI;
    }
}
