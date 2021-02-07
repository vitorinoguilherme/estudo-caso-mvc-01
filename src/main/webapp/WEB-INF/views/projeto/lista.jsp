<%@ page import="java.util.List"%>
<%@ page import="org.example.models.projeto.Projeto"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de Projetos</title>
</head>
<body>
    <h1>Lista de Projetos</h1>
    <table>
        <tr>
            <th>Codigo</th>
            <th>Titulo</th>
            <th>Data Inicio</th>
            <th>Data Fim</th>
            <th>Codigo Departamento</th>
        </tr>

        <%
            List<Projeto> projetos = (List<Projeto>) request.getAttribute("projetos");
            for(Projeto proj : projetos) {
        %>

        <tr>
            <td><%= proj.getCodigo()%></td>
            <td><%= proj.getTitulo()%>></td>
            <td><%= proj.getData_inicio()%></td>
            <td><%= proj.getData_fim()%></td>
            <td><%= proj.getDepartamento().getCodigo()%></td>
        </tr>

        <%
            }
        %>

    </table>
</body>
</html>