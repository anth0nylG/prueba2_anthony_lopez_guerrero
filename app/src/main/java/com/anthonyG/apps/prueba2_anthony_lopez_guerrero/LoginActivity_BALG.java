package com.anthonyG.apps.prueba2_anthony_lopez_guerrero;

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

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarUsuario(view);
            }
        });
    }

    private void ValidarUsuario(View view) {

        if (editTextUsr.getText().toString().equals("anthony") && editTextPasswd.getText().toString().equals("anthony123")
                || (editTextUsr.getText().toString().equals("alexis") && editTextPasswd.getText().toString().equals("alexis123")))
        {
            Intent flags = new Intent(this, MainActivity_BALG.class);
            startActivity(flags);
        }
        else
        {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}