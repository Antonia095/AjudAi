package br.com.ifpb.ajudai.controller.utilities;

import br.com.ifpb.ajudai.model.entities.Especialista;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.persistence.dao.EspecialistaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/gatilho")
public class GatilhhosUtilities extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("valor").equals("1")) {
            gatilhoBemVindo(req);
        } else if ((req.getParameter("valor").equals("2")) && (req.getSession().getAttribute("especialidade") == null)) {
            gatilhoEspecialistaConcluiCadastro(req, resp);
        } else if (req.getParameter("valor").equals("3")) {
            addEspecialidade(req, resp);
        } else if (req.getParameter("valor").equals("5")){
            req.getSession().setAttribute("conteudo",false);
            resp.getWriter().print("");
        }else{
            req.getSession().setAttribute("especialidade",false);
            resp.getWriter().print("");
        }
    }

    private void addEspecialidade(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        String descricao = (req.getParameter("descricao")==null) ? "" : req.getParameter("descricao");
        EspecialistaDao especialistaDao = new EspecialistaDao();
        req.getSession().setAttribute("especialidade",false);
        try{
            if(especialistaDao.updateEntities(new Especialista(usuario.getNomeUsuario(),descricao))){
                resp.getWriter().print("");

            }else{
                resp.getWriter().print("erro");
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    private void gatilhoBemVindo(HttpServletRequest req){
        req.getSession().setAttribute("bemVindo",false);
    }

    private void gatilhoEspecialistaConcluiCadastro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        EspecialistaDao especialistaDao = new EspecialistaDao();
        try{
            if(especialistaDao.searchEntities(usuario.getNomeUsuario())==null){
                req.getSession().setAttribute("especialidade",true);
                resp.getWriter().print("concluir");
            }
        }catch (SQLException | ClassNotFoundException e){
            resp.getWriter().print("");
        }
        resp.getWriter().print("");
    }

}
