package br.com.ifpb.ajudai.controller.utilities;

import br.com.ifpb.ajudai.model.entities.Conteudo;
import br.com.ifpb.ajudai.model.entities.Postagem;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.persistence.dao.ConteudoDao;
import br.com.ifpb.ajudai.model.persistence.dao.PostagemDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdicionarConteudoUtilities {
    public static synchronized void addConteudo(String nomeConteudo, String descricao, String local, HttpServletRequest req){
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        Conteudo conteudo = new Conteudo(nomeConteudo,local);
        ConteudoDao conteudoDao = new ConteudoDao();
        PostagemDao postagemDao = new PostagemDao();
        try{
            conteudoDao.addEntities(conteudo);
            postagemDao.addEntities(new Postagem(descricao, LocalDate.now(), usuario.getNomeUsuario(), conteudoDao.recuperaCodigo()));
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
