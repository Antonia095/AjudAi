package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;

public class Estante {
    private int id;
    private LocalDate dataCriacao;

    public Estante(){}

    public Estante(int id, LocalDate dataCriacao) {
        this.id = id;
        this.dataCriacao = dataCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
