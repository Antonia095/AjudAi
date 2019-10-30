package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Comentario {
    private String descricao;
    private LocalDate dataComentario;

    public Comentario(String descricao, LocalDate dataComentario) {
        this.descricao = descricao;
        this.dataComentario = dataComentario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(LocalDate dataComentario) {
        this.dataComentario = dataComentario;
    }
}
