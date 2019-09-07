package com.example.mypark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


//PAGINA INICIAL APOS USUARIO LOGAR
public class LoginActivity extends AppCompatActivity {


    Button btnPesquisar;
    CheckBox checkAcademia,checkDog,checkSkate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnPesquisar = (Button)findViewById(R.id.btnPesquisar);
        checkAcademia = (CheckBox)findViewById(R.id.checkAcademia);
        checkDog = (CheckBox)findViewById(R.id.checkDog);
        checkSkate = (CheckBox)findViewById(R.id.checkSkate);

        //Recebendo nome do usuario da main
        Intent i = getIntent();
        Bundle p = i.getExtras();
        String nome = p.getString("chave_nome");
        setTitle("Bem Vindo, " + nome);

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAcademia.isChecked()){
                    Log.d("Teste", "onClick: Chek selecionado");
                    Toast.makeText(LoginActivity.this, "Check academia selecionado", Toast.LENGTH_SHORT).show();
                }
                if(checkDog.isChecked()){
                    Log.d("Teste", "onClick: Chek selecionado");
                    Toast.makeText(LoginActivity.this, "Check brinquedos selecionado", Toast.LENGTH_SHORT).show();
                }

                if(!checkDog.isChecked()){
                    Log.d("Teste", "onClick: Chek selecionado");
                    Toast.makeText(LoginActivity.this, "Nenhum check selecionado", Toast.LENGTH_SHORT).show();
                }

            }


        });

    }

    }




