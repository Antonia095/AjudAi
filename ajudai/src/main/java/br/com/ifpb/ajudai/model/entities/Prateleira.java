package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Prateleira {
    private int codigo;
    private String descricao;
    private LocalDate dataCriacao;
    private String tipo;
    private List<Prateleira> prateleiras;

    public Prateleira(){this.prateleiras = new ArrayList<>();
    }

    public Prateleira(int codigo, String descricao, LocalDate dataCriacao, String tipo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.tipo = tipo;
        this.prateleiras = new ArrayList<Prateleira>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean addPrateleira(Prateleira prateleira){return prateleiras.add(prateleira);}

    public boolean removePrateleira(Prateleira prateleira){return prateleiras.remove(prateleira);}



}
