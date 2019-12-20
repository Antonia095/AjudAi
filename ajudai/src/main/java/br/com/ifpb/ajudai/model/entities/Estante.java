package br.com.ifpb.ajudai.model.entities;

import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estante {
    private int id;
    private LocalDate dataCriacao;
    private String nomeUsuario;
    private List<Prateleira> prateleiras;

    public Estante() {
        this.prateleiras = new ArrayList<>();
    }

    public Estante(int id, LocalDate dataCriacao, String nomeUsuario) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.nomeUsuario = nomeUsuario;
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public boolean addEntities(Object object) {
        return prateleiras.add((Prateleira)object);
    }

    public boolean removeEntities(Object object) {
        return prateleiras.remove((Prateleira)object);
    }
}
