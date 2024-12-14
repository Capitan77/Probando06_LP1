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

    private UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String correo = req.getParameter("correo");
        String clave = req.getParameter("contrasenia");


        try {

            Usuario usuario = usuarioDao.verificarCredenciales(correo,clave);

            if(usuario != null){
                //credenciales correctas

                HttpSession httpSession = req.getSession(); //nueva sesion
                httpSession.setAttribute("usuario",usuario);

                //vamos a usar respons para enviar directamente sin modificar la direccion
                resp.sendRedirect("usuarios");

            }else {
                //error de credenciales al momento de iniciar sesion
                req.setAttribute("error","Usuario o contraseña incorrecta");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        }catch (SQLException error) {
            throw new ServletException("Error al validar contraseña",error);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if(httpSession != null) {
            httpSession.invalidate();
        }
        resp.sendRedirect("login.jsp");
    }
}
