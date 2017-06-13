<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Usuários</title>
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
        <h3>Dados dos Usuários</h3>
        <div align="center">
            <table border:1>
                <tr>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Função</th>
                </tr>
                <c:forEach var="item" items="${lista}">
                    <tr>
                        <td>${item.cpf}</td>
                        <td>${item.nome}</td>
                        <td>${item.funcao}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div align="center">
            <p>
                <input type="button" value="Voltar" onClick="history.go(-1)">
            </p>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
