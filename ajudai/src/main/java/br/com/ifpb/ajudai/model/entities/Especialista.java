package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Especialista extends Usuario {
    private String descricao;
    private List<Especialidade> especialidades;

    public Especialista() {
        this.especialidades = new ArrayList<>();
    }

    public Especialista(String nomeCompleto, String nomeUsuario, String telefone, String email,
                        String senha, LocalDate dataNascimento, String descricao) {
        super(nomeCompleto, nomeUsuario, telefone, email, senha, dataNascimento);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean addEspecialidade(Especialidade especialidade){
        return especialidades.add(especialidade);
    }

    public boolean removeEspecialidade(Especialidade especialidade){
        return especialidades.remove(especialidade);
    }


}
