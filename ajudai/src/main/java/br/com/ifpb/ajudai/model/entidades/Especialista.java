package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Especialista extends Usuario {
    private String descricao;
    private String[] areas;

    public Especialista(String nomeUsuario, String nomeCompleto, LocalDate dataNascimento, String email,
                        String senha, String[] telefone, boolean situacao, String descricao, String[] areas) {
        super(nomeUsuario, nomeCompleto, dataNascimento, email, senha, telefone, situacao);
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
