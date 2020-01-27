package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Postagem;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostagemDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public PostagemDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Postagem postagem = (Postagem) object;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO POSTAGEM(descricao, datapostagem," +
                    " nomeusuario, codconteudo) VALUES(?,?,?,?)");
            statement.setString(1,postagem.getDescricao());
            statement.setDate(2,Date.valueOf(postagem.getDataPostagem()));
            statement.setString(3,postagem.getNomeUsuario());
            statement.setInt(4,postagem.getCodConteudo());
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
}
