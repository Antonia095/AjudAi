package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.utilities.AdicionarConteudoUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adicionarlink")
public class AdicionarLinkController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = req.getParameter("link");
        String descricao = req.getParameter("descricao");
        String nomeConteudo = req.getParameter("nomeConteudo");
        AdicionarConteudoUtilities.addConteudo(nomeConteudo,descricao,link,req);
        req.getSession().setAttribute("conteudo",true);
    }
}
