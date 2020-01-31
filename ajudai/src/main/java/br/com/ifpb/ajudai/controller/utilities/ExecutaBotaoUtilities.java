package br.com.ifpb.ajudai.controller.utilities;


import br.com.ifpb.ajudai.model.entities.Conteudo;
import br.com.ifpb.ajudai.model.entities.ConteudoEstante;
import br.com.ifpb.ajudai.model.entities.Prateleira;
import br.com.ifpb.ajudai.model.persistence.dao.AlertaDao;
import br.com.ifpb.ajudai.model.persistence.dao.ConteudoDao;
import br.com.ifpb.ajudai.model.persistence.dao.ConteudoEstanteDao;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ExecutaBotaoUtilities {
    public static boolean geraDenuncia(int codigo){
        Conteudo conteudo = buscaConteudo(codigo);
        try{
            if(conteudo==null){
                return false;
            }else{
                new AlertaDao().addEntities(conteudo);
                return true;
            }
        }catch (SQLException | ClassNotFoundException e){
            return false;
        }
    }

    private static Conteudo buscaConteudo(int codigo){
        try {
            return new ConteudoDao().buscaConteudo(codigo);
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }
    }

    public static void adicionaConteudoPrateleira(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getSession().getAttribute("listaEstante")==null){
           List<Prateleira> prateleiras = PrateleiraUtilities.recuperaPrateleiras(req);
           if(prateleiras!=null){
               req.getSession().setAttribute("listaEstante",true);
               resp.getWriter().print(new Gson().toJson(prateleiras));
           }
        }else{
            try{
                new ConteudoEstanteDao().addEntities(new ConteudoEstante(PrateleiraUtilities.idEstante(req),
                                Integer.parseInt(req.getParameter("codPra")),Integer.parseInt(req.getParameter("codigo"))));
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
            req.getSession().setAttribute("listaEstante",null);
            resp.getWriter().print("adicao");
        }
    }
}
