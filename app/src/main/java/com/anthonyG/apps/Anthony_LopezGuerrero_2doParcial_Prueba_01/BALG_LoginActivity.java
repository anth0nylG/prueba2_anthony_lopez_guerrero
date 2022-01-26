package com.anthonyG.apps.Anthony_LopezGuerrero_2doParcial_Prueba_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BALG_LoginActivity extends AppCompatActivity {

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

        BALG_ClienteDAL clienteDAL = new BALG_ClienteDAL(this);
        String usr = editTextUsr.getText().toString();
        String passwd = editTextPasswd.getText().toString();
        BALG_Cliente cliente = new BALG_Cliente();
//        cliente=clienteDAL.selectByUsrDAL(usr.toString());


        if(cliente!=null)
        {
            Toast.makeText(this,"Hay Datos",Toast.LENGTH_SHORT).show();



        }
        else
        {
            Toast.makeText(this, "No se encontraron registros del cliente en la tabla", Toast.LENGTH_SHORT).show();
        }

        Intent flags = new Intent(this, MainActivity.class);
        startActivity(flags);

    }

    private void EditUserInformation(View view) {
        Intent crudActivity = new Intent(this,BALG_CrudClientes.class);
        startActivity(crudActivity);
    }
}