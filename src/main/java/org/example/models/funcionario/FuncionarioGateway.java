package org.example.models.funcionario;

import org.example.models.ConnectionFactory;
import org.example.models.departamento.Departamento;

import java.sql.*;
import java.util.*;

public class FuncionarioGateway {
    private Connection conn = ConnectionFactory.getConnection();

    public List<Funcionario> getAll() throws SQLException{
        List<Funcionario> funcionarios = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM funcionarios;");

        while (rs.next()) {
            Funcionario funcionario = new Funcionario(
                    rs.getString("CPF"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    new Departamento(rs.getInt("cod_departamento")));
            funcionarios.add(funcionario);
        }
        rs.close();

        return funcionarios;
    }

    public void create(String CPF, String nome, String email, Integer codigo_departamento) throws SQLException {
        String SQL_INSERT = "INSERT INTO funcionarios VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, CPF);
        pstm.setString(2, nome);
        pstm.setString(3, email);
        pstm.setInt(4, codigo_departamento);

        pstm.execute();
        pstm.close();
    }

    public void update(String CPF, String nome, String email) throws SQLException {
        String SQL_UPDATE = "UPDATE funcionarios SET nome = ?, email = ? WHERE CPF = ? ";

        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);

        pstm.setString(1, nome);
        pstm.setString(2, email);
        pstm.setString(3, CPF);

        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(String CPF) throws SQLException {
        String SQL_DELETE = "DELETE FROM funcionarios WHERE CPF = ?";

        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);

        pstm.setString(1, CPF);

        pstm.executeUpdate();
        pstm.close();
    }
}
