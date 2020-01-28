package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Comentario;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public ComentarioDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        return false;
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
            List<Comentario> comentarios = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM COMENTARIO WHERE codpostagem = ?");
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                comentarios.add(new Comentario(resultSet.getInt("id"),resultSet.getString("descricao"),
                        resultSet.getDate("datacomentario").toLocalDate(),resultSet.getInt("codPostagem")));
            }
            return comentarios;
        }
    }
}
