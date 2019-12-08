package br.com.ifpb.ajudai.model.connectiondb.configconnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Redis {
    private static String host;
    private static int porta;

    static {
        InputStream input = Redis.class.getClassLoader().getResourceAsStream("configuracao/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            host = properties.getProperty("banco.redis.host");
            porta = Integer.parseInt(properties.getProperty("banco.redis.porta"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public Jedis getConnetion(){
        return new Jedis(host,porta);
    }*/
}
