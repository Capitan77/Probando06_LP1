package com.cibertec.models;

public class Usuario {

    //creamos una clase usuario que usaremos para almacenar todos
    //los datos que vayamos a resivir desde SQL

    //habilitamos los atributos
    //ponemos contructores complejos
    //1* con todos lo parametros
    //2* con todos los parametros menos el ID

    //inicializamos GETTERS y SETTERS

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;


    public Usuario(int id, String nombre, String apellido, String correo, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario(String nombre, String apellido, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }
}
