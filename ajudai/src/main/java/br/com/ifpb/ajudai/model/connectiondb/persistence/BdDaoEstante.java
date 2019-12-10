package br.com.ifpb.ajudai.model.connectiondb.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifpb.ajudai.model.connectiondb.configconnection.Postgre;
import br.com.ifpb.ajudai.model.connectiondb.interfaces.DAOestante;
import br.com.ifpb.ajudai.model.entities.Estante;

public class BdDaoEstante implements DAOestante{

	private Postgre con;
	
	public BdDaoEstante() {
		con = new Postgre();
	}

	@Override
	public void criar(Estante estante, String nomeUsuario) {
		
		try(Connection connection = con.getConnetion()){
			
            PreparedStatement statement;
			statement = connection.prepareStatement("INSERT INTO ESTANTE(datacriacao,nomeusuario) VALUES(?,?)");
			Date data = new Date(System.currentTimeMillis());
			statement.setDate(1, data);
			statement.setString(2, nomeUsuario);
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	

}
