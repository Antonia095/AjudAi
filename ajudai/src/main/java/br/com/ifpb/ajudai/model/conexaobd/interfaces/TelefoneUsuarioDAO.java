package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Especialista;
import br.com.ifpb.ajudai.model.entidades.Usuario;

import java.sql.SQLException;

public interface TelefoneUsuarioDAO {
    boolean adicionarTelefone(String nomeUsuario, String telefone) throws SQLException, ClassNotFoundException;
    boolean removerTelefone(String nomeUsuario, String telefone) throws SQLException, ClassNotFoundException;
    boolean atualizarTelefone(String nomeUsuario, String telefone) throws SQLException, ClassNotFoundException;
    String[] buscarTelefones(Usuario usuario) throws SQLException, ClassNotFoundException;
}
