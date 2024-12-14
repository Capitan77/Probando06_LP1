package com.cibertec.servlets;

import com.cibertec.dao.UsuarioDao;
import com.cibertec.dao.impl.UsuarioDaoImpl;
import com.cibertec.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ListadoUsuariosServlets", urlPatterns ="/usuarios" )
public class ListadoUsuariosServlets extends HttpServlet {

    //creamos una variables que provenga de UsuarioDao para poder llamar a los metodos
    //que se encuentran implementado en UsuarioDaoImpl
    UsuarioDao usuarioDao = new UsuarioDaoImpl();

    //iniciamos un metodo tipo GET para transmitir los datos de manera superficial
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //obtiene los datos de la sesion actual
        //req.getSession(false):  -> sesion actual (correo y contraseña)
        HttpSession httpSession = req.getSession(false);
        //y verifica si es igual a null, en caso sea asi retornara nuevamente a Login.jsp
        //esto servirá como para retener y no dejar avanzar al acceso de datos, en caso
        //no se haya iniciado sesion
        if(httpSession == null || httpSession.getAttribute("usuario") == null){
            resp.sendRedirect("login.jsp");
            return;
        }


        //en caso si se haya iniciado sesion ejecuta lo demas

        try {

            //crea un lista tipo Usuario y ejecuta a traves de la variable usuarioDao
            //el metodo obtenerUsuarios
            List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
            //esa lista llamada usuarios se enviar por un atributo llamado usuarios
            req.setAttribute("usuarios", usuarios);
            //y se redirecciona a usuarios.jsp
            req.getRequestDispatcher("usuarios.jsp").forward(req, resp);

        }
        //se captan los posible errores y se envia mensajes
        catch (SQLException error) {
            throw  new ServletException("Error al listar los usuarios", error);
        }

    }
}
