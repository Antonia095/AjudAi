package br.com.ifpb.ajudai.model.entities;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Conteudo {
    private int codigo;
    private String nome;
    private String local;
    private String descricao;

    private List<Postagem> postagens;

    public Conteudo() {
        postagens = new ArrayList<>();
    }

    public Conteudo(int codigo, String nome, String local) {
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;
        postagens = new ArrayList<>();
    }

    public Conteudo(String nome, String local, String descricao) {
        this.nome = nome;
        this.local = local;
        this.descricao = descricao;
        postagens = new ArrayList<>();
    }

    public Conteudo(String nome, String local){
        this.nome = nome;
        this.local = local;
        postagens = new ArrayList<>();
    }

    public Conteudo(int codigo, String local) {
        this.codigo = codigo;
        this.local = local;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
