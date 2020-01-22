package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.utilities.PrateleiraUtilities;
import br.com.ifpb.ajudai.model.entities.Prateleira;
import br.com.ifpb.ajudai.model.persistence.dao.PrateleiraDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/criapraleira")
public class CriaPrateleiraController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeEstante = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String tipo = req.getParameter("tipo");
        PrateleiraDao prateleiraDao = new PrateleiraDao();
        try{
            prateleiraDao.addEntities(new Prateleira(nomeEstante,descricao,tipo, PrateleiraUtilities.idEstante(req)));
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        PrateleiraUtilities.setaPrateleiras(req);
    }
}
