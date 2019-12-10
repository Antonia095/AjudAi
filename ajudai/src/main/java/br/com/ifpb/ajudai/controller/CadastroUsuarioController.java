package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.validators.ValidadorCadastro;
import br.com.ifpb.ajudai.model.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/cadastrar")
public class CadastroUsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if(ValidadorCadastro.validadorNomeUsuario(req.getParameter("nomeUsuario"))){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Usuario usuario = new Usuario(req.getParameter("nomeCompleto"),req.getParameter("nomeUsuario"),
                        req.getParameter("telefone"), LocalDate.parse(req.getParameter("data"),formatter));
            }else{
                resp.getWriter().println("existe");
            }
    }
}
