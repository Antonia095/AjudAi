package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.persistence.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/excluirconta")
public class ExcliuContaController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDao usuarioDao = new UsuarioDao();
        try{
            usuarioDao.removeEntities(req.getSession().getAttribute("usuario"));
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LogoutController logout = new LogoutController();
        logout.doGet(req,resp);

    }
}
