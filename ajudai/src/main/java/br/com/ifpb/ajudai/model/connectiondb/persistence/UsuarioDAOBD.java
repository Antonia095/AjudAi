package br.com.ifpb.ajudai.model.connectiondb.persistence;

import br.com.ifpb.ajudai.model.connectiondb.configconnection.Postgre;
import br.com.ifpb.ajudai.model.connectiondb.interfaces.UsuarioDAO;
import br.com.ifpb.ajudai.model.entities.Usuario;

import java.sql.*;

public class UsuarioDAOBD implements UsuarioDAO {
    private Postgre postgre;

    public UsuarioDAOBD(){
        postgre = new Postgre();
    }


    @Override
    public boolean addUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = postgre.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USUARIO(nomeusuario," +
                    "nomecompleto,datanascimento,email,telefone,senha,ativo) VALUES(?,?,?,?,?,?,?)");
            statement.setString(1,usuario.getNomeUsuario());
            statement.setString(2,usuario.getNomeCompleto());
            statement.setDate(3,Date.valueOf(usuario.getDataNascimento()));
            statement.setString(4,usuario.getEmail());
            statement.setString(5,usuario.getTelefone());
            statement.setString(6,String.valueOf(usuario.hashCode()));
            statement.setBoolean(7,true);
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removeUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Usuario searchUsuario(String id) throws SQLException, ClassNotFoundException {
        try(Connection connection = postgre.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USUARIO WHERE nomeusuario = ? " +
                    "OR email = ?");
            statement.setString(1,id);
            statement.setString(2,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new Usuario(resultSet.getString("nomecompleto"),resultSet.getString("nomeusuario"),
                        resultSet.getString("telefone"),resultSet.getString("email"),
                        resultSet.getString("senha"),resultSet.getDate("datanascimento").toLocalDate());
            }
            return null;
        }
    }
}
