package br.com.ifpb.ajudai.model.entities;

import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prateleira {
    private int codigo;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private String tipo;
    private List<Conteudo> conteudos;

    public Prateleira() {
        this.conteudos = new ArrayList<>();
    }

    public Prateleira(int codigo, String nome, String descricao, LocalDate dataCriacao, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.tipo = tipo;
        this.conteudos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean addEntities(Object object) {
        return conteudos.add((Conteudo) object);
    }

    public boolean removeEntities(Object object) {
        return conteudos.remove((Conteudo)object);
    }
}
