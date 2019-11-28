package br.com.ifpb.ajudai.model.conexaobd.persistencia;

import br.com.ifpb.ajudai.model.conexaobd.ConnectionFactory;
import br.com.ifpb.ajudai.model.conexaobd.interfaces.AdministradorDAO;
import br.com.ifpb.ajudai.model.entidades.Administrador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministradorDAOBD implements AdministradorDAO {
    private ConnectionFactory conFactory;

    public AdministradorDAOBD(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean atualizarAdministrador(Administrador administrador) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnetion()){
            PreparedStatement statement = connection.prepareStatement("UPDATE Administrador SET DataInicio" +
                    " = ?");
            statement.setDate(1, Date.valueOf(administrador.getDataInicio()));
            return statement.executeUpdate()>0;

        }
    }
}
