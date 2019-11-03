package br.com.ifpb.ajudai.model.conexaobd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static String url;
    private static String senha;
    private static String usuario;

    static {
        InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("Conexao/confi" +
                "g.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            url = properties.getProperty("banco.ajudai.url");
            senha = properties.getProperty("banco.ajudai.senha");
            usuario = properties.getProperty("banco.ajudai.usuario");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnetion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,usuario,senha);
    }

}
