package br.com.ifpb.ajudai.model.connectiondb.interfaces;

import br.com.ifpb.ajudai.model.entities.Estante;

import java.sql.SQLException;

public interface EstanteDao {
		
	boolean criar(Estante estante,String nomeUsuario) throws SQLException, ClassNotFoundException;
	
}
