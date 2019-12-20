package br.com.ifpb.ajudai.model.persistence.dao;

import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.interfaces.EntitiesDao;
import br.com.ifpb.ajudai.model.persistence.ConnectionFactory;

import java.sql.*;

public class UsuarioDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public UsuarioDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Usuario usuario = (Usuario) object;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USUARIO(nomeusuario, nomecompleto, datanascimento, email," +
                    " senha, imagem, telefone) VALUES (?,?,?,?,?,?,?)");
            statement.setString(1,usuario.getNomeUsuario());
            statement.setString(2,usuario.getNomeCompleto());
            statement.setDate(3, Date.valueOf(usuario.getDataNascimento()));
            statement.setString(4,usuario.getEmail());
            statement.setString(5,String.valueOf(usuario.hashCode()));
            statement.setString(6,usuario.getImagem());
            statement.setString(7, usuario.getTelefone());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removeEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Usuario usuario = (Usuario) object;
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USUARIO WHERE nomeusuario = ? OR" +
                    " email = ?");
            statement.setString(1,usuario.getNomeUsuario());
            statement.setString(2,usuario.getImagem());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean updateEntities(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            Usuario usuario = (Usuario) object;
            PreparedStatement statement = connection.prepareStatement("UPDATE USUARIO SET nomecompleto = ?, " +
                    "datanascimento = ?, email = ?, senha = ?, imagem = ?, telefone = ? WHERE nomeusuario = ?");
            statement.setString(1,usuario.getNomeCompleto());
            statement.setDate(2,Date.valueOf(usuario.getDataNascimento()));
            statement.setString(3,usuario.getEmail());
            statement.setString(4,String.valueOf(usuario.hashCode()));
            statement.setString(5,usuario.getImagem());
            statement.setString(6,usuario.getTelefone());
            statement.setString(7,usuario.getNomeUsuario());

            return statement.executeUpdate()>0;
        }
    }

    @Override
    public Object searchEntities(String id) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USUARIO WHERE nomeusuario = ? OR " +
                    "email = ?");
            statement.setString(1,id);
            statement.setString(2,id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new Usuario(resultSet.getString("nomeusuario"),resultSet.getString("nomecompleto"),
                        resultSet.getDate("datanascimento").toLocalDate(),resultSet.getString("email"),
                        resultSet.getString("imagem"),resultSet.getString("telefone"),
                        resultSet.getString("senha"));
            }else {
                return null;
            }

        }
    }
}
