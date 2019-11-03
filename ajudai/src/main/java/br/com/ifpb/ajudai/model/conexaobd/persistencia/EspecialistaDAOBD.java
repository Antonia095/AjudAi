package br.com.ifpb.ajudai.model.conexaobd.persistencia;

import br.com.ifpb.ajudai.model.conexaobd.ConnectionFactory;
import br.com.ifpb.ajudai.model.conexaobd.interfaces.EspecialistaDAO;
import br.com.ifpb.ajudai.model.entidades.Especialista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialistaDAOBD implements EspecialistaDAO {
    private ConnectionFactory conFactory;

    public EspecialistaDAOBD(){
        conFactory = new ConnectionFactory();
    }


    @Override
    public boolean adicionarEspecialista(Especialista especialista) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " +
                    "Especilista(NomeUsuario,Descricao) VALUES(?,?)");
            statement.setString(1,especialista.getNomeUsuario());
            statement.setString(2,especialista.getDescricao());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removerEspecialista(Especialista especialista) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Especilista " +
                    "WHERE NomeUsuario = ?");
            statement.setString(1,especialista.getNomeUsuario());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean atualizarEspecialista(Especialista especialista) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("UPDATE Especialista " +
                    "SET Descricao = ?");
            statement.setString(1,especialista.getDescricao());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public Especialista buscarEspecialista(String nomeUsuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            Especialista especialista = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Especialista WHERE" +
                    " NomeUsuario = ?");
            statement.setString(1,nomeUsuario);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                especialista.setDescricao(resultSet.getString("Descricao"));
                return especialista;
            }else{
                return especialista;
            }
        }
    }
}
