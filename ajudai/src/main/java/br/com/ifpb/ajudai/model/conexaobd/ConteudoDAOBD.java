package br.com.ifpb.ajudai.model.conexaobd;


import br.com.ifpb.ajudai.model.entidades.Conteudo;
import br.com.ifpb.ajudai.model.entidades.Especialista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConteudoDAOBD {
    private ConnectionFactory conFactory;

    public ConteudoDAOBD(){
        conFactory = new ConnectionFactory();
    }


    public boolean adicionarConteudo(Conteudo conteudo) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Conteudo(Nome,Local,IdPostagem)" +
                    "VALUES (?,?,?)");
            statement.setString(1,conteudo.getNome());
            statement.setString(2,conteudo.getLocal());
            statement.setInt(3,2);
            return statement.executeUpdate()>0;
        }

    }


    public boolean removerConteudo(Conteudo conteudo) {
        return false;
    }

    public boolean atualizarContedudo(Conteudo conteudo) {
        return false;
    }

    public Conteudo buscarConteudo(int id) {
        return null;
    }
}
