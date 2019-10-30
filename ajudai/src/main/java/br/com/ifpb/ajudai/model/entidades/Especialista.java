package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Especialista extends Usuario {
    private String descricao;
    private String[] areas;

    public Especialista(String nome, String nomeUsuario, LocalDate dataNascimento, String email,
                        String senha, String[] telefone, String descricao, String[] areas) {
        super(nome, nomeUsuario, dataNascimento, email, senha, telefone);
        this.descricao = descricao;
        this.areas = areas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[] getAreas() {
        return areas;
    }

    public void setAreas(String[] areas) {
        this.areas = areas;
    }
}
