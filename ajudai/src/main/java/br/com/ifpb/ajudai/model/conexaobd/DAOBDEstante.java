package br.com.ifpb.ajudai.model.conexaobd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifpb.ajudai.model.conexaobd.interfaces.DAOEstante;
import br.com.ifpb.ajudai.model.entidades.Usuario;

public class DAOBDEstante implements DAOEstante {

	private ConnectionFactory con;
	
	public DAOBDEstante() {
		con = new ConnectionFactory();
	}

	@Override
	public void add(Usuario usuario) throws ClassNotFoundException, SQLException {
		this.con.getConnetion();
		String query = "INSERT INTO estante () VALUES ()";
		PreparedStatement statement = this.con.getConnetion().prepareStatement(query);
		statement.executeUpdate();
	}

}
