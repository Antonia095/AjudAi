package br.com.ifpb.ajudai.controller.utilities;

import br.com.ifpb.ajudai.model.entities.Prateleira;
import br.com.ifpb.ajudai.model.persistence.dao.PrateleiraDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/mostraprateleira")
public class MostraPrateleira extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codPrateleira = req.getParameter("codPrateleira");
        if(req.getParameter("valor").equals("1")){
            PrateleiraDao prateleiraDao = new PrateleiraDao();
            try{
                Prateleira prateleira = (Prateleira) prateleiraDao.searchEntities(codPrateleira);
                resp.getWriter().print(new Gson().toJson(prateleira, Prateleira.class));
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{

        }

    }
}
