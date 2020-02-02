package br.com.ifpb.ajudai.controller;


import br.com.ifpb.ajudai.controller.utilities.ExecutaBotaoUtilities;
import br.com.ifpb.ajudai.controller.utilities.PrateleiraUtilities;
import br.com.ifpb.ajudai.model.entities.Estante;
import br.com.ifpb.ajudai.model.entities.Prateleira;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/executabotao")
public class ExecutaBotaoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String botao = req.getParameter("botao");
        String codigo = req.getParameter("codigo");
        if(botao.equals("1")){
            ExecutaBotaoUtilities.adicionaConteudoPrateleira(req,resp);
        }else if(botao.equals("2")){

        }else if(botao.equals("4")){
            Estante estante = (Estante) req.getSession().getAttribute("estante");
            if(!estante.getPrateleiras().isEmpty()){
                req.getSession().setAttribute("codConteudoAdd",codigo);
                resp.getWriter().print("existePrateleira");
            }else{
                resp.getWriter().print("Sua estante está vazia");
            }
        }else if(botao.equals("3")){

        }
    }


}
