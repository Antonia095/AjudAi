package br.com.ifpb.ajudai.controller.utilities;


import br.com.ifpb.ajudai.model.entities.Conteudo;
import br.com.ifpb.ajudai.model.persistence.dao.AlertaDao;
import br.com.ifpb.ajudai.model.persistence.dao.ConteudoDao;

import java.sql.SQLException;

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
}
