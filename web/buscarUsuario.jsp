<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Buscar Usuário</title>
    </head>
    <body align="center">
        <div align="right">
            <a href="/AcidentesPRF/logout.jsp"> logout </a>
        </div>
        <c:choose>
            <c:when test="${ usuario eq null }">
                <jsp:forward page="login.jsp" />
            </c:when>
            <c:otherwise>
                <h2>Bem-vindo ${ usuario.nome }</h2>  
            </c:otherwise>
        </c:choose>
        <h3>Dados da Publicação</h3>
        <form method = "post" action = "/AcidentesPRF/BuscarUsuario">
            <p>Pesquisar por: </p>
            <p>
                <input type="radio" name="fonte" value="CPF" checked> CPF: 
                <input type = "text" name = "cpf" size = "15"><br>
                <input type="radio" name="fonte" value="Nome"> Nome: 
                <input type = "text" name = "nome" size = "40"><br>
                <input type="radio" name="fonte" value="Todos"> Todos<br>
            </p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
                <input type="button" value="Voltar" onClick="history.go(-1)">
            </p>
        </form>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
