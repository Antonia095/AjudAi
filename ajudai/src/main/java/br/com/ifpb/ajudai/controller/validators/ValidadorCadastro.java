package br.com.ifpb.ajudai.controller.validators;

import br.com.ifpb.ajudai.model.connectiondb.persistence.UsuarioDaoDb;
import br.com.ifpb.ajudai.model.entities.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidadorCadastro {

    public static boolean validadorNomeUsuario(String nomeUsuario){
        UsuarioDaoDb usuarioDaoDb = new UsuarioDaoDb();
        try {
           Usuario usuario = usuarioDaoDb.searchUsuario(nomeUsuario);
           if(usuario==null){
               return true;
           }else{
               return false;
           }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
}
