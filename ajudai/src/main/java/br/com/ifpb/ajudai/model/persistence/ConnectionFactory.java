package br.com.ifpb.ajudai.model.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static String usuario;
    private static String senha;
    private static String url;
    private static String driver;

    static {
        InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("configuration/config." +
                "properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            url = properties.getProperty("banco.ajudai.url");
            senha = properties.getProperty("banco.ajudai.senha");
            usuario = properties.getProperty("banco.ajudai.usuario");
            driver = properties.getProperty("banco.ajudai.driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url,usuario,senha);
    }
}
