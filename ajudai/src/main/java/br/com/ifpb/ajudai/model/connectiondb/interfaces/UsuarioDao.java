package br.com.ifpb.ajudai.model.connectiondb.interfaces;

import br.com.ifpb.ajudai.model.entities.Usuario;

import java.sql.SQLException;

public interface UsuarioDao {
    boolean addUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    boolean removeUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    boolean updateUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    Usuario searchUsuario(String id) throws SQLException, ClassNotFoundException;
}