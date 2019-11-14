package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import java.sql.SQLException;

import br.com.ifpb.ajudai.model.entidades.Usuario;

public interface DAOEstante {
	public void add(Usuario usuario) throws ClassNotFoundException, SQLException;
}
