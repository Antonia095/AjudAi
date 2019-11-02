package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Conteudo;
import br.com.ifpb.ajudai.model.entidades.Especialista;

import java.sql.SQLException;

public interface ConteudoDAO {
    boolean adicionarConteudo(Especialista especialista) throws SQLException, ClassNotFoundException;
    boolean removerConteudo(Especialista especialista);
    boolean atualizarContedudo(Especialista especialista);
    Conteudo buscarConteudo(int id);
}
