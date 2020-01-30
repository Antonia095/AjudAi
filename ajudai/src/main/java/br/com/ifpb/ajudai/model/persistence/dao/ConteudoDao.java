package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Busca;
import br.com.ifpb.ajudai.model.entities.Comentario;
import br.com.ifpb.ajudai.model.entities.Conteudo;
import br.com.ifpb.ajudai.model.entities.Postagem;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ConteudoDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public ConteudoDao() {
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Conteudo conteudo = (Conteudo) object;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO CONTEUDO(nome,local) VALUES(?,?)");
            statement.setString(1,conteudo.getNome());
            statement.setString(2,conteudo.getLocal());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removeEntities(Object object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateEntities(Object object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Object searchEntities(String id) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Busca busca = new Busca();
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT c.codigo, c.nome, p.descricao, c.local, p.codigo AS codPostagem " +
                    "FROM CONTEUDO c, POSTAGEM p " +
                    "WHERE (p.descricao ilike ? OR p.descricao ilike ? OR c.nome ilike ? OR c.nome ilike ?) AND c.codigo = p.codConteudo");
            statement.setString(1,id+"%");
            statement.setString(2,"%"+id+"%");
            statement.setString(3,id+"%");
            statement.setString(4,"%"+id+"%");
            ResultSet resultConteudo = statement.executeQuery();
            ComentarioDao comentarioDao = new ComentarioDao();
            while (resultConteudo.next()){
                busca.addCodConteudo(resultConteudo.getInt("codigo"));
                busca.addNomes(resultConteudo.getString("nome"));
                busca.addDescricoes(resultConteudo.getString("descricao"));
                busca.addLocais(resultConteudo.getString("local"));
                busca.addCodPostagem(resultConteudo.getInt("codPostagem"));
                if(comentarioDao.searchEntities(String.valueOf(resultConteudo.getInt("codPostagem")))!=null){
                    busca.addComentarios((List<Comentario>) comentarioDao.searchEntities(String.valueOf(resultConteudo.getInt("codPostagem"))));
                }
            }
            return busca;
        }
    }

    public Integer recuperaCodigo() throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT recuperacodigo()");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("recuperaCodigo");
        }
    }

    public Conteudo buscaConteudo(int codigo) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CONTEUDO WHERE codigo = ?");
            statement.setInt(1,codigo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Conteudo(codigo,resultSet.getString("local"));
        }
    }
}
