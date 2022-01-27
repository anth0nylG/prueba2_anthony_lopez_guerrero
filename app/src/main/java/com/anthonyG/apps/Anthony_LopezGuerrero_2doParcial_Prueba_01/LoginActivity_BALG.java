package com.anthonyG.apps.Anthony_LopezGuerrero_2doParcial_Prueba_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity_BALG extends AppCompatActivity {

    private EditText editTextUsr;
    private EditText editTextPasswd;

    private Button buttonLogin;
    private Button buttonCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balg_login);

        editTextUsr = findViewById(R.id.editTextUsuario);
        editTextPasswd = findViewById(R.id.editTextPassword1);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonCrud = findViewById(R.id.buttonCrud);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarUsuario(view);
            }
        });

        buttonCrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditUserInformation(view);
            }
        });
    }

    private void ValidarUsuario(View view) {

        if(editTextUsr.getText().equals("anthony") || editTextUsr.getText().equals("alexis") && editTextPasswd.getText().equals("anthony123") || editTextPasswd.getText().equals("anthony123"))
        {
            Intent flags = new Intent(this, MainActivity_BALG.class);
            startActivity(flags);
        }
        else
        {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }

    }

    private void EditUserInformation(View view) {
        Intent crudActivity = new Intent(this, CrudClientes_BALG.class);
        startActivity(crudActivity);
    }
}