package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Especialista;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialistaDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public EspecialistaDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Especialista especialista = (Especialista) object;
            new UsuarioDao().addEntities(new Usuario(especialista.getNomeUsuario(),especialista.getNomeCompleto(),
                    especialista.getDataNascimento(),especialista.getEmail(),
                    especialista.getImagem(),especialista.getTelefone(),especialista.getSenha()));
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ESPECIALISTA(nomeusuario, descricao) " +
                    "VALUES (?,?)");
            statement.setString(1,especialista.getNomeUsuario());
            statement.setString(2,especialista.getDescricao());

            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removeEntities(Object object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Especialista especialista = (Especialista) object;
            PreparedStatement statement = connection.prepareStatement("UPDATE ESPECIALISTA SET descricao = ? WHERE nomeusuario" +
                    " = ?");
            statement.setString(1, especialista.getDescricao());
            statement.setString(2, especialista.getNomeUser());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public Object searchEntities(String id) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ESPECIALISTA WHERE nomeusuario = ?");
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String descricao = resultSet.getString("descricao");
            if(descricao.length()>2){
                return descricao;
            }else{
                return null;
            }
        }
    }
}
