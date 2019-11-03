package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;
import java.util.List;

public class Prateleira {
    private String descricao;
    private LocalDate dataCriacao;
    private String tipo;
    private List<Conteudo> conteudos;

    public Prateleira(String descricao, LocalDate dataCriacao, String tipo, List<Conteudo> conteudos) {
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.tipo = tipo;
        this.conteudos = conteudos;
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

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
}
