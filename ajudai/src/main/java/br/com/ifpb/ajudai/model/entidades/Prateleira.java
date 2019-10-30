package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Prateleira {
    private String descricao;
    private LocalDate dataCriacao;
    private String tipo;

    public Prateleira(String descricao, LocalDate dataCriacao, String tipo) {
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
