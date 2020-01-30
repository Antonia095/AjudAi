package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.entities.Mensagem;
import br.com.ifpb.ajudai.model.persistence.dao.MensagemDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/notificacao")
public class ListaMensagemController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Mensagem> mensagens = (List<Mensagem>) new MensagemDao().searchEntities("");
            if(!mensagens.isEmpty()){
                resp.getWriter().print(new Gson().toJson(mensagens));
            }else{
                resp.getWriter().print("");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
