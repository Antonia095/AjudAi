package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Mensagem;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensagemDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public MensagemDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Mensagem mensagem = (Mensagem) object;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO MENSAGEM(titulo, texto) VALUES(?,?)");
            statement.setString(1,mensagem.getTitulo());
            statement.setString(2,mensagem.getTexto());
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
            List<Mensagem> mensagens = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MENSAGEM");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                mensagens.add(new Mensagem(resultSet.getString("titulo"),resultSet.getString("texto"),
                        resultSet.getDate("data").toLocalDate()));
            }

            return mensagens;
        }
    }
}
