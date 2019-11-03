package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Conteudo;
import br.com.ifpb.ajudai.model.entidades.Especialista;

import java.sql.SQLException;

public interface ConteudoDAO {
    boolean adicionarConteudo(Conteudo conteudo) throws SQLException, ClassNotFoundException;
    boolean removerConteudo(Conteudo conteudo);
    boolean atualizarContedudo(Conteudo conteudo);
    Conteudo buscarConteudo(int id);
}
