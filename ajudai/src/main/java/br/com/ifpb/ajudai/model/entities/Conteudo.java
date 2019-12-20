package br.com.ifpb.ajudai.model.entities;

public class Conteudo {
    private int codigo;
    private String nome;
    private String local;

    public Conteudo() {
    }

    public Conteudo(int codigo, String nome, String local) {
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
