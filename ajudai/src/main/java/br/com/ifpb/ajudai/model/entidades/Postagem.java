package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Postagem {
    private String descricao;
    private LocalDate dataPostagem;

    public Postagem(String descricao, LocalDate dataPostagem) {
        this.descricao = descricao;
        this.dataPostagem = dataPostagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }
}
