package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Conteudo;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return null;
    }

    public Integer recuperaCodigo() throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT recuperacodigo()");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("recuperaCodigo");
        }
    }
}
