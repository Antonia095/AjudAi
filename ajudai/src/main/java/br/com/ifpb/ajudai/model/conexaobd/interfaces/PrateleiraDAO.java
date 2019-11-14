package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Conteudo;
import br.com.ifpb.ajudai.model.entidades.Prateleira;

import java.sql.SQLException;
import java.util.List;


public interface PrateleiraDAO {
    boolean adicionarPrateleira(Prateleira prateleira) throws SQLException, ClassNotFoundException;
    boolean removerPrateleira(Prateleira prateleira) throws SQLException, ClassNotFoundException;
    Prateleira atualizarPrateleira(Prateleira prateleira) throws SQLException, ClassNotFoundException;
    List listarPrateleiras() throws SQLException, ClassNotFoundException;

}
