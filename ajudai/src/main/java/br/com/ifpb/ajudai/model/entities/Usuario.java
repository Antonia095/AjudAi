package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
    private String nomeUsuario;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String imagem;
    private String telefone;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nomeUsuario, String nomeCompleto, LocalDate dataNascimento, String telefone) {
        this.nomeUsuario = nomeUsuario;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Usuario(String nomeUsuario, String nomeCompleto, LocalDate dataNascimento,
                   String email, String imagem, String telefone, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.imagem = imagem;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario(String nomeUsuario, String nomeCompleto, String email, String telefone) {
        this.nomeUsuario = nomeUsuario;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(senha);
    }
}
