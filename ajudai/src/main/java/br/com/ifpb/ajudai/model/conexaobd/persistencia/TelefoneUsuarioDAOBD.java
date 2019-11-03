package br.com.ifpb.ajudai.model.conexaobd.persistencia;

import br.com.ifpb.ajudai.model.conexaobd.ConnectionFactory;
import br.com.ifpb.ajudai.model.conexaobd.interfaces.TelefoneUsuarioDAO;
import br.com.ifpb.ajudai.model.entidades.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;


public class TelefoneUsuarioDAOBD implements TelefoneUsuarioDAO {
    private ConnectionFactory conFactory;

    public TelefoneUsuarioDAOBD(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean adicionarTelefone(String nomeUsuario,String telefone) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO TelefoneUsuario(NomeUsuario," +
                    "Telefone) VALUES(?,?)");
            statement.setString(1,nomeUsuario);
            statement.setString(2,telefone);
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removerTelefone(String nomeUsuario, String telefone) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM TelefoneUsuario " +
                    "WHERE NomeUsuario = ? AND Telefone = ?");
            statement.setString(1,nomeUsuario);
            statement.setString(2,telefone);
            return statement.executeUpdate()>0;
        }

    }

    @Override
    public boolean atualizarTelefone(String nomeUsuario, String telefone) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("UPDATE TelefoneUsuario " +
                    "SET Telefone = ? WHERE NomeUsuario = ?");
            statement.setString(1,telefone);
            statement.setString(2,nomeUsuario);
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public String[] buscarTelefones(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            String[] telefones = new String[1];
            PreparedStatement statement = connection.prepareStatement("SELECT Telefone FROM " +
                    "TelefoneUsuario WHERE NomeUsuario = ?");
            statement.setString(1,usuario.getNomeUsuario());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int cont = 0;
                do{
                    telefones[cont] = resultSet.getString("Telefone");
                    telefones = aumentaArray(telefones);
                    cont++;
                }while (resultSet.next());

                return telefones;

            }else{
                return null;
            }
        }
    }

    private String[] aumentaArray(String[] telefones){
        return telefones = Arrays.copyOf(telefones,telefones.length+1);
    }
}
