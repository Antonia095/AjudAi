package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.utilities.ImagemCaminhoUtilities;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.persistence.dao.UsuarioDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/dados")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 20,
        maxRequestSize = 1024 * 1024 * 20
)
public class EditaController extends HttpServlet {
    private String nomeImagem;
    private String novaImagem;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("valor")!=null){
            Gson gson = new Gson();
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
            resp.getWriter().print(gson.toJson(usuario,Usuario.class));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimento  = req.getParameter("nascimentoUser");
        String telefone = req.getParameter("telefoneUser");
        usuario.setDataNascimento(LocalDate.parse(dataNascimento,formatter));
        usuario.setTelefone(telefone);
        this.novaImagem = getImagem(req);
        boolean fotoSituacao = true;
        UsuarioDao usuarioDao = new UsuarioDao();
        if(novaImagem.equals("")){
            Usuario user = null;
            try{
                user = (Usuario) usuarioDao.searchEntities(usuario.getNomeUsuario());
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
            this.novaImagem = user.getImagem();
            fotoSituacao = (!user.getImagem().toUpperCase().equals("IMAGES/USER.SVG")) ? fotoSituacao : false;
        }
        usuario.setImagem(novaImagem);
        try{
            usuarioDao.updateEntities(usuario);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        if(fotoSituacao){
            usuario.setImagem(ImagemCaminhoUtilities.seta(usuario,req));
        }
        req.getSession().setAttribute("usuario",usuario);
        resp.sendRedirect("pages/usuario/usuario.jsp");
    }

    private String getImagem(HttpServletRequest req) throws IOException, ServletException {
        Part part = req.getPart("fupload");
        if(!part.getSubmittedFileName().equals("")){
            String projeto = ImagemCaminhoUtilities.path(new File(".").getCanonicalPath()) +"IMAGENS";
            File imagens = new File(projeto);
            this.nomeImagem = String.valueOf(new Date()) + part.getSubmittedFileName();

            if(!imagens.isDirectory()){
                imagens.mkdir();
            }
            part.write(imagens.getAbsolutePath() + File.separator + this.nomeImagem);
            return imagens.getAbsolutePath() + File.separator + this.nomeImagem;
        }else{
            return "";
        }

    }
}
