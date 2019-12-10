package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;

public class Postagem {
    private int codigo;
    private String area;
    private String descricao;
    private LocalDate dataPostagem;
    private Usuario usuario;

    public Postagem() {
        this.usuario = new Usuario();
    }

    public Postagem(int codigo, String area, String descricao, LocalDate dataPostagem) {
        this.codigo = codigo;
        this.area = area;
        this.descricao = descricao;
        this.dataPostagem = dataPostagem;
        this.usuario = new Usuario();
    }


}
