package br.com.ifpb.ajudai.model.entidades;

public class Conteudo {
    private String nome;
    private String local;

    public Conteudo(String nome, String local) {
        this.nome = nome;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
