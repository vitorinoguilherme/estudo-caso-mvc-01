package org.example.controllers.projeto;

import org.example.models.projeto.Projeto;
import org.example.models.projeto.ProjetoGateway;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/projetos")
public class ListaProjetosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProjetoGateway pg = new ProjetoGateway();
        List<Projeto> projetos = null;

        try {
            projetos = pg.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("projetos", projetos);
        request.getRequestDispatcher("/WEB-INF/views/projeto/lista.jsp").forward(request, response);
    }


}
