package br.com.ifpb.ajudai.model.conexaobd;

import br.com.ifpb.ajudai.model.conexaobd.interfaces.ConteudoDAO;
import br.com.ifpb.ajudai.model.entidades.Conteudo;
import br.com.ifpb.ajudai.model.entidades.Especialista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConteudoDAOBD implements ConteudoDAO {
    private ConnectionFactory conFactory;

    public ConteudoDAOBD(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean adicionarConteudo(Especialista especialista) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Conteudo(Nome,Local,IdPostagem)" +
                    "VALUES (?,?,?)");
        }
        return false;
    }

    @Override
    public boolean removerConteudo(Especialista especialista) {
        return false;
    }

    @Override
    public boolean atualizarContedudo(Especialista especialista) {
        return false;
    }

    @Override
    public Conteudo buscarConteudo(int id) {
        return null;
    }
}
