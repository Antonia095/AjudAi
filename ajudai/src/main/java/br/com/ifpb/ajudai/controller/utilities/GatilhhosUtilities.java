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
            gatilhoBemVindo(req);
            acionaIncricaoEspecialista(req,resp);
            if(req.getParameter("valor")!=null){
                Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
                try{
                    new EspecialistaDao().updateEntities(new Especialista(usuario.getNomeUsuario(), req.getParameter("descricao")));
                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
    }

    private void gatilhoBemVindo(HttpServletRequest req){
        req.getSession().setAttribute("bemVindo",false);
    }

    private void acionaIncricaoEspecialista(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        EspecialistaDao especialistaDao = new EspecialistaDao();
        try{
            if(especialistaDao.searchEntities(usuario.getNomeUsuario())==null){
                resp.getWriter().print("concluir");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        resp.getWriter().print("");
    }
}
