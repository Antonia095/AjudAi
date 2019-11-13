package br.com.ifpb.ajudai.model.entidades;

import java.sql.Date;

public class Comentario {
    private String descricao;
    private Date dataComentario;

    public Comentario(String descricao, Date dataComentario) {
        this.descricao = descricao;
        this.dataComentario = dataComentario;
    }
    public Comentario() {
    	
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(Date dataComentario) {
        this.dataComentario = dataComentario;
    }
}
