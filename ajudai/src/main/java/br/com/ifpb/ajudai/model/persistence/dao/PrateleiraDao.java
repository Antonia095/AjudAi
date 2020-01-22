package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Prateleira;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrateleiraDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public PrateleiraDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Prateleira prateleira = (Prateleira) object;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRATELEIRA(nome, idestante, " +
                    "descricao, datacriacao, tipo) VALUES(?,?,?,?,?)");
            statement.setString(1,prateleira.getNome());
            statement.setInt(2,prateleira.getIdEstante());
            statement.setString(3,prateleira.getDescricao());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
            statement.setString(5,prateleira.getTipo());

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

    public List<Prateleira> listaPrateleiras(int id) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            List<Prateleira> prateleiras = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRATELEIRA WHERE idestante = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                prateleiras.add(new Prateleira(resultSet.getInt("codigo"),resultSet.getString("nome"),
                        resultSet.getString("descricao"),resultSet.getDate("datacriacao").toLocalDate(),
                        resultSet.getString("tipo")));
            }
            return prateleiras;

        }
    }
}
