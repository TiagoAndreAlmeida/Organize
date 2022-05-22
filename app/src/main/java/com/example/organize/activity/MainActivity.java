package com.example.organize.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.organize.R;
import com.example.organize.activity.config.FirebaseConfig;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        addSlide(new FragmentSlide.Builder()
            .background(R.color.white)
            .fragment(R.layout.slide1)
            .canGoBackward(false)
            .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide2)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide3)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide4)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.slide_intro)
                .canGoForward(false)
                .build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificaUsuarioLogado();
    }

    private void verificaUsuarioLogado() {
        FirebaseAuth firebaseAuth = FirebaseConfig.getFirebaseAuthInstance();
//        DatabaseReference databaseReference = FirebaseConfig.getDatabaseReference();

        if(firebaseAuth.getCurrentUser() != null) {
//            firebaseAuth.signOut();
            startActivity(new Intent(this, PrincipalActivity.class));
        }
    }

    public void onEntrar(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void onCadastrar(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }
}