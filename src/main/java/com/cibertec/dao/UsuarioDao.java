package com.cibertec.dao;

import com.cibertec.models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
//nombramos los metodos para ser inicializados en IMPL


    //inicializmos en una lista de la clase Usuario llamado obtenerUsuarios
    List<Usuario>obtenerUsuarios() throws SQLException;

    //Inicializamos un metodo que pueda ingresar a la clase usuario para
    //usar como parametro a los atributos de usuario correo y clave
    Usuario verificarCredenciales(String correo, String clave) throws SQLException;

}
