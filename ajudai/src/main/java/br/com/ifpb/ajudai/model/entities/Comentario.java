package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;

public class Comentario {
    private int id;
    private String descricao;
    private LocalDate dataComentario;

    public Comentario() {
    }

    public Comentario(int id, String descricao, LocalDate dataComentario) {
        this.id = id;
        this.descricao = descricao;
        this.dataComentario = dataComentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
