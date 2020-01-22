package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.utilities.EmailUtilities;
import br.com.ifpb.ajudai.controller.utilities.LoginCadastroUtilities;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.persistence.dao.EspecialistaDao;
import br.com.ifpb.ajudai.model.persistence.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = null;

        if(req.getParameter("valor").equals("1")){
            String nomeUsuario = req.getParameter("nomeUsuario");
            String nomeCompleto = req.getParameter("nomeCompleto");
            String email = req.getParameter("email");
            String telefone = req.getParameter("telefone");
            usuario = new Usuario(nomeUsuario,nomeCompleto,email,telefone);
            req.getSession().setAttribute("cadastro",usuario);
            req.getSession().setAttribute("init",2);
            String resposta = LoginCadastroUtilities.existenciaUsuario(nomeUsuario,email);
            resp.getWriter().print(resposta);

        }else if(req.getParameter("valor").equals("2")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            usuario = (Usuario) req.getSession().getAttribute("cadastro");
            usuario.setDataNascimento(LocalDate.parse(req.getParameter("nascimento"),formatter));
            usuario.setSenha(req.getParameter("senha"));
            usuario.setImagem("images/user.svg");
            req.getSession().setAttribute("init",1);
            if(req.getParameter("tipoUsuario").toUpperCase().equals("ESTUDANTE")){
                UsuarioDao usuarioDao = new UsuarioDao();
                try {
                    usuarioDao.addEntities(usuario);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else{
                EspecialistaDao especialistaDao = new EspecialistaDao();
                try{
                    especialistaDao.addEntities(LoginCadastroUtilities.realizaMudanca(usuario,""));
                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
            req.getSession().setAttribute("cadastro",usuario);
            usuario = (Usuario) req.getSession().getAttribute("cadastro");
            String emailDestinatario = usuario.getEmail();
            String codAcesso = LoginCadastroUtilities.geraCodigoAcesso();
            req.getSession().setAttribute("acesso",codAcesso);
            EmailUtilities emailUtilities = new EmailUtilities(codAcesso);
            emailUtilities.enviarEmail(emailDestinatario);
        }else{
            String codigo = (String) req.getSession().getAttribute("acesso");
            if(req.getParameter("codigo").toUpperCase().equals(codigo.toUpperCase())){
                usuario = (Usuario) req.getSession().getAttribute("cadastro");
                req.getSession().setAttribute("usuario", usuario);
                try {
                    new UsuarioDao().atualizaAcesso(usuario.getNomeUsuario());
                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }
                req.getSession().setAttribute("bemVindo",true);
                resp.getWriter().print("");
            }else{
                resp.getWriter().print("Codigo Errado");
            }
        }
    }
}
