package br.com.ifpb.ajudai.model.conexaobd.interfaces;

public interface Prateleira {
    boolean adicionarPrateleira();
    boolean removerPrateleira();
    boolean atualizarPrateleira();
    Prateleira buscarPrateleira(String nome);
}
