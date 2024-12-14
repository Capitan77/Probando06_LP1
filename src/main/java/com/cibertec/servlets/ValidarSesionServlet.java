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

@WebServlet(name="ValidarSesionServlet", urlPatterns = "/login")
public class ValidarSesionServlet extends HttpServlet {

    //creamos una variables que provenga de UsuarioDao para poder llamar a los metodos
    //que se encuentran implementado en UsuarioDaoImpl
    private UsuarioDao usuarioDao = new UsuarioDaoImpl();

    //iniciamos un metodo tipo POST para transmitir los datos de manera interna
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //obtenemos los parametros que se envian desde el login.jsp
        String correo = req.getParameter("correo");
        String clave = req.getParameter("contrasenia");


        try {

            //inicializamos un objeto llamado usuario de la clase Usuario
            //y a traves del usuarioDao llamaremos al metodo implementado
            // verificarCredenciales (con los dos parametros recuperdados)
            Usuario usuario = usuarioDao.verificarCredenciales(correo,clave);

            if(usuario != null){
                //credenciales correctas
                HttpSession httpSession = req.getSession(); //nueva sesion

                //almacenamos sesion en el objeto usuario y lo enviamos atraves del
                //atributo usuario
                httpSession.setAttribute("usuario",usuario);

                //vamos a usar respons para enviar directamente sin modificar la direccion
                resp.sendRedirect("usuarios");

            }else {
                //error de credenciales al momento de iniciar sesion
                req.setAttribute("error","Usuario o contraseña incorrecta");
                //en caso haya un error se enviará nuevamente a login.jsp
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        }
        //capturamos errores
        catch (SQLException error) {
            throw new ServletException("Error al validar contraseña",error);
        }

    }

    //Usamos metodo GET para programar el boton de cerrar sesión
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //obtenemos la sesion actual (correo y contraseña)
        HttpSession httpSession = req.getSession(false);
        //si hay una sesion activada, se desabilitará y se cerrará la sesión
        if(httpSession != null) {
            httpSession.invalidate();
        }
        //y finalmente se enviará hacia el login.jsp
        resp.sendRedirect("login.jsp");
    }
}
