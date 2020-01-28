package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.entities.Busca;
import br.com.ifpb.ajudai.model.persistence.dao.ConteudoDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/buscaconteudo")
public class BuscaConteudoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String texto = req.getParameter("busca");
        ConteudoDao conteudoDao = new ConteudoDao();
        Gson gson = new Gson();
        if(texto.length()>2){
            try{
                if((conteudoDao.searchEntities(texto)!=null)&&((Busca)conteudoDao.searchEntities(texto)).getCodConteudos().isEmpty()!=true){
                    resp.getWriter().print(gson.toJson(conteudoDao.searchEntities(texto)));
                }else{
                    resp.getWriter().print("");
                }
            }catch (SQLException | ClassNotFoundException e){
                resp.getWriter().print("");
            }
        }else{
            resp.getWriter().print("");
        }
    }
}
