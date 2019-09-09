package com.example.mypark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;



//PAGINA INICIAL APOS USUARIO LOGAR
public class LoginActivity extends AppCompatActivity {


    Button btnPesquisar;
    CheckBox checkAcademia,checkDog,checkSkate,checkPicnic,checkBike,checkCorrida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnPesquisar = (Button)findViewById(R.id.btnPesquisar);

        checkBike = (CheckBox) findViewById(R.id.checkBike);
        checkPicnic = (CheckBox) findViewById(R.id.checkPicnic);
        checkCorrida = (CheckBox)findViewById(R.id.checkCorrida);
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
                if(checkAcademia.isChecked() || checkBike.isChecked() || checkCorrida.isChecked() ){
                    Intent i = new Intent(LoginActivity.this,TelaMaps.class);
                    startActivity(i);
                }


            }


        });

    }

    }




