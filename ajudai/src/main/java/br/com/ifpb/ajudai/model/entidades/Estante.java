package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Estante {
    private LocalDate dataCriacao;

    public Estante(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
