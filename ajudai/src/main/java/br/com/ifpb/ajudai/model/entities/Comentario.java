package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;

public class Comentario {
    private int id;
    private String descricao;
    private LocalDate dataPostagem;
    private int codPostagem;

    public Comentario() {

    }

    public Comentario(int id, String descricao, LocalDate dataPostagem, int codPostagem) {
        this.id = id;
        this.descricao = descricao;
        this.dataPostagem = dataPostagem;
        this.codPostagem = codPostagem;
    }

    public Comentario(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
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

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public int getCodPostagem() {
        return codPostagem;
    }

    public void setCodPostagem(int codPostagem) {
        this.codPostagem = codPostagem;
    }
}
