package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Postagem {
    private int codigo;
    private String area;
    private String descricao;
    private LocalDate dataPostagem;
    private Usuario usuario;
    private List<Comentario> comentarios;

    public Postagem() {
        this.usuario = new Usuario();
        this.comentarios = new ArrayList<>();
    }

    public Postagem(int codigo, String area, String descricao, LocalDate dataPostagem) {
        this.codigo = codigo;
        this.area = area;
        this.descricao = descricao;
        this.dataPostagem = dataPostagem;
        this.usuario = new Usuario();
        this.comentarios = new ArrayList<>();
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getNomeUsuario(){
        return usuario.getNomeUsuario();
    }
}
