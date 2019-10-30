package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
    private int codigo;
    private String nomeCompleto;
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String[] telefone;
    private boolean situacao;

    public Usuario(String nomeCompleto, String nomeUsuario, LocalDate dataNascimento, String email,
                   String senha, String[] telefone, boolean situacao) {
        this.nomeCompleto = nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.situacao = situacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nome) {
        this.nomeCompleto = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String[] getTelefone() {
        return telefone;
    }

    public void setTelefone(String[] telefone) {
        this.telefone = telefone;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(senha);
    }
}
