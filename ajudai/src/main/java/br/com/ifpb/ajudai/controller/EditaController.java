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
        String nomeCompleto = req.getParameter("nomeComUser");
        String telefone = req.getParameter("telefoneUser");
        usuario.setDataNascimento(LocalDate.parse(dataNascimento,formatter));
        usuario.setNomeCompleto(nomeCompleto);
        usuario.setTelefone(telefone);
        usuario.setImagem(getImagem(req));
        UsuarioDao usuarioDao = new UsuarioDao();
        try{
            usuarioDao.updateEntities(usuario);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        usuario.setImagem(ImagemCaminhoUtilities.seta(usuario,req));
        req.getSession().setAttribute("usuario",usuario);
        resp.sendRedirect("pages/usuario/usuario.jsp");
    }

    private String getImagem(HttpServletRequest req) throws IOException, ServletException {
        Part part = req.getPart("fupload");
        String projeto = ImagemCaminhoUtilities.path(new File(".").getCanonicalPath()) +"IMAGENS";
        File imagens = new File(projeto);
        this.nomeImagem = String.valueOf(new Date()) + part.getSubmittedFileName();

        if(!imagens.isDirectory()){
            imagens.mkdir();
        }
        part.write(imagens.getAbsolutePath() + File.separator + this.nomeImagem);
        return imagens.getAbsolutePath() + File.separator + this.nomeImagem;
    }
}
