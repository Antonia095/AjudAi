package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.utilities.LoginCadastroUtilities;
import br.com.ifpb.ajudai.model.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/etapaum")
public class EtapaUmController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("tipo")!=null){
            String nomeCompleto = req.getParameter("nomeCompleto");
            String nomeUsuario = req.getParameter("nomeUsuario");
            String email = req.getParameter("email");
            String telefone = req.getParameter("telefone");
            Usuario usuario = new Usuario(nomeUsuario,nomeCompleto,email,telefone);
            String busca = LoginCadastroUtilities.existenciaUsuario(nomeUsuario,email);
            if(busca.length()==0){
                req.getSession().setAttribute("user",usuario);
                resp.getWriter().print("");
            }else{
                resp.getWriter().print(busca);
            }
        }
    }
}
