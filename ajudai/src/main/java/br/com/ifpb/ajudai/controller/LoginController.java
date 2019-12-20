package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.utilities.ImagemCaminhoUtilities;
import br.com.ifpb.ajudai.controller.utilities.LoginCadastroUtilities;
import br.com.ifpb.ajudai.model.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String senha = req.getParameter("senha");
        String resultado = LoginCadastroUtilities.usuarioExistente(id,senha);
        if(resultado.toUpperCase().equals("SUCESSO")){
            Usuario usuario = LoginCadastroUtilities.buscaUsuario(id);
            String imagem = ImagemCaminhoUtilities.seta(usuario,req);
            usuario.setImagem(imagem);
            req.getSession().setAttribute("usuario",usuario);
            resp.getWriter().print(resultado);
        }else{
            resp.getWriter().print(resultado);
        }
    }
}
