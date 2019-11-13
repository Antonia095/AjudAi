package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import java.util.List;

import br.com.ifpb.ajudai.model.entidades.Comentario;

public interface DAOComentario {

	public void excluir(int id);
	public void add(Comentario comentario);
	public List<Comentario> listar();
}
