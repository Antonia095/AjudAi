package br.com.ifpb.ajudai.controller.utilities;

import br.com.ifpb.ajudai.model.entities.Especialista;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.persistence.dao.UsuarioDao;

import java.sql.SQLException;
import java.util.UUID;

public class LoginCadastroUtilities {
    public static Usuario buscaUsuario(String id){
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = null;
        try {
            usuario = (Usuario) usuarioDao.searchEntities(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static String usuarioExistente(String id, String senha){
        Usuario usuario = buscaUsuario(id);
        Usuario user = new Usuario();
        user.setSenha(senha);
        if(usuario==null){
            return "Conta inexistente";
        }else if(!usuario.getSenha().equals(String.valueOf(user.hashCode()))){
            return "Senha incorreta";
        }else{
            if(temAcesso(id)){
                return "sucesso";
            }else{
                return "Conta inexistente";
            }

        }
    }

    public static String existenciaUsuario(String nomeUsuario, String email){
        if(buscaUsuario(nomeUsuario)!=null){
            return "Nome de usuario ja existe";
        }else if(buscaUsuario(email)!=null){
            return "Email ja esta em uso";
        }else{
            return "";
        }
    }

    public static Especialista realizaMudanca(Usuario usuario, String descricao) {
        return new Especialista(usuario.getNomeUsuario(),usuario.getNomeCompleto(),usuario.getDataNascimento(),usuario.getEmail(),
                usuario.getImagem(),usuario.getTelefone(),usuario.getSenha(), descricao);
    }

    public static String geraCodigoAcesso(){
        String codigo = UUID.randomUUID().toString();
        System.out.println(codigo);
        int pos = codigo.indexOf("-");
        return codigo.substring(0,pos);
    }

    private static boolean temAcesso(String id) {
        try{
            return new UsuarioDao().acesso(id);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
}
