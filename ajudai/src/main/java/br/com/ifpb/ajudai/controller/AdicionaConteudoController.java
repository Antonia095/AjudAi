package br.com.ifpb.ajudai.controller;


import br.com.ifpb.ajudai.controller.utilities.AdicionarConteudoUtilities;
import br.com.ifpb.ajudai.controller.utilities.ImagemCaminhoUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@WebServlet("/adicionaconteudo")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 100,
        maxRequestSize = 1024 * 1024 * 100
)
public class AdicionaConteudoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nomeConteudo");
        String descricao = req.getParameter("descricao");
        String caminhoConteudo = pegaCaminhoConteudo(req);
        AdicionarConteudoUtilities.addConteudo(nome,descricao,caminhoConteudo,req);
    }

    private String pegaCaminhoConteudo(HttpServletRequest req) throws IOException, ServletException {
        Part part = req.getPart("conteudo");
        String caminho = ImagemCaminhoUtilities.path(new File(".").getCanonicalPath()) + "CONTEUDO";
        File conteudo = new File(caminho);
        String nomeConteudo = part.getSubmittedFileName() + String.valueOf(new Date());
        if(!conteudo.isDirectory()){
            conteudo.mkdir();
        }
        part.write(conteudo.getAbsolutePath() + File.separator + nomeConteudo);
        return conteudo.getAbsolutePath() + File.separator + nomeConteudo;
    }
}
