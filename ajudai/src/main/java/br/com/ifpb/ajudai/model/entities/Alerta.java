package br.com.ifpb.ajudai.model.entities;

public class Alerta {
    private int id;
    private String conteudo;

    public Alerta() {
    }

    public Alerta(int id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
