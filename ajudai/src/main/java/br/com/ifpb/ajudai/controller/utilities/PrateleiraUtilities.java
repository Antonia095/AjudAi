package br.com.ifpb.ajudai.controller.utilities;

import br.com.ifpb.ajudai.model.entities.Estante;
import br.com.ifpb.ajudai.model.entities.Prateleira;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.persistence.dao.EstanteDao;
import br.com.ifpb.ajudai.model.persistence.dao.PrateleiraDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class PrateleiraUtilities {
    public static int idEstante(HttpServletRequest req){
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        EstanteDao estanteDao = new EstanteDao();
        int idEstante = 0;
        try{
            idEstante = (int) estanteDao.searchEntities(usuario.getNomeUsuario());
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return idEstante;
    }

    public static List<Prateleira> recuperaPrateleiras(HttpServletRequest req){
        PrateleiraDao prateleiraDao = new PrateleiraDao();
        List<Prateleira> prateleiras = null;
        try{
            prateleiras = prateleiraDao.listaPrateleiras(idEstante(req));
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return prateleiras;
    }

    public static void setaPrateleiras(HttpServletRequest req){
        Estante estante = new Estante();
        if(recuperaPrateleiras(req)!=null){
            estante.setPrateleiras(recuperaPrateleiras(req));
            req.getSession().setAttribute("estante",estante);
        }
    }
}
