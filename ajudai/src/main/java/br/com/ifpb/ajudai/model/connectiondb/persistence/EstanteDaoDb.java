package br.com.ifpb.ajudai.model.connectiondb.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifpb.ajudai.model.connectiondb.configconnection.Postgre;
import br.com.ifpb.ajudai.model.connectiondb.interfaces.EstanteDao;
import br.com.ifpb.ajudai.model.entities.Estante;

public class EstanteDaoDb implements EstanteDao {

	private Postgre postgre;
	
	public EstanteDaoDb() {
		postgre = new Postgre();
	}

	@Override
	public boolean criar(Estante estante, String nomeUsuario) throws SQLException, ClassNotFoundException {
		
		try(Connection connection = postgre.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ESTANTE(datacriacao,nomeusuario) VALUES(?,?)");
			Date data = new Date(System.currentTimeMillis());
			statement.setDate(1, data);
			statement.setString(2, nomeUsuario);
			return statement.executeUpdate()>0;
		
		}
	}
	
	

}
