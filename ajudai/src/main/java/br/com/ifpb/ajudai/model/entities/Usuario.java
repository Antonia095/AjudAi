package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
    private String nomeCompleto;
    private String nomeUsuario;
    private String telefone;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private Estante estante;


    public Usuario() {
    }

    public Usuario(String nomeCompleto, String nomeUsuario, String telefone,
                   String email, String senha, LocalDate dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Estante getEstante() {
        return estante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(senha);
    }
}
