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
        int codPrateleira = Integer.parseInt(req.getParameter("codPra"));
        int codConteudo = Integer.parseInt(String.valueOf(req.getSession().getAttribute("codConteudoAdd")));
        ConteudoEstanteDao conteudoEstanteDao = new ConteudoEstanteDao();
        try{
            if(conteudoEstanteDao.existeNaEstante(codPrateleira,codConteudo)){
                resp.getWriter().print("estaprateleira");
            }else{
                conteudoEstanteDao.addEntities(new ConteudoEstante(PrateleiraUtilities.idEstante(req),codPrateleira,codConteudo));
                resp.getWriter().print("adicao");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
