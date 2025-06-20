<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Livro</title>
</head>
<body>
    <h2>Cadastro de Livro</h2>
    <form action="livros" method="post">
        Título: <input type="text" name="titulo"><br><br>
        Autor: <input type="text" name="autor"><br><br>
        Ano: <input type="number" name="ano"><br><br>
        <input type="submit" value="Cadastrar">
    </form>
    <br>
    <a href="livros">Ver todos os livros</a>
</body>
</html>