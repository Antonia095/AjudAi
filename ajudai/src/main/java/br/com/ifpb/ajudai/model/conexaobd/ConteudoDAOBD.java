package br.com.ifpb.ajudai.model.conexaobd;

import br.com.ifpb.ajudai.model.conexaobd.interfaces.ConteudoDAO;
import br.com.ifpb.ajudai.model.entidades.Conteudo;

public class ConteudoDAOBD implements ConteudoDAO {



    @Override
    public boolean adicionarConteudo() {

    }

    @Override
    public boolean removerConteudo() {
        return false;
    }

    @Override
    public boolean atualizarContedudo() {
        return false;
    }

    @Override
    public Conteudo buscarConteudo(Conteudo conteudo) {
        return null;
    }
}
