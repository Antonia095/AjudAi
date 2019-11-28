package br.com.ifpb.ajudai.model.conexaobd;

import br.com.ifpb.ajudai.model.conexaobd.interfaces.PrateleiraDAO;
import br.com.ifpb.ajudai.model.entidades.Conteudo;
import br.com.ifpb.ajudai.model.entidades.Prateleira;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrateleiraDAOBD implements PrateleiraDAO {
    private ConnectionFactory conexao;

    public PrateleiraDAOBD() {
        conexao = new ConnectionFactory();

    }

    @Override
    public boolean adicionarPrateleira(Prateleira prateleira)throws SQLException,ClassNotFoundException {
        try(Connection connection = conexao.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Prateleira"+
                    "(idestante, descricao,tipo) VALUES(?,?,?)");
            statement.setInt(1,prateleira.getIdEstante());
            statement.setString(2,prateleira.getDescricao());
            statement.setString(3,prateleira.getTipo());
            return statement.executeUpdate()>0;

        }


    }

    @Override
    public boolean removerPrateleira(Prateleira prateleira)throws SQLException, ClassNotFoundException {
        try(Connection connection = conexao.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM prateleira WHERE id = ?");
            statement.setString(1, prateleira.getTipo());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public Prateleira atualizarPrateleira(Prateleira prateleira)throws SQLException, ClassNotFoundException {
        try(Connection connection = conexao.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("UPDATE prateleira "+
                    "SET destricrição = ?, datacriacao = ? , tipo = ?");
            statement.setString(1,prateleira.getDescricao());
            statement.setDate(2, Date.valueOf(prateleira.getDataCriacao()));
            statement.setString(3,prateleira.getTipo());
            statement.executeUpdate();
            return prateleira;

        }
    }


    @Override
    public List listarPrateleiras()throws SQLException, ClassNotFoundException{
            try(Connection connection = conexao.getConnetion()){
                String query = "SELECT * FROM prateleira";
                PreparedStatement statement = this.conexao.getConnetion().prepareStatement(query);
                ResultSet result = statement.executeQuery();
                List<Prateleira> prateleiras = new ArrayList<>();
                while (result.next()) {
                    Prateleira prateleira1 = new Prateleira();
                    prateleira1.setDescricao(result.getString("descricao"));
                    prateleira1.setDataCriacao(result.getDate("dataCriacao").toLocalDate());
                    prateleira1.setTipo(result.getString("tipo"));
                    prateleiras.add(prateleira1);

                 }
                return prateleiras;
            }
    }

   


}
