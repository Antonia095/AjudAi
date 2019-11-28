package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Usuario;

import java.sql.SQLException;

public interface UsuarioDAO {
    boolean adicionarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    boolean removerUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    boolean atualizarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    Usuario buscarUsuario(String nomeUsuario) throws SQLException, ClassNotFoundException;
}