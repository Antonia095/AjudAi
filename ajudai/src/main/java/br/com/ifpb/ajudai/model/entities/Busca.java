package br.com.ifpb.ajudai.model.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Busca {
    private List<Integer> codConteudos;
    private List<Integer> codPostagens;
    private List<String> nomes;
    private List<String> locais;
    private List<String> descricoes;
    private HashSet<List<Comentario>> comentarios;

    public Busca(){
        codConteudos = new ArrayList<>();
        codPostagens = new ArrayList<>();
        nomes = new ArrayList<>();
        locais = new ArrayList<>();
        descricoes = new ArrayList<>();
        comentarios = new HashSet<>();
    }

    public boolean addCodConteudo(int codConteudo){
        return codConteudos.add(codConteudo);
    }

    public boolean addCodPostagem(int codPostagem){
        return codPostagens.add(codPostagem);
    }

    public boolean addNomes(String nome){
        return nomes.add(nome);
    }

    public boolean addLocais(String local){
        return locais.add(local);
    }

    public boolean addDescricoes(String descricao){
        return descricoes.add(descricao);
    }

    public boolean addComentarios(List<Comentario> com){
        return comentarios.add(com);
    }

    public List<Integer> getCodConteudos() {
        return codConteudos;
    }
}
