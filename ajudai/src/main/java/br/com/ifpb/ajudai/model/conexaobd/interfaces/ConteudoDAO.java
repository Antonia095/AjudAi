package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Conteudo;

public interface ConteudoDAO {
    boolean adicionarConteudo();
    boolean removerConteudo();
    boolean atualizarContedudo();
    Conteudo buscarConteudo(Conteudo conteudo);
}
