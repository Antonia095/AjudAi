package br.com.ifpb.ajudai.controller;


import br.com.ifpb.ajudai.controller.utilities.ExecutaBotaoUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/executabotao")
public class ExecutaBotaoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String botao = req.getParameter("botao");
        String codigo = req.getParameter("codigo");
        boolean resultado = false;
        if(botao.equals("1")){

        }else if(botao.equals("2")){

        }else{
            resultado = (ExecutaBotaoUtilities.geraDenuncia(Integer.parseInt(codigo))) ?true :false;
            resposta(resultado,resp);
        }
    }

    private void resposta(boolean resultado, HttpServletResponse resp) throws IOException {
        if(resultado){
            resp.getWriter().print("sucesso");
        }else{
            resp.getWriter().print("");
        }
    }
}
