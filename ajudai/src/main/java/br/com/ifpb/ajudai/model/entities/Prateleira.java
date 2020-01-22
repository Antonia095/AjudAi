package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prateleira {
    private int codigo;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private String tipo;
    private int idEstante;
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

    public Prateleira(String nome, String descricao, String tipo, int idEstante) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.idEstante = idEstante;
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

    public int getIdEstante() {
        return idEstante;
    }

    public void setIdEstante(int idEstante) {
        this.idEstante = idEstante;
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

    public String codString(){
        return this.nome.substring(0,2) + String.valueOf(this.codigo);
    }
}
