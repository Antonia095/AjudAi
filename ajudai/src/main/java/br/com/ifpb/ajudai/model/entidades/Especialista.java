package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Especialista extends Usuario {
    private String descricao;
    private String[] areas;

    public Especialista(String nomeUsuario, String nomeCompleto, String email,
                        String telefone, boolean situacao) {
        super(nomeUsuario, nomeCompleto, email, telefone, situacao);

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
