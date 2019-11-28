package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.model.conexaobd.persistencia.UsuarioDAOBD;
import br.com.ifpb.ajudai.model.entidades.Especialista;
import br.com.ifpb.ajudai.model.entidades.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@WebServlet("/continuar")
public class CadastraUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(req.getParameter("tipo").toUpperCase().equals("ESTUDANTE")){
            Usuario usuario = new Usuario(req.getParameter("nomeUsuario"),req.getParameter("nome"),
                    req.getParameter("email"),req.getParameter("telefone"),true);
            usuario.setSenha(req.getParameter("senha"));
            usuario.setDataNascimento(LocalDate.parse(req.getParameter("dataNascimento"),formato));
            session.setAttribute("usuario",usuario);
            session.setAttribute("tipo",1);
            UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
            try {
                usuarioDAOBD.adicionarUsuario(usuario);
                req.getRequestDispatcher("usuario.jsp").forward(req,resp);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else {
            Especialista especialista = new Especialista(req.getParameter("nomeUsuario"),req.getParameter("nome"),
                    req.getParameter("email"),req.getParameter("telefone"),true);
            session.setAttribute("especialista",especialista);
            session.setAttribute("tipo",2);
        }
        req.setAttribute("especialidades", Arrays.asList("Web", "Banco",
                "Estrutura de Dados","APS"));
        req.getRequestDispatcher("formulario.jsp").forward(req,resp);
    }
}
