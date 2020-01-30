package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;

public class Mensagem {
    private String titulo;
    private String texto;
    private LocalDate dataPublicacao;

    public Mensagem() {
    }

    public Mensagem(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public Mensagem(String titulo, String texto, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.texto = texto;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
