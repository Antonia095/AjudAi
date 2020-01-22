package br.com.ifpb.ajudai.controller.utilities;

import br.com.ifpb.ajudai.model.entities.Postagem;
import br.com.ifpb.ajudai.model.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class ConteudoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        Postagem postagem = new Postagem(LocalDate.now(),req.getParameter("descricao"),usuario.getNomeUsuario());
        if(req.getParameter("valor")!=null){

        }
    }
}
