package com.example.mypark;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    //PAGINA INICIAL APOS USUARIO LOGAR
    TextView txtNomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView txtNomeUsuario = (TextView) findViewById(R.id.txtNomeUsuario);


        //Recebendo nome do usuario da main
        Intent i = getIntent();
        Bundle p = i.getExtras();
        String nome = p.getString("chave_nome");
        txtNomeUsuario.setText("Bem Vindo, "+nome);



    }



}
