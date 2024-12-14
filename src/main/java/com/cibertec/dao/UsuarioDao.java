package com.cibertec.dao;

import com.cibertec.models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {

    List<Usuario>obtenerUsuarios() throws SQLException;
    Usuario verificarCredenciales(String correo, String clave) throws SQLException;

}
