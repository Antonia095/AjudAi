package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;

public class Administrador {
    private String codigo;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Administrador() {
    }

    public Administrador(String nome, String email, String senha, LocalDate dataInicio) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataInicio = dataInicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
