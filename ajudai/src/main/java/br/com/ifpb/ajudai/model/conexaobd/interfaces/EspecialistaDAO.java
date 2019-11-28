package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Especialista;

import java.sql.SQLException;

public interface EspecialistaDAO {
    boolean adicionarEspecialista(Especialista especialista) throws SQLException, ClassNotFoundException;
    boolean removerEspecialista(Especialista especialista) throws SQLException, ClassNotFoundException;
    boolean atualizarEspecialista(Especialista especialista) throws SQLException, ClassNotFoundException;
    Especialista buscarEspecialista(String nomeUsuario) throws SQLException, ClassNotFoundException;
}
