package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.ConteudoEstante;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConteudoEstanteDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public ConteudoEstanteDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            ConteudoEstante conteudoEstante = (ConteudoEstante) object;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRATELEIRACONTEUDO(idestante,codprateleira," +
                    "codconteudo) VALUES(?,?,?)");
            statement.setInt(1,conteudoEstante.getIdEstante());
            statement.setInt(2,conteudoEstante.getCodPrateleira());
            statement.setInt(3,conteudoEstante.getCodConteudo());
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

    public boolean existeNaEstante(int codPrateteleira, int codConteudo) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRATELEIRACONTEUDO WHERE codprateleira = ?" +
                    "AND codconteudo = ?");
            statement.setInt(1,codPrateteleira);
            statement.setInt(2,codConteudo);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }
}
