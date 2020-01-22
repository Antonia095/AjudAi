package br.com.ifpb.ajudai.controller.utilities;

import br.com.ifpb.ajudai.model.entities.Usuario;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImagemCaminhoUtilities {
    public static String path(String path){
        char [] caminho = path.toCharArray();
        String novoCaminho = "";
        int cont = 0;
        for (char c: caminho){
            if(c=='/'){
                cont++;
            }
            novoCaminho += c;
            if (cont==3) break;
        }
        return novoCaminho;
    }

    public static String seta(Usuario usuario, HttpServletRequest req) throws IOException {
        FileInputStream arquivo = new FileInputStream( new File(usuario.getImagem()));
        FileOutputStream destino = new FileOutputStream(new File(req.getServletContext().getRealPath("")+"images"+
                arquivo.getFD().toString()));
        arquivo.getChannel().transferTo(0,arquivo.getChannel().size(),destino.getChannel());
        return "images" + arquivo.getFD().toString();
    }
}
