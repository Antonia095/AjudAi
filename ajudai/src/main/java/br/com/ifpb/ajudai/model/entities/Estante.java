package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estante {
    private int id;
    private LocalDate dataCriacao;
    private List<Prateleira> prateleiras;

    public Estante(){this.prateleiras = new ArrayList<>();
    }

    public Estante(int id, LocalDate dataCriacao) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.prateleiras = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean addPrateleira(Prateleira prateleira){return prateleiras.add(prateleira);}

    public boolean removePrateleira(Prateleira prateleira){return prateleiras.remove(prateleira);}
}
