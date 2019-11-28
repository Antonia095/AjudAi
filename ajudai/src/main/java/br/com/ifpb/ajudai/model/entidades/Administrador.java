package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Administrador {
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Administrador(LocalDate dataInicio, LocalDate dataFim) { ;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
