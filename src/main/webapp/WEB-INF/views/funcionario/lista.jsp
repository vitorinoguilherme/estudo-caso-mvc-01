<%@ page import="java.util.List"%>
<%@ page import="org.example.models.funcionario.Funcionario"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de Funcionarios</title>
</head>
<body>
    <h1>Lista de Funcionarios</h1>
    <table>
        <tr>
            <th>CPF</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Código Departamento</th>
        </tr>

        <%
            List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("funcionarios");
            for(Funcionario func: funcionarios) {
        %>

        <tr>
            <td><%= func.getCPF()%></td>
            <td><%= func.getNome()%>></td>
            <td><%= func.getEmail()%></td>
            <td><%= func.getDepartamento().getCodigo()%></td>
        </tr>

        <%
            }
        %>
    </table>
</body>
</html>