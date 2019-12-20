package br.com.ifpb.ajudai.controller;

import br.com.ifpb.ajudai.controller.utilities.ImagemCaminhoUtilities;
import br.com.ifpb.ajudai.controller.utilities.LoginCadastroUtilities;
import br.com.ifpb.ajudai.model.entities.Especialista;
import br.com.ifpb.ajudai.model.entities.Usuario;
import br.com.ifpb.ajudai.model.persistence.dao.EspecialistaDao;
import br.com.ifpb.ajudai.model.persistence.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/etapadois")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 20,
        maxRequestSize = 1024 * 1024 * 20
)
public class EtapaDoisController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Usuario usuario = (Usuario) req.getSession().getAttribute("user");
        String dataNascimento = req.getParameter("nascimento");
        String tipoUsuario = req.getParameter("tipo");
        String senha = req.getParameter("senha");
        String imagem = getImagem(req,resp);
        usuario.setDataNascimento(LocalDate.parse(dataNascimento,formatter));
        usuario.setSenha(senha);
        usuario.setImagem(imagem);
        if(tipoUsuario.toUpperCase().equals("ESPECIALISTA")){
            Especialista especialista = LoginCadastroUtilities.realizaMudanca(usuario,req.getParameter("descricao"));
            try {
                new EspecialistaDao().addEntities(especialista);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            try {
                new UsuarioDao().addEntities(usuario);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        String image = ImagemCaminhoUtilities.seta(usuario,req);
        usuario.setImagem(image);
        req.getSession().setAttribute("usuario",usuario);
        resp.sendRedirect("pages/usuario/usuario.jsp");
    }
    private String getImagem(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part part = req.getPart("foto");
        String projeto = ImagemCaminhoUtilities.path(new File(".").getCanonicalPath()) +"IMAGENS";
        File imagens = new File(projeto);
        if(!imagens.isDirectory()){
            imagens.mkdir();
        }
        part.write(imagens.getAbsolutePath() + File.separator + String.valueOf(new Date()) + part.getSubmittedFileName());
        return imagens.getAbsolutePath() + File.separator + String.valueOf(new Date()) + part.getSubmittedFileName();
    }
}
