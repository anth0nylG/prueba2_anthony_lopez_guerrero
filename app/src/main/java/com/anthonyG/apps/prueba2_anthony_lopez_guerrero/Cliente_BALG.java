package com.anthonyG.apps.prueba2_anthony_lopez_guerrero;

public class Cliente_BALG {
    private int codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String usr;
    private String passwd;

    public Cliente_BALG() {
    }

    public Cliente_BALG(int codigo, String nombre, String apellido, String correo, String usr, String passwd) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usr = usr;
        this.passwd = passwd;
    }

    public Cliente_BALG(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
