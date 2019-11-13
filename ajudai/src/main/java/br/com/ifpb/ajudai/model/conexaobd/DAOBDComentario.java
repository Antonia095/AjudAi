package br.com.ifpb.ajudai.model.conexaobd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.ajudai.model.conexaobd.interfaces.DAOComentario;
import br.com.ifpb.ajudai.model.entidades.Comentario;
import br.edu.ifpb.pweb1.model.Livro;


public class DAOBDComentario implements DAOComentario{

	private ConnectionFactory con;
	
	public DAOBDComentario() {
		con = new ConnectionFactory();
	}

	@Override
	public void excluir(int id) throws ClassNotFoundException, SQLException {
		this.con.getConnetion();
		String query = "DELETE FROM comentario WHERE id = ?";
		PreparedStatement statement = this.con.getConnetion().prepareStatement(query);
		statement.setInt(1, id);
		statement.executeUpdate();
	}

	@Override
	public void add(Comentario comentario) throws ClassNotFoundException, SQLException {
		this.con.getConnetion();
		String query = "INSERT INTO comentario (, , , ) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = this.con.getConnetion().prepareStatement(query);
		statement.executeUpdate();
	}

	@Override
	public List<Comentario> listar() throws ClassNotFoundException, SQLException {
		this.con.getConnetion();
		String query = "SELECT * FROM comentario";
		PreparedStatement statement = this.con.getConnetion().prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<Comentario> comentario = new ArrayList<>();
		while (result.next()) {
			Comentario coment = new Comentario();
			coment.setDescricao(result.getString("descricao"));
			coment.setDataComentario(result.getDate("datacometario"));
			comentario.add(coment);
		}
		return null;
	}

}
