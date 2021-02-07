package org.example.models.projeto;

import org.example.models.ConnectionFactory;
import org.example.models.departamento.Departamento;

import java.util.*;
import java.sql.*;
import java.util.Date;

public class ProjetoGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<Projeto> getAll() throws SQLException {
        List<Projeto> projetos = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM projetos;");

        while (rs.next()) {
            Projeto projeto = new Projeto(
                    rs.getInt("codigo"),
                    rs.getString("titulo"),
                    rs.getDate("data_inicio"),
                    rs.getDate("data_fim"),
                    new Departamento(rs.getInt("cod_departamento"))
            );
            projetos.add(projeto);
        }
        rs.close();

        return projetos;
    }

    public void create(String titulo, Date data_inicio, Date data_fim, Integer cod_departamento) throws SQLException {
        String SQL_INSERT = "INSERT INTO projetos (titulo, data_inicio, data_fim, cod_departamento)" +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, titulo);
        pstm.setDate(2, (java.sql.Date) data_inicio);
        pstm.setDate(3, (java.sql.Date) data_fim);
        pstm.setInt(4, cod_departamento);

        pstm.execute();
        pstm.close();
    }

    public void update(String titulo, Integer codigo) throws SQLException {
        String SQL_UPDATE = "UPDATE projetos SET titulo = ? WHERE codigo = ?";

        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);

        pstm.setString(1, titulo);
        pstm.setInt(2, codigo);

        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(Integer codigo) throws SQLException {
        String SQL_DELETE = "DELETE FROM projetos WHERE codigo = ?";

        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);

        pstm.setInt(1, codigo);

        pstm.executeUpdate();
        pstm.close();
    }
}
