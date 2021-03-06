package com.example.organize.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.organize.R;
import com.example.organize.activity.config.FirebaseConfig;
import com.example.organize.activity.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEdit, senhaEdit;
    private Button button;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEdit = findViewById(R.id.editLoginEmail);
        senhaEdit = findViewById(R.id.editLoginSenha);
        button = findViewById(R.id.loginButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString();
                String senha = senhaEdit.getText().toString();
                if(!email.isEmpty() || !senha.isEmpty()) {
                    onLogin(email, senha);
                } else {
                    Toast.makeText(getApplicationContext(), "Preencha os campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onLogin (String email, String senha) {
        FirebaseAuth firebaseAuth = FirebaseConfig.getFirebaseAuthInstance();
        firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            navegarPrincipal();
                        } else {
                            String exception = "";
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthInvalidUserException e) {
                                exception = "Usu??rio n??o cadastrado";
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                exception = "E-mail e senha n??o batem";
                            } catch (Exception e) {
                                exception = "Error ao cadastrar usu??rio";
                                e.printStackTrace();
                            }
                            Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void navegarPrincipal() {
        finish();
    }
}