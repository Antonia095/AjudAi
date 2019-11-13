package br.com.ifpb.ajudai.model.conexaobd.persistencia;

import br.com.ifpb.ajudai.model.conexaobd.ConnectionFactory;
import br.com.ifpb.ajudai.model.conexaobd.interfaces.UsuarioDAO;
import br.com.ifpb.ajudai.model.entidades.Usuario;

import java.sql.*;

public class UsuarioDAOBD implements UsuarioDAO {
    private ConnectionFactory conFactory;

    public UsuarioDAOBD(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean adicionarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Usuario(NomeCompleto," +
                    "NomeUsuario,DataNascimento,Email,Senha,Situacao) VALUES (?,?,?,?,?,?)");
            statement.setString(1,usuario.getNomeCompleto());
            statement.setString(2,usuario.getNomeUsuario());
            statement.setDate(3, Date.valueOf(usuario.getDataNascimento()));
            statement.setString(4,usuario.getEmail());
            statement.setString(5,Integer.toString(usuario.hashCode()));
            statement.setBoolean(6,usuario.getSituacao());

            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removerUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Usuario " +
                    "WHERE NomeUsuario = ?");
            statement.setString(1,usuario.getNomeUsuario());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean atualizarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("UPDATE Usuario SET " +
                    "NomeCompleto = ?, DataNascimento = ?, Email = ?, Senha = ?, Situacao = ? " +
                    "WHERE NomeUsuario = ?");
            statement.setString(1,usuario.getNomeCompleto());
            statement.setDate(2,Date.valueOf(usuario.getDataNascimento()));
            statement.setString(3,usuario.getEmail());
            statement.setString(4,Integer.toString(usuario.hashCode()));
            statement.setBoolean(5,usuario.getSituacao());
            statement.setString(6,usuario.getNomeUsuario());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public Usuario buscarUsuario(String nomeUsuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            Usuario usuario = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Usuario " +
                    "WHERE NomeUsuario = ?");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return null;
            }else{
                return usuario;
            }
        }
    }
}
