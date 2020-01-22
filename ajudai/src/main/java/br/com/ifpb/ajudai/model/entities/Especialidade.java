package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;

public class Especialidade extends Usuario {
    private String area;

    public Especialidade() {
    }

    public Especialidade(String nomeUsuario, String nomeCompleto, LocalDate dataNascimento, String email, String imagem, String telefone, String senha, String area) {
        super(nomeUsuario, nomeCompleto, dataNascimento, email, imagem, telefone, senha);
        this.area = area;
    }

    public Especialidade(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
