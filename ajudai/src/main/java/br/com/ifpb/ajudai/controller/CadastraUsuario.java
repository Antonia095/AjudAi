package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.conexaobd.UsuarioDAOBD;
import br.com.ifpb.ajudai.model.entidades.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/cadastrar")
public class CadastraUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Usuario usuario = new Usuario(req.getParameter("nomeUsuario"),
                req.getParameter("nomeCompleto"),
                LocalDate.parse(req.getParameter("dataNascimento"),formatter)
                ,req.getParameter("email"),
                req.getParameter("senha"),true);

        try {
            UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
            usuarioDAOBD.adicionarUsuario(usuario);
            req.getRequestDispatcher("sucesso.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(500);
        } catch (ClassNotFoundException e) {
            resp.sendError(501);
        }
    }
}
