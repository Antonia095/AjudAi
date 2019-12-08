package br.com.ifpb.ajudai.model.connectiondb.configconnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Postgre {
    private static String url;
    private static String senha;
    private static String usuario;

    static {
        InputStream input = Postgre.class.getClassLoader().getResourceAsStream("connection/confi" +
                "g.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            url = properties.getProperty("postgre.ajudai.url");
            senha = properties.getProperty("postgre.ajudai.senha");
            usuario = properties.getProperty("postgre.ajudai.usuario");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnetion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,usuario,senha);
    }

}
