package br.com.ifpb.ajudai.model.entities;

import java.time.LocalDate;
import java.util.List;

public class Especialista extends Usuario {
    private String nomeUser;
    private String descricao;
    private List<Especialidade> especialidades;

    public Especialista() {
    }

    public Especialista(String nomeUsuario, String descricao){
        this.descricao = descricao;
        this.nomeUser = nomeUsuario;
    }

    public Especialista(String nomeUsuario, String nomeCompleto, LocalDate dataNascimento,
                        String telefone) {
        super(nomeUsuario, nomeCompleto, dataNascimento, telefone);
    }

    public Especialista(String nomeUsuario, String nomeCompleto, LocalDate dataNascimento,
                        String email, String imagem, String telefone, String senha, String descricao) {
        super(nomeUsuario, nomeCompleto, dataNascimento, email, imagem, telefone, senha);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean addEntities(Object object) {
        return especialidades.add((Especialidade)object);
    }

    public boolean removeEntities(Object object) {
        return especialidades.remove((Especialidade)object);
    }
}
