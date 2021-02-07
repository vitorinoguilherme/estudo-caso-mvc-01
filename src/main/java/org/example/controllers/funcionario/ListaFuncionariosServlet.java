package org.example.controllers.funcionario;

import org.example.models.funcionario.Funcionario;
import org.example.models.funcionario.FuncionarioGateway;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/funcionarios")
public class ListaFuncionariosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FuncionarioGateway fg = new FuncionarioGateway();
        List<Funcionario> funcionarios = null;
        try {
            funcionarios = fg.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("funcionarios", funcionarios);
        request.getRequestDispatcher("/WEB-INF/views/funcionario/lista.jsp").forward(request, response);
    }
}
