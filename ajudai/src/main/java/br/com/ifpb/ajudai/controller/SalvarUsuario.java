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


@WebServlet("/salvar")
public class SalvarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        int tipo = (int) session.getAttribute("tipo");
        if(tipo==1){
            try {
                usuarioDAOBD.adicionarUsuario((Usuario) session.getAttribute("usuario"));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }else{
            Especialista especialista = (Especialista) session.getAttribute("especialista");
            especialista.setDescricao(req.getParameter("descricao"));
            System.out.println(especialista);
            req.getRequestDispatcher("usuario.jsp").forward(req,resp);
        }

    }
}
