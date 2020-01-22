package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Postagem {
    private int codigo;
    private String area;
    private String descricao;
    private LocalDate dataPostagem;
    private String nomeUsuario;
    private List<Comentario> comentarios;

    public Postagem() {
        this.comentarios = new ArrayList<>();
    }

    public Postagem(int codigo, String area, String descricao, LocalDate dataPostagem, String nomeUsuario) {
        this.codigo = codigo;
        this.area = area;
        this.descricao = descricao;
        this.dataPostagem = dataPostagem;
        this.nomeUsuario = nomeUsuario;
        this.comentarios = new ArrayList<>();
    }

    public Postagem(LocalDate dataPostagem, String descricao, String nomeUsuario){
        this.dataPostagem = dataPostagem;
        this.descricao = descricao;
        this.nomeUsuario = nomeUsuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public boolean addEntities(Object object) {
        return comentarios.add((Comentario)object);
    }

    public boolean removeEntities(Object object) {
        return comentarios.remove((Comentario)object);
    }
}
