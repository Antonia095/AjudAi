package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.conexaobd.persistencia.UsuarioDAOBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cadastrar")
public class CadastraUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valor = req.getParameter("usuario");
        try {
            UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
            usuarioDAOBD.removerUsuario(valor);
            req.getRequestDispatcher("sucesso.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(500);
        } catch (ClassNotFoundException e) {
            resp.sendError(501);
        }
    }
}
