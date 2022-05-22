package com.example.organize.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.organize.R;
import com.example.organize.activity.model.Movimentacao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MovimentacaoActivity extends AppCompatActivity {
    private EditText editValor;
    private TextInputEditText editCategoria, editDescricao, dataInput;
    private FloatingActionButton salvarBtn;
    private Movimentacao movimentacao = new Movimentacao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String tag = intent.getStringExtra("tipo");
        if(tag.equals("adicionar")) {
            setTheme(R.style.receitaTheme);
        } else if(tag.equals("remover")) {
            setTheme(R.style.despesaTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacao);

        editValor = findViewById(R.id.editValor);
        editCategoria = findViewById(R.id.editCategoriaText);
        editDescricao = findViewById(R.id.editDescricaoText);
        dataInput = findViewById(R.id.dateInput);
        salvarBtn = findViewById(R.id.enviarBtn);
    }

    public void showDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fixMonth = month < 10 ? "0"+(month+1) : ""+(month+1);
                String data = (dayOfMonth+""+fixMonth+""+year);
                dataInput.setText(dayOfMonth+"/"+fixMonth+"/"+year);
                movimentacao.setData(data);
            }
        }, ano, mes,dia);

        datePickerDialog.show();
    }

    public void salvar(View view) {
        String valorStr = editValor.getText().toString();
        String categoria = editCategoria.getText().toString();
        String descricao = editDescricao.getText().toString();

        if(!valorStr.isEmpty() && !categoria.isEmpty() && !descricao.isEmpty() && !movimentacao.getData().isEmpty()) {
            Double valor = Double.parseDouble(valorStr);
            movimentacao.setValor(valor);
            movimentacao.setCategoria(categoria);
            movimentacao.setDescricao(descricao);
            movimentacao.salvar();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Preencha os campos", Toast.LENGTH_LONG).show();
        }

    }
}