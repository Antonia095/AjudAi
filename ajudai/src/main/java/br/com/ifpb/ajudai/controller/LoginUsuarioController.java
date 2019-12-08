package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.connectiondb.persistence.UsuarioDAOBD;
import br.com.ifpb.ajudai.model.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginUsuarioController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario_email = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        UsuarioDAOBD userdb = new UsuarioDAOBD();
        Usuario usuario = null;
        try {
            usuario = userdb.searchUsuario(usuario_email);
            if(usuario!=null){
                if(senha.equals(String.valueOf(usuario.hashCode()))){
                    req.getSession().setAttribute("usuario",usuario);
                    resp.getWriter().println("redirecionar");
                }else{
                    resp.getWriter().println("erro");
                }
            }else{
                resp.getWriter().println("conta nao existe");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
