package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
    private String nomeUsuario;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String telefone;
    private boolean situacao;

    public Usuario(String nomeUsuario, String nomeCompleto, String email, String telefone, boolean situacao) {
        this.nomeUsuario = nomeUsuario;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.situacao = situacao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public boolean getSituacao() {
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
