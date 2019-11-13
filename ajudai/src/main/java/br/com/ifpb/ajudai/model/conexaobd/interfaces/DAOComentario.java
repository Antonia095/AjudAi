package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.ifpb.ajudai.model.entidades.Comentario;

public interface DAOComentario {

	public void excluir(int id) throws ClassNotFoundException, SQLException;
	public void add(Comentario comentario) throws ClassNotFoundException, SQLException;
	public List<Comentario> listar() throws ClassNotFoundException, SQLException;
}
