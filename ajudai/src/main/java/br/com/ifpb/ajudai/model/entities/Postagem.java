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
    private int codConteudo;
    private List<Comentario> comentarios;

    public Postagem() {
        this.comentarios = new ArrayList<>();
    }

    public Postagem(String descricao, LocalDate dataPostagem, String nomeUsuario, int codConteudo) {
        this.codigo = codigo;
        this.area = area;
        this.descricao = descricao;
        this.dataPostagem = dataPostagem;
        this.nomeUsuario = nomeUsuario;
        this.codConteudo = codConteudo;
    }

    public Postagem(int codigo, String descricao, int codConteudo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.codConteudo = codConteudo;
    }

    public Postagem(int codigo, String area, String descricao, LocalDate dataPostagem, String nomeUsuario, int codConteudo) {
        this.codigo = codigo;
        this.area = area;
        this.descricao = descricao;
        this.dataPostagem = dataPostagem;
        this.nomeUsuario = nomeUsuario;
        this.codConteudo = codConteudo;
        this.comentarios = new ArrayList<>();
    }

    public Postagem(LocalDate dataPostagem, String descricao, String nomeUsuario){
        this.dataPostagem = dataPostagem;
        this.descricao = descricao;
        this.nomeUsuario = nomeUsuario;
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getCodConteudo() {
        return codConteudo;
    }

    public void setCodConteudo(int codConteudo) {
        this.codConteudo = codConteudo;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public boolean addEntities(Object object) {
        return comentarios.add((Comentario)object);
    }

    public boolean removeEntities(Object object) {
        return comentarios.remove((Comentario)object);
    }
}
