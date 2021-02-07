package org.example.controllers.departamento;

import org.example.models.departamento.Departamento;
import org.example.models.departamento.DepartamentoGateway;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/departamentos")
public class ListaDepartamentosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartamentoGateway dg = new DepartamentoGateway();
        List<Departamento> departamentos = null;
        try {
            departamentos = dg.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("departamentos", departamentos);
        request.getRequestDispatcher("/WEB-INF/views/departamento/lista.jsp").forward(request, response);
    }
}