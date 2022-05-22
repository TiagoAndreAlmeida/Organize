package com.example.organize.activity.model;

import android.util.Log;

import com.example.organize.activity.config.FirebaseConfig;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Movimentacao {
    private String categoria, descricao, data;
    private double valor;

    public Movimentacao() {
    }

    public Movimentacao(String categoria, String descricao, double valor) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void salvar() {
        FirebaseAuth firebaseAuth = FirebaseConfig.getFirebaseAuthInstance();
        DatabaseReference databaseReference = FirebaseConfig.getDatabaseReference();
        String mesAno = this.data.substring(2);
        try {
            databaseReference.child("movimentacao")
                    .child(firebaseAuth.getUid())
                    .child(mesAno)
                    .push()
                    .setValue(this);
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                ", valor=" + valor +
                '}';
    }
}
