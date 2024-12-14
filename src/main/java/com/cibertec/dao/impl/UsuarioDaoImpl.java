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

        //inicializamos una lista llamada - listaRespuesta y lo guardamos como una nueva lista Vacia

        List<Usuario> listaRespuesta =  new ArrayList<>();

        //almacenamos en una cadena de texto llamada query la consulta SQL

        String query = "SELECT id, nombre, apellido, correo as email, clave FROM Usuarios;";

        try(
                //establecemos la conexion hacia la base de datos como parametro
                Connection connection = DBConnection.getConnection();
                //preparamos para realizar la consulta
                PreparedStatement statement = connection.prepareStatement(query);
                //almacenamos los resultados de la consulta en resultDB
                ResultSet resultDB = statement.executeQuery();
                ){


            //mientra se encuentre con datos el resultDB seguira recuperando los datos de los usuarios
            while (resultDB.next()){
                //y estos seran almacenados en un nuevo objeto llamado item
                Usuario item = new Usuario(
                        resultDB.getInt("id"),
                        resultDB.getString("nombre"),
                        resultDB.getString("apellido"),
                        resultDB.getString("email"),
                        resultDB.getString("clave")
                );
                //finalmente se agregará el objeto item a la variable tipo lista -  listaRespuesta declarada al comienzo
                //del metodo
                listaRespuesta.add(item);
            }
        }
        //en caso de ocurrir un error lo capturamos
        catch (ClassNotFoundException error) {
            throw new RuntimeException("Ocurrio un error:",error);
        }
        //retornamos la lista listaRespuesta
        return listaRespuesta;
    }

    @Override
    public Usuario verificarCredenciales(String correo, String clave) throws SQLException {

        //almacenamos la consulta SQL en una variable tipo cadena llamada query
        String query = "SELECT id, nombre, apellido, correo, clave FROM Usuarios WHERE correo=? AND clave=?;";
        try(

                //Establecemos la conexion por medio de un parametro para cuidar recursos
                Connection connection = DBConnection.getConnection();
                //prepara la consulta para realizarla
                PreparedStatement statement = connection.prepareStatement(query);

        ) {

            // Asignamos los valores proporcionados (correo y clave) a los parámetros de la consulta (marcadores '?').

            // El primer '?' se reemplaza por el valor de 'correo'.
            statement.setString(1,correo);
            // El segundo '?' se reemplaza por el valor de 'clave'.
            statement.setString(2,clave);


            // Ejecutamos la consulta preparada y almacenamos el resultado en un objeto ResultSet.
            ResultSet resultDB = statement.executeQuery();

            //si existen datos en resultDB seguira con recuperando datos
            if(resultDB.next()) {
                //los datos se almacenaran en un objeto item de la clase usuario
                Usuario item = new Usuario(
                        resultDB.getInt("id"),
                        resultDB.getString("nombre"),
                        resultDB.getString("apellido"),
                        resultDB.getString("correo"),
                        resultDB.getString("clave")
                );
                //y finalmente se retornara el item con los datos
                return item;
            }

        }
        //captamos si en caso existe un error
        catch (ClassNotFoundException error){
            throw new RuntimeException("Orcurrio un error: ",error);
        }

        //retorna un valor nulo en caso no se haya recuperado nada
        return null;

    }
}
