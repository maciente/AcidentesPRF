<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserir Usuário</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
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
        <form method="POST" action="/AcidentesPRF/InserirUsuario">
            <div align="center">
                <h3>Dados do Usuário</h3>
                <p>Nome: <input type="text" name="nome" size="40"></p>
                <p>CPF: <input type="text" name="cpf" size="40"></p>
                <p>Função: 
                    <select name="funcao"> 
                        <option value="administrador" >Administrador</option> 
                        <option value="operador">Operador</option> 
                        <option value="usuario">Usuário Comum</option> 
                    </select></p>
                <p>Senha: <input type="password" name="senha" size="40"></p>
            </div>
            <div align="center">
                <p>
                    <input type="submit" value="Salvar">
                    <input type="reset" value="Resetar">
                </p> 
            </div>
        </form>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
