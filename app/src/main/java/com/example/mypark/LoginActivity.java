package com.example.mypark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //PAGINA INICIAL APOS USUARIO LOGAR
       EditText txtNomeUsuario;

       MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtNomeUsuario = (EditText)findViewById(R.id.txtNomeUsuario);
        txtNomeUsuario = main.txtNome;


    }
}
