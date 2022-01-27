package com.anthonyG.apps.prueba2_anthony_lopez_guerrero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrudClientes_BALG extends AppCompatActivity {

    private EditText editTextCodigo;
    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextCorreo;
    private EditText editTextUsr;
    private EditText editTextPasswd;

    private Button buttonInsert;
    private Button buttonFind;
    private Button buttonDelete;
    private Button buttonEddit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balg_crud_clientes);

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextUsr = findViewById(R.id.editTextUsr);
        editTextPasswd = findViewById(R.id.editTextPassword);

        buttonInsert = findViewById(R.id.button_insertar);
        buttonFind = findViewById(R.id.button_buscar);
        buttonDelete = findViewById(R.id.button_eliminar);
        buttonEddit = findViewById(R.id.button_editar);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicInsertar(view);
            }
        });

        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicBuscar(view);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicEliminar(view);
            }
        });

        buttonEddit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicEditar(view);
            }
        });
    }

    public void onClicInsertar(View view){
        this.InsertarConClase();
    }

    private void InsertarConClase() {

        ClienteDAL_BALG clienteDAL = new ClienteDAL_BALG(this);

        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        String correo = editTextCorreo.getText().toString();
        String usr = editTextUsr.getText().toString();
        String passwd = editTextPasswd.getText().toString();

        if(!nombre.equals("") && !apellido.equals("") && !correo.equals("")){
            Cliente_BALG cliente = new Cliente_BALG();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCorreo(correo);
            cliente.setUsr(usr);
            cliente.setPasswd(passwd);

            clienteDAL.insertDAL(cliente);

            editTextNombre.setText("");
            editTextApellido.setText("");
            editTextCorreo.setText("");
            editTextUsr.setText("");
            editTextPasswd.setText("");

            Toast.makeText(this, "Cliente insertado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Todos los campos son Obligatorios", Toast.LENGTH_SHORT).show();
        }
    }




    public void onClicEditar(View view){
        this.editarConClase();

    }
    public void editarConClase(){

        ClienteDAL_BALG clienteDAL = new ClienteDAL_BALG(this);
        String codigo = editTextCodigo.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        String correo = editTextCorreo.getText().toString();

        Cliente_BALG cliente = new Cliente_BALG();
        cliente.setCodigo(Integer.valueOf(codigo));
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo);

        int cantidad=clienteDAL.updateDAL(cliente);

        if(cantidad>0){
            Toast.makeText(this, "Registro Modificado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "El registro no se pudo Modificar", Toast.LENGTH_SHORT).show();
        }
    }



    public void onClicEliminar(View view){
        this.eliminarConClase();
    }
    public void eliminarConClase(){

        ClienteDAL_BALG clienteDAL = new ClienteDAL_BALG(this);
        String codigo = editTextCodigo.getText().toString();

        int cantidad = clienteDAL.deleteDAL(Integer.valueOf(codigo));

        if(cantidad>0){
            Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Registro no encontrado", Toast.LENGTH_SHORT).show();
        }

        editTextNombre.setText("");
        editTextApellido.setText("");
        editTextCorreo.setText("");
    }


    public void onClicBuscar(View view){
        this.buscarConClase();
    }
    public void buscarConClase(){

        ClienteDAL_BALG clienteDAL = new ClienteDAL_BALG(this);
        String codigo = editTextCodigo.getText().toString();

        Cliente_BALG cliente = new Cliente_BALG();
        cliente=clienteDAL.selectByCodigoDAL(Integer.valueOf(codigo));

        if(cliente!=null)
        {
            editTextNombre.setText(cliente.getNombre());
            editTextApellido.setText(cliente.getApellido());
            editTextCorreo.setText(cliente.getCorreo());
        }
        else
        {
            Toast.makeText(this, "No se encontraron registros en la tabla", Toast.LENGTH_SHORT).show();
        }

    }
}