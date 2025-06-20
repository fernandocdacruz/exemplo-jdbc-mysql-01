<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.entities.Livro" %>
<%
    List<Livro> lista = (List<Livro>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Livros</title>
</head>
<body>
    <h2>Livros Cadastrados</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Título</th><th>Autor</th><th>Ano</th>
        </tr>
        <%
            if (lista != null) {
                for (Livro l : lista) {
        %>
        <tr>
            <td><%= l.getId() %></td>
            <td><%= l.getTitulo() %></td>
            <td><%= l.getAutor() %></td>
            <td><%= l.getAno() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br><a href="index.jsp">Cadastrar novo livro</a>
</body>
</html>