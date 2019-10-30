package br.com.ifpb.ajudai.model.entidades;

import java.time.LocalDate;

public class Administrador extends Usuario {
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Administrador(String nome, String nomeUsuario, LocalDate dataNascimento, String email, String senha,
                         String[] telefone, LocalDate dataInicio, LocalDate dataFim) {
        super(nome, nomeUsuario, dataNascimento, email, senha, telefone);
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
