package br.com.ifpb.ajudai.model.conexaobd.interfaces;

import br.com.ifpb.ajudai.model.entidades.Especialista;

public interface EspecialistaDAO {
    boolean adicionarEspecialista(Especialista especialista);
    boolean removerEspecialista(Especialista especialista);
    boolean atualizarEspecialista(Especialista especialista);
    Especialista buscarEspecialista(int id);
}
