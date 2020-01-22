package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(!usuario.getImagem().toUpperCase().equals("IMAGES/USER.SVG")){
            File imagem = new File("../webapp/"+usuario.getImagem());
            imagem.delete();
        }
        session.invalidate();
        resp.sendRedirect("pages/usuario/usuario.jsp");
    }
}
