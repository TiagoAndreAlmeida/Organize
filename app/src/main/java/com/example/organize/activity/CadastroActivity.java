package com.example.organize.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class CadastroActivity extends AppCompatActivity {

    private EditText nomeInput, emailInput, senhaInput;
    private Button cadastrarButton;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nomeInput = findViewById(R.id.editCadastroNome);
        emailInput = findViewById(R.id.editCadastroEmail);
        senhaInput = findViewById(R.id.editCadastroSenha);
        cadastrarButton = findViewById(R.id.cadastroButton);

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeInput.getText().toString();
                String email = emailInput.getText().toString();
                String senha = senhaInput.getText().toString();

                if(!nome.isEmpty() || !email.isEmpty() || !senha.isEmpty()) {
                    usuario = new Usuario(nome, email, senha);
                    cadastrar();
                } else {
                    Toast.makeText(getApplicationContext(), "Preencha os campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void cadastrar() {
        FirebaseAuth firebaseAuth = FirebaseConfig.getFirebaseAuthInstance();
        firebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Usuário cadastrado", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error ao cadastrar usuário", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}