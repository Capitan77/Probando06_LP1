package com.cibertec.dao.impl;

import com.cibertec.dao.UsuarioDao;
import com.cibertec.models.Usuario;
import com.cibertec.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {
    @Override
    public List<Usuario> obtenerUsuarios() throws SQLException {
        //Consultar SQL
        //Cosultar a la BD
        //Ejecutar la consulta SQL
        //Obtener los resultados de la consulta de BD
        //Preparar a respuesta
        //devolver la respuesta

        List<Usuario> listaRespuesta =  new ArrayList<>();

        String query = "SELECT id, nombre, apellido, correo as email, clave FROM Usuarios;";

        try(
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultDB = statement.executeQuery();
                ){
            while (resultDB.next()){
                Usuario item = new Usuario(
                        resultDB.getInt("id"),
                        resultDB.getString("nombre"),
                        resultDB.getString("apellido"),
                        resultDB.getString("email"),
                        resultDB.getString("clave")
                );
                listaRespuesta.add(item);
            }
        }  catch (ClassNotFoundException error) {
            throw new RuntimeException("Ocurrio un error:",error);
        }

        return listaRespuesta;
    }

    @Override
    public Usuario verificarCredenciales(String correo, String clave) throws SQLException {
        String query = "SELECT id, nombre, apellido, correo, clave FROM Usuarios WHERE correo=? AND clave=?;";
        try(
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);

        ) {
            statement.setString(1,correo);
            statement.setString(2,clave);
            ResultSet resultDB = statement.executeQuery();

            if(resultDB.next()) {
                Usuario item = new Usuario(
                        resultDB.getInt("id"),
                        resultDB.getString("nombre"),
                        resultDB.getString("apellido"),
                        resultDB.getString("correo"),
                        resultDB.getString("clave")
                );

                return item;
            }

        }catch (ClassNotFoundException error){
            throw new RuntimeException("Orcurrio un error: ",error);
        }

        return null;

    }
}
