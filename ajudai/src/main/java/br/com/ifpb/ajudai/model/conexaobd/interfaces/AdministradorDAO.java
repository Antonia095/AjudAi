package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Administrador;

import java.sql.SQLException;

public interface AdministradorDAO {
    boolean atualizarAdministrador(Administrador administrador) throws SQLException, ClassNotFoundException;
}
